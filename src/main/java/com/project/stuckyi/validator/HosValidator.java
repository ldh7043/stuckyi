package com.project.stuckyi.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.project.stuckyi.domain.HosDTO;

public class HosValidator implements Validator {

   @Override
   public boolean supports(Class<?> clazz) {
      System.out.println("supports(" + clazz.getName() + ")");
      return HosDTO.class.isAssignableFrom(clazz);
   }

   @Override
   public void validate(Object target, Errors errors) {
      HosDTO dto = (HosDTO)target;
      
      //오류 검출할것들
      
      String hosName = dto.getHosName();
      if(hosName == null || hosName.trim().isEmpty()) {
         System.out.println("환자명을 입력해주세요");
      } else {
         System.out.println("환자명 입력완료.");
      }
      
      String hosTitle = dto.getHosTitle();
      if(hosTitle == null || hosTitle.trim().isEmpty()) {
         System.out.println("병원명을 입력해주세요");
      } else {
         System.out.println("병원명 입력완료.");
      }

   }

}