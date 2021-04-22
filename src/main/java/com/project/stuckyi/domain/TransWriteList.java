package com.project.stuckyi.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransWriteList extends TransWriteResult {

   List<TransWriteDTO> list;

   int page;

   int transTotalPage;

   int transTotalCnt;

   int transPages;

   int pageRows;

   public List<TransWriteDTO> getList() {
      return list;
   }

   public void setList(List<TransWriteDTO> list) {
      this.list = list;
   }

   public int getPage() {
      return page;
   }

   public void setPage(int page) {
      this.page = page;
   }

   public int getTransTotalPage() {
      return transTotalPage;
   }

   public void setTransTotalPage(int transTotalPage) {
      this.transTotalPage = transTotalPage;
   }

   public int getTransTotalCnt() {
      return transTotalCnt;
   }

   public void setTransTotalCnt(int transTotalCnt) {
      this.transTotalCnt = transTotalCnt;
   }

   public int getTransPages() {
      return transPages;
   }

   public void setTransPages(int transPages) {
      this.transPages = transPages;
   }

   public int getPageRows() {
      return pageRows;
   }

   public void setPageRows(int pageRows) {
      this.pageRows = pageRows;
   }

} // end TransWriteResult();