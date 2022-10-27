package pack.spring.pension.member;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	// 회원가입
	public int insert(Map<String, Object> map) {
		return this.sqlSessionTemplate.insert("member.insert", map);
	}

	// 로그인
	public Map<String, Object> select(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectOne("member.select", map);
	}
	
	//마이페이지
	public Map<String, Object> select_myPage(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectOne("member.select_myPage", map);
	}
	
	//회원정보수정
	public int update_member(Map<String, Object> map){
		return this.sqlSessionTemplate.update("member.update_member", map);
	}
	
	//회원탈퇴
	public int delete_member(Map<String, Object> map) {
		return this.sqlSessionTemplate.delete("member.delete_member", map);
	}
	
}
