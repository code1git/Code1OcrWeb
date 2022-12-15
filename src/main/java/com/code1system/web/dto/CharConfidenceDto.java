package com.code1system.web.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class CharConfidenceDto {
	private String ocrmedia_id;
	private String char_type;
	private String char_index;
	private int accrue_count;
	private float confidence_sum;
	private float confidence;
	
}
