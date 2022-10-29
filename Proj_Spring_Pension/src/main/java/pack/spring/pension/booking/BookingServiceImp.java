package pack.spring.pension.booking;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImp implements BookingService {

	@Autowired
	BookingDAO bookingDAO;
	
	//모든객실 불러오기
	@Override
	public List<Map<String, Object>> select_list() {
		return bookingDAO.select_list();
	}
	
	/* 해당 날짜 예약 여부 확인*/
	@Override
	public Map<String, Object> select_chkBooking(Map<String, Object> map) {
		return this.bookingDAO.select_chkBooking(map);
	}
	
	//객실이름으로 객실 정보 불러오기
	@Override
	public Map<String, Object> select_getRoomInfo(Map<String, Object> map) {
		return this.bookingDAO.select_getRoomInfo(map);
	}

	
}
