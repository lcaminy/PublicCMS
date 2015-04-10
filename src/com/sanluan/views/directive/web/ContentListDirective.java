package com.sanluan.views.directive.web;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sanluan.common.base.BaseDirective;
import com.sanluan.common.handler.DirectiveHandler;
import com.sanluan.common.handler.PageHandler;
import com.sanluan.logic.service.web.WebContentService;

import freemarker.template.TemplateException;

/**
 * @author zhangxd
 * 
 */
@Component
public class ContentListDirective extends BaseDirective {

	@Override
	public void execute(DirectiveHandler handler) throws TemplateException, IOException {
		PageHandler page = service.getPage(handler.getInt("catalogId"), handler.getInt("userId"), handler.getInt("status"),
				handler.getString("title"), handler.getBool("showAll"), handler.getPageNo(), handler.getCount());
		handler.export(page);
	}

	@Autowired
	private WebContentService service;

}
