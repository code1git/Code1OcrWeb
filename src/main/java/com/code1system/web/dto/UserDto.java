package com.code1system.web.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class UserDto {
	private String user_id;
	private String user_name;
	private String pgsecuid;
	@JsonIgnore
	private String password;
	private String position;
	private String organization;
	@JsonIgnore
	private int admin;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date reg_date;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date del_date;
	private int del_flag;
	
	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	private int page = 1;
	@JsonIgnore
	private int length;
	@JsonIgnore
	private int start;
	private int total_user;
}
