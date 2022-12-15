package com.code1system.web.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class ConfidenceDto {
	@JsonIgnore
	private String ocrmedia_id;
	private List<KeyConfidenceDto> key;
	private List<CharConfidenceDto> kor;
	private List<CharConfidenceDto> eng;
	private List<CharConfidenceDto> num;
	private List<CharConfidenceDto> spe;
}
