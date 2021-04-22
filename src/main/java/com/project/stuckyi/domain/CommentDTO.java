package com.project.stuckyi.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommentDTO {
	private int cmtUid;
	private String cmtContent;
	private int brdUid;
	private String userid;
	private LocalDate cmtRegdate;
	public int getCmtUid() {
		return cmtUid;
	}
	public void setCmtUid(int cmtUid) {
		this.cmtUid = cmtUid;
	}
	public String getCmtContent() {
		return cmtContent;
	}
	public void setCmtContent(String cmtContent) {
		this.cmtContent = cmtContent;
	}
	public int getBrdUid() {
		return brdUid;
	}
	public void setBrdUid(int brdUid) {
		this.brdUid = brdUid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public LocalDate getCmtRegdate() {
		return cmtRegdate;
	}
	public void setCmtRegdate(LocalDate cmtRegdate) {
		this.cmtRegdate = cmtRegdate;
	}
	
//  regDate 를 String 으로 리턴하는 getter
	public String getCmtRegDate() {
		if(this.cmtRegdate == null) return "";
		return this.cmtRegdate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}
	

}
