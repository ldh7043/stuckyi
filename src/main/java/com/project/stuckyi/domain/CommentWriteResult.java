package com.project.stuckyi.domain;

public class CommentWriteResult {
	int commentCount;
	String commentStatus;  
	String commentMessage;
	private String commentdateTime;
	public int getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	public String getCommentStatus() {
		return commentStatus;
	}
	public void setCommentStatus(String commentStatus) {
		this.commentStatus = commentStatus;
	}
	public String getCommentMessage() {
		return commentMessage;
	}
	public void setCommentMessage(String commentMessage) {
		this.commentMessage = commentMessage;
	}
	public String getCommentdateTime() {
		return commentdateTime;
	}
	public void setCommentdateTime(String commentdateTime) {
		this.commentdateTime = commentdateTime;
	}
	
	

}
