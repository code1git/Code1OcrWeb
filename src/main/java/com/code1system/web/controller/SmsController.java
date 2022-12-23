package com.code1system.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code1system.web.dto.SmsDto;
import com.code1system.web.sms.SmsInfo;
import com.code1system.web.sms.SmsUtil;


@RestController
public class SmsController {
	@Value("${code1system.smssvr}")
	private String smsAddr;
	@Value("${code1system.smsport}")
	private int smsReqPort;
	@Value("${code1system.smscallback}")
	private String smsCallback;
	
	@RequestMapping("/sms")
	public ResponseEntity<Object> logList(SmsDto smsDto, HttpSession session) throws Exception{
		SmsInfo info = new SmsInfo();
		info.setCallback(smsCallback);
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss000");
		info.setKey(sdf.format(new Date()));
		
		System.out.println("ReceiveNum : " + smsDto.getReceiveNum());
		System.out.println();
		
		info.setRecvphone(smsDto.getReceiveNum());
		info.setEmpno(smsDto.getUserNum());
		info.setMessage(smsDto.getText());
		
		System.out.println(info);
		
		SmsUtil smsUtil = new SmsUtil();
		int rtn = -1;
		try {
			rtn = smsUtil.sendSms(smsAddr, smsReqPort, info);
		} catch (Exception e) {
			e.getStackTrace();
		}
		
		return new ResponseEntity<Object>(rtn, HttpStatus.OK);
	}
	
}
