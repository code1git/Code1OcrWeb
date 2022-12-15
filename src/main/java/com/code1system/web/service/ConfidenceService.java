package com.code1system.web.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code1system.web.dbmapper1.Db1Mapper;
import com.code1system.web.dto.CharConfidenceDto;
import com.code1system.web.dto.ConfidenceDto;
import com.code1system.web.dto.KeyConfidenceDto;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Service
public class ConfidenceService {
	@Autowired
	Db1Mapper db1;
	
	public List<KeyConfidenceDto> KeyConfidenceList (String ocrmedia_id){
		HashMap<String, String> queryMap = new HashMap<>();
		queryMap.put("ocrmedia_id", ocrmedia_id);
		List<KeyConfidenceDto> confidenceList = db1.getKeyConfidence(queryMap);
		return confidenceList;
	}
	
	public List<CharConfidenceDto> CharConfidenceList (String ocrmedia_id){
		HashMap<String, String> queryMap = new HashMap<>();
		queryMap.put("ocrmedia_id", ocrmedia_id);
		List<CharConfidenceDto> confidenceList = db1.getCharConfidence(queryMap);
		return confidenceList;
	}
	
	public ConfidenceDto ConfidenceList (String ocrmedia_id) {
		ConfidenceDto rtn = new ConfidenceDto();
		rtn.setOcrmedia_id(ocrmedia_id);
		HashMap<String, String> queryMap = new HashMap<>();
		queryMap.put("ocrmedia_id", ocrmedia_id);
		rtn.setKey(db1.getKeyConfidence(queryMap));
		queryMap.put("char_type", "KOR");
		rtn.setKor(db1.getCharConfidence(queryMap));
		queryMap.put("char_type", "ENG");
		rtn.setEng(db1.getCharConfidence(queryMap));
		queryMap.put("char_type", "NUM");
		rtn.setNum(db1.getCharConfidence(queryMap));
		queryMap.put("char_type", "SPE");
		rtn.setSpe(db1.getCharConfidence(queryMap));
						
		return rtn;
	}
}
