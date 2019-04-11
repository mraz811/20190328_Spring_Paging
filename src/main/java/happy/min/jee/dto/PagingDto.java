package happy.min.jee.dto;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PagingDto {

	private Logger logger = LoggerFactory.getLogger(PagingDto.class);
	
	private int pageCnt; // 출력할 페이지 번호 개수 ex) 10개씩, 5개씩
	private int index; // 출력할 페이지 번호  
	
	private int pageStartNum; // 출력할 페이지 시작 번호 
	private int listCnt; // 페이지당 출력할 리스트 개수
	
	private int total; // 전체 글 개수(리스트 총 개수)
	
	// 초기값을 여기서 입력하고, 이번엔 ajax처리를 해볼 예정. 
	// dto를 하나 만들어 놓고 부를 때마다 ajax로 변경하니 효율성, 속도면에서 훨씬 좋음
	{
		logger.info("=========== 페이지 DTO 초기화 블럭 실행 시간: "+(new Date())+" ===========");
		pageCnt = 5;
		index = 0;
		pageStartNum = 1;
		listCnt = 5;
	}
	
	// default 생성자를 만들고
	public PagingDto() {}
	
	// 생성자 오버로딩을 할 건데, 타입을 여기서 맞춰 줄 예정
	// 화면에서 index, pageStartNum, listCnt만 받아줄 예정
	public PagingDto(String index, String pageStartNum, String listCnt) {
		logger.info("=========== 페이지 DTO 생성자 호출 시간: "+(new Date())+" ===========");
		
		// 화면에서 값을 가지고 오지 않으면 null point exception이 발생할 수 있기 때문에 
		// 값을 받아오는 상황에서만 입력해주도록 if문으로 걸러줌
		if(index != null) {
			this.index = Integer.parseInt(index);
		}
		if(pageStartNum != null) {
			this.pageStartNum = Integer.parseInt(pageStartNum);
		}
		if(listCnt != null) {
			this.listCnt = Integer.parseInt(listCnt);
		}
	}
	
	public int getStart() {
		logger.info("=========== 페이지 DTO getStart 실행 시간: "+(new Date())+" ===========");
		return index*listCnt+1;
	}
	
	public int getLast() {
		logger.info("=========== 페이지 DTO getLast 실행 시간: "+(new Date())+" ===========");
		return (index*listCnt)+listCnt;
	}
	
	public int getPageLastNum() { // 마지막 번호 계산
		logger.info("=========== 페이지 DTO getPageLastNum 실행 시간: "+(new Date())+" ===========");
		int pageLastNum = 0 ;
		int remainListCnt = total - listCnt*(pageStartNum-1);
		int remainPageCnt = remainListCnt/listCnt;
		
		if(remainListCnt%listCnt != 0) {
			remainPageCnt++;
		}
		
		if(remainListCnt <= listCnt) {
			pageLastNum = pageStartNum;
		} else if(remainPageCnt <= pageCnt) {
			pageLastNum = remainPageCnt + pageStartNum-1;
		} else {
			pageLastNum = pageCnt + pageStartNum-1;
		}
				
		return pageLastNum;
	}

	public int getPageCnt() {
		logger.info("=========== 페이지 DTO getPageCnt 실행 시간: "+(new Date())+" ===========");
		return pageCnt;
	}

	public void setPageCnt(int pageCnt) {
		this.pageCnt = pageCnt;
	}

	public int getIndex() {
		logger.info("=========== 페이지 DTO getIndex 실행 시간: "+(new Date())+" ===========");
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getPageStartNum() {
		logger.info("=========== 페이지 DTO getPageStartNum 실행 시간: "+(new Date())+" ===========");
		return pageStartNum;
	}

	public void setPageStartNum(int pageStartNum) {
		this.pageStartNum = pageStartNum;
	}

	public int getListCnt() {
		logger.info("=========== 페이지 DTO getListCnt 실행 시간: "+(new Date())+" ===========");
		return listCnt;
	}

	public void setListCnt(int listCnt) {
		this.listCnt = listCnt;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "PagingDto [pageCnt=" + pageCnt + ", index=" + index + ", pageStartNum=" + pageStartNum + ", listCnt="
				+ listCnt + ", total=" + total + "]";
	}
	
	
	
	
	
	
	
	
}
