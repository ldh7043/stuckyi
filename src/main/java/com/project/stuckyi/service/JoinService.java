package com.project.stuckyi.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.stuckyi.domain.AjaxDAO;
import com.project.stuckyi.domain.JoinDTO;

@Service
public class JoinService {
   AjaxDAO dao;
   
   @Autowired
   private SqlSession sqlSession;
   
   @Autowired
   private BCryptPasswordEncoder bPasswordEncoder;
   
   public List<JoinDTO> listJoin(int from, int pageRows){
      dao = sqlSession.getMapper(AjaxDAO.class);
      return dao.selectJoinFromRow(from, pageRows);
   }
   
   public List<JoinDTO> listJoinAll(){
      dao = sqlSession.getMapper(AjaxDAO.class);
      return dao.selectJoinAll();
   }
   
   public int joinCountAll() {
	      dao = sqlSession.getMapper(AjaxDAO.class); // MyBatis 사용
	      return dao.joinCountAll();
   }
   
   
   public boolean writeJoin(JoinDTO dto) {
      dao = sqlSession.getMapper(AjaxDAO.class);
      
      dao.insertJoin(dto.getId(),bPasswordEncoder.encode(dto.getPw()), dto.getPh(), dto.getEmail(), dto.getName(), dto.getGender(), '1'); //유저 등록
      dao.giveAuth("ROLE_MEMBER", dto.getId()); //기본 권한 부여
      return true;
      
   }
   
   public int updateJoin(JoinDTO dto) {
	      dao = sqlSession.getMapper(AjaxDAO.class); // MyBatis 사용
	      return dao.updateJoin(dto);
   }
   
   public int deleteJoinByUid(String uid) {
      dao = sqlSession.getMapper(AjaxDAO.class); // MyBatis 사용
      return dao.deleteJoinByUid(uid);
   }
   
   public List<JoinDTO> selectJoinByUid(String id) {
      dao = sqlSession.getMapper(AjaxDAO.class); // MyBatis 사용
      return dao.selectJoinByUid(id);  // 1개짜리 List
   }
   
   public List<JoinDTO> viewJoinByUid(String id){
      dao = sqlSession.getMapper(AjaxDAO.class); // MyBatis 사용
      return dao.selectJoinByUid(id);
   }

}