package com.code1system.web.aop;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.server.ResponseStatusException;

@Aspect
@Component
public class AuthCheckAspect {
	@Before("@annotation(com.code1system.web.aop.AdminCheck)")
	public void adminLoginCheck() throws ResponseStatusException {
	    HttpSession session = ((ServletRequestAttributes)(RequestContextHolder.currentRequestAttributes())).getRequest().getSession();
	    String memberId = SessionUtil.getLoginMemberId(session);
	    
	    if (memberId == null) {
	        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "NO_ADMIN");
	    }
	}
	
	@Before("@annotation(com.code1system.web.aop.SsoCheck)")
	public void ssoCheck() throws ResponseStatusException {
	    HttpSession session = ((ServletRequestAttributes)(RequestContextHolder.currentRequestAttributes())).getRequest().getSession();
	    String SsoId = SessionUtil.getSsoId(session);
	    
	    if (SsoId == null) {
	        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "NO_SSO");
	    }
	}
	
	@Before("@annotation(com.code1system.web.aop.LoginCheck)")
	public void loginCheck() throws ResponseStatusException {
	    HttpSession session = ((ServletRequestAttributes)(RequestContextHolder.currentRequestAttributes())).getRequest().getSession();
	    String SsoId = SessionUtil.getSsoId(session);
	    String memberId = SessionUtil.getLoginMemberId(session);
	    System.out.println(SsoId);
	    System.out.println(memberId);
	    if (SsoId == null && memberId == null) {
	        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "NO_LOGIN");
	    }
	}
}
