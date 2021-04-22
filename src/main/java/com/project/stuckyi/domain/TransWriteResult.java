package com.project.stuckyi.domain;

public class TransWriteResult {
   int transCount;
   String transStatus;
   String transMessage;
   private String transdateTime;
   
   public int getTransCount() {
      return transCount;
   }
   public void setTransCount(int transCount) {
      this.transCount = transCount;
   }
   public String getTransStatus() {
      return transStatus;
   }
   public void setTransStatus(String transStatus) {
      this.transStatus = transStatus;
   }
   public String getTransMessage() {
      return transMessage;
   }
   public void setTransMessage(String transMessage) {
      this.transMessage = transMessage;
   }
   public String getTransdateTime() {
      return transdateTime;
   }
   public void setTransdateTime(String transdateTime) {
      this.transdateTime = transdateTime;
   }
}