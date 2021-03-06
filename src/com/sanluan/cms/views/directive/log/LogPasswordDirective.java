package com.sanluan.cms.views.directive.log;

// Generated 2015-5-12 12:57:43 by SourceMaker

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sanluan.cms.entities.log.LogPassword;
import com.sanluan.cms.logic.service.log.LogPasswordService;
import com.sanluan.common.base.BaseDirective;
import com.sanluan.common.handler.DirectiveHandler;

import freemarker.template.TemplateException;

@Component
public class LogPasswordDirective extends BaseDirective {

	@Override
	public void execute(DirectiveHandler handler) throws TemplateException, IOException {
		Integer id = handler.getInteger("id");
		if (null != id) {
			LogPassword bean = service.getEntity(id);
			handler.put("bean", bean).renderIfNotNull(bean);
		}
	}

	@Autowired
	private LogPasswordService service;

}
