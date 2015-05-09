package com.sanluan.cms.views.directive.cms;

// Generated 2015-5-8 16:50:23 by SourceMaker

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sanluan.cms.logic.service.cms.CmsDictionaryDataService;
import com.sanluan.common.base.BaseDirective;
import com.sanluan.common.handler.DirectiveHandler;
import com.sanluan.common.handler.PageHandler;

import freemarker.template.TemplateException;

@Component
public class CmsDictionaryDataListDirective extends BaseDirective {

	@Override
	public void execute(DirectiveHandler handler) throws TemplateException, IOException {
		PageHandler page = service.getPage(handler.getString("name"), handler.getInteger("dictionaryId"),  handler.getPageNo(), handler.getCount());
		handler.export(page);
	}

	@Autowired
	private CmsDictionaryDataService service;

}