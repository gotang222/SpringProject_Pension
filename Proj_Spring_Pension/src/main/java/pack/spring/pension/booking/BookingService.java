package pack.spring.pension.booking;

import java.util.List;
import java.util.Map;

public interface BookingService {
	
	//모든객실 불러오기
	List<Map<String, Object>> select_list();

}
