package pack.spring.pension.booking;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookingController {
	
	// 예약현황페이지
	@RequestMapping(value = "/calendar")
	public ModelAndView join() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/booking/calendar");
		return mav;
	}
	
}
