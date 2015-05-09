package com.sanluan.cms.views.directive.cms;

// Generated 2015-5-9 16:36:28 by SourceMaker

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sanluan.cms.logic.service.cms.CmsCategoryAttributeService;
import com.sanluan.common.base.BaseDirective;
import com.sanluan.common.handler.DirectiveHandler;
import com.sanluan.common.handler.PageHandler;

import freemarker.template.TemplateException;

@Component
public class CmsCategoryAttributeListDirective extends BaseDirective {

	@Override
	public void execute(DirectiveHandler handler) throws TemplateException, IOException {
		PageHandler page = service.getPage( handler.getPageNo(), handler.getCount());
		handler.render(page);
	}

	@Autowired
	private CmsCategoryAttributeService service;

}