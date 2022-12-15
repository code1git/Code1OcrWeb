package com.code1system.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class StatsDto {
	private String stats_flag;
	private String ocrmedia_id;
	private Integer year;
	private Integer yearly_count;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer month;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer monthly_count;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer day_01_count;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer day_02_count;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer day_03_count;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer day_04_count;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer day_05_count;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer day_06_count;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer day_07_count;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer day_08_count;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer day_09_count;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer day_10_count;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer day_11_count;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer day_12_count;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer day_13_count;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer day_14_count;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer day_15_count;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer day_16_count;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer day_17_count;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer day_18_count;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer day_19_count;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer day_20_count;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer day_21_count;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer day_22_count;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer day_23_count;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer day_24_count;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer day_25_count;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer day_26_count;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer day_27_count;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer day_28_count;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer day_29_count;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer day_30_count;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer day_31_count;
}
