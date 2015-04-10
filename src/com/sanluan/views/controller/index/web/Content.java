package com.sanluan.views.controller.index.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sanluan.common.base.BaseController;
import com.sanluan.common.tools.RequestUtils;
import com.sanluan.entities.system.SystemUser;
import com.sanluan.entities.web.WebContent;
import com.sanluan.logic.service.web.WebContentService;

/**
 * @author zhangxd
 * 
 */
@Controller
@RequestMapping("user/content")
public class Content extends BaseController {
	@Autowired
	private WebContentService service;

	@RequestMapping(value = { "save" + DO_SUFFIX })
	public String save(WebContent entity, HttpServletRequest request, ModelMap model) {
		if (virifyNotEmpty("content", entity.getContent(), model) || virifyNotEmpty("title", entity.getTitle(), model)) {
			return "user/content/create";
		} else {
			SystemUser user = RequestUtils.getUserFromSession(request);
			entity.setUserId(user.getId());
			if (null == entity.getId()) {
				service.save(entity);
			} else {
				if (virifyNotEquals("user.content", user, service.getEntity(entity.getId()).getUserId(), model)) {
					return "user/content/create";
				}
				service.update(entity.getId(), entity, new String[] { "id", "published", "realPublished", "userId" });
			}
			model.addAttribute("message", "content_save_success");
		}
		return REDIRECT + "../index" + PAGE_SUFFIX;
	}
}
