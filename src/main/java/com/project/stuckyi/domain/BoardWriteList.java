package com.project.stuckyi.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BoardWriteList extends BoardWriteResult {
	
	List<BoardDTO> boardlist;
	
	int page;
	
	int boardTotalPage;
	
	int boardTotalCnt;
	
	int boardWritePages;
	
	int boardPageRows;

	public List<BoardDTO> getList() {
		return boardlist;
	}

	public void setList(List<BoardDTO> list) {
		this.boardlist = list;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalPage() {
		return boardTotalPage;
	}

	public void setTotalPage(int totalPage) {
		this.boardTotalPage = totalPage;
	}

	public int getTotalCnt() {
		return boardTotalCnt;
	}

	public void setTotalCnt(int totalCnt) {
		this.boardTotalCnt = totalCnt;
	}

	public int getWritePages() {
		return boardWritePages;
	}

	public void setWritePages(int writePages) {
		this.boardWritePages = writePages;
	}

	public int getPageRows() {
		return boardPageRows;
	}

	public void setPageRows(int pageRows) {
		this.boardPageRows = pageRows;
	}
	
}
