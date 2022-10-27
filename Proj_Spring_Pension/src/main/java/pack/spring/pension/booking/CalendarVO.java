package pack.spring.pension.booking;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarVO {
	
	int nowYear;
	int nowMonth;
	int nowDate;
	int nowDay;
	int monthParam = 0; // 이전 월 또는 다음 월 버튼 파라미터
	int nowPageYear = 0; // 현재 페이지 연도
	int nowPageMonth = 0; // 현재 페이지 월
	int year;
	int month;
	int date;
	int day;
	int lastDay; // 이번달의 마지막 날짜
	String today;
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