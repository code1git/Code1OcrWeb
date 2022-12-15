package com.code1system.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.code1system.web.aop.SessionUtil;
import com.code1system.web.aop.SsoUtil;
import com.code1system.web.dto.UserDto;
import com.code1system.web.service.UserService;


@ResponseStatus
@RestController
public class AuthController {
	
	@Autowired
	UserService userService;
	
	@Value("${code1system.ssomodule}")
	public String ssoModule;
	
	@RequestMapping("/login")
	public ResponseEntity<Object> login(UserDto userDto, HttpSession session) {
		if(userService.authCheck(userDto)) {
			SessionUtil.setLoginMemberId(session, userDto.getUser_id());
			return new ResponseEntity<>("Login OK", HttpStatus.OK);
		}
		return new ResponseEntity<>("Wrong user or pw", HttpStatus.UNAUTHORIZED);
	}
	
	@RequestMapping("/logout")
	public ResponseEntity<Object> logout(HttpSession session) {
		SessionUtil.destoryLoginMemberId(session);
		return new ResponseEntity<>("LOGOUT", HttpStatus.OK);
	}
	
	@RequestMapping("/ssotest")
	public String ssoTest(HttpSession session) {
		SessionUtil.setSsoId(session, "test");
		return "test sso id on";
	}
	
	@RequestMapping("/ssologin")
	public ResponseEntity<Object> loginSso(UserDto userDto, HttpSession session) {
		System.out.println("try sso : " + userDto.getPgsecuid());
		SsoUtil ssoUtil = new SsoUtil();
		String ssoId = ssoUtil.getSsoId(ssoModule, userDto.getPgsecuid());
		System.out.println("ssoid :" + ssoId);
		if(ssoId!=null&&!ssoId.equals("")) {
			SessionUtil.setSsoId(session, ssoId);
			return new ResponseEntity<>("SSO Login OK", HttpStatus.OK);
		}
		return new ResponseEntity<>("NO SSO USER ID", HttpStatus.UNAUTHORIZED);
	}
	
	@RequestMapping("/ssologout")
	public ResponseEntity<Object> ssologout(HttpSession session) {
		SessionUtil.destorySsoId(session);
		return new ResponseEntity<>("LOGOUT", HttpStatus.OK);
	}
}
