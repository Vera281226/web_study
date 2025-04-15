$(document).ready(function() {
	$("#btnSearch").click(function() {
			$("#show", "#showCount").empty();
			let bname = $("#name").val();
			
			$.ajax({
				type:"post", url:"js41jikwon.jsp", data:{"name":bname}, //js41jikwon.jsp?name=총무부
				dataType:"json", // 반환 타입
				success:function(datas){
					let count = 0;
					let str= 
					`<table border='1'> 
					<tr><th>사번</th><th>직원명</th><th>직급</th><th>관리고객수</th></tr>`
					$.each(datas.jikwon, function(idx, data) {
						str += `<tr><td> ${data["jikwonno"]}</td>`;
						if(Number(data["jikwongogek"]) === 0) str += `<td>${data["jikwonname"]}</td>`
						else str += `<td><a href='javascript:func(${data["jikwonno"]})'>${data["jikwonname"]}</td>`
						str  += `<td>${data["jikwonjik"]}</td><td>${data["jikwongogek"]}</td></tr>`;
						count += 1;
					})
					str += `</table>`; 
					$("#show").append(str);
					$("#showCount").append(count);
				}, error:function() {
					$("#show").append("직원 읽기 에러")
				}	
}); }); });
function func(para) {
				$("#gogek").empty();
				$.ajax({
					type:"post",
					url:"js41gogek.jsp",
					data:{"arg":para},
					dataType:"json",
					success:function(datas) {
						let str = "<table border ='1'>";
						str += "<tr><th>고객명</th><th>전화</th></tr>";
						
						$.each(datas.gogek, function(idx, data) {
							str += "<tr>";
							str += "<td>" + data["gogekname"] + "</td>";
							str += " <td>" + data["gogektel"] + "</td>";
						});
						str += "</table>";
						$("#show").append(str);
						},
						error:function(){
							$("#show").text("고객 읽기 에러")}
})};