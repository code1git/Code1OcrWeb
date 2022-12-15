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
public class LogDto {
	private int seq;
	private String ifsystem_id;
	private String user_id;
	private String filename;
	private String filepath;
	private String ocrmedia_id;
	private int page_cnt;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date reg_date;
	private int statis_added;
	private String err_code;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String user_name;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String organization;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Date start_date;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Date end_date;
	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	private int page = 1;
	@JsonIgnore
	private int length;
	@JsonIgnore
	private int start;
}
