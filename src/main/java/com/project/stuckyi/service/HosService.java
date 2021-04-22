package com.project.stuckyi.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.stuckyi.domain.AjaxDAO;
import com.project.stuckyi.domain.HosDTO;

@Service
public class HosService {
   AjaxDAO dao;

   @Autowired
   private SqlSession sqlSession;

   public List<HosDTO> hosList(int from, int pageRows) {
      dao = sqlSession.getMapper(AjaxDAO.class);
      return dao.selectHosFromRow(from, pageRows);
   }
   
   public List<HosDTO> selectHos() {
      dao = sqlSession.getMapper(AjaxDAO.class);
      return dao.selectHos();
   }

   public int countHos() {
      dao = sqlSession.getMapper(AjaxDAO.class);
      return dao.hosCountAll();
   }

   // viewByUid

   public int regiHos(HosDTO dto) {
      dao = sqlSession.getMapper(AjaxDAO.class); // MyBatis 사용
      return dao.insertHos(dto);
   }

   // update

   public int deleteHosByUid(int uid) {
      dao = sqlSession.getMapper(AjaxDAO.class); // MyBatis 사용
      return dao.deleteHosByUid(uid);
   }

   public List<HosDTO> selectHosByUid(int uid) {
      dao = sqlSession.getMapper(AjaxDAO.class); // MyBatis 사용
      return dao.selectHosByUid(uid); // 1개짜리 List
   }

}