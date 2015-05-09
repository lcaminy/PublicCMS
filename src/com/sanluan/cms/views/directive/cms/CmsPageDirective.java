package com.sanluan.cms.views.directive.cms;

// Generated 2015-5-9 16:36:28 by SourceMaker

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sanluan.cms.entities.cms.CmsPage;
import com.sanluan.cms.logic.service.cms.CmsPageService;
import com.sanluan.common.base.BaseDirective;
import com.sanluan.common.handler.DirectiveHandler;

import freemarker.template.TemplateException;

@Component
public class CmsPageDirective extends BaseDirective {

	@Override
	public void execute(DirectiveHandler handler) throws TemplateException, IOException {
		Integer id = handler.getInteger("id");
		if (null != id) {
			CmsPage bean = service.getEntity(id);
			handler.put("bean", bean);
			handler.render();
		}
	}

	@Autowired
	private CmsPageService service;

}
