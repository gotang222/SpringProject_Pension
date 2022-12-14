package pack.spring.pension.bbs;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BbsServiceImp implements BbsService {
	
	@Autowired
	BbsDao bbsDao;
	
	// 전체 게시글 수
	@Override
	public int select_count(Map<String, Object> map) {
		return this.bbsDao.select_count(map);
	}
	
	// 게시판 목록
	@Override
	public List<Map<String, Object>> select_list(Map<String, Object> map) {
		return this.bbsDao.select_list(map);
	}
	
	// 게시판 글작성
	@Override
	public String insert(Map<String, Object> map) {
		int affectRowCnt = this.bbsDao.insert(map);
		if (affectRowCnt == 1) {
			return map.get("num").toString();
		}
		return null;
	}
	
	// 글 상세보기
	@Override
	public Map<String, Object> select_detail(Map<String, Object> map) {
		return this.bbsDao.select_detail(map);
	}
	
	// 글 수정하기
	@Override
	public String update_board(Map<String, Object> map) {
		int affectRowCnt = this.bbsDao.update_board(map);
		if (affectRowCnt == 1) {
			return map.get("num").toString();
		}
		return null;
	}

	// 글 삭제하기
	@Override
	public void delete(Map<String, Object> map) {
		this.bbsDao.delete(map);
	}
	
}
