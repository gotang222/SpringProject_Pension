package pack.spring.pension.member;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImp implements MemberService {

	@Autowired
	MemberDao memberDao;
	
	// 회원가입
	@Override
	public int insert(Map<String, Object> map) {
		int affectRowCnt = memberDao.insert(map);
		if (affectRowCnt == 1) {
			int num = Integer.parseInt(map.get("num").toString());
			System.out.println("\nMemberService - num : " + num);
			return num;
		}
		return 0;
	}
	
	// 로그인
	@Override
	public Map<String, Object> select(Map<String, Object> map) {
		return this.memberDao.select(map);
	}

}
