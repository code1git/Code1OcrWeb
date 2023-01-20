package com.code1system.web.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Document {
	private String e_date;
	private String s_date;
	private String doc_keep_period;
	private String seq;
	private String filename;
	private String ocrmedia_id;
	private String seqArr;
	private String user_id;
	
	
}
