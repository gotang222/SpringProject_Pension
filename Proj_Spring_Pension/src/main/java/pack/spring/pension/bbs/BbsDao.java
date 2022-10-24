package pack.spring.pension.bbs;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BbsDao {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	// 게시판 목록
	public List<Map<String, Object>> select_list(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectList("bbs.select_list", map);
	}

	// 게시판 글작성
	public int insert(Map<String, Object> map) {
		return this.sqlSessionTemplate.insert("bbs.insert", map);
	}
	
	// 글 상세보기
	public Map<String, Object> select_detail(Map<String, Object> map) {
		this.sqlSessionTemplate.update("bbs.update_views", map);
		return this.sqlSessionTemplate.selectOne("bbs.select_detail", map);
	}
	
}
