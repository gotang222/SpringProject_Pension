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
	
	//ID중복확인
	@Override
	public Map<String, Object> select_idChk(Map<String, Object> map) {
		return memberDao.select_idChk(map);
	}
	
	// 로그인
	@Override
	public Map<String, Object> select(Map<String, Object> map) {
		return this.memberDao.select(map);
	}
	
	//마이페이지
	@Override
	public Map<String, Object> select_myPage(Map<String, Object> map) {
		return this.memberDao.select_myPage(map);
	}
	
	//회원정보수정
	@Override
	public int update_member(Map<String, Object> map) {
		int rowCnt = memberDao.update_member(map);
		if(rowCnt==1) {
			return rowCnt;
		}
		return 0;
	}
	
	//회원탈퇴
	@Override
	public int delete_member(Map<String, Object> map) {
		int rowCnt = memberDao.delete_member(map);
		if(rowCnt==1) {
			return rowCnt;
		}
		return 0;
	}

}
