package com.project.stuckyi.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.project.stuckyi.domain.JoinDTO;

public class UpdateValidator implements Validator {

   @Override
   public boolean supports(Class<?> clazz) {
      System.out.println("supports(" + clazz.getName() + ")");
      return JoinDTO.class.isAssignableFrom(clazz);
   }

   @Override
   public void validate(Object target, Errors errors) {
      System.out.println("validate()");
      JoinDTO dto = (JoinDTO)target;
      
      String ph = dto.getPh();
      String phReg = "(^01[0|1|2|6|7|8|9]?)(\\d{3,4})(\\d{4})$";
      Boolean resultPhone = Pattern.matches(phReg, ph);
      if(ph == null || ph.trim().isEmpty() || resultPhone == false) {
         System.out.println("전화번호 오류 : 전화번호를 입력하세요.(02-111-1111 또는 010-1111-1111)");
         errors.rejectValue("ph", "WrongPhone");
      }
      
      String id = dto.getId();
      if(id == null || id.trim().isEmpty() || id.length()<5 || id.length() > 12) {
         System.out.println("id 오류: 5~12자 이내로 입력해주세요.");
         // 에러등록 rejectValue(field, errorCode);
         errors.rejectValue("id", "WrongID");
      }
      
      String pw = dto.getPw();
      if(pw == null || pw.trim().isEmpty() || pw.length()<8 || pw.length()>20) {
         System.out.println("비밀번호 오류 : 비밀번호를 입력하세요.(8자이상 20자 이하)");
         errors.rejectValue("pw", "WrongPw");
      } 
      
      String email = dto.getEmail();
      String emailAddr = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
      Boolean resultEmail = Pattern.matches(emailAddr, email);
      
      if(email == null || email.trim().isEmpty() || resultEmail == false) {
         System.out.println("email 오류 : 이메일을 입력하세요.(ABCD@xxxx.com)");
         errors.rejectValue("email", "WrongEmail");
      }
   }
}