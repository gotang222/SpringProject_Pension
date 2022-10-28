package pack.spring.pension.member;

import java.util.Map;

public interface MemberService {

	//회원가입
	int insert(Map<String, Object> map);
	
	//ID중복확인
	Map<String, Object> select_idChk(Map<String, Object> map);

	// 로그인
	Map<String, Object> select(Map<String, Object> map);
	
	// 마이페이지
	Map<String, Object> select_myPage(Map<String, Object> map);
	
	//회원정보수정
	int update_member(Map<String, Object> map);
	
	//회원탈퇴
	int delete_member(Map<String, Object> map);
	
}
