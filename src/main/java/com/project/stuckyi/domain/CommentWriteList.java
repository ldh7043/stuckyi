package com.project.stuckyi.domain;

import java.util.List;

public class CommentWriteList extends CommentWriteResult{
	List<CommentDTO> commentList;
	
	int commentpage;
	
	int commentTotalPage;
	
	int commentTotalCnt;
	
	int commentWritePages;
	
	int commentPageRows;

	public List<CommentDTO> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<CommentDTO> commentList) {
		this.commentList = commentList;
	}

	public int getCommentpage() {
		return commentpage;
	}

	public void setCommentpage(int commentpage) {
		this.commentpage = commentpage;
	}

	public int getCommentTotalPage() {
		return commentTotalPage;
	}

	public void setCommentTotalPage(int commentTotalPage) {
		this.commentTotalPage = commentTotalPage;
	}

	public int getCommentTotalCnt() {
		return commentTotalCnt;
	}

	public void setCommentTotalCnt(int commentTotalCnt) {
		this.commentTotalCnt = commentTotalCnt;
	}

	public int getCommentWritePages() {
		return commentWritePages;
	}

	public void setCommentWritePages(int commentWritePages) {
		this.commentWritePages = commentWritePages;
	}

	public int getCommentPageRows() {
		return commentPageRows;
	}

	public void setCommentPageRows(int commentPageRows) {
		this.commentPageRows = commentPageRows;
	}
	
	
}
