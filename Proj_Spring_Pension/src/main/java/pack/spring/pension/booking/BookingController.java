package pack.spring.pension.booking;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pack.spring.pension.bbs.PageVO;

@Controller
public class BookingController {
	/*
	@Autowired
	BookingService bookingService;
	*/

	// 캘린더
	@RequestMapping(value = "/calendar", method = RequestMethod.GET)
	public ModelAndView calendar(@RequestParam Map<String, Object> map) {
		
		ModelAndView mav = new ModelAndView();
		CalendarVO calendarVO = new CalendarVO();
		calendarVO.setStart(0);
		
		String monthParam= map.get("monthParam").toString();
		if(monthParam != null) {
			calendarVO.setNowPageYear(Integer.parseInt(map.get("nowPageYear").toString()));
			calendarVO.setNowPageMonth(Integer.parseInt(map.get("nowPageMonth").toString()));
			calendarVO.setMonthParam(Integer.parseInt(map.get("monthParam").toString()));
		}
		mav.addObject("calendarVO", calendarVO);
		/*
		 * map.put("start", pVO.getStart()); map.put("end", pVO.getEnd());
		 * List<Map<String, Object>> list = this.bbsService.select_list(map);
		 * 
		 * mav.addObject("category", map.get("category")); mav.addObject("list", list);
		 * mav.addObject("pVO", pVO);
		 * 
		 * mav.setViewName("/bbs/board");
		 */
		
		return mav;
	
	}
	// 캘린더
		@RequestMapping(value = "/calendar")
		public ModelAndView calendar() {
			
			ModelAndView mav = new ModelAndView();
			CalendarVO calendarVO = new CalendarVO();
			calendarVO.setChkNoneMonthParam(0);
			calendarVO.setStart(0);
			
			return mav;
		}
}
