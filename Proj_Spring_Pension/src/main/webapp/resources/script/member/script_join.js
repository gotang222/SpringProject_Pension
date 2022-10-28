$(function(){
	
	/* ID 중복확인 팝업 */
	$("button#idChkBtn").click(function(){
		let uid = $("#uid").val().trim();
		
		if (uid == "") {
			alert("아이디를 입력해주세요.");
			$("#uid").focus();
			
		} else if (idChk()) {
			alert("아이디는 3~20자의 영문 대소문자, 숫자만 사용 가능합니다.");
			$("#uid").focus();
			
		} else {
			
			
			let url = "/idChk?uid="+uid;
			let nickName = "idChk";
	
			let w = screen.width;     // 1920
			let popWidth = 480;
			let leftPos = (w - popWidth) / 2; // left Position 팝업창 왼쪽 시작위치
	
			let h = screen.height;    // 1080
			let popHeight = 320;
			let topPos = (h - popHeight) / 2;
	
			let prop = "width="+ popWidth +", height="+ popHeight;
				  prop += ", left=" + leftPos + ", top=" + topPos; 
			window.open(url, nickName, prop);
			
			// 사용 예 : 팝업창의 가로폭 200px, 높이 100px 이며
			//            화면의 왼쪽에서 300px, 위쪽에서 400px 에 위치한 곳에 팝업창 출력
			//             =>  window.open("파일명", "닉네임", 
			//                      "width=200, height=100, left=300, top=400")          
		}
	});
	

	
	// 아이디 중복체크 팝업창 닫기
	$("button#popCloseBtn").click(function(){
		let idCheck = $(this).val();
		
		if (idCheck == 1) {
			$("span#idChkTxt", opener.document).text("중복된 아이디입니다.");
		} else {
			$("span#idChkTxt", opener.document).text("사용 가능한 아이디입니다.");
		}
		$("input#idCheck", opener.document).val(idCheck);
		window.close();
		opener.joinFrm.uid.focus();
		// DOM으로 접근
		// opener객체는 팝업창을 실행한 부모페이지를 지칭함.
	});
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/* 아이디 유효성 검사 */
	$("input#uid").keyup(function(){
		$("input#idCheck").val(1);
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
	
	/* ////////////////////////////////////////////////////////////////////////////// */
	/* /////////////// 회원정보 수정 페이지 (/member/modify.jsp) 시작 ///////////// */
	/* ////////////////////////////////////////////////////////////////////////////// */
	
	/* 회원정보 수정 버튼 submit 처리 */
	$("button#modifySubmitBtn").click(function(){
		modifySubmit();
	});
	$("#modifyFrm input").keyup(function(e){
		if (e.which == 13) {
			modifySubmit();
		}
	});
	
	/* ////////////////////////////////////////////////////////////////////////////// */
	/* /////////////// 회원정보 수정 페이지 (/member/modify.jsp) 끝 ////////////// */
	/* ////////////////////////////////////////////////////////////////////////////// */
	
});





	
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
	alert("idCheck : "+idCheck);
	if (uid == "") {
		alert("아이디를 입력해주세요.");
		$("#uid").focus();
		
	} else if (idChk()) {
		alert("아이디는 3~20자의 영문 대소문자, 숫자만 사용 가능합니다.");
		$("#uid").focus();
		
	} else if (idCheck != 0 ) {
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

/* 회원정보 수정 처리 시작 */
function modifySubmit() {
	
	let upw = $("#upw").val().trim();
	let upw2 = $("#upw2").val().trim();
	let uBirth = $("#uBirth").val().trim();
	let uPhone = $("#uPhone").val().trim();
	let uEmail1 = $("#uEmail1").val().trim();
	let uEmail2 = $("#uEmail2").val().trim();
	
	if (upw == "") {
		alert("비밀번호를 입력해주세요.");
		$("#upw").focus();
		
	} else if (pwChk()) {
		alert("비밀번호는 3~20자의 영문 대소문자, 숫자, 특수기호(_),(-),(!),(@)만 사용 가능합니다.");
		$("#upw").focus();
		
	} else if (upw2 == "" || upw != upw2) {
		alert("비밀번호가 일치하지 않습니다.");
		$("#upw2").focus();
		
	}  else if (uBirth == "") {
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
		let chk = confirm("회원정보를 수정 하시겠습니까?");
		
		if (chk) {
			let uEmail = uEmail1 + "@" + uEmail2;
			$("input[name=uEmail]").val(uEmail);
			$("form#modifyFrm").submit();
		} else {
			alert("취소했습니다.");
		}
		
	}
	
}
/* 회원정보 수정 처리 끝 */

/* 아이디 / 비밀번호 유효성 검사 시작 */
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

/* 회원 탈퇴 시작 */
function resign() {
	let chk = confirm("탈퇴하시겠습니까?");
	if (chk) {
		let uid=$("input#uid").val().trim();
		location.href = "/resign?uid="+uid;
	} else {
		alert("취소했습니다.");
	}
}
/* 회원 탈퇴 끝 */