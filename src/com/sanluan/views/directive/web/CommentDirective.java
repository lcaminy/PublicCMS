package com.sanluan.views.directive.web;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sanluan.common.base.BaseDirective;
import com.sanluan.common.handler.DirectiveHandler;
import com.sanluan.entities.web.WebComment;
import com.sanluan.logic.service.web.WebCommentService;

import freemarker.template.TemplateException;

/**
 * @author zhangxd
 * 
 */
@Component
public class CommentDirective extends BaseDirective {

	@Override
	public void execute(DirectiveHandler handler) throws TemplateException, IOException {
		Integer id = handler.getInt("id");
		if (null != id) {
			Map<String, Object> map = getMap();
			WebComment bean = service.getEntity(id);
			map.put("bean", bean);
			handler.export(map, bean);
		}
	}

	@Autowired
	private WebCommentService service;

}
