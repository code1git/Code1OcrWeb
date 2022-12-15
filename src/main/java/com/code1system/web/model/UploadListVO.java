package com.code1system.web.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UploadListVO {
	private String uuid;
	private String ocr_system_id;
	private String ocr_user_id;
	private String ocr_filepath;
	private String file_name;
	private String docType;
	private String ocr_mediaName;
	private String ocr_result_format;
	private String doc_keep_period;
	private MultipartFile binary; 
	private int status;
	private String seq;
	private String ocr_doc_type;
	
}
