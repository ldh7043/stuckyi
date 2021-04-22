package com.project.stuckyi.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HosDTO {
   private int hosUid;
   private String resDate; //예약날짜
   private String hosTime; //예약시간
   private String hosType; //진료과목
   private String hosTitle; //병원이름
   private String hosName; //환자이름
   private String hosPh; //전화번호
   private String userId; //아이디
   private LocalDateTime hosDate; // 등록일 

   public HosDTO(int hosUid, String resDate, String hosTime, String hosType, String hosTitle, String hosName,
         String hosPh, String userId, LocalDateTime hosDate) {
      super();
      this.hosUid = hosUid;
      this.resDate = resDate;
      this.hosTime = hosTime;
      this.hosType = hosType;
      this.hosTitle = hosTitle;
      this.hosName = hosName;
      this.hosPh = hosPh;
      this.userId = userId;
      this.hosDate = hosDate;
   }

   public HosDTO() {
      super();
      // TODO Auto-generated constructor stub
   }

   public int getHosUid() {
      return hosUid;
   }

   public void setHosUid(int hosUid) {
      this.hosUid = hosUid;
   }

   public String getResDate() {
      return resDate;
   }

   public void setResDate(String resDate) {
      this.resDate = resDate;
   }

   public String getHosTime() {
      return hosTime;
   }

   public void setHosTime(String hosTime) {
      this.hosTime = hosTime;
   }

   public String getHosType() {
      return hosType;
   }

   public void setHosType(String hosType) {
      this.hosType = hosType;
   }

   public String getHosTitle() {
      return hosTitle;
   }

   public void setHosTitle(String hosTitle) {
      this.hosTitle = hosTitle;
   }

   public String getHosName() {
      return hosName;
   }

   public void setHosName(String hosName) {
      this.hosName = hosName;
   }

   public String getHosPh() {
      return hosPh;
   }

   public void setHosPh(String hosPh) {
      this.hosPh = hosPh;
   }

   public String getUserId() {
      return userId;
   }

   public void setUserId(String userId) {
      this.userId = userId;
   }

   public LocalDateTime getHosDate() {
      return hosDate;
   }

   public void setHosDate(LocalDateTime hosDate) {
      this.hosDate = hosDate;
   }

   public String getRegDateTime() {
      if(this.hosDate == null) return "";
      return this.hosDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
   }
}