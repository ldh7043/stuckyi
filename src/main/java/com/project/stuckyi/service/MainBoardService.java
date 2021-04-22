package com.project.stuckyi.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.stuckyi.domain.AjaxDAO;
import com.project.stuckyi.domain.BoardDTO;

@Service
public class MainBoardService {
	AjaxDAO dao;

	@Autowired
	private SqlSession sqlSession;
	
	public List<BoardDTO> boardList(int from, int pageRows){
		dao = sqlSession.getMapper(AjaxDAO.class);
		return dao.selectBoardFromRow(from, pageRows);
	}
	
	public int countBoard() {
		dao = sqlSession.getMapper(AjaxDAO.class);
		return dao.countMainBoard();
	}
	
	public List<BoardDTO> incViewBoard(int uid){
		dao = sqlSession.getMapper(AjaxDAO.class);
		dao.incMainViewCnt(uid);
		return dao.selectMainByUid(uid);
	}
	
	public int boardWrite(BoardDTO dto) {
		dao = sqlSession.getMapper(AjaxDAO.class);
		return dao.insertMain(dto);
	}
	
	public int boardUpdate(BoardDTO dto) {
		dao = sqlSession.getMapper(AjaxDAO.class);
		return dao.updateMain(dto);
	}
	
	public int boardDelete(int uid) {
		dao = sqlSession.getMapper(AjaxDAO.class);
		return dao.deleteMain(uid);
	}
	
	public List<BoardDTO> selectMainByUid(int uid){
		dao = sqlSession.getMapper(AjaxDAO.class);
		return dao.selectMainByUid(uid);
	}
	
	
}
