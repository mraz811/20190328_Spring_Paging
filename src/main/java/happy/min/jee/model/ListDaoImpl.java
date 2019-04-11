package happy.min.jee.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import happy.min.jee.dto.ListDto;
import happy.min.jee.dto.PagingDto;

@Repository
public class ListDaoImpl implements IListDao {

	private Logger logger = LoggerFactory.getLogger(ListDaoImpl.class);
	private final String NS = "happy.min.jee.paging.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<ListDto> selectPaging(PagingDto paging) {
		logger.info("^^^^^^^ 페이징 Dao - selectPaging");
		return sqlSession.selectList(NS+"selectPaging", paging);
	}

	@Override
	public int selectTotalPage() {
		logger.info("^^^^^^^ 페이징 Dao - selectTotalPaging");
		return sqlSession.selectOne(NS+"selectTotalPaging");
	}

	@Override
	public boolean listInsert(ListDto list) {
		logger.info("^^^^^^^ 페이징 Dao - listInsert");
		return sqlSession.insert(NS+"listinsert", list)==1? true:false;
	}

	@Override
	public boolean deleteAll() {
		logger.info("^^^^^^^ 페이징 Dao - deleteAll");
		return sqlSession.delete(NS+"deleteAll")==0? true:false;
	}

}
