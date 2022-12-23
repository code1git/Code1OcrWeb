package com.code1system.web.sms;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SmsUtil {
	private Socket socket = null;
	
	public int sendSms(String addr, int port, SmsInfo smsInfo) {
		OutputStream os = null;
		InputStream is = null;
		try {
			socket = new Socket();
			socket.connect(new InetSocketAddress(addr, port));
			os = socket.getOutputStream();
			os.write(smsInfo.toByteArray());
			os.flush();
			is = socket.getInputStream();
			byte[] buf = new byte[5];
			is.read(buf);
			StringBuilder sb = new StringBuilder();
			sb.append((char)buf[0]);
			sb.append((char)buf[1]);
			sb.append((char)buf[2]);
			sb.append((char)buf[3]);
			return Integer.parseInt(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(socket!=null && !socket.isClosed()) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return -1;
	}
}
