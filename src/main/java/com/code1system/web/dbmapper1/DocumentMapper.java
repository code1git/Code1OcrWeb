package com.code1system.web.dbmapper1;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.code1system.web.model.Document;
import com.code1system.web.model.UploadListVO;

@Mapper
public interface DocumentMapper {
	List<HashMap<String, Object>> getDocumentList(Document docment);
	
	List<HashMap<String, Object>> selectOcrMediaId();
	
	String selectPeriod();
	
	String selectMediaId(String mediaName);

	String selectApiKey(String mediaName);
	
	int insertDocument(UploadListVO vo);
	
	int updatePeriod(Document param);
	
	int updateAllPeriod(Document param);
	
	int deleteDoc(String seqArr);
	
	String selectPeriodTable();
}
