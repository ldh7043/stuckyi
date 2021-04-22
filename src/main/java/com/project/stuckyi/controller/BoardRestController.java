package com.project.stuckyi.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.stuckyi.domain.BoardDTO;
import com.project.stuckyi.domain.BoardWriteList;
import com.project.stuckyi.domain.BoardWriteResult;
import com.project.stuckyi.domain.CommentDTO;
import com.project.stuckyi.domain.CommentWriteList;
import com.project.stuckyi.domain.CommentWriteResult;
import com.project.stuckyi.domain.HosDTO;
import com.project.stuckyi.domain.HosWriteList;
import com.project.stuckyi.domain.JoinDTO;
import com.project.stuckyi.domain.JoinWriteList;
import com.project.stuckyi.domain.TransWriteDTO;
import com.project.stuckyi.domain.TransWriteList;
import com.project.stuckyi.service.CommentService;
import com.project.stuckyi.service.HosService;
import com.project.stuckyi.service.JoinService;
import com.project.stuckyi.service.MainBoardService;
import com.project.stuckyi.service.TransAjaxService;

@RestController
public class BoardRestController {
	@Autowired
	MainBoardService mainBoardService;
	
	@Autowired
	CommentService commentService;
	   
	@Autowired
   HosService hosService;
   
   @Autowired
   TransAjaxService transService;
   
   @Autowired
   JoinService joinService;
   
	// 게시판 목록
	@GetMapping("/board/{page}/{pageRows}")
	public BoardWriteList boardList(
			@PathVariable int page,
			@PathVariable int pageRows){
		List<BoardDTO> boardList = null;
		String boardStatus = "FAIL";
		StringBuffer boardMessage = new StringBuffer();

		
		int writePages = 10;
		int totalPage = 0;
		int totalCnt = 0;
		
		try {
			totalCnt = mainBoardService.countBoard();
			
			totalPage = (int)Math.ceil(totalCnt / (double)pageRows);
			
			int from = (page - 1) * pageRows + 1;
			
			if (totalCnt <= pageRows * (page - 1)) {
				boardMessage.append("[param 값이 없거나 잘못 요청되었습니다.]");
				from = 1; page = 1;
				boardList = mainBoardService.boardList(from, pageRows);
			} else {
				boardList = mainBoardService.boardList(from, pageRows);
			}
			
			
			if(boardList == null) {
				boardMessage.append("[리스트할 데이터가 없습니다]");
			} else {
				boardStatus = "OK";
			}
		} catch (Exception e) {
			boardMessage.append("[트랜잭션 에러:" + e.getMessage() + "]");
		}
		
		BoardWriteList result = new BoardWriteList();
		result.setBoardStatus(boardStatus);
		String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		result.setDateTime(dateTime);
		
		if(boardList != null) {
			result.setBoardCount(boardList.size());
			result.setList(boardList);
		}
		result.setList(boardList);
		result.setBoardMessage(boardMessage.toString());
		result.setPage(page);
		result.setTotalPage(totalPage);
		result.setWritePages(writePages);
		result.setPageRows(pageRows);
		result.setTotalCnt(totalCnt);
		
		return result;
	}
	

	   @GetMapping("/board/{uid}")
	   public BoardWriteList boardView(@PathVariable int boarduid, Model model) {
	      List<BoardDTO> boardList = null;
	      List<CommentDTO> commentList = null;
	      StringBuffer boardMessage = new StringBuffer();
	      String boardStatus = "FAIL";

	      try {
	         boardList = mainBoardService.selectMainByUid(boarduid);

	         if (boardList.size() == 0) {
	            boardMessage.append("[해당 데이터가 없습니다]");
	         } else {
	            boardStatus = "OK";
	         }

	      } catch (NumberFormatException e) {
	         e.printStackTrace();
	         boardMessage.append("[유효하지 않은 parameter]");
	      } catch (Exception e) {
	         e.printStackTrace();
	         boardMessage.append("[트랜잭션 에러:" + e.getMessage() + "]");
	      }

	      BoardWriteList result = new BoardWriteList();
	      result.setBoardStatus(boardStatus);
	      result.setBoardMessage(boardMessage.toString());
	      String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	      result.setDateTime(dateTime);
	      if (boardList != null) {
	         result.setBoardCount(boardList.size());
	         result.setList(boardList);
	      }

	      return result;
	   }
	
	
	// 댓글 작성
		@PostMapping("/comment/writeOk")
		public CommentWriteResult writeOk(CommentDTO dto) {
			int count = 0;
			
			// response 에 필요한 값들
			StringBuffer message = new StringBuffer();
			String status = "FAIL";  // 기본 FAIL

			try {	

				count = commentService.commentWrite(dto);
				
				if(count == 0) {
					message.append("[트랜잭션 실패 : 0 insert]");
				} else {
					status = "OK";
				}

			} catch (Exception e) {
				//e.printStackTrace();				
				message.append("[트랜잭션 에러:" + e.getMessage() + "]");
			}

			CommentWriteResult result = new CommentWriteResult();
			result.setCommentStatus(status);
			result.setCommentMessage(message.toString());
			result.setCommentCount(count);
			return result;	
		}
		
	// 댓글 목록
	@GetMapping("/comment/{brduid}/{page}/{pageRows}")
	public CommentWriteList commentList(
			@PathVariable int brduid,
			@PathVariable int page,
			@PathVariable int pageRows){
		List<CommentDTO> commentList = null;
		String commentStatus = "FAIL";
		StringBuffer commentMessage = new StringBuffer();

		
		int writePages = 10;
		int totalPage = 0;
		int totalCnt = 0;
		
		try {
			totalCnt = commentService.countComment();
			
			totalPage = (int)Math.ceil(totalCnt / (double)pageRows);
			
			int from = (page - 1) * pageRows + 1;
			
			if (totalCnt <= pageRows * (page - 1)) {
				commentMessage.append("[param 값이 없거나 잘못 요청되었습니다.]");
				from = 1; page = 1;
				commentList = commentService.commentList(brduid, from, pageRows);
			} else {
				commentList = commentService.commentList(brduid, from, pageRows);
			}
			
			
			if(commentList == null) {
				commentMessage.append("[리스트할 데이터가 없습니다]");
			} else {
				commentStatus = "OK";
			}
		} catch (Exception e) {
			commentMessage.append("[트랜잭션 에러:" + e.getMessage() + "]");
		}
		
		CommentWriteList result = new CommentWriteList();
		result.setCommentStatus(commentStatus);
		String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		result.setCommentdateTime(dateTime);
		
		if(commentList != null) {
			result.setCommentCount(commentList.size());
			result.setCommentList(commentList);
		}
		
		result.setCommentList(commentList);
		result.setCommentMessage(commentMessage.toString());
		result.setCommentpage(page);
		result.setCommentTotalPage(totalPage);
		result.setCommentWritePages(writePages);
		result.setCommentPageRows(pageRows);
		result.setCommentTotalCnt(totalCnt);
		
		return result;
	}
	
	// 댓글 삭제
		@DeleteMapping("/comment/deleteOk")
		public CommentWriteResult deleteOk(int cmtUid) {
			int count = 0;
			
			// response 에 필요한 값들
			StringBuffer message = new StringBuffer();
			String status = "FAIL";  // 기본 FAIL

			try {	

				count = commentService.commentDelete(cmtUid);
				status = "OK";

			} catch (Exception e) {
				//e.printStackTrace();				
				message.append("[트랜잭션 에러:" + e.getMessage() + "]");
			}

			CommentWriteResult result = new CommentWriteResult();
			result.setCommentStatus(status);
			result.setCommentMessage(message.toString());
			result.setCommentCount(count);
			return result;	
		}
	

		   // 병원
		   @GetMapping("/hos/{page}/{pageRows}")
		   public HosWriteList hosList(@PathVariable int page, @PathVariable int pageRows) {
		      List<HosDTO> hosList = null;
		      String hosStatus = "FAIL";
		      StringBuffer hosMessage = new StringBuffer();

		      int hosWritePages = 10;
		      int hosTotalPage = 0;
		      int hosTotalCnt = 0;

		      try {
		         hosTotalCnt = hosService.countHos();

		         hosTotalPage = (int) Math.ceil(hosTotalCnt / (double) pageRows);

		         int from = (page - 1) * pageRows + 1;

		         if (hosTotalCnt <= pageRows * (page - 1)) {
		            hosMessage.append("[param 값이 없거나 잘못 요청되었습니다.]");
		            from = 1;
		            page = 1;
		            hosList = hosService.hosList(from, pageRows);
		         } else {
		            hosList = hosService.hosList(from, pageRows);
		         }

		         if (hosList == null) {
		            hosMessage.append("[리스트할 데이터가 없습니다]");
		         } else {
		            hosStatus = "OK";
		         }
		      } catch (Exception e) {
		         hosMessage.append("[트랜잭션 에러 :" + e.getMessage() + "]");
		      }

		      HosWriteList result = new HosWriteList();
		      result.setHosStatus(hosStatus);
		      String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		      result.setHosdateTime(dateTime);

		      if (hosList != null) {
		         result.setHosCount(hosList.size());
		         result.setHoslist(hosList);
		      }
		      result.setHoslist(hosList);
		      result.setHosMessage(hosMessage.toString());
		      result.setPage(page);
		      result.setHosTotalPage(hosTotalPage);
		      result.setHosWritePages(hosWritePages);
		      result.setHosPageRows(pageRows);
		      result.setHosTotalCnt(hosTotalCnt);

		      return result;
		   }

		   @GetMapping("/hos/{uid}")
		   public HosWriteList hosView(@PathVariable int hosuid, Model model) {
		      List<HosDTO> hosList = null;
		      StringBuffer hosMessage = new StringBuffer();
		      String hosStatus = "FAIL";

		      try {
		         hosList = hosService.selectHosByUid(hosuid);

		         if (hosList.size() == 0) {
		            hosMessage.append("[해당 데이터가 없습니다.]");
		         } else {
		            hosStatus = "OK";
		         }
		      } catch (NumberFormatException e) {
		         e.printStackTrace();
		         hosMessage.append("[유효하지 않은 parameter]");
		      } catch (Exception e) {
		         e.printStackTrace();
		         hosMessage.append("[트랜잭션 에러:" + e.getMessage() + "]");
		      }

		      HosWriteList result = new HosWriteList();
		      result.setHosStatus(hosStatus);
		      result.setHosMessage(hosMessage.toString());
		      String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		      result.setHosdateTime(dateTime);
		      if (hosList != null) {
		         result.setHosCount(hosList.size());
		         result.setHoslist(hosList);
		      }

		      return result;
		   }
		   
		   // 교통
		   @GetMapping("/trans/{page}/{pageRows}")
		   public TransWriteList transList(
		         @PathVariable int page,
		         @PathVariable int pageRows) {
		      List<TransWriteDTO> transList = null;
		      String transStatus = "FAIL";
		      StringBuffer transMessage = new StringBuffer();
		      
		      int transPages = 10;
		      int transTotalPage = 0;
		      int transTotalCnt = 0;
		      
		      try {
		         transTotalCnt = transService.countTrans();
		         
		         transTotalPage = (int)Math.ceil(transTotalCnt / (double)pageRows);
		         
		         int from = (page - 1) * pageRows + 1;
		         
		         if(transTotalCnt <= pageRows * (page - 1)) {
		            transMessage.append("[param 값이 없거나 잘못 요청되었습니다.]");
		            from = 1; page = 1;
		            transList = transService.transList(from, pageRows);
		         } else {
		            transList = transService.transList(from, pageRows);
		         }
		         
		         if(transList == null) {
		            transMessage.append("[리스트할 데이터가 없습니다.]");
		         } else {
		            transStatus = "OK";
		         }
		      } catch(Exception e) {
		         transMessage.append("[트랜잭션 에러:" + e.getMessage() + "]");
		      }
		      
		      TransWriteList result = new TransWriteList();
		      result.setTransStatus(transStatus);
		      String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		      result.setTransdateTime(dateTime);
		      
		      if(transList != null) {
		         result.setTransCount(transList.size());
		         result.setList(transList);
		      }
		      result.setList(transList);
		      result.setTransMessage(transMessage.toString());
		      result.setPage(page);
		      result.setTransTotalPage(transTotalPage);
		      result.setTransPages(transPages);
		      result.setPageRows(pageRows);
		      result.setTransTotalCnt(transTotalCnt);
		      
		      return result;
		   }
		   
		   @GetMapping("/trans/{uid}")
		   public TransWriteList transView(@PathVariable int uid, Model model) {
		      List<TransWriteDTO> transList = null;
		      StringBuffer transMessage = new StringBuffer();
		      String transStatus = "FAIL";
		      
		      try {
		         transList = transService.selectTransByUid(uid);
		         
		         if(transList.size() == 0) {
		            transMessage.append("[해당 데이터가 없습니다]");
		         } else {
		            transStatus = "OK";
		         }
		      } catch(NumberFormatException e) {
		         e.printStackTrace();
		         transMessage.append("[유효하지 않은 parameter]");
		      } catch(Exception e) {
		         e.printStackTrace();
		         transMessage.append("[트랜잭션 에러:" + e.getMessage() + "]");
		      }
		      
		      TransWriteList result = new TransWriteList();
		      result.setTransStatus(transStatus);
		      result.setTransMessage(transMessage.toString());
		      String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		      result.setTransdateTime(dateTime);
		      if(transList != null) {
		         result.setTransCount(transList.size());
		         result.setList(transList);
		      }
		      return result;
		   }
		   
		   // 회원정보 json
		   @GetMapping("/join/{page}/{pageRows}")
		   public JoinWriteList joinList(@PathVariable int page, @PathVariable int pageRows) {
		      List<JoinDTO> joinList = null;
		      String joinStatus = "FAIL";
		      StringBuffer joinMessage = new StringBuffer();
		   
		      int joinWritePages = 10;
		      int joinTotalPage = 0;
		      int joinTotalCnt = 0;
		   
		      try {
		         joinTotalCnt = joinService.joinCountAll();
		   
		         joinTotalPage = (int) Math.ceil(joinTotalCnt / (double) pageRows);
		   
		         int from = (page - 1) * pageRows + 1;
		   
		         if (joinTotalCnt <= pageRows * (page - 1)) {
		            joinMessage.append("[param 값이 없거나 잘못 요청되었습니다.]");
		            from = 1;
		            page = 1;
		            joinList = joinService.listJoin(from, pageRows);
		         } else {
		            joinList = joinService.listJoin(from, pageRows);
		         }
		   
		         if (joinList == null) {
		            joinMessage.append("[리스트할 데이터가 없습니다]");
		         } else {
		            joinStatus = "OK";
		         }
		      } catch (Exception e) {
		         joinMessage.append("[트랜잭션 에러 :" + e.getMessage() + "]");
		      }
		   
		      JoinWriteList result = new JoinWriteList();
		      result.setStatus(joinStatus);
		      String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		      result.setDateTime(dateTime);
		   
		      if (joinList != null) {
		         result.setCount(joinList.size());
		         result.setList(joinList);
		      }
		      result.setList(joinList);
		      result.setMessage(joinMessage.toString());
		      result.setPage(page);
		      result.setTotalPage(joinTotalPage);
		      result.setWritePages(joinWritePages);
		      result.setPageRows(pageRows);
		      result.setTotalCnt(joinTotalCnt);
		   
		      return result;
		   }
		   
		   @GetMapping("/join/{id}")
		   public JoinWriteList joinView(@PathVariable String id, Model model) {
		      List<JoinDTO> joinList = null;
		      StringBuffer joinMessage = new StringBuffer();
		      String joinStatus = "FAIL";
		   
		      try {
		         joinList = joinService.selectJoinByUid(id);
		   
		         if (joinList.size() == 0) {
		            joinMessage.append("[해당 데이터가 없습니다.]");
		         } else {
		            joinStatus = "OK";
		         }
		      } catch (NumberFormatException e) {
		         e.printStackTrace();
		         joinMessage.append("[유효하지 않은 parameter]");
		      } catch (Exception e) {
		         e.printStackTrace();
		         joinMessage.append("[트랜잭션 에러:" + e.getMessage() + "]");
		      }
		   
		      JoinWriteList result = new JoinWriteList();
		      result.setStatus(joinStatus);
		      result.setMessage(joinMessage.toString());
		      String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		      result.setDateTime(dateTime);
		      if (joinList != null) {
		         result.setCount(joinList.size());
		         result.setList(joinList);
		      }
		   
		      return result;
		   }
		   
	
	
	
}
