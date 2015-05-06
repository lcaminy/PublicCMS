package com.sanluan.cms.views.directive.cms;

// Generated 2015-5-6 16:53:26 by SourceMaker

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sanluan.cms.logic.service.cms.CmsModelExtendService;
import com.sanluan.common.base.BaseDirective;
import com.sanluan.common.handler.DirectiveHandler;
import com.sanluan.common.handler.PageHandler;

import freemarker.template.TemplateException;

@Component
public class CmsModelExtendListDirective extends BaseDirective {

	@Override
	public void execute(DirectiveHandler handler) throws TemplateException, IOException {
		PageHandler page = service.getPage(handler.getInteger("modelId"), handler.getInteger("extendType"), handler.getShort("type"),  handler.getPageNo(), handler.getCount());
		handler.export(page);
	}

	@Autowired
	private CmsModelExtendService service;

}