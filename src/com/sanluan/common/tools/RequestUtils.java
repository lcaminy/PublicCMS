package com.sanluan.common.tools;

import static com.sanluan.common.constants.CommonConstants.COOKIES_USER;
import static com.sanluan.common.constants.CommonConstants.SESSION_ADMIN;
import static com.sanluan.common.constants.CommonConstants.SESSION_USER;
import static com.sanluan.common.constants.CommonConstants.SESSION_USER_TIME;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.sanluan.entities.system.SystemUser;

public class RequestUtils {
	public static String getIp(HttpServletRequest request) {
		String ip = request.getHeader("X-Real-IP");
		if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
			return ip;
		}
		ip = request.getHeader("X-Forwarded-For");
		if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
			int index = ip.indexOf(',');
			if (index != -1) {
				return ip.substring(0, index);
			} else {
				return ip;
			}
		} else {
			return request.getRemoteAddr();
		}
	}

	public static String getUserAgent(HttpServletRequest request) {
		return request.getHeader("user-agent");
	}

	public static String getAccept(HttpServletRequest request) {
		return request.getHeader("Accept");
	}

	public static SystemUser getUserFromSession(HttpServletRequest request) {
		return (SystemUser) getSession(request).getAttribute(SESSION_USER);
	}

	public static Date getUserTimeFromSession(HttpServletRequest request) {
		return (Date) getSession(request).getAttribute(SESSION_USER_TIME);
	}
	
	public static void setUserToSession(HttpServletRequest request, SystemUser user) {
		getSession(request).setAttribute(SESSION_USER, user);
		getSession(request).setAttribute(SESSION_USER_TIME, new Date());
	}

	public static void clearUserToSession(HttpServletRequest request, HttpServletResponse response) {
		cancleCookie(request, response, COOKIES_USER, null);
		getSession(request).removeAttribute(SESSION_USER);
	}

	public static void clearUserTimeToSession(HttpServletRequest request) {
		getSession(request).removeAttribute(SESSION_USER_TIME);
	}

	
	public static SystemUser getAdminFromSession(HttpServletRequest request) {
		return (SystemUser) getSession(request).getAttribute(SESSION_ADMIN);
	}

	public static void setAdminToSession(HttpServletRequest request, SystemUser user) {
		getSession(request).setAttribute(SESSION_ADMIN, user);
	}

	public static void clearAdminToSession(HttpServletRequest request) {
		getSession(request).removeAttribute(SESSION_ADMIN);
	}

	public static HttpSession getSession(HttpServletRequest request) {
		return request.getSession();
	}

	public static Cookie getCookie(HttpServletRequest request, String name) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(name)) {
					return cookie;
				}
			}
		}
		return null;
	}

	public static Cookie addCookie(HttpServletRequest request, HttpServletResponse response, String name, String value,
			Integer expiry, String domain) {
		Cookie cookie = new Cookie(name, value);
		if (expiry != null) {
			cookie.setMaxAge(expiry);
		}
		if (StringUtils.isNotBlank(domain)) {
			cookie.setDomain(domain);
		}
		String ctx = request.getContextPath();
		cookie.setPath(StringUtils.isBlank(ctx) ? "/" : ctx);
		response.addCookie(cookie);
		return cookie;
	}

	public static void cancleCookie(HttpServletRequest request, HttpServletResponse response, String name, String domain) {
		Cookie cookie = new Cookie(name, null);
		cookie.setMaxAge(0);
		String ctx = request.getContextPath();
		cookie.setPath(StringUtils.isBlank(ctx) ? "/" : ctx);
		if (StringUtils.isNotBlank(domain)) {
			cookie.setDomain(domain);
		}
		response.addCookie(cookie);
	}
}
