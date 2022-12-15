package com.code1system.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code1system.web.dbmapper1.Db1Mapper;
import com.code1system.web.dto.LogDto;

@Service
public class LogService {
	@Autowired
	Db1Mapper db1;
	private int pageLen = 100;
	
	public List<LogDto> logList (LogDto logDto){
		logDto.setLength(pageLen);
		logDto.setStart(logDto.getLength()*(logDto.getPage()-1));
		List<LogDto> logs = db1.getLogList(logDto);
		return logs;
	}
}
