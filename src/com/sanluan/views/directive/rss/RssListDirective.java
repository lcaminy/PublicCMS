package com.sanluan.views.directive.rss;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sanluan.common.base.BaseDirective;
import com.sanluan.common.handler.DirectiveHandler;
import com.sanluan.common.handler.PageHandler;
import com.sanluan.logic.service.web.WebRssService;

import freemarker.template.TemplateException;

/**
 * @author zhangxd
 * 
 */
@Component
public class RssListDirective extends BaseDirective {

	@Override
	public void execute(DirectiveHandler handler) throws TemplateException, IOException {
		PageHandler page = service.getPage(handler.getString("name"), handler.getInt("parentId"), handler.getBool("tree"),
				handler.getPageNo(), handler.getCount());
		handler.export(page);
	}

	@Autowired
	private WebRssService service;

}
