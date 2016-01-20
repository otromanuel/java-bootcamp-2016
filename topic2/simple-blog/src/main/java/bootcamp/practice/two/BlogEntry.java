package bootcamp.practice.two;

import java.util.Date;

public class BlogEntry {

	private String title;
	private String content;
	private Date date;
	
	public String getContent() {
		return content;
	}

	public Date getDate() {
		return date;
	}	

	public String getTitle() {
		return this.title;
	}

	public BlogEntry(String title, String content) {
		this.title = title;
		this.content = content;
		this.date = new Date();
	}



}
