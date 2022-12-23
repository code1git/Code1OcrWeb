package com.code1system.web.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class MailDto {
	private String address;
	private String title;
	private String text;
}
