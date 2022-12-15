package com.code1system.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code1system.web.aop.AdminCheck;
import com.code1system.web.aop.LoginCheck;
import com.code1system.web.dto.LogDto;
import com.code1system.web.service.LogService;



@RestController
public class LogController {
	@Autowired
	private LogService logService;
	
	//@AdminCheck
	@RequestMapping("/log/list")
	public ResponseEntity<List<LogDto>> logList(LogDto logDto, HttpSession session){
		List<LogDto> logList = logService.logList(logDto);
		return new ResponseEntity<List<LogDto>>(logList, HttpStatus.OK);
	}
}
