package pack.spring.pension.member;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	// 회원가입 페이지
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public ModelAndView join() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/member/join");
		return mav;
	}

	// 회원가입
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public ModelAndView join(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();

		int num = this.memberService.insert(map);
		
		mav.setViewName("redirect:/");
		
		return mav;
	}
	
	// 로그인 페이지
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/member/login");
		return mav;
	}
	
	// 로그인
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam Map<String, Object> map, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		
		Map<String, Object> loginMap = this.memberService.select(map);
		
		HttpSession session = request.getSession();
		session.setAttribute("session_data", loginMap);
		session.setAttribute("session_uid", map.get("uid").toString());
		mav.addObject("data", loginMap);
		mav.setViewName("/index");
		return mav;
	}
	
}