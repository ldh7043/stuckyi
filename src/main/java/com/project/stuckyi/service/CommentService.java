package com.project.stuckyi.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.stuckyi.domain.AjaxDAO;
import com.project.stuckyi.domain.CommentDTO;

@Service
public class CommentService {
	AjaxDAO dao;
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<CommentDTO> commentList(int brduid, int from, int pageRows){
		dao = sqlSession.getMapper(AjaxDAO.class);
		return dao.selectComment(brduid, from, pageRows);
	}
	
	public int countComment() {
		dao = sqlSession.getMapper(AjaxDAO.class);
		return dao.countComment();
	}
	
	
	public int commentWrite(CommentDTO dto) {
		dao = sqlSession.getMapper(AjaxDAO.class);
		return dao.insertComment(dto);
	}
	
	public int commentUpdate(CommentDTO dto) {
		dao = sqlSession.getMapper(AjaxDAO.class);
		return dao.updateComment(dto);
	}
	
	public int commentDelete(int uid) {
		dao = sqlSession.getMapper(AjaxDAO.class);
		return dao.deleteCommentByUid(uid);
	}


}
