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
	
	//ID중복확인
	@RequestMapping(value = "/idChk", method = RequestMethod.GET)
	public ModelAndView select_idChk(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		Map<String, Object> idChk = this.memberService.select_idChk(map);
		System.out.println("idChk 값 확인 : "+idChk);
		mav.addObject("inputuid", map.get("uid"));
		mav.addObject("idChk", idChk);
		mav.setViewName("/member/idChk");
		return mav;
	}
	
	// 로그인 페이지
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/member/login");
		return mav;
	}
	
	// 로그인
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam Map<String, Object> map, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		
		Map<String, Object> loginMap = this.memberService.select(map);
		System.out.println("loginMap : " + loginMap);
		if(loginMap != null) {
			System.out.println("if 들어왔음");
			HttpSession session = request.getSession();
			session.setAttribute("session_data", loginMap);
			session.setAttribute("session_uid", map.get("uid").toString());
			mav.addObject("data", loginMap);
			mav.setViewName("/index");
		} else {

			mav.setViewName("/member/loginFail");
		}
		return mav;
		
	}
	
	//마이페이지
	@RequestMapping(value = "/myPage", method = RequestMethod.GET)
	public ModelAndView myPage(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		
		Map<String, Object> myPageMap = this.memberService.select_myPage(map);

		mav.addObject("data", myPageMap);
		mav.setViewName("/member/myPage");
		return mav;
	}
	
	//회원정보수정
	@RequestMapping(value = "/myPage", method = RequestMethod.POST)
	public ModelAndView myPage_update(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		System.out.println(777);
		int num = this.memberService.update_member(map);
		
		mav.setViewName("/index");
		
		return mav;
	}
	
	//회원탈퇴
	@RequestMapping(value = "/resign", method = RequestMethod.GET)
	public ModelAndView resign(@RequestParam Map<String, Object> map, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		int num = this.memberService.delete_member(map);
		System.out.println("num : "+num);
		HttpSession session = req.getSession();
		if(num==1) {
			session.invalidate();
			mav.setViewName("redirect:/");
		}
		return mav;
	}
	
}