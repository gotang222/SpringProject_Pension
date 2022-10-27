package pack.spring.pension.booking;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookingController {
	/*
	@Autowired
	BookingService bookingService;
	*/
	// 캘린더
	@RequestMapping(value = "/calendar")
	public ModelAndView calendar() {
		ModelAndView mav = new ModelAndView();

		//모든객실 불러오기
		/* List<Map<String, Object>> list = this.bookingService.select_list(); */
		/* mav.addObject("list", list); */
		
		mav.setViewName("/booking/calendar");
		return mav;
	}
	
}
