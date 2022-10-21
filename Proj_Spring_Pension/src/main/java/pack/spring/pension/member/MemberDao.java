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
	
}
