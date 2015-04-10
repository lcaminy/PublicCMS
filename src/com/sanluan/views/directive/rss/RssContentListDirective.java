package com.sanluan.views.directive.rss;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sanluan.common.base.BaseDirective;
import com.sanluan.common.handler.DirectiveHandler;
import com.sanluan.common.tools.RssUtils;
import com.sanluan.logic.service.web.WebPageService;
import com.sun.syndication.feed.synd.SyndEntry;

import freemarker.template.TemplateException;

/**
 * @author zhangxd
 * 
 */
@Component
public class RssContentListDirective extends BaseDirective {

	@Override
	public void execute(DirectiveHandler handler) throws TemplateException, IOException {
		String url = handler.getString("url");
		if (StringUtils.isNotBlank(url)) {
			List<SyndEntry> list = RssUtils.parseRss(url);
			Map<String, Object> map = getMap();
			map.put("list", list);
			handler.export(map, list);
		}
	}

	@Autowired
	private WebPageService service;

}
