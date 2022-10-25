package pack.spring.pension.bbs;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BbsController {
	
	@Autowired
	BbsService bbsService;
	
	// 게시판 목록
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public ModelAndView list(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		
		// 전체 데이터 수(DB에 저장된 row 개수)
		long totalRecord = this.bbsService.select_count(map);
		
		int numPerPage =  3;    // 페이지당 출력하는 데이터 수(=게시글 숫자)
		int pagePerBlock = 3;   // 블럭당 표시되는 페이지 수의 개수
		int totalPage = 0;           // 전체 페이지 수
		int totalBlock = 0;          // 전체 블록수
		int nowPage = 1;          // 현재 (사용자가 보고 있는) 페이지 번호
		int nowBlock = 1;         // 현재 (사용자가 보고 있는) 블럭

		int start = 0;     // DB에서 데이터를 불러올 때 시작하는 인덱스 번호
		int end = 5;     // 시작하는 인덱스 번호부터 반환하는(=출력하는) 데이터 개수 
		    // select * from T/N where... order by ... limit start, end;

		int listSize = 0;    // 1페이지에서 보여주는 데이터 수
		
		map.put("start", start);
		map.put("end", end);
		List<Map<String, Object>> list = this.bbsService.select_list(map);
		
		
		mav.addObject("list", list);
		mav.addObject("totalRecord", totalRecord);
		mav.addObject("category", map.get("category"));
		
		mav.setViewName("/bbs/board");
		return mav;
	}
	
	// 글작성 페이지
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public ModelAndView write(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("category", map.get("category").toString());
		mav.setViewName("/bbs/write");
		return mav;
	}

	// 글작성
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public ModelAndView write(@RequestParam Map<String, Object> map, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		Map<String, Object> loginMap = (Map<String, Object>) session.getAttribute("session_data");
		map.put("uid", loginMap.get("uid"));
		map.put("uName", loginMap.get("uName"));
		
		String num = this.bbsService.insert(map);
		mav.setViewName("redirect:/detail?num=" + num);
		return mav;
	}
	
	// 글 상세보기
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView detail(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		
		Map<String, Object> detailMap = this.bbsService.select_detail(map);
		mav.addObject("detail", detailMap);
		mav.setViewName("/bbs/detail");
		return mav;
	}
	
	// 글 수정 페이지
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public ModelAndView modify(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		
		Map<String, Object> detailMap = this.bbsService.select_detail(map);
		mav.addObject("detail", detailMap);
		mav.setViewName("/bbs/modify");
		return mav;
	}
	
	// 글 수정
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public ModelAndView modify(@RequestParam Map<String, Object> map, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		String num = this.bbsService.update_board(map);
		mav.setViewName("redirect:/detail?num=" + num);
		return mav;
	}
	
}
