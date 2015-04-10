package com.sanluan.views.controller.index.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sanluan.common.base.BaseController;
import com.sanluan.common.tools.RequestUtils;
import com.sanluan.entities.system.SystemUser;
import com.sanluan.entities.web.WebComment;
import com.sanluan.logic.service.web.WebCommentService;

/**
 * @author zhangxd
 * 
 */
@Controller
@RequestMapping("user/comment")
public class Comment extends BaseController {
	@Autowired
	private WebCommentService service;

	@RequestMapping(value = { "save" + DO_SUFFIX })
	public ModelMap save(WebComment entity, HttpServletRequest request, ModelMap model) {
		if (virifyNotEmpty("content", entity.getContent(), model) || virifyNotEmpty("comment.type", entity.getType(), model)) {
			return model;
		} else {
			SystemUser user = RequestUtils.getUserFromSession(request);
			entity.setUserId(user.getId());
			service.save(entity);
		}
		return model;
	}
}
