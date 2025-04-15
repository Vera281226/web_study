$(document).ready(function() {
	$("#btnSearch").click(function() {
			$("#show").empty();
			let jname = $("#name").val();
			$.ajax({
				type:"post", url:"js42.jsp", data:{"name":jname},
							dataType:"json", // 반환 타입
							success:function(datas){
								let str= 
								`<table border='1'> 
								<tr><th>사번</th><th>직원명</th><th>직급</th><th>연봉</th></tr>`;
								$.each(datas.jikwon, function(idx, data) {
									str += `<tr><td> ${data["jikwonno"]}</td><td>${data["jikwonname"]}</td><td>${data["jikwonjik"]}</td><td>${data["jikwonpay"]}</td></tr>`;
								})
								str += `</table>`; 
								$("#show").append(str);
							}, error:function() {
								$("#show").append("직원 읽기 에러")
							}	
}); }); });