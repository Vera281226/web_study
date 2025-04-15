$(document).ready(function() {
	$("#id_err").hide();
	$("#age_err").hide();
	$("#age_err2").hide();
	$("#pwd_err").hide();
	$("#pwd_err2").hide(); 
	
	$("#btnSend").click(function () { // 오류 검사 후 전송을 위한 함수
		// id 검사
		let id = $("#userid").val();
		if(id.length<2 || isNaN(id) === false) { $("#id_err").show(); return false; }
		else $("#id_err").hide();
		// age 검사
		let age = $("#age").val();
		if(age.length<1) { $("#age_err").show(); return false; }
				else $("#age_err").hide();
		// age 검사 2 : 아스키코드를 이용한 양수만 허용
		/*
		for(let i=0; i<age.length; i++) {
			// 1글자씩 출력 후 Ascii 코드 값 얻기
			let data = age.charAt(i).charCodeAt(0);
			if(data < 48 || data > 57) { $("#age_err2").show(); return false; }
			else $("#age_err2").hide();
		}*/
		// 사용자 정의 함수 호출
		if(isPositiveIntegerMyFunc(age) === false || age<15 || age>99) { $("#age_err2").show(); return false; }
		else $("#age_err2").hide();
		
		// 비밀번호 검사 : 2개의 비밀번호가 일치해야함
		let pwd = $("#pwd").val();
		if(pwd.length<1)	{ $("#pwd_err").show(); return false; } // $("#pwd").next().show() 라고 DOM 처럼 써주어도 된다 .prev()
		else $("#pwd_err").hide();	
	
		let pwd2 = $("#pwd2").val();
		if(pwd !== pwd2) { $("#pwd_err2").show(); return false; }
		else $("#pwd_err2").hide();
		
		// 오류검사 통과 후 자료를 서버로 전송
		$("#signFrm").attr("action", "js39.jsp").attr("method", "get").submit();
	});
});

// 사용자 정의 함수를 작성
function isPositiveIntegerMyFunc(para) {
	let num = Number(para);
	return Number.isInteger(num);
}