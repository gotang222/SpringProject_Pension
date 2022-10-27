package pack.spring.pension.booking;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class BookingDAO {
	
	@Autowired
	SqlSessionTemplate sessionTemplate;
	
	//모든객실 불러오기
	public List<Map<String, Object>> select_list() {
		return sessionTemplate.selectList("booking.select_list");
	}
}
