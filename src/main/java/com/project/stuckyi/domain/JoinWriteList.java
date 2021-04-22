package com.project.stuckyi.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JoinWriteList extends JoinWriteResult{
   List<JoinDTO> list;  // 데이터 목록
   
   int page;   // 현재 페이지 #
   
   int totalPage;  // 총 몇 '페이지' 분량인가?
   
   int totalCnt;   // 글은 총 몇개인가?
   
   int writePages;   // 한 [페이징] 에 몇개의 '페이지' 를 표현할 것인가?
   
   int pageRows;   // 한 '페이지' 에 몇개의 글을 리스트 할 것입인가?

   public List<JoinDTO> getList() {
      return list;
   }

   public void setList(List<JoinDTO> list) {
      this.list = list;
   }

   public int getPage() {
      return page;
   }

   public void setPage(int page) {
      this.page = page;
   }

   public int getTotalPage() {
      return totalPage;
   }

   public void setTotalPage(int totalPage) {
      this.totalPage = totalPage;
   }

   public int getTotalCnt() {
      return totalCnt;
   }

   public void setTotalCnt(int totalCnt) {
      this.totalCnt = totalCnt;
   }

   public int getWritePages() {
      return writePages;
   }

   public void setWritePages(int writePages) {
      this.writePages = writePages;
   }

   public int getPageRows() {
      return pageRows;
   }

   public void setPageRows(int pageRows) {
      this.pageRows = pageRows;
   }
}