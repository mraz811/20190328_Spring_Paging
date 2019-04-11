package happy.min.jee;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import happy.min.jee.dto.ListDto;
import happy.min.jee.dto.PagingDto;
import happy.min.jee.model.IListService;

// 4^^번
@Controller
public class Moon2seul_Ctrl {

	private Logger logger = LoggerFactory.getLogger(Moon2seul_Ctrl.class);
	
	@Autowired
	private IListService iListService; 
	// 얘를 상속받은 객체가 bean이어야 하니 ServiceImpl이 @Service로 빈 선언이 되어 있어야 함
	
	// 5^^번
	@RequestMapping(value="/test.do", method=RequestMethod.GET)
	public String yeongJae() {
		logger.info("행복한 민지 패키지에 있는 문이슬 아래 있는 영재로 옴");
//		return "/WEB-INF/view/test.jsp";
		return "paging";
	}
	
	@RequestMapping(value="/paging.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String paging(PagingDto paging, Model model /*int index, int pageStartNum, int listCnt*/) {
		logger.info("페이징 시작하는 곳: {}", new Date());
		logger.info("전송받은 PagingDto값: " +paging);
		
		List<ListDto> lists = iListService.selectPaging(paging);
		paging.setTotal(iListService.selectTotalPage());
		
		model.addAttribute("lists", lists);
		model.addAttribute("paging", paging);
		logger.info("================== 페이징 DTO 값 : " +paging);
		
		return "paging";
	}
	
	@RequestMapping(value="/list.do", method=RequestMethod.GET)
	public String list(int num) {
		// math.random말고 얘 random 함수 사용하는 이유는 범위를 설정할 수 있기 때문
		Random ran = new Random();
		for (int i = 0; i < num; i++) {			// 범위
			iListService.listInsert(new ListDto(ran.nextInt(10000000)+"", ""));
		}
		
		return "redirect:/paging.do";
	}
	
	@RequestMapping(value="/remove.do", method=RequestMethod.GET)
	public String remove() {
		iListService.deleteAll();
		return "redirect:/paging.do";
	}
	
	
}
