package pack.spring.pension.booking;

import java.util.List;
import java.util.Map;

public interface BookingService {
	
	//모든객실 불러오기
	List<Map<String, Object>> select_list();
	
	// 해당 날짜 예약 여부 확인
	Map<String, Object> select_chkBooking(Map<String, Object> map);
	
	//객실이름으로 객실 정보 불러오기
	Map<String, Object> select_getRoomInfo(Map<String, Object> map);

}
