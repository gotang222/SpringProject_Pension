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
		System.out.println("map이란 : "+map);
		ModelAndView mav = new ModelAndView();
		PageVO pVO = new PageVO();
		
		pVO.setTotalRecord(this.bbsService.select_count(map));
		String nowPage = map.get("nowPage").toString();
		pVO.setNowPage(Integer.parseInt(nowPage));
		
		map.put("start", pVO.getStart());
		map.put("end", pVO.getEnd());
		List<Map<String, Object>> list = this.bbsService.select_list(map);
		
		mav.addObject("category", map.get("category"));
		mav.addObject("list", list);
		mav.addObject("pVO", pVO);
		
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
		mav.setViewName("redirect:/detail?num=" + num + "&nowPage=1");
		return mav;
	}
	
	// 글 상세보기
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView detail(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		
		Map<String, Object> detailMap = this.bbsService.select_detail(map);
		mav.addObject("detail", detailMap);
		mav.addObject("nowPage", map.get("nowPage"));
		mav.setViewName("/bbs/detail");
		return mav;
	}
	
	// 글 수정 페이지
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public ModelAndView modify(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		
		Map<String, Object> detailMap = this.bbsService.select_detail(map);
		mav.addObject("detail", detailMap);
		mav.addObject("category", map.get("category"));
		mav.addObject("nowPage", map.get("nowPage"));
		mav.setViewName("/bbs/modify");
		return mav;
	}
	
	// 글 수정
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public ModelAndView modify(@RequestParam Map<String, Object> map, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		String num = this.bbsService.update_board(map);
		String nowPage = map.get("nowPage").toString();
		mav.setViewName("redirect:/detail?num=" + num + "&nowPage=" + nowPage);
		return mav;
	}
	
	// 글 삭제
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam Map<String, Object> map, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		this.bbsService.delete(map);
		
		String category = map.get("category").toString();
		mav.setViewName("redirect:/board?category=" + category + "&nowPage=1");
		return mav;
	}
	
}
