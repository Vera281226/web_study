$(document).ready(function() {
	$("#btnXml").click(function() {
		$("#show").empty();
		$.ajax({
			url:"js40dbxml.jsp", dataType:"xml", // 반환 타입
			success:function(datas){
				$(datas).find("sangpum").each(function() {
					let obj = $(this);
					let str =`<div>${obj.find("code").text()} ${obj.find("sang").text()} ${obj.find("su").text()} ${obj.find("dan").text()}</div>`
					$("#show").append(str);
				});
			},
			error:function(){
				$("#show").append("xml 읽기 오류")
			} 
}); });
	
	$("#btnJson").click(function() {
		$("#show2").empty();
		$.ajax({
				url:"js40dbjson.jsp", dataType:"json",
				success:function(datas){
					$.each(datas.sangpum, function(idx, data) {
						let str =`<div>${data["code"]} ${data["sang"]} ${data["su"]} ${data["dan"]}</div>`
						$("#show").append(str);
					})
				},
				error:function(){
					$("#show2").append("json 읽기 오류")
				}
}); }); });