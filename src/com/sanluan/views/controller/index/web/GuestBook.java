package com.sanluan.views.controller.index.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sanluan.common.base.BaseController;
import com.sanluan.entities.system.SystemGuestBook;
import com.sanluan.logic.service.system.SystemGuestBookService;

/**
 * @author zhangxd
 * 
 */
@Controller
@RequestMapping("guestbook")
public class GuestBook extends BaseController {
	@Autowired
	private SystemGuestBookService service;

	@RequestMapping(value = { "save" + DO_SUFFIX })
	public String save(SystemGuestBook entity, HttpServletRequest request, ModelMap model) {
		if (virifyNotEmpty("guestBook.contact", entity.getContact(), model)
				||virifyNotEmpty("guestBook.nickName", entity.getUserName(), model)
				|| virifyNotEmpty("guestBook.content", entity.getContent(), model)
				|| virifyNotLongThen("guestBook.contact", entity.getContact(), 100, model)
				|| virifyNotLongThen("guestBook.content", entity.getContact(), 1000, model)) {
			return "guestbook/create";
		}
		service.save(entity);
		model.addAttribute("message", "guestbook_save_success");
		return REDIRECT + "create" + PAGE_SUFFIX;
	}
}
