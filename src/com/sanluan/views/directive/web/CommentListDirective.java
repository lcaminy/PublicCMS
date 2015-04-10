package com.sanluan.views.directive.web;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sanluan.common.base.BaseDirective;
import com.sanluan.common.handler.DirectiveHandler;
import com.sanluan.common.handler.PageHandler;
import com.sanluan.logic.service.web.WebCommentService;

import freemarker.template.TemplateException;

/**
 * @author zhangxd
 * 
 */
@Component
public class CommentListDirective extends BaseDirective {

	@Override
	public void execute(DirectiveHandler handler) throws TemplateException, IOException {
		PageHandler page = service.getPage(handler.getString("type"), handler.getInt("itemId"), handler.getInt("userId"),
				handler.getPageNo(), handler.getCount());
		handler.export(page);
	}

	@Autowired
	private WebCommentService service;

}
