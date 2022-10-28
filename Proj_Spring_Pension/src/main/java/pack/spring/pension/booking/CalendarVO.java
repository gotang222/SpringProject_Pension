package pack.spring.pension.booking;

import java.util.Calendar;

public class CalendarVO {
	
	int monthParam; // 이전 월 또는 다음 월 버튼 파라미터
	int nowPageYear; // 현재 페이지 연도
	int nowPageMonth; // 현재 페이지 월
	
	Calendar nowCal = Calendar.getInstance(); // 오늘 날짜 캘린더
	
	int nowYear = nowCal.get(Calendar.YEAR);					// 오늘 연도
	int nowMonth = (nowCal.get(Calendar.MONTH)+1);			// 오늘 월
	int nowDate = nowCal.get(Calendar.DATE);					// 오늘 일
	int nowDay = nowCal.get(Calendar.DAY_OF_WEEK);		// 오늘 요일
	
	public int getMonthParam() {
		return monthParam;
	}
	public void setMonthParam(int monthParam) {
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
	public Calendar getNowCal() {
		return nowCal;
	}
	public void setNowCal(Calendar nowCal) {
		this.nowCal = nowCal;
	}
	public int getNowYear() {
		return nowYear;
	}
	public void setNowYear(int nowYear) {
		this.nowYear = nowYear;
	}
	public int getNowMonth() {
		return nowMonth;
	}
	public void setNowMonth(int nowMonth) {
		this.nowMonth = nowMonth;
	}
	public int getNowDate() {
		return nowDate;
	}
	public void setNowDate(int nowDate) {
		this.nowDate = nowDate;
	}
	public int getNowDay() {
		return nowDay;
	}
	public void setNowDay(int nowDay) {
		this.nowDay = nowDay;
	}
	
	
	
}