package org.shiftworks.aspect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

// 패키지 Git 저장을 위한 샘플입니다.


// 세션에 관련된 공통사항을 관리하는 클래스
@Aspect
public class SessionAspect {
	
	// 세션을 검증하는 메소드
	@Around("execution(public * shiftworks.controller.*.*do(..))")
	public String sessionCheck(ProceedingJoinPoint joinPoint) throws Throwable {
		Object[] obj = joinPoint.getArgs();
		HttpServletRequest request = (HttpServletRequest) obj[0];
		HttpSession session = request.getSession();
		
		String name = (String) session.getAttribute("name");
		String view = "session/session_fail";
		
		try {
			if(name == null) {
				throw new Exception("no session");
			} else {
				view = (String) joinPoint.proceed(); // session_do() 호출
			}
		} catch (Exception e) {
			return view;
		}
		
		return view;
	}
}
