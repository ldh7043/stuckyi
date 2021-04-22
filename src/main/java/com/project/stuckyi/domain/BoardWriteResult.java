package com.project.stuckyi.domain;

public class BoardWriteResult {

	int boardCount;
	String boardStatus;  
	String boardMessage;
	private String dateTime;
	
	
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public int getBoardCount() {
		return boardCount;
	}
	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}
	public String getBoardStatus() {
		return boardStatus;
	}
	public void setBoardStatus(String boardStatus) {
		this.boardStatus = boardStatus;
	}
	public String getBoardMessage() {
		return boardMessage;
	}
	public void setBoardMessage(String boardMessage) {
		this.boardMessage = boardMessage;
	}
	
	
	
}
