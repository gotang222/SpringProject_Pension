package pack.spring.pension.booking;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

public class BookingServiceImp implements BookingService {

	@Autowired
	BookingDAO bookingDAO;
	
	//모든객실 불러오기
	@Override
	public List<Map<String, Object>> select_list() {
		return this.bookingDAO.select_list();
	}
}
