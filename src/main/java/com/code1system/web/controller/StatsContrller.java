package com.code1system.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code1system.web.aop.LoginCheck;
import com.code1system.web.dto.StatsDto;
import com.code1system.web.dto.UserDto;
import com.code1system.web.service.StatsService;
import com.code1system.web.service.UserService;

@RestController
public class StatsContrller {

	@Autowired
	private StatsService statsService;
	
	//@LoginCheck
	@RequestMapping("/stats")
	public ResponseEntity<List<StatsDto>> stats(StatsDto statsDto, HttpSession session){
		
		List<StatsDto> stats = statsService.getStats(statsDto);
		return new ResponseEntity<List<StatsDto>>(stats, HttpStatus.OK);
	}
	
}
