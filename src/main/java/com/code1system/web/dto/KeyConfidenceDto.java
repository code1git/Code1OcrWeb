package com.code1system.web.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class KeyConfidenceDto {
	private String ocrmedia_id;
	private String key_item_id;
	private String key_item_name;
	private int accrue_count;
	private float confidence_sum;
	private float confidence;
}
