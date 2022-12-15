package com.code1system.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.code1system.web.dbmapper1.DocumentMapper;
import com.code1system.web.model.Document;
import com.code1system.web.model.UploadListVO;



@RestController
public class DoucmentController {
	@Value("${code1system.input_folder}")
	private String input_folder;
	
	@Autowired
	private DocumentMapper documentMapper;
	
	/**
	 * 파일 목록 조회
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/ocr/document")
	public List<HashMap<String, Object>> getDocumentList(Document params) throws Exception{
		List<HashMap<String, Object>> docList = new ArrayList<HashMap<String, Object>>();
		//System.out.println(params.getFilename());
		//System.out.println(params.getOcrmedia_id());
		try {
			docList = documentMapper.getDocumentList(params);
			
			//System.out.println(docList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return docList;
	}
	
	/**
	 * 보관기간 조회
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/ocr/period")
	public String selectPeriod() throws Exception{
		String docList = "";
		try {
			docList = documentMapper.selectPeriodTable();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return docList;
	}
	
	/**
	 * code1ocr_mediaid 조회
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/ocr/ocrmediaid")
	public List<HashMap<String, Object>> selectOcrMediaId() throws Exception{
		List<HashMap<String, Object>> ocrIdList = new ArrayList<HashMap<String, Object>>();
		try {
			ocrIdList = documentMapper.selectOcrMediaId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ocrIdList;
	}

	/**
	 * 보관기간 Update
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/ocr/updatePeriod")
	public int updatePeriod(Document params) throws Exception{
		int updateCnt = documentMapper.updatePeriod(params);
		updateCnt = documentMapper.updateAllPeriod(params);

		return updateCnt;
	}

	/**
	 * 문서 삭제
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/ocr/deleteDoc", method = RequestMethod.GET)
	public int deleteDocument(Document params) throws Exception{
		int updateCnt = 0;
		String[] seqArr = params.getSeqArr().split(",");
		for(int i = 0; i < seqArr.length; i++) {
			updateCnt += documentMapper.deleteDoc(seqArr[i]);
		}
		//int updateCnt = 0;
		return updateCnt;
	}
}
