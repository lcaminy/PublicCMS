package com.sanluan.views.controller.admin;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sanluan.common.base.BaseController;
import com.sanluan.common.tools.RequestUtils;
import com.sanluan.common.tools.VerificationUtils;
import com.sanluan.entities.log.LogLogin;
import com.sanluan.entities.system.SystemUser;
import com.sanluan.logic.component.CacheComponent;
import com.sanluan.logic.service.log.LogLoginService;
import com.sanluan.logic.service.system.SystemUserService;

/**
 * @author zhangxd
 * 
 */
@Controller
public class LoginController extends BaseController {
	@Autowired
	private SystemUserService service;
	@Autowired
	private CacheComponent cacheComponent;
	@Autowired
	private LogLoginService logLoginService;

	@RequestMapping(value = { "login" + DO_SUFFIX }, method = RequestMethod.POST)
	public String login(String password, String returnUrl, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		SystemUser user = RequestUtils.getUserFromSession(request);
		if (virifyNotEquals("password", VerificationUtils.encode(password), user.getPassword(), model)
				|| virifyNotAdmin(user, model)) {
			model.addAttribute("returnUrl", returnUrl);
			LogLogin log = new LogLogin();
			log.setName(user.getName());
			log.setErrorPassword(password);
			log.setIp(RequestUtils.getIp(request));
			logLoginService.save(log);
			return "login";
		}
		RequestUtils.setAdminToSession(request, user);
		service.updateLoginStatus(user.getId(), user.getName(), user.getAuthToken(), RequestUtils.getIp(request));
		if (StringUtils.isNotBlank(returnUrl)) {
			try {
				returnUrl = URLDecoder.decode(returnUrl, "utf-8");
			} catch (UnsupportedEncodingException e) {
			}
			return REDIRECT + returnUrl;
		} else
			return REDIRECT + "index" + PAGE_SUFFIX;
	}

	@RequestMapping(value = { "changePassword" + DO_SUFFIX }, method = RequestMethod.POST)
	public String changePassword(HttpServletRequest request, Integer id, String oldpassword, String password, String repassword,
			ModelMap model) {
		SystemUser user;
		String page = "common/ajaxDone";
		if (null != id) {
			user = service.getEntity(id);
		} else {
			user = RequestUtils.getAdminFromSession(request);
			if (virifyNotEquals("password", user.getPassword(), VerificationUtils.encode(oldpassword), model)) {
				return "common/ajaxError";
			} else if (virifyNotEmpty("password", password, model) || virifyNotEquals("repassword", password, repassword, model)) {
				return "common/ajaxError";
			} else {
				RequestUtils.clearAdminToSession(request);
				model.addAttribute("message", "common.needReLogin");
				page = "common/ajaxTimeout";
			}
		}
		if (null != user)
			service.updatePassword(user.getId(), RequestUtils.getIp(request), VerificationUtils.encode(password));
		return page;
	}

	@RequestMapping(value = { "logout" + DO_SUFFIX }, method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		RequestUtils.clearAdminToSession(request);
		return REDIRECT + "index" + PAGE_SUFFIX;
	}

	@RequestMapping(value = { "clearTemplateCache" + DO_SUFFIX })
	public String clearTemplateCache(HttpServletRequest request) {
		cacheComponent.clearTemplateCache();
		return "common/ajaxDone";
	}
}
