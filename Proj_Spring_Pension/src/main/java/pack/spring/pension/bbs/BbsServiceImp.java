package pack.spring.pension.bbs;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BbsServiceImp implements BbsService {
	
	@Autowired
	BbsDao bbsDao;

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

}
