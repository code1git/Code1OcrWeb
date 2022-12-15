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
import com.code1system.web.dto.CharConfidenceDto;
import com.code1system.web.dto.ConfidenceDto;
import com.code1system.web.service.ConfidenceService;

@RestController
public class ConfidenceCotroller {

	@Autowired
	private ConfidenceService confidenceService;
	
	//@AdminCheck
	@RequestMapping("/confitest")
	public ResponseEntity<List<CharConfidenceDto>> test(CharConfidenceDto charConfidenceDto, HttpSession session){
		
		List<CharConfidenceDto> list = confidenceService.CharConfidenceList(charConfidenceDto.getOcrmedia_id());
		return new ResponseEntity<List<CharConfidenceDto>>(list, HttpStatus.OK);
	}
	
	//@LoginCheck
	@RequestMapping("/confidence")
	public ResponseEntity<ConfidenceDto> GetConfidence(ConfidenceDto confidenceDto, HttpSession session){
		
		ConfidenceDto rtn = confidenceService.ConfidenceList(confidenceDto.getOcrmedia_id());
		return new ResponseEntity<ConfidenceDto>(rtn, HttpStatus.OK);
	}
	
}
