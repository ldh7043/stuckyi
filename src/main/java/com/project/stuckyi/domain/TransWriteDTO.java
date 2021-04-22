package com.project.stuckyi.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransWriteDTO {
   private int transUid;
   private String transAddr; // 주소지
   private String transDate; // 예약날짜
   private String transTime; // 예약시간
   private String transComment; // 요청사항
   private String transName; // 탑승자
   private String userId; // 아이디
   private LocalDateTime wDate; // 등록날짜

   public TransWriteDTO() {
      super();
      // TODO Auto-generated constructor stub
   }

   public TransWriteDTO(int transUid, String transAddr, String transDate, String transTime, String transComment,
         String transName, String userId, LocalDateTime wDate) {
      super();
      this.transUid = transUid;
      this.transAddr = transAddr;
      this.transDate = transDate;
      this.transTime = transTime;
      this.transComment = transComment;
      this.transName = transName;
      this.userId = userId;
      this.wDate = wDate;
   }

   public int getTransUid() {
      return transUid;
   }

   public void setTransUid(int transUid) {
      this.transUid = transUid;
   }

   public String getTransAddr() {
      return transAddr;
   }

   public void setTransAddr(String transAddr) {
      this.transAddr = transAddr;
   }

   public String getTransDate() {
      return transDate;
   }

   public void setTransDate(String transDate) {
      this.transDate = transDate;
   }

   public String getTransTime() {
      return transTime;
   }

   public void setTransTime(String transTime) {
      this.transTime = transTime;
   }

   public String getTransComment() {
      return transComment;
   }

   public void setTransComment(String transComment) {
      this.transComment = transComment;
   }

   public String getTransName() {
      return transName;
   }

   public void setTransName(String transName) {
      this.transName = transName;
   }

   public String getUserId() {
      return userId;
   }

   public void setUserId(String userId) {
      this.userId = userId;
   }

   public LocalDateTime getwDate() {
      return wDate;
   }

   public void setwDate(LocalDateTime wDate) {
      this.wDate = wDate;
   }

   // regDate 를 String 으로 리턴하는 getter
   public String getRegDateTime() {
      if (this.wDate == null)
         return "";
      return this.wDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
   }

} // end DTO