package com.code1system.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code1system.web.dbmapper1.Db1Mapper;
import com.code1system.web.dto.UserDto;

@Service
public class UserService {
	@Autowired
	Db1Mapper db1;
	private int pageLen = 100;
	
	public List<UserDto> userList (UserDto userDto){
		userDto.setLength(pageLen);
		userDto.setStart(userDto.getLength()*(userDto.getPage()-1));
		List<UserDto> logs = db1.getUserList(userDto);
		return logs;
	}
	
	public boolean authCheck (UserDto userDto) {
		String ipPw = userDto.getPassword();
		List<UserDto> userList = db1.getUserById(userDto.getUser_id());
		String dbPw = userList.get(0).getPassword();
		return ipPw.equals(dbPw)?true:false;
	}
	
	public UserDto getUser (String userId) {
		List<UserDto> userList = db1.getUserById(userId);
		if (userList.size() == 0) {
			return null;
		}
		return userList.get(0);
	}
}
