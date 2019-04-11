package happy.min.jee.dto;

import java.io.Serializable;

public class ListDto implements Serializable {

	private static final long serialVersionUID = -5634591550669502773L;

	private String title;
	private String regdate;

	public ListDto() {
		super();
	}

	public ListDto(String title, String regdate) {
		super();
		this.title = title;
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "ListDto [title=" + title + ", regdate=" + regdate + "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	
	
	
}
