package com.code1system.web.aop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.List;

public class SsoUtil {
	
	public String getSsoId(String moudlePath, String pgsecuid) {
		String userId = "";
		List<String> command = new ArrayList<>();
		command.add(moudlePath);
		command.add("-d");
		command.add(pgsecuid);
		try {
			ProcessBuilder pb = new ProcessBuilder(command);
			Process p = pb.start();
			
			BufferedReader br =
		            new BufferedReader(
		                new InputStreamReader(
		                    new SequenceInputStream(p.getInputStream(), p.getErrorStream())));
			p.getOutputStream().close();
	        userId = br.readLine();
	        br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userId;
	}
}
