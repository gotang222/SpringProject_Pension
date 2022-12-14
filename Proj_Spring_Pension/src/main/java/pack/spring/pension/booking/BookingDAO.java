package pack.spring.pension.booking;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookingDAO {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	
	//모든 객실 정보 불러오기 시작
	public List<Map<String, Object>> select_list() {
		return this.sqlSessionTemplate.selectList("booking.select_list");
	}
	//모든 객실 정보 불러오기 끝
	
	// 해당 날짜 예약 여부 확인 시작
	public Map<String, Object> select_chkBooking(Map<String, Object> map) {
		System.out.println("dao도들어옴");
		return this.sqlSessionTemplate.selectOne("booking.select_chkBooking", map);
	}
	//해당 날짜 예약 여부 확인 끝
	
	//객실이름으로 객실 정보 불러오기 시작
	public Map<String, Object>  select_getRoomInfo(Map<String, Object> map){
		return this.sqlSessionTemplate.selectOne("booking.select_getRoomInfo", map);
	}
	//객실이름으로 객실 정보 불러오기 끝
	
	//객실 예약 시작
	public int insert_roomBooking(Map<String, Object> map) {
		System.out.println("456");
		return this.sqlSessionTemplate.insert("booking.insert_roomBooking", map);
	}
	//객실 예약 끝
}
