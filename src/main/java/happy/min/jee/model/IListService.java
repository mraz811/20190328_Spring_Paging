package happy.min.jee.model;

import java.util.List;

import happy.min.jee.dto.ListDto;
import happy.min.jee.dto.PagingDto;

public interface IListService {

	public List<ListDto> selectPaging(PagingDto paging);
	public int selectTotalPage();
	
	public boolean listInsert(ListDto list);
	public boolean deleteAll();
	
}
