package org.shiftworks.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication auth) throws IOException, ServletException {
		
		log.warn("Login Success");

		// 보유 권한을 담을 리스트 생성
		List<String> roleNames = new ArrayList<String>();
		
		// 아마 이부분...?
		// 보유한 권한을 리스트에 추가
		auth.getAuthorities().forEach(authority -> {
			roleNames.add(authority.getAuthority());
		});
		
		log.warn("ROLE NAMES: " + roleNames);
		
		// 권한에 따라 페이지 이동
		if(roleNames.contains("ROLE_ADMIN")) {
			response.sendRedirect("/");
			return;
		}
		if(roleNames.contains("ROLE_MEMBER")) {
			response.sendRedirect("/");
			return;
		}
		
		// 위 조건에 해당하는 권한이 없을 경우 home으로 이동
		response.sendRedirect("/");
		
	}

}