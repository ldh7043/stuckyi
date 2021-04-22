package com.project.stuckyi.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.stuckyi.domain.JoinDTO;
import com.project.stuckyi.service.HosService;
import com.project.stuckyi.service.JoinService;
import com.project.stuckyi.service.MainBoardService;
import com.project.stuckyi.validator.JoinValidator;

@Controller
@RequestMapping("/join")
public class JoinController {
	
	@Autowired
	private JoinService joinService;
	
	
	public JoinController() {
		
	}
	
	// 회원 등록
	@RequestMapping("/join")
	public String writeJoin(Model model) {
		return "home/join";
	}
	
	   // 회원 등록 ok
	   @RequestMapping("/joinOk")
	   public String writeOkJoin(@ModelAttribute("j") @Valid JoinDTO dto, 
	         BindingResult bindingResult, Model model) {
	      JoinValidator validator = new JoinValidator();
	      validator.validate(dto, bindingResult);
	      
	      showErrors(bindingResult);
	      
	      String page = "home/joinOk";
	      
	      if(bindingResult.hasErrors()) { // 에러가 있었으면
	         for(FieldError fieldError : bindingResult.getFieldErrors()) {
	            switch(fieldError.getField()) {
	            case "email":       
	                     model.addAttribute("errors","email 오류 : 이메일을 입력하세요.(ABCD@xxxx.com)");
	                     break;
	            case "id":
	               model.addAttribute("errors","ID 오류: 5~12자 이내로 입력해주세요.");
	               break;
	            case "name":
	               model.addAttribute("errors","name 오류 : 이름을 입력하세요.");
	               break;
	            case "pw":
	               model.addAttribute("errors","비밀번호 오류 : 비밀번호를 입력하세요.(8자이상 20자 이하)");
	               break;
	            case "ph":
	               model.addAttribute("errors","전화번호 오류 : 전화번호를 입력하세요. 단, 하이픈은 빼고 입력(ex.01011111111)");
	               break;
	            case "gender":
	               model.addAttribute("errors","gender 오류: 성별을 입력하세요.");
	               break;
	            }
	         }
	         page = "home/join";  // 원래 폼으로 돌아가기
	      }
	      model.addAttribute("result" , joinService.writeJoin(dto));
	      return page;
	   }

	
	@RequestMapping("/confirmId")
	public String confirmId(String id, Model model) {
		model.addAttribute("list" , joinService.selectJoinByUid(id));
		String page = "home/confirmId";
		
		return page;
	}

	private void showErrors(Errors errors) {
		if(errors.hasErrors()) {
			System.out.println("에러 개수 : " + errors.getErrorCount());
			System.out.println("\t[field]\t|[code]");
			List<FieldError> errList = errors.getFieldErrors();
			for(FieldError err : errList) {
				System.out.println("\t" + err.getField() + "\t|" + err.getCode());
			}
		} else {
			System.out.println("에러 없음");
		}
		
	}
	

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new JoinValidator());
	}
	
	
	
	
	
	
	//복지시설 url TODO

	
	
}
