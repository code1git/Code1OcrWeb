package com.code1system.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code1system.web.aop.AdminCheck;
import com.code1system.web.aop.LoginCheck;
import com.code1system.web.dto.UserDto;
import com.code1system.web.service.UserService;

@RestController
public class UserContrller {

	@Autowired
	private UserService userService;
	
	//@AdminCheck
	@RequestMapping("/user/list")
	public ResponseEntity<List<UserDto>> logList(UserDto userDto, HttpSession session) throws Exception{
		
		List<UserDto> logList = userService.userList(userDto);
		return new ResponseEntity<List<UserDto>>(logList, HttpStatus.OK);
	}
	
}
