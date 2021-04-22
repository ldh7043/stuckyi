package com.project.stuckyi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.stuckyi.domain.JoinDTO;
import com.project.stuckyi.service.HosService;
import com.project.stuckyi.service.JoinService;
import com.project.stuckyi.service.TransAjaxService;
import com.project.stuckyi.validator.UpdateValidator;

@Controller
@RequestMapping("/main")
public class MainController {
	
	private JoinService joinService;
	private HosService hosService;
	private TransAjaxService transService;
	// 생성자
	public MainController() {
		
	}
	@Autowired
	   public void setJoinService(JoinService joinService) {
	      this.joinService = joinService;
	   }

   @Autowired
   public void setHosService(HosService hosService) {
      this.hosService = hosService;
   }

   @Autowired
   public void setTransService(TransAjaxService transService) {
      this.transService = transService;
   }
	@GetMapping("/accessError")
	public String accessDenied(Authentication auth, Model model) {
		System.out.println("access Denied: " + auth);
		
		model.addAttribute("msg", "접근 권한 거부");
		
		return "home/accessError";

	}
	
	@GetMapping("/home")
	public String homePage() {
		return "home/homeBeforeLogin";
	}
	
	@GetMapping("/login")
	public String loginInput(String error, String logout, Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("error: " + error);
		System.out.println("logout: " + logout);
		
		// session 에 있는 메세지를 model 로 받아서 옮기고, session에 있는 건 없애주기
		System.out.println("GET:/main/login.  loginFailMsg = " + session.getAttribute("loginFailMsg")); 
		
		if(session.getAttribute("loginFailMsg") != null) {
			model.addAttribute("loginFailMsg", session.getAttribute("loginFailMsg"));
			session.removeAttribute("loginFailMsg");
		}
		
		if(error != null) {
			model.addAttribute("error", "로그인 에러, 계정정보 확인 부탁");
		}
		
		if(logout != null) {
			model.addAttribute("logout", "로그아웃!");
		}
		
		return "home/login";
	}
	
	@PostMapping("/logFail")
	public String logFail() {		
		return "redirect:main/login";
	}
	
	@GetMapping("/logout")
	public String logoutGET(String error, String logout, Model model) {
		System.out.println("GET: cutsom logout");

		if(error != null) {
			model.addAttribute("error", "로그인 에러, 계정정보 확인 부탁");
		}
		
		if(logout != null) {
			model.addAttribute("logout", "로그아웃!");
		}
		
		return "home/login";
	}

	@PostMapping("/logout")
   public String logoutPOST(String error, String logout, Model model) {
      System.out.println("POST: cutsom logout");

      if(error != null) {
         model.addAttribute("error", "로그인 에러, 계정정보 확인 부탁");
      }
      
      if(logout != null) {
         model.addAttribute("logout", "로그아웃!");
      }
      
      return "home/homeBeforeLogin";
   }
	
	@GetMapping("/homeLogged")
	public String homePageLogged() {
		System.out.println("Get: homeAfterLogin");
		return "home/homeBeforeLogin";
	}
	
	@RequestMapping("/welfareMain")
	public String welfareMain() {
		
		return "welfare/welfareMain";
	}
	@RequestMapping("/welfareInfo")
	public String welfareInfo() {
		
		return "welfare/welfareInfo";
	}
	
	@RequestMapping("/mypage")
	   public String mypage(Model model) {      
	      model.addAttribute("listHos", hosService.selectHos());
	      model.addAttribute("listTrans", transService.selectTrans());
	      return "home/mypage";
	   }
	   
	   // 회원 등록 ok
	   @RequestMapping("/mypageUpdate")
	   public String writeOkJoin(@ModelAttribute("j") @Valid JoinDTO dto, 
	      BindingResult bindingResult, Model model) {
	      UpdateValidator validator = new UpdateValidator();
	      validator.validate(dto, bindingResult);
	      
	      showErrors(bindingResult);
	      
	      String page = "home/mypageUpdate";
	      
	      if(bindingResult.hasErrors()) { // 에러가 있었으면
	         page = "home/mypage";  // 원래 폼으로 돌아가기
	      }
	      model.addAttribute("result" , joinService.updateJoin(dto));
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
	   
	   @RequestMapping("/mypageDeleteHos")
	   public String mypageDeleteHos(int hosUid, Model model) {
	      model.addAttribute("result", hosService.deleteHosByUid(hosUid));
	      return "home/mypageDeleteHos";
	   }
	   
	   @RequestMapping("/mypageDeleteTrans")
	   public String mypageDeleteTrans(int transUid, Model model) {
	      model.addAttribute("result", transService.deleteByUid(transUid));
	      return "home/mypageDeleteTrans";
	   }
	   
	
}
