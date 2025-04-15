<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>영화 검색 자동완성</title>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <style>
        /* 최근 검색어 스타일 */
        #recentSearches {
            margin-top: 10px;
            display: flex;
            gap: 10px;
            flex-wrap: wrap;
        }
        .recent-item {
            background: #f0f0f0;
            padding: 5px 10px;
            border-radius: 15px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <h2>영화 검색</h2>
    <form id="searchForm">
        <input type="text" id="movieSearch" placeholder="영화 제목 입력">
        <button type="submit">검색</button>
    </form>
    <div id="recentSearches"></div>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    
    <script>
    const MAX_RECENT = 5; // 최대 저장 개수

    $(function() {
        const cookieManager = {
            create: (name, value) => {
                const date = new Date();
                date.setTime(date.getTime() + (365*24*60*60*1000));
                document.cookie = `${name}=${value};expires=${date.toUTCString()};path=/`;
            },
            read: (name) => {
                const cookies = document.cookie.split(';');
                for(let cookie of cookies) {
                    const [key, value] = cookie.split('=');
                    if(key.trim() === name) return decodeURIComponent(value);
                }
                return null;
            }
        };

        // 최근 검색어 표시
        function showRecentSearches() {
            const recentData = cookieManager.read('recentSearches') || '';
            const searches = recentData.split(',').filter(Boolean);
            $('#recentSearches').html(
                searches.map(text => 
                    `<div class="recent-item">${text}</div>`
                ).join('')
            );
        }

        // 최근 검색어 저장
        function saveRecentSearch(text) {
            let recent = (cookieManager.read('recentSearches') || '').split(',');
            recent = [text, ...recent.filter(item => item !== text)].slice(0, MAX_RECENT);
            cookieManager.create('recentSearches', recent.join(','));
            showRecentSearches();
        }

        // 자동완성 설정
        $("#movieSearch").autocomplete({
            source: function(request, response) {
                $.ajax({
                    url: "autocomplete.jsp",
                    dataType: "json",
                    data: { term: request.term },
                    success: response
                });
            },
            minLength: 2,
            select: function(event, ui) {
                saveRecentSearch(ui.item.value);
            }
        });

        // 폼 제출 핸들러
        $("#searchForm").submit(function(e) {
            e.preventDefault();
            const searchText = $("#movieSearch").val();
            if(searchText) {
                saveRecentSearch(searchText);
                // 실제 검색 로직 실행
                console.log("검색 실행:", searchText);
            }
        });

        // 최근 검색어 클릭 핸들러
        $(document).on('click', '.recent-item', function() {
            const text = $(this).text();
            $("#movieSearch").val(text).trigger('input');
        });

        // 초기 최근 검색어 로드
        showRecentSearches();
    });
    </script>
</body>
</html>