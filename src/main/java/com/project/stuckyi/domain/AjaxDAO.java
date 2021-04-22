package com.project.stuckyi.domain;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface AjaxDAO {
	
	
	// 후기 리스트
	public List<CommentDTO> selectComment(
			@Param("brduid") int brduid,
			@Param("from") int from,
			@Param("pageRows") int pageRows);
	
	// 후기 작성
	public int insertComment(CommentDTO dto);
	
	// 후기 수정
	public int updateComment(CommentDTO dto);
	
	// 후기 삭제
	public int deleteCommentByUid(int uid);

	// 후기 갯수
	public int countComment();
	
	// 댓글 리스트
	public List<BoardDTO> selectBoardFromRow(
			@Param("from") int from,
			@Param("pageRows") int pageRows);

	//댓글 조회수 증가
	public int incMainViewCnt(int uid);


	// 댓글 작성
	public int insertMain(BoardDTO dto);
	
	// 댓글 갯수
	public int countMainBoard();
	
	// 댓글 수정
	public int updateMain(BoardDTO dto);

	// 댓글 삭제
	public int deleteMain(int uid);
	
	// 댓글 보기
	public List<BoardDTO> selectMainByUid(int uid);
	
	
	//교통 목록
	public List<TransWriteDTO> selectTransFromRow(
			@Param("from") int from,
			@Param("pageRows") int pageRows);
	
	// 교통 목록
	public List<TransWriteDTO> selectTrans();

	//전체 글의 개수
	public int transCountAll();
	
	// 글 읽기(예약확인)
	public List<TransWriteDTO> selectTransByUid(int transUid);


	// 글작성(예약하기)
	public int insertTrans(TransWriteDTO dto);
	

	// 특정 uid 글(들) 삭제하기(예약삭제)
	public int deleteTransByUid(int transUid);
	
	
	
	// 병원 목록
	   public List<HosDTO> selectHosFromRow(
	         @Param("from") int from,
	         @Param("pageRows") int pageRows);
	   
	   // 병원 목록
	   public List<HosDTO> selectHos();
	   
	   // 병원 확인
	   public List<HosDTO> selectHosByUid(int uid);
	   
	   // 병원 등록
	   public int insertHos(HosDTO dto);
	   
	   // 병원 예약 갯수
	   public int hosCountAll();
	   
	   // 병원 삭제
	   public int deleteHosByUid(int hosUid);
	
	
	// 회원관리(목록)
	// 회원 목록
	public List<JoinDTO> selectJoinFromRow(
				@Param("from") int from,
				@Param("pageRows") int pageRows);
	
	public List<JoinDTO> selectJoinAll();
		
	// 회원 확인
	public List<JoinDTO> selectJoinByUid(String id);
		
	// 회원 등록
	public int insertJoin(String id, String pw, String phone, String email, String name, String gender, char enabled);
	
	// 회원 정보 수정
	public int updateJoin(JoinDTO dto);
	   
	// 회원 삭제(?)
	public int deleteJoinByUid(String uids);

	public int joinCountAll();
	
	public List<JoinDTO> selectUser(JoinDTO dto);
	
	public List<AuthDTO> getAuthList(String userId);
	
	public int giveAuth(String userId, String auth);
	
}

