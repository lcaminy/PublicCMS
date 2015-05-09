package com.sanluan.cms.views.directive.cms;

// Generated 2015-5-8 16:50:23 by SourceMaker

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sanluan.cms.entities.cms.CmsBlockData;
import com.sanluan.cms.logic.service.cms.CmsBlockDataService;
import com.sanluan.common.base.BaseDirective;
import com.sanluan.common.handler.DirectiveHandler;

import freemarker.template.TemplateException;

@Component
public class CmsBlockDataDirective extends BaseDirective {

	@Override
	public void execute(DirectiveHandler handler) throws TemplateException, IOException {
		Integer id = handler.getInteger("id");
		if (null != id) {
			Map<String, Object> map = getMap();
			CmsBlockData bean = service.getEntity(id);
			map.put("bean", bean);
			handler.export(map, bean);
		}
	}

	@Autowired
	private CmsBlockDataService service;

}
