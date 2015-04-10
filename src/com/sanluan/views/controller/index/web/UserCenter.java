package com.sanluan.views.controller.index.web;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sanluan.common.base.BaseController;
import com.sanluan.common.tools.LanguagesUtils;
import com.sanluan.common.tools.RequestUtils;
import com.sanluan.common.tools.VerificationUtils;
import com.sanluan.entities.log.LogEmailCheck;
import com.sanluan.entities.system.SystemUser;
import com.sanluan.logic.component.HtmlComponent;
import com.sanluan.logic.component.MailComponent;
import com.sanluan.logic.service.log.LogEmailCheckService;
import com.sanluan.logic.service.system.SystemUserService;

/**
 * @author zhangxd
 * 
 */
@Controller
@RequestMapping("user")
public class UserCenter extends BaseController {
	private final String passwordPage = "user/password";
	@Autowired
	private SystemUserService service;
	@Autowired
	private MailComponent mailComponent;
	@Autowired
	private HtmlComponent htmlComponent;
	@Autowired
	private LogEmailCheckService logEmailCheckService;

	@RequestMapping(value = { "changePassword" + DO_SUFFIX })
	public String changePassword(String oldpassword, String password, String repassword, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		SystemUser user = RequestUtils.getUserFromSession(request);
		if (virifyNotEmpty("password", password, model) || virifyNotEquals("repassword", password, repassword, model)) {
			return passwordPage;
		} else {
			if (virifyNotEquals("password", user.getPassword(), VerificationUtils.encode(oldpassword), model)) {
				return passwordPage;
			} else {
				RequestUtils.clearUserToSession(request, response);
				model.addAttribute("message", "needReLogin");
			}

			if (null != user)
				service.updatePassword(user.getId(), RequestUtils.getIp(request), VerificationUtils.encode(password));
		}
		return REDIRECT + "../login" + PAGE_SUFFIX;
	}
	

	@RequestMapping(value = { "saveEmail" + DO_SUFFIX })
	public String saveEmail(String email, HttpServletRequest request, ModelMap model) {
		if (virifyNotEmpty("email", email, model) || virifyNotEMail("email", email, model)
				|| virifyHasExist("email", service.findByEmail(email), model)) {
			return "editEmail";
		}
		SystemUser user = RequestUtils.getUserFromSession(request);

		String emailCheckCode = UUID.randomUUID().toString();
		LogEmailCheck emailCheckLog = new LogEmailCheck();
		emailCheckLog.setUserId(user.getId());
		emailCheckLog.setCode(emailCheckCode);
		emailCheckLog.setEmail(email);
		logEmailCheckService.save(emailCheckLog);

		ModelMap emailModel = new ModelMap();
		emailModel.put("tempUser", user);
		emailModel.put("email", email);
		emailModel.put("emailCheckCode", emailCheckCode);

		mailComponent.sendHtml(email, LanguagesUtils.getMessage(request, "email.register.title", user.getNickName()),
				htmlComponent.dealTemplateFile(LanguagesUtils.getMessage(request, "email.register.template"), emailModel));
		model.addAttribute("message", "saveEmail.success");
		return REDIRECT + "index" + PAGE_SUFFIX;
	}
}
