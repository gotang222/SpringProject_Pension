package pack.spring.pension.booking;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
	
	@Autowired
	BookingService bookingService;
	

	@RequestMapping(value = "/calendar", method = RequestMethod.GET)
	public ModelAndView calendar(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		RoomVO rVO = new RoomVO();
		List<Map<String, Object>> objList = this.bookingService.select_list();
		String decimalFormat = "#,###";
		DecimalFormat df = new DecimalFormat(decimalFormat);

		String dateFormat = "yyyy년 MM월 dd일 (E)";
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);

		Calendar nowCal = Calendar.getInstance(); // 오늘 날짜 캘린더
		String[] weekArr = {"일", "월", "화", "수", "목", "금", "토"};

		int nowYear = nowCal.get(Calendar.YEAR);					// 오늘 연도
		int nowMonth = nowCal.get(Calendar.MONTH);			// 오늘 월
		int nowDate = nowCal.get(Calendar.DATE);					// 오늘 일
		int nowDay = nowCal.get(Calendar.DAY_OF_WEEK);		// 오늘 요일

		// //////////////////////// 달력 넘기기 처리 시작 ////////////////////////
		int monthParam = 0; // 이전 월 또는 다음 월 버튼 파라미터
		int nowPageYear = 0; // 현재 페이지 연도
		int nowPageMonth = 0; // 현재 페이지 월

		Calendar cal = Calendar.getInstance();
		
		if (map.get("monthParam") != null) {
			
			monthParam = Integer.parseInt(map.get("monthParam").toString());
			nowPageYear = Integer.parseInt(map.get("nowPageYear").toString());
			nowPageMonth = Integer.parseInt(map.get("nowPageMonth").toString());
			
			// 이전 월로 이동
			if (monthParam ==  1) {
				
				if (nowPageMonth == 1) {
					cal.set(Calendar.YEAR, nowPageYear - 1);
					cal.set(Calendar.MONTH, 11);
				} else {
					cal.set(Calendar.YEAR, nowPageYear);
					cal.set(Calendar.MONTH, nowPageMonth - 2);
				}
			
			// 다음 월로 이동
			} else if (monthParam == 2) {
				
				if (nowPageMonth == 12) {
					cal.set(Calendar.YEAR, nowPageYear + 1);
					cal.set(Calendar.MONTH, 0);
				} else {
					cal.set(Calendar.YEAR, nowPageYear);
					cal.set(Calendar.MONTH, nowPageMonth);
				}
			}
			
		} else {
			cal.set(Calendar.YEAR, nowYear); // 현재 연도로 초기화
			cal.set(Calendar.MONTH, nowMonth); // 현재 월로 초기화
		}
		// //////////////////////// 달력 넘기기 처리 끝 ////////////////////////

		cal.set(Calendar.DATE, 1); // 1일로 초기화

		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int date = cal.get(Calendar.DATE);
		int day = cal.get(Calendar.DAY_OF_WEEK);

		int lastDay = cal.getActualMaximum(Calendar.DATE); // 이번달의 마지막 날짜
		List<String> taglist = new ArrayList<>();
		
		for (int i = 1; i <= lastDay; i++) {
			cal.set(Calendar.DATE, i);
			int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
			
			// 1일 이전 빈칸 처리
			if (i == 1) {
				for (int j = 1; j < dayWeek; j++) {
					taglist.add("<td></td>");
					}
			}
			
			if (dayWeek == 1) { // 일요일부터 시작
				taglist.add("<tr>");
			}
			taglist.add("<td>");
			taglist.add("<h4> " + i + "</h4>");			
			
			Calendar compareCal = Calendar.getInstance(); // 날짜 비교용 캘린더 객체
			compareCal.set(year, month, i);

			if (compareCal.before(nowCal)) { // 오늘 이전의 날짜
				taglist.add("<span>예약종료</span>");
			} else {
				for (int j = 0; j < objList.size(); j++) {
					
					Map<String, Object> m = objList.get(j); 
					int rNum = Integer.parseInt(m.get("num").toString());
					String rName = m.get("rName").toString();
					mav.addObject("rName", rName);
					int rLimit =Integer.parseInt(m.get("rLimit").toString());
					int rPrice =Integer.parseInt(m.get("rPrice").toString());
					int rPictures =Integer.parseInt(m.get("rPictures").toString());
					
					
					// 주말 요금 +20000원
					int weekendPrice = 20000;
					if (dayWeek == 1 || dayWeek == 7) rPrice += weekendPrice;
					
					// 예약 여부 확인
					dateFormat = "yyyy-MM-dd";
					sdf = new SimpleDateFormat(dateFormat);
					String bDate = sdf.format(compareCal.getTime());
					
					String chkBooking = "";
					map.put("rNum", rNum);
					map.put("bDate", bDate);
					Map<String, Object> temp = this.bookingService.select_chkBooking(map);
					
					int z = Integer.parseInt(temp.get("count(*)").toString());
					boolean ToF =false;
					if(z==1) {
						ToF=true;
					}
					
					if (ToF) {
						chkBooking = "booked";
					} else {
						chkBooking = "noBooked";
					}
					
					// 출력부분
					taglist.add("<p class='dFlex' style='justify-content: space-between'>");
					taglist.add("<a class='" + chkBooking + "'>" + rName + "</a>");
					taglist.add("<span>" + df.format(rPrice) + "</span></p>");
				}
			}
			taglist.add("</td>");
			
			
			if (dayWeek == 7 && i < lastDay) { // 토요일 줄바꿈
				taglist.add("</tr>");
				
			}
			
			// 마지막일 이후 빈칸 처리
			if (i == lastDay) {
				for (int j = 0; j < 7 - dayWeek; j++) {
					taglist.add("<td></td>");					 
				}
			}
		}
		mav.addObject("today", sdf.format(nowCal.getTime()));
		
		dateFormat = "yyyy-MM-";
		sdf = new SimpleDateFormat(dateFormat);
		String bDate = sdf.format(cal.getTime());
		mav.addObject("bDate", bDate);
		
		CalendarVO calendarVO = new CalendarVO();

		mav.addObject("year", year);
		mav.addObject("nowPageMonth", month+1);
		mav.addObject("taglist", taglist);		
		mav.setViewName("/booking/calendar");
		return mav;
	}
	
	@RequestMapping(value = "/booking", method = RequestMethod.GET)
	public ModelAndView booking(@RequestParam Map<String, Object> map) {
		System.out.println(" 경로 부킹 겟");
		System.out.println(map);
		Map<String, Object> getRoomInfo = this.bookingService.select_getRoomInfo(map);
		System.out.println("m : "+getRoomInfo);
		
		String rLimit = getRoomInfo.get("rLimit").toString();
		String rName = getRoomInfo.get("rName").toString();
		int rNum = Integer.parseInt(getRoomInfo.get("num").toString());
		
		String decimalFormat = "#,### 원";
		DecimalFormat df = new DecimalFormat(decimalFormat);
		int bMoney = Integer.parseInt(map.get("bMoney").toString());
		String payPrice = df.format(bMoney);
		String bDate = map.get("bDate").toString();

		ModelAndView mav = new ModelAndView();
		
		mav.addObject("rLimit", rLimit);
		mav.addObject("payPrice", payPrice);
		mav.addObject("bMoney", bMoney);
		mav.addObject("rName", rName);
		mav.addObject("rNum", rNum);

		
		String bbDate = bDate.trim()+map.get("bDay").toString().trim();
		mav.addObject("bDate", bbDate);
		
		mav.setViewName("/booking/booking");
		return mav;
	}
	
	@RequestMapping(value = "/booking", method = RequestMethod.POST)
	public ModelAndView booking_insert(@RequestParam Map<String, Object> map) {

		System.out.println("부킹인설트포스트들어옴");
		ModelAndView mav = new ModelAndView();
		System.out.println(map);
		int insertBooking = this.bookingService.insert(map);
		System.out.println("insertBooking : "+insertBooking);
		if(insertBooking==1) {
			mav.setViewName("redirect:/calendar");			
		}



		
		return mav;
	}


}
