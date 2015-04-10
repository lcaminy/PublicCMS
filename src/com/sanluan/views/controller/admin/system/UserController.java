package com.sanluan.views.controller.admin.system;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sanluan.common.base.BaseController;
import com.sanluan.common.tools.RequestUtils;
import com.sanluan.logic.service.system.SystemUserService;

/**
 * @author zhangxd
 * 
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController {
	@Autowired
	private SystemUserService service;

	@RequestMapping(value = { "enable" + DO_SUFFIX }, method = RequestMethod.POST)
	public String enable(HttpServletRequest request, Integer id, String repassword, ModelMap model) {
		if (virifyEquals("admin.operate", RequestUtils.getAdminFromSession(request), id, model)) {
			return "common/ajaxError";
		}
		service.updateStatus(id, false);
		return "common/ajaxDone";
	}

	@RequestMapping(value = { "disable" + DO_SUFFIX }, method = RequestMethod.POST)
	public String disable(HttpServletRequest request, Integer id, String repassword, ModelMap model) {
		if (virifyEquals("admin.operate", RequestUtils.getAdminFromSession(request), id, model)) {
			return "common/ajaxError";
		}
		service.updateStatus(id, true);
		return "common/ajaxDone";
	}
}
