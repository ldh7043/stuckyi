package com.project.stuckyi.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.stuckyi.domain.AjaxDAO;
import com.project.stuckyi.domain.HosDTO;
import com.project.stuckyi.domain.TransWriteDTO;

@Service
public class TransAjaxService {
   AjaxDAO dao;
   
   @Autowired
   private SqlSession sqlSession;
   
   public List<TransWriteDTO> transList(int from, int pageRows){
      dao = sqlSession.getMapper(AjaxDAO.class);
      return dao.selectTransFromRow(from, pageRows);
   }
   
   public List<TransWriteDTO> selectTrans() {
      dao = sqlSession.getMapper(AjaxDAO.class);
      return dao.selectTrans();
   }

   public int countTrans() {
      dao = sqlSession.getMapper(AjaxDAO.class); // MyBatis 사용
      return dao.transCountAll();
   }
   
   public int transWrite(TransWriteDTO dto) {
      dao = sqlSession.getMapper(AjaxDAO.class); // MyBatis 사용
      return dao.insertTrans(dto); 
   }   
   
   public int deleteTransByUid(int transUid) {
	      return sqlSession.getMapper(AjaxDAO.class).deleteTransByUid(transUid);
   }
   
   public int deleteByUid(int transUid) {
      dao = sqlSession.getMapper(AjaxDAO.class); // MyBatis 사용
      return dao.deleteTransByUid(transUid);
   }
   
   public List<TransWriteDTO> selectTransByUid(int uid) {
      dao = sqlSession.getMapper(AjaxDAO.class); // MyBatis 사용
      return dao.selectTransByUid(uid);  // 1개짜리 List
   }
   
   
   
}