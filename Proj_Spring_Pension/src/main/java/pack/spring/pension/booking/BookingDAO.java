package pack.spring.pension.booking;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class BookingDAO {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public List<Map<String, Object>> select_list() {
		return this.sqlSessionTemplate.selectList("booking.select_list");
	}
}
