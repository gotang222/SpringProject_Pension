package pack.spring.pension.bbs;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BbsDao {

	@Autowired
	SqlSessionTemplate sessionTemplate;
	
}
