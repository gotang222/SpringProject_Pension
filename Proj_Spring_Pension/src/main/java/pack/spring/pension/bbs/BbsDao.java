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
	
	// 전체 게시글 수
	public int select_count(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectOne("bbs.select_count", map);
	}
	
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
	
	// 글 수정하기
	public int update_board(Map<String, Object> map) {
		return this.sqlSessionTemplate.update("bbs.update_board", map);
	}
	
	// 글 삭제하기
	public void delete(Map<String, Object> map) {
		this.sqlSessionTemplate.delete("bbs.delete", map);
	}
	
}

