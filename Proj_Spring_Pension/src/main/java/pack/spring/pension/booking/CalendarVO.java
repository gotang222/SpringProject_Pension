package pack.spring.pension.booking;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarVO {
	
	int start;
	
	Calendar nowCal = Calendar.getInstance();
	
	int nowYear = nowCal.get(Calendar.YEAR);					// 오늘 연도
	int nowMonth = nowCal.get(Calendar.MONTH);			// 오늘 월
	int nowDate = nowCal.get(Calendar.DATE);					// 오늘 일
	int nowDay = nowCal.get(Calendar.DAY_OF_WEEK);		// 오늘 요일
	String nowCalTime;
	
	
	String[] weekArr = {"일", "월", "화", "수", "목", "금", "토"};

	int monthParam = 0; // 이전 월 또는 다음 월 버튼 파라미터
	int nowPageYear = 0; // 현재 페이지 연도
	int nowPageMonth = 0; // 현재 페이지 월
	
	Calendar cal = Calendar.getInstance();
	Calendar compareCal = Calendar.getInstance();
	
	int compareCal_set;
	int year = cal.get(Calendar.YEAR);
	int month = cal.get(Calendar.MONTH);
	int date = cal.get(Calendar.DATE);
	int day = cal.get(Calendar.DAY_OF_WEEK);
	int lastDay = cal.getActualMaximum(Calendar.DATE); // 이번달의 마지막 날짜
	String today;
	
	int chkNoneMonthParam;
	
	
	
	
	public int getCompareCal_set() {
		return compareCal_set;
	}
	public void setCompareCal_set(int compareCal_set) {
		compareCal.set(year, month, compareCal_set);
		this.compareCal_set = compareCal_set;
	}
	public Calendar getCompareCal() {
		return compareCal;
	}
	public void setCompareCal(Calendar compareCal) {
		this.compareCal = compareCal;
	}
	
	public String[] getWeekArr() {
		return weekArr;
	}
	public void setWeekArr(String[] weekArr) {
		this.weekArr = weekArr;
	}
	
	public String getNowCalTime() {
		String dateFormat = "yyyy년 MM월 dd일 (E)";
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(nowCal.getTime());
	}
	public void setNowCalTime(String nowCalTime) {
		this.nowCalTime = nowCalTime;
	}
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		cal.set(Calendar.DATE, 1); // 1일로 초기화
		this.start = start;
	}
	
	public int getChkNoneMonthParam() {
		return chkNoneMonthParam;
	}
	public void setChkNoneMonthParam(int chkNoneMonthParam) {
		cal.set(Calendar.YEAR, nowYear); // 현재 연도로 초기화
		cal.set(Calendar.MONTH, nowMonth); // 현재 월로 초기화

		this.chkNoneMonthParam = chkNoneMonthParam;
	}
	public int getNowYear() {
		nowYear = nowCal.get(Calendar.YEAR);
		return nowYear;
	}
	public void setNowYear(int nowYear) {
		this.nowYear = nowYear;
	}
	
	public int getNowMonth() {
		nowMonth = nowCal.get(Calendar.MONTH);
		return nowMonth;
	}
	public void setNowMonth(int nowMonth) {
		this.nowMonth = nowMonth;
	}
	
	public int getNowDate() {
		nowDate = nowCal.get(Calendar.DATE);
		return nowDate;
	}
	public void setNowDate(int nowDate) {
		this.nowDate = nowDate;
	}
	
	public int getNowDay() {
		nowDay = nowCal.get(Calendar.DAY_OF_WEEK);
		return nowDay;
	}
	public void setNowDay(int nowDay) {
		this.nowDay = nowDay;
	}
	
	public int getMonthParam() {
		return monthParam;
	}
	public void setMonthParam(int monthParam) {
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
		this.monthParam = monthParam;
	}
	public int getNowPageYear() {
		return nowPageYear;
	}
	public void setNowPageYear(int nowPageYear) {
		this.nowPageYear = nowPageYear;
	}
	public int getNowPageMonth() {
		return nowPageMonth;
	}
	public void setNowPageMonth(int nowPageMonth) {
		this.nowPageMonth = nowPageMonth;
	}
	public int getYear() {
		Calendar cal = Calendar.getInstance();
		year = cal.get(Calendar.YEAR);
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		Calendar cal = Calendar.getInstance();
		month = (cal.get(Calendar.MONTH)+1);
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public int getDay() {
		return day;
	}
	public Calendar getCal() {
		return cal;
	}

	public void setCal(Calendar cal) {
		this.cal = cal;
	}
	public Calendar getNowCal() {
		return nowCal;
	}
	public void setNowCal(Calendar nowCal) {
		this.nowCal = nowCal;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getLastDay() {
		return lastDay;
	}
	public void setLastDay(int lastDay) {
		this.lastDay = lastDay;
	}
	public String getToday() {
		return today;
	}
	public void setToday(String today) {
		this.today = today;
	}
	
	
	
}