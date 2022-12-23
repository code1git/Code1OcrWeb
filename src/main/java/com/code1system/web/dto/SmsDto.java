package com.code1system.web.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class SmsDto {
	private String receiveNum;
	private String userNum;
	private String text;
}
