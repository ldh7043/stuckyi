package com.project.stuckyi.domain;

import java.util.List;

public class HosWriteList extends HosWriteResult {
   
   List<HosDTO> hoslist;
   
   int page;
   
   int hosTotalPage;
   
   int hosTotalCnt;
   
   int hosWritePages;
   
   int hosPageRows;

   public List<HosDTO> getHoslist() {
      return hoslist;
   }

   public void setHoslist(List<HosDTO> hoslist) {
      this.hoslist = hoslist;
   }

   public int getPage() {
      return page;
   }

   public void setPage(int page) {
      this.page = page;
   }

   public int getHosTotalPage() {
      return hosTotalPage;
   }

   public void setHosTotalPage(int hosTotalPage) {
      this.hosTotalPage = hosTotalPage;
   }

   public int getHosTotalCnt() {
      return hosTotalCnt;
   }

   public void setHosTotalCnt(int hosTotalCnt) {
      this.hosTotalCnt = hosTotalCnt;
   }

   public int getHosWritePages() {
      return hosWritePages;
   }

   public void setHosWritePages(int hosWritePages) {
      this.hosWritePages = hosWritePages;
   }

   public int getHosPageRows() {
      return hosPageRows;
   }

   public void setHosPageRows(int hosPageRows) {
      this.hosPageRows = hosPageRows;
   }
   
   

}