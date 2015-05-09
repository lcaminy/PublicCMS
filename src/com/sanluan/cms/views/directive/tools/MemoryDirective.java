package com.sanluan.cms.views.directive.tools;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.sanluan.common.base.BaseDirective;
import com.sanluan.common.handler.DirectiveHandler;

import freemarker.template.TemplateException;

/**
 * @author zhangxd
 * 
 */
@Component
public class MemoryDirective extends BaseDirective {

	@Override
	public void execute(DirectiveHandler handler) throws TemplateException, IOException {
		Map<String, Long> map = new HashMap<String,Long>();
		map.put("free", Runtime.getRuntime().freeMemory());
		map.put("total", Runtime.getRuntime().totalMemory());
		map.put("max", Runtime.getRuntime().maxMemory());
		handler.put("bean", map);
		handler.render();
	}
}
