package com.project.stuckyi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.stuckyi.domain.HosDTO;
import com.project.stuckyi.domain.TransWriteDTO;
import com.project.stuckyi.domain.TransWriteList;
import com.project.stuckyi.domain.TransWriteResult;
import com.project.stuckyi.service.TransAjaxService;
import com.project.stuckyi.validator.HosValidator;
import com.project.stuckyi.validator.TransValidator;

import oracle.jdbc.driver.Message;

@Controller
@RequestMapping("/trans")
public class transController {

   @Autowired
   TransAjaxService TransAjaxService;
   
   
   //택시 메인 페이지
   @RequestMapping("/transmain")
   public String trmain() {
      return "trans/transTaxiMain";
   }
   
   //택시 예약 페이지
   @RequestMapping("/taxireserve")
   public String taxiInfo() {
      return "trans/transTaxiReserve";
   }
   
   //지하철 메인 페이지
   @RequestMapping("/submain")
   public String submain() {
      return "trans/transSubMain";
   }
   
   //지하철 정보 페이지
   @RequestMapping("/subinfo")
   public String subinfo() {
      return "trans/transSubInfo";
   }
   
   //등록완료
   @RequestMapping("/transReserveOk")
   public String registerOk(@ModelAttribute("t") @Valid TransWriteDTO dto
         , BindingResult bindingresult
         , Model model) {
      
      showErrors(bindingresult);
      
      String page;
      if(bindingresult.hasErrors()) {
         page = "trans/transTaxiReserve";
      } else {
         page = "trans/transReserveOk";
         model.addAttribute("result", TransAjaxService.transWrite(dto));
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
      binder.setValidator(new TransValidator());
   }
   
   
} // end transController();



