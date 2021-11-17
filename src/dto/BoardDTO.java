package dto;

import java.util.Date;

public class BoardDTO {
	
	private Long dno;
	private String author;
	private String title;
	private String content;
	private Long hit;
	private String ip;
	private Date postdate;
	
	
	public Long getDno() {
		return dno;
	}
	public void setDno(Long dno) {
		this.dno = dno;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getHit() {
		return hit;
	}
	public void setHit(Long hit) {
		this.hit = hit;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Date getPostdate() {
		return postdate;
	}
	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}
	
	
	
}
