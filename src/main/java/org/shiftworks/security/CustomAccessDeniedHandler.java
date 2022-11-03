package org.shiftworks.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

  @Override
  public void handle(HttpServletRequest request, 
      HttpServletResponse response, AccessDeniedException accessException)
      throws IOException, ServletException {

    log.error("Access Denied Handler");
    log.error("Redirect....");

    // 접근 권한이 없는 경우 accessError로 redirect
    response.sendRedirect("/accessError");

  }

}
