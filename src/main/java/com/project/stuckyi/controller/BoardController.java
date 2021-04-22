package com.project.stuckyi.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.stuckyi.domain.BoardDTO;
import com.project.stuckyi.service.JoinService;
import com.project.stuckyi.service.MainBoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	MainBoardService mainBoardService;
	
	@Autowired
	JoinService joinService;
	
	@RequestMapping("/list")
	public String boardList(Model model) {
//		model.addAttribute("boardList", mainBoardService.boardList(1, 10));
		return "board/boardList";
	}
	
	@RequestMapping("/write")
	public String boardWrite(BoardDTO dto, HttpSession session, Model model) {
		model.addAttribute("userid", session.getAttribute("userId"));
		return "board/boardWrite";
	}

	// dto, writer, 잘 넘어가는지 확인
	@RequestMapping("/writeOk")
	public String boardWriteOk(BoardDTO dto, HttpSession session, Model model) {
		// session에 저장된 userID
//		String writer = (String) session.getAttribute("user_id");
//		// writer를 BoardDTO의 userId로 설정
//		dto.setUserId(writer);
		model.addAttribute("boardWrite", mainBoardService.boardWrite(dto));
		return "board/boardWriteOk";
	}
	
	@GetMapping("/view")
	public String view(int uid, Model model) {
		model.addAttribute("viewcnt", mainBoardService.incViewBoard(uid));
		model.addAttribute("boarditem", mainBoardService.selectMainByUid(uid));
		return "board/boardView";
	}
	
	@RequestMapping("/update")
	public String update(int uid, Model model) {
		model.addAttribute("list", mainBoardService.selectMainByUid(uid));		
		return "board/boardUpdate";
	}

	@PostMapping("/updateOk")
	public String updateOk(BoardDTO dto, Model model) {
		
		int boardUpdate = mainBoardService.boardUpdate(dto);
		model.addAttribute("result", boardUpdate);
		return "board/boardUpdateOk";
	}

	@GetMapping("/delete")
	public String deleteOk(int uid, Model model) {
		model.addAttribute("result", mainBoardService.boardDelete(uid));
		return "board/boardDelete";
	}
	
	
	

}
