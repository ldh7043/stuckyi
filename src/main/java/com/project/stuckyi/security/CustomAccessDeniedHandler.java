package com.project.stuckyi.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {

   @Override
   public void handle(HttpServletRequest request, HttpServletResponse response,
         AccessDeniedException accessDeniedException) throws IOException, ServletException {
      System.out.println("Custom Access Denied Handler");
      accessDeniedException.printStackTrace();
      System.out.println("redirecting");
      response.sendRedirect(request.getContextPath() + "/main/accessError");   // 다이렉트

   }

}