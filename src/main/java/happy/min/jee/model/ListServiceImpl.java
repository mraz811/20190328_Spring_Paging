package happy.min.jee.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import happy.min.jee.dto.ListDto;
import happy.min.jee.dto.PagingDto;

@Service
public class ListServiceImpl implements IListService {

	@Autowired
	private IListDao iListDao;
	
	@Override
	public List<ListDto> selectPaging(PagingDto paging) {
		return iListDao.selectPaging(paging);
	}

	@Override
	public int selectTotalPage() {
		return iListDao.selectTotalPage();
	}

	@Override
	public boolean listInsert(ListDto list) {
		return iListDao.listInsert(list);
	}

	@Override
	public boolean deleteAll() {
		return iListDao.deleteAll();
	}



}
