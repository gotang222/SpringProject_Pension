$(function(){
	
	/* 아이디 유효성 검사 */
	$("input#uid").keyup(function(){
		$("input#idCheck").val(0);
		if (idChk()) {
			$("p#idGuideTxt").css("color", "red");
		} else {
			$("p#idGuideTxt").css("color", "black");
		}
	});
	
	/* 비밀번호 보기 체크 처리 */
	$("input#showPwChk").change(function(){
		if ($(this).is(":checked")) {
			$("input#upw").attr("type", "text");
		} else {
			$("input#upw").attr("type", "password");
		}
	});
	
	/* 비밀번호 확인 일치여부 확인 */
	$("input#upw2").keyup(function(){
		let upw = $("input#upw").val();
		let upw2 = $("input#upw2").val();
		if (upw2 == "") {
			$("span#upw2ChkTxt").text("");
		} else if (upw == upw2) {
			$("span#upw2ChkTxt").text("비밀번호 일치!");
		} else {
			$("span#upw2ChkTxt").text("비밀번호가 다릅니다.");
		}
	});
	
	/* 비밀번호 유효성 검사 */
	$("input#upw").keyup(function(){
		if (pwChk()) {
			$("p#pwGuideTxt").css("color", "red");
		} else {
			$("p#pwGuideTxt").css("color", "black");
		}
	});
	
	/* 이메일 직접입력/선택입력 처리 */
	$("select#selectEmail").change(function(){
		let email = $(this).val();
		$("input#uEmail2").val(email);
	});
	
	/* 회원가입 버튼 submit 처리 */
	$("button#joinSubmitBtn").click(function(){
		joinSubmit();
	});
	
});

/* 아이디 비밀번호 유효성 검사 시작 */
function idChk() {
	let uid = $("input#uid").val().trim();
	let reg = /[^a-z|A-Z|0-9]/;
	let ToF = reg.test(uid) || $("#uid").val().length < 3;
	return ToF; 
}
function pwChk() {
	let upw = $("input#upw").val().trim();
	let reg = /[^a-z|A-Z|0-9|_\-\!@]/;
	let ToF = reg.test(upw) || $("#upw").val().length < 3;
	return ToF;
}
/* 아이디 / 비밀번호 유효성 검사 끝 */
	
/* 회원가입 처리 시작 */
function joinSubmit() {
	
	let uid = $("#uid").val().trim();
	let upw = $("#upw").val().trim();
	let upw2 = $("#upw2").val().trim();
	let uName = $("#uName").val().trim();
	let uBirth = $("#uBirth").val().trim();
	let uPhone = $("#uPhone").val().trim();
	let uEmail1 = $("#uEmail1").val().trim();
	let uEmail2 = $("#uEmail2").val().trim();
	let idCheck = $("#idCheck").val().trim();
	
	if (uid == "") {
		alert("아이디를 입력해주세요.");
		$("#uid").focus();
		
	} else if (idChk()) {
		alert("아이디는 3~20자의 영문 대소문자, 숫자만 사용 가능합니다.");
		$("#uid").focus();
		
	} else if (idCheck == "") {
		alert("ID중복 확인해주세요.");
		$("#uid").focus();
		
	} else if (idCheck == "1") {
		alert("중복된 아이디입니다.");
		$("#uid").focus();
		
	} else if (upw == "") {
		alert("비밀번호를 입력해주세요.");
		$("#upw").focus();
		
	} else if (pwChk()) {
		alert("비밀번호는 3~20자의 영문 대소문자, 숫자, 특수기호(_),(-),(!),(@)만 사용 가능합니다.");
		$("#upw").focus();
		
	} else if (upw2 == "" || upw != upw2) {
		alert("비밀번호가 일치하지 않습니다.");
		$("#upw2").focus();
		
	} else if (uName == "") {
		alert("이름을 입력해주세요.");
		$("#uName").focus();
		
	} else if (uBirth == "") {
		alert("생년월일을 입력해주세요.");
		$("#uBirth").focus();
		
	} else if (isNaN(uBirth)) {
		alert("숫자만 입력해주세요.");
		$("#uBirth").val("");
		$("#uBirth").focus();
		
	} else if (uPhone == "") {
		alert("연락처를 입력해주세요.");
		$("#uPhone").focus();
		
	} else if (isNaN(uPhone)) {
		alert("숫자만 입력해주세요.");
		$("#uPhone").val("");
		$("#uPhone").focus();
		
	} else {
		let chk = confirm("회원가입 하시겠습니까?");
	
		if (chk) {
			if (uEmail1 == "" || uEmail2 == "") {
				$("#uEmail1").val("");
				$("#uEmail2").val("");
			} else {
				let uEmail = uEmail1 + "@" + uEmail2;
				$("input[name=uEmail]").val(uEmail);
			}
			
			$("form#joinFrm").submit();
			
		} else {
			alert("취소했습니다.");
		}
		
	}
	
}
/* 회원가입 처리 끝 */