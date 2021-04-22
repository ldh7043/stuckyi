package com.project.stuckyi.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BoardDTO {
	private int brdUid;
	private String brdTitle;
	private String brdContent;
	private int brdViewcnt;
	private String brdType;
	private LocalDate brdRegdate;
	private String userId;
	public int getBrdUid() {
		return brdUid;
	}
	public void setBrdUid(int brdUid) {
		this.brdUid = brdUid;
	}
	public String getBrdTitle() {
		return brdTitle;
	}
	public void setBrdTitle(String brdTitle) {
		this.brdTitle = brdTitle;
	}
	public String getBrdContent() {
		return brdContent;
	}
	public void setBrdContent(String brdContent) {
		this.brdContent = brdContent;
	}
	public int getBrdViewcnt() {
		return brdViewcnt;
	}
	public void setBrdViewcnt(int brdViewcnt) {
		this.brdViewcnt = brdViewcnt;
	}
	public String getBrdType() {
		return brdType;
	}
	public void setBrdType(String brdType) {
		this.brdType = brdType;
	}
	public LocalDate getBrdRegdate() {
		return brdRegdate;
	}
	public void setBrdRegdate(LocalDate brdRegdate) {
		this.brdRegdate = brdRegdate;
	}
	
	//  regDate 를 String 으로 리턴하는 getter
	public String getRegDate() {
		if(this.brdRegdate == null) return "";
		return this.brdRegdate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}


	
}
