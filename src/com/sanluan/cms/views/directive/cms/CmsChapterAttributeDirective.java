package com.sanluan.cms.views.directive.cms;

// Generated 2015-5-6 16:53:26 by SourceMaker

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sanluan.cms.entities.cms.CmsChapterAttribute;
import com.sanluan.cms.logic.service.cms.CmsChapterAttributeService;
import com.sanluan.common.base.BaseDirective;
import com.sanluan.common.handler.DirectiveHandler;

import freemarker.template.TemplateException;

@Component
public class CmsChapterAttributeDirective extends BaseDirective {

	@Override
	public void execute(DirectiveHandler handler) throws TemplateException, IOException {
		Integer id = handler.getInteger("id");
		if (null != id) {
			Map<String, Object> map = getMap();
			CmsChapterAttribute bean = service.getEntity(id);
			map.put("bean", bean);
			handler.export(map, bean);
		}
	}

	@Autowired
	private CmsChapterAttributeService service;

}