package com.sanluan.cms.views.directive.cms;

// Generated 2015-5-10 17:54:56 by SourceMaker

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sanluan.cms.logic.service.cms.CmsBlockDataService;
import com.sanluan.common.base.BaseDirective;
import com.sanluan.common.handler.DirectiveHandler;
import com.sanluan.common.handler.PageHandler;

import freemarker.template.TemplateException;

@Component
public class CmsBlockDataListDirective extends BaseDirective {

	@Override
	public void execute(DirectiveHandler handler) throws TemplateException, IOException {
		PageHandler page = service.getPage(handler.getInteger("blockId"), handler.getDate("startCreateDate"), handler.getDate("endCreateDate"), handler.getInteger("isDisable"), handler.getInteger("pageNo",1), handler.getInteger("count",20));
		handler.put("page", page).render();
	}

	@Autowired
	private CmsBlockDataService service;

}