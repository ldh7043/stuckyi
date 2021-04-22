package com.project.stuckyi.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.stuckyi.service.HosService;
import com.project.stuckyi.service.JoinService;
import com.project.stuckyi.service.MainBoardService;
import com.project.stuckyi.service.TransAjaxService;

@Controller
@RequestMapping("/admin")
public class AdminController {
   
   private JoinService joinService;
   private HosService hosService;
   private TransAjaxService transService;
   private MainBoardService boardService;
   
   public AdminController() {}
   
   @Autowired
   public void setAdminService(JoinService joinService) {
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
    
    @Autowired
    public void setBoardService(MainBoardService boardService) {
       this.boardService = boardService;
    }
   
   @RequestMapping("/member")
   public String listAdmin(Model model) {
      model.addAttribute("list", joinService.listJoinAll());
      return "admin/adminMain";
   }
   
   @GetMapping("/memberinfo/{id}")
   public String infoAdmin(Model model, @PathVariable String id, HttpServletRequest request) {
      request.setAttribute("id", id);
         model.addAttribute("listHos", hosService.selectHos());
        model.addAttribute("listTrans", transService.selectTrans());
        model.addAttribute("listboard", boardService.countBoard());
      return "admin/adminInfo";
   }   
   
   @GetMapping("/memberinfo/adminDeleteTrans")
    public String mypageDeleteTrans(int transUid, String userId, Model model, HttpServletRequest request) {   
      request.setAttribute("userId", userId);
      request.setAttribute("id", transUid);
      model.addAttribute("result", transService.deleteTransByUid(transUid));
      return "admin/adminDeleteTrans";
   }
   
   @RequestMapping("/memberinfo/adminDeleteHos")
    public String adminDeleteHos(int hosUid, String userId, Model model, HttpServletRequest request) {
      request.setAttribute("userId", userId);
      request.setAttribute("id", hosUid);   
      model.addAttribute("result", hosService.deleteHosByUid(hosUid));
      return "admin/adminDeleteHos";
   }
   
   @RequestMapping("/memberinfo/adminDeleteBrd")
    public String adminDeleteBrd(int brdUid, String userId, Model model, HttpServletRequest request) {
      request.setAttribute("userId", userId);
      request.setAttribute("id", brdUid);
      model.addAttribute("result", boardService.boardDelete(brdUid));
      return "admin/adminDeleteBrd";
   }
   
}