package com.code1system.web.dbmapper1;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.code1system.web.dto.CharConfidenceDto;
import com.code1system.web.dto.KeyConfidenceDto;
import com.code1system.web.dto.LogDto;
import com.code1system.web.dto.StatsDto;
import com.code1system.web.dto.UserDto;

@Mapper
public interface Db1Mapper {
	// log mapper
	List<LogDto> getLogList(LogDto logDto);
	
	// user mapper
	List<UserDto> getUserList(UserDto userDto);
	List<UserDto> getUserById(UserDto userDto);
	
	// Confidence
	List<KeyConfidenceDto> getKeyConfidence(HashMap<String, String> querymap);
	List<CharConfidenceDto> getCharConfidence(HashMap<String, String> querymap);
	
	// Stats
	List<StatsDto> getStats(StatsDto statsDto);
}
