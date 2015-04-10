package com.sanluan.common.interceptor;

import static com.sanluan.common.constants.CommonConstants.COOKIES_USER;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.util.UrlPathHelper;

import com.sanluan.common.base.BaseInterceptor;
import com.sanluan.common.tools.RequestUtils;
import com.sanluan.entities.system.SystemUser;
import com.sanluan.logic.service.system.SystemUserService;

/**
 * @author zhangxd
 * 
 */
public class ContextInterceptor extends BaseInterceptor implements ApplicationContextAware {
	private String[] needLoginUrls;
	private String loginUrl;
	private ApplicationContext applicationContext;
	private SystemUserService systemUserService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException {
		SystemUser user = RequestUtils.getUserFromSession(request);
		if (null == user) {
			Cookie userCookie = RequestUtils.getCookie(request, COOKIES_USER);
			if (null != userCookie && StringUtils.isNotBlank(userCookie.getValue())) {
				user = getSystemUserService().findByAuthToken(userCookie.getValue());
				if (null != user) {
					RequestUtils.setUserToSession(request, user);
				} else {
					RequestUtils.cancleCookie(request, response, COOKIES_USER, null);
				}
			}
		} else {
			Date date = RequestUtils.getUserTimeFromSession(request);
			if (null == date || date.before(DateUtils.addSeconds(new Date(), -30))) {
				user = getSystemUserService().getEntity(user.getId());
				RequestUtils.setUserToSession(request, user);
			}
		}
		if (verify(getURL(request))) {
			UrlPathHelper helper = new UrlPathHelper();
			if (null != user && user.isDisable()) {
				user = null;
				RequestUtils.clearUserToSession(request, response);
				RequestUtils.cancleCookie(request, response, COOKIES_USER, null);
			}
			if (null == user) {
				try {
					response.sendRedirect(helper.getOriginatingContextPath(request) + loginUrl + "?returnUrl=" + getURL(request)
							+ getEncodeQueryString(request.getQueryString()));
					return false;
				} catch (IOException e) {
				}
			}
		}
		return true;
	}

	private SystemUserService getSystemUserService() {
		if (null == systemUserService) {
			systemUserService = applicationContext.getBean(SystemUserService.class);
		}
		return systemUserService;
	}

	private boolean verify(String url) {
		if (null != needLoginUrls && null != loginUrl && null != url) {
			for (String needLoginUrl : needLoginUrls) {
				if (null != needLoginUrl) {
					if (url.startsWith(needLoginUrl)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	/**
	 * @param needLoginUrls
	 *            the needLoginUrls to set
	 */
	public void setNeedLoginUrls(String[] needLoginUrls) {
		this.needLoginUrls = needLoginUrls;
	}

	/**
	 * @param loginUrl
	 *            the loginUrl to set
	 */
	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}
}
