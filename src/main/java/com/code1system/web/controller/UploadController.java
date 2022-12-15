package com.code1system.web.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.code1system.web.aop.SessionUtil;
import com.code1system.web.dbmapper1.DocumentMapper;
import com.code1system.web.model.UploadListVO;
import com.fasterxml.jackson.databind.ObjectMapper;



@RestController
public class UploadController {
	@Value("${code1system.input_folder}")
	private String input_folder;
	
	@Autowired
	private DocumentMapper documentMapper;
	
	/**
	 * 문서 업로드
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/ocr/uploadDoc", method = RequestMethod.POST)
	public UploadListVO upload(UploadListVO vo, HttpSession session) throws Exception{
//		post 전송
//		http://49.254.96.114:8080/code1-api/image-ocr
		System.out.println(vo.toString());
		System.out.println(vo.getBinary().getOriginalFilename());
		String r = vo.toString();
		System.out.println(r);
		
		UploadListVO uploadVo = new UploadListVO();
		uploadVo = uploadFile(vo.getBinary());
		
		String uuid = UUID.randomUUID().toString();

		uploadVo.setUuid(uuid);
		uploadVo.setFile_name(vo.getFile_name());
		uploadVo.setStatus(0);
		uploadVo.setDoc_keep_period(documentMapper.selectPeriod());
		uploadVo.setOcr_mediaName(documentMapper.selectMediaId(vo.getOcr_mediaName()));
		uploadVo.setOcr_mediaName(documentMapper.selectMediaId(vo.getOcr_mediaName()));
		uploadVo.setOcr_doc_type(documentMapper.selectApiKey(vo.getOcr_mediaName()));
		
		uploadVo.setOcr_system_id(vo.getOcr_system_id());
		String ssoId = SessionUtil.getSsoId(session);
		if(ssoId!=null&&ssoId.equals("")) {
			uploadVo.setOcr_user_id(ssoId);
		}else {
			uploadVo.setOcr_user_id(vo.getOcr_user_id());
		}
		if("CODE1WRP".equals(vo.getOcr_result_format())) {
			uploadVo.setOcr_result_format("full_text");
		} else {
			uploadVo.setOcr_result_format("key_value");
		}
		
		
//		uploadVo.setOcr_doc_type("id_card");
		
		documentMapper.insertDocument(uploadVo);
		ObjectMapper mapper = new ObjectMapper();
		uploadVo.setOcr_filepath(uploadVo.getOcr_filepath().replace("F:/", "D:/") + "/" + uploadVo.getFile_name());

		return uploadVo;
	}
	
	public UploadListVO uploadFile(MultipartFile file){

        String uploadFileName = file.getOriginalFilename();
        Path fileDir;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(file.getInputStream(), "UTF-8"));
        } catch (IOException e) {
        }
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String yyyymmdd = sdf.format(Calendar.getInstance().getTime());
        String realName = uploadFileName;
        String dir = yyyymmdd.substring(0,4) + "/" + yyyymmdd.substring(4,6) + "/" + yyyymmdd.substring(6, 8) + "/" + realName;
        if(!new File(input_folder).exists()){
            (new File(input_folder)).mkdirs();
        }
        fileDir = Paths.get(input_folder).toAbsolutePath().normalize();
        Path targetLocation = fileDir.resolve(realName);

        try {
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
        }
        
        UploadListVO result = new UploadListVO();
        result.setFile_name(uploadFileName);
        result.setOcr_filepath(input_folder);
        
        return result;
    }
	
}
