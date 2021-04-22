package com.project.stuckyi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.stuckyi.domain.HosDTO;
import com.project.stuckyi.service.HosService;
import com.project.stuckyi.validator.HosValidator;

@Controller
@RequestMapping("/clinic")
public class HosController {
   
   private HosService hosService;
   
   @Autowired
   public void setHosService(HosService hosService) {
      this.hosService = hosService;
   }
   
   public HosController() {}
   
   //홈페이지 css test
   @RequestMapping("/clinictest")
   public String htest(HttpServletRequest request) {
      return "clinic/clinicResult";
   }
   
   //병원메인페이지
   @RequestMapping("/clinicmain")
   public String hmain() {
      return "clinic/clinicMain";
   }
   
   //병원정보페이지
   @RequestMapping("/clinicinfo")
   public String hinfo(HttpServletRequest request) {
      return "clinic/clinicInfo";
   }
   
   //예약등록
   @RequestMapping("/clinicreserve")
   public String register() {
      return "clinic/clinicReserve";
   }
   
   //등록완료
   @RequestMapping("/clinicReserveOk")
   public String registerOk(@ModelAttribute("h") @Valid HosDTO dto
         , BindingResult bindingresult
         , Model model) {
      
      System.out.println("병원이름: " + dto.getHosTitle() + "\n예약시간: " + dto.getHosTime() + "\n환자명: " + dto.getHosName() + "\n예약날짜: " + dto.getResDate() + "\n진료과목: " + dto.getHosType() + "\n");
      
      showErrors(bindingresult);
      
      String page;
      if(bindingresult.hasErrors()) {
         page = "clinic/clinicReserve";
      } else {
         page = "clinic/clinicReserveOk";
         model.addAttribute("result", hosService.regiHos(dto));
      }
      
      return page;
   }
   
   private void showErrors(Errors errors) {
      if(errors.hasErrors()) {
         System.out.println("에러 갯수: " + errors.getErrorCount());
         System.out.println("\t[field]\t|[code]");
         errors.getFieldErrors();
         List<FieldError> errList = errors.getFieldErrors();
         
         for(FieldError err : errList) {
            System.out.println("\t" + err.getField() + "\t|" + err.getCode());
         }
      } else {
         System.out.println("에러없음 \n");
      }
   }
   
   @InitBinder
   public void initBinder(WebDataBinder binder) {
      binder.setValidator(new HosValidator());
   }
   
}