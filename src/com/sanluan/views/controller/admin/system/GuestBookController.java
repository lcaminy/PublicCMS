package com.sanluan.views.controller.admin.system;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sanluan.common.base.BaseController;
import com.sanluan.logic.service.system.SystemGuestBookService;

/**
 * @author zhangxd
 * 
 */
@Controller
@RequestMapping("guestbook")
public class GuestBookController extends BaseController {
	@Autowired
	private SystemGuestBookService service;

	@RequestMapping(value = { "delete" + DO_SUFFIX })
	public String delete(Integer id, HttpServletRequest request, ModelMap model) {
		service.delete(id);
		return "common/ajaxDone";
	}
}
