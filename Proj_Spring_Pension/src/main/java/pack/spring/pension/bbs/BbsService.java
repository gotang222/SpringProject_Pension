package pack.spring.pension.bbs;

import java.util.List;
import java.util.Map;

public interface BbsService {
	
	// 전체 게시글 수
	int select_count(Map<String, Object> map);
	
	// 게시판 목록
	List<Map<String, Object>> select_list(Map<String, Object> map);
	
	// 게시판 글작성
	String insert(Map<String, Object> map);
	
	// 글 상세보기
	Map<String, Object> select_detail(Map<String, Object> map);
	
	// 글 수정하기
	String update_board(Map<String, Object> map);

	// 글 삭제하기
	void delete(Map<String, Object> map);

}
