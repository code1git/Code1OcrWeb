package com.code1system.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code1system.web.dbmapper1.Db1Mapper;
import com.code1system.web.dto.StatsDto;
import com.code1system.web.dto.UserDto;

@Service
public class StatsService {
	@Autowired
	Db1Mapper db1;
	
	public List<StatsDto> getStats (StatsDto statsDto){
		List<StatsDto> stats = db1.getStats(statsDto);
		return stats;
	}
}
