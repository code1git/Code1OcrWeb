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
	public ResponseEntity<UserDto> login(UserDto userDto, HttpSession session) {
		UserDto rtn = new UserDto();
		if (userDto.getUser_id() == null || userDto.getUser_id().equals("") ||
			userDto.getPassword() == null || userDto.getPassword().equals("")) {
			rtn.setLogin_msg("plz type id and pw");
			return new ResponseEntity<>(rtn, HttpStatus.UNAUTHORIZED);
			
		}
		if(userService.authCheck(userDto)) {
			SessionUtil.setLoginMemberId(session, userDto.getUser_id());
			rtn.setLogin_msg("admin login ok");
			return new ResponseEntity<>(rtn, HttpStatus.OK);
		}
		rtn.setLogin_msg("Wrong user or pw");
		return new ResponseEntity<>(rtn, HttpStatus.UNAUTHORIZED);
	}
	
	@RequestMapping("/logout")
	public ResponseEntity<Object> logout(HttpSession session) {
		SessionUtil.destoryLoginMemberId(session);
		return new ResponseEntity<>("ADMIN LOGOUT", HttpStatus.OK);
	}
	
	@RequestMapping("/ssotest")
	public ResponseEntity<UserDto> ssoTest(UserDto userDto, HttpSession session) {
		UserDto rtn = new UserDto();
		UserDto ssoLoginUser = userService.getUser(userDto.getUser_id());
		
		if (ssoLoginUser == null) {
			rtn.setUser_id(userDto.getUser_id());
			rtn.setLogin_msg("sso error : user not found");
			return new ResponseEntity<>(rtn, HttpStatus.UNAUTHORIZED);
		}
		if(ssoLoginUser.getAdmin()==1) {
			rtn.setLogin_msg("sso error : is not sso user");
			return new ResponseEntity<>(rtn, HttpStatus.UNAUTHORIZED);				
		}
		SessionUtil.setSsoId(session, userDto.getUser_id());
		rtn.setUser_id(ssoLoginUser.getUser_id());
		rtn.setUser_name(ssoLoginUser.getUser_name());
		rtn.setOrganization(ssoLoginUser.getOrganization());
		rtn.setLogin_msg("SSO LOGIN SUCCESS : " + userDto.getUser_id());
		return new ResponseEntity<>(rtn, HttpStatus.OK);
	}
	
	@RequestMapping("/ssologin")
	public ResponseEntity<UserDto> loginSso(UserDto userDto, HttpSession session) {
		UserDto rtn = new UserDto();
		try {
			System.out.println("try sso : " + userDto.getPgsecuid());
			SsoUtil ssoUtil = new SsoUtil();
			String ssoId = ssoUtil.getSsoId(ssoModule, userDto.getPgsecuid());
			if(ssoId==null||ssoId.equals("")) {
				rtn.setLogin_msg("sso error : seed decode error!!");
				return new ResponseEntity<>(rtn, HttpStatus.UNAUTHORIZED);
			}
			System.out.println("ssoid :" + ssoId);
			UserDto ssoLoginUser = userService.getUser(ssoId);
			if (ssoLoginUser == null) {
				rtn.setUser_id(ssoId);
				rtn.setLogin_msg("sso error : user not found");
				return new ResponseEntity<>(rtn, HttpStatus.UNAUTHORIZED);
			}
			if(ssoLoginUser.getAdmin()==1) {
				rtn.setLogin_msg("sso error : is not sso user");
				return new ResponseEntity<>(rtn, HttpStatus.UNAUTHORIZED);				
			}
			SessionUtil.setSsoId(session, ssoId);
			rtn.setUser_id(ssoLoginUser.getUser_id());
			rtn.setUser_name(ssoLoginUser.getUser_name());
			rtn.setOrganization(ssoLoginUser.getOrganization());
			rtn.setLogin_msg("SSO LOGIN SUCCESS");
			return new ResponseEntity<>(rtn, HttpStatus.OK);
		} catch (Exception e) {
			rtn.setLogin_msg("SSO LOGIN FAIL");
			return new ResponseEntity<>(rtn, HttpStatus.UNAUTHORIZED);
		}
	}
	
	@RequestMapping("/ssologout")
	public ResponseEntity<Object> ssologout(HttpSession session) {
		SessionUtil.destorySsoId(session);
		return new ResponseEntity<>("SSO LOGOUT", HttpStatus.OK);
	}
}
