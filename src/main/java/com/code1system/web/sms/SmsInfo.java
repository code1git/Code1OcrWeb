package com.code1system.web.sms;

import java.nio.charset.Charset;

import com.fasterxml.jackson.core.util.ByteArrayBuilder;

public class SmsInfo {
	// M741O (5)
	private byte[] classcode = new byte[]{0x4d, 0x37, 0x34 , 0x31, 0x4f};
	// M741 (4)
	private byte[] password = new byte[] {0x4d, 0x37, 0x34 , 0x31};
	private byte[] key = new byte[15];
	private byte[] recvphone = new byte[15];
	private byte[] callback = new byte[15];
	private byte[] message = new byte[80];
	private byte[] empno = new byte[8];
	private byte[] refcnt = new byte [] {0x30, 0x30, 0x30, 0x30, 0x30};
	
	public void setKey(String key) {
		if(key.length()>15) {
			throw new IllegalArgumentException("max key length = 15!");
		}
		for(int i=0; i <key.length(); i++) {
			this.key[i] = (byte) key.charAt(i);
		}
	}
	public void setRecvphone(String recvphone) {
		if(recvphone.length()>15) {
			throw new IllegalArgumentException("max recvphone length = 15!");
		}
		for(int i=0; i <recvphone.length(); i++) {
			this.recvphone[i] = (byte) recvphone.charAt(i);
		}
	}
	public void setCallback(String callback) {
		if(callback.length()>15) {
			throw new IllegalArgumentException("max callback length = 15!");
		}
		for(int i=0; i <callback.length(); i++) {
			this.callback[i] = (byte) callback.charAt(i);
		}
	}
	public void setMessage(String message) {
		byte[] msgbuf = message.getBytes(Charset.forName("EUC-KR"));
		if(msgbuf.length>80) {
			throw new IllegalArgumentException("max message length = 80!");
		}
		for(int i=0; i <msgbuf.length; i++) {
			this.message[i] = msgbuf[i];
		}
	}
	public void setEmpno(String empno) {
		if(empno.length()>8) {
			throw new IllegalArgumentException("max empno length = 8!");
		}
		for(int i=0; i <empno.length(); i++) {
			this.empno[i] = (byte) empno.charAt(i);
		}
	}
	
	
	public byte[] toByteArray() {
		ByteArrayBuilder builder = new ByteArrayBuilder();
		for(byte b : classcode) {
			builder.append(b);
		}
		builder.append(0x00);
		for(byte b : password) {
			builder.append(b);
		}
		builder.append(0x00);
		for(byte b : key) {
			builder.append(b);
		}
		builder.append(0x00);
		for(byte b : recvphone) {
			builder.append(b);
		}
		builder.append(0x00);
		for(byte b : callback) {
			builder.append(b);
		}
		builder.append(0x00);
		for(byte b : message) {
			builder.append(b);
		}
		builder.append(0x00);
		for(byte b : empno) {
			builder.append(b);
		}
		builder.append(0x00);
		for(byte b : refcnt) {
			builder.append(b);
		}
		builder.append(0x00);
		return builder.toByteArray();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("classcode : ");
		sb.append(new String(classcode));
		sb.append("\n password : ");
		sb.append(new String(password));
		sb.append("\n key : ");
		sb.append(new String(key));
		sb.append("\n recvphone : ");
		sb.append(new String(recvphone));
		sb.append("\n callback : ");
		sb.append(new String(callback));
		sb.append("\n message : ");
		sb.append(new String(message, Charset.forName("EUC-KR")));
		sb.append("\n empno : ");
		sb.append(new String(empno));
		sb.append("\n refcnt : ");
		sb.append(new String(refcnt));
		sb.append("\n");
		return sb.toString();
	}
}
