package com.project.stuckyi.domain;

public class HosWriteResult {
   
   int hosCount;
   String hosStatus;
   String hosMessage;
   private String hosdateTime;
   
   public int getHosCount() {
      return hosCount;
   }
   public void setHosCount(int hosCount) {
      this.hosCount = hosCount;
   }
   public String getHosStatus() {
      return hosStatus;
   }
   public void setHosStatus(String hosStatus) {
      this.hosStatus = hosStatus;
   }
   public String getHosMessage() {
      return hosMessage;
   }
   public void setHosMessage(String hosMessage) {
      this.hosMessage = hosMessage;
   }
   public String getHosdateTime() {
      return hosdateTime;
   }
   public void setHosdateTime(String hosdateTime) {
      this.hosdateTime = hosdateTime;
   }
   
}