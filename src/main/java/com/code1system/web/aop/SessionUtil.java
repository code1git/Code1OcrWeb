package com.code1system.web.aop;

import javax.servlet.http.HttpSession;

public class SessionUtil {
	private static final String LOGIN_MEMBER_ID = "LOGIN_MEMBER_ID";
	private static final String SSO_ID = "SSO_ID";
	
	private SessionUtil() {}
	
	public static String getLoginMemberId(HttpSession session) {
		return (String) session.getAttribute(LOGIN_MEMBER_ID);
	}
	
	public static void setLoginMemberId(HttpSession session, String id) {
		session.setAttribute(LOGIN_MEMBER_ID, id);
	}
	
	public static void destoryLoginMemberId(HttpSession session) {
		session.removeAttribute(LOGIN_MEMBER_ID);
	}
	
	public static String getSsoId(HttpSession session) {
		return (String) session.getAttribute(SSO_ID);
	}
	
	public static void setSsoId(HttpSession session, String id) {
		session.setAttribute(SSO_ID, id);
	}
	
	public static void destorySsoId(HttpSession session) {
		session.removeAttribute(SSO_ID);
	}
}
