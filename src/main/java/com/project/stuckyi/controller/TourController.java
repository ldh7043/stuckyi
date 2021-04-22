package com.project.stuckyi.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tour")
public class TourController {
	
	public TourController() {}

	//투어 검색 페이지
	@RequestMapping("/tourmain")
	public String tmain(Model model) {
		return "tour/tourMain";
	}
	
	//투어 정보 페이지
	@RequestMapping("/tourinfo")
	public String tinfo(HttpServletRequest request) {
      return "tour/tourInfo";
   }
}
