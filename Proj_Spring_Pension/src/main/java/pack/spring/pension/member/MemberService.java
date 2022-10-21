package pack.spring.pension.member;

import java.util.Map;

public interface MemberService {

	//회원가입
	int insert(Map<String, Object> map);

	// 로그인
	Map<String, Object> select(Map<String, Object> map);
	
}
