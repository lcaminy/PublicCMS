package com.sanluan.cms.views.directive.cms;

// Generated 2015-5-8 16:50:23 by SourceMaker

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sanluan.cms.logic.service.cms.CmsCategoryExtendService;
import com.sanluan.common.base.BaseDirective;
import com.sanluan.common.handler.DirectiveHandler;
import com.sanluan.common.handler.PageHandler;

import freemarker.template.TemplateException;

@Component
public class CmsCategoryExtendListDirective extends BaseDirective {

	@Override
	public void execute(DirectiveHandler handler) throws TemplateException, IOException {
		PageHandler page = service.getPage(handler.getInteger("extendType"), handler.getInteger("cateoryId"), handler.getShort("type"),  handler.getPageNo(), handler.getCount());
		handler.export(page);
	}

	@Autowired
	private CmsCategoryExtendService service;

}