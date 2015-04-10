package com.sanluan.views.directive.system;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sanluan.common.base.BaseDirective;
import com.sanluan.common.handler.DirectiveHandler;
import com.sanluan.entities.system.SystemTicket;
import com.sanluan.logic.service.system.SystemTicketService;

import freemarker.template.TemplateException;

/**
 * @author zhangxd
 * 
 */
@Component
public class TicketDirective extends BaseDirective {

	@Override
	public void execute(DirectiveHandler handler) throws TemplateException, IOException {
		String code = handler.getString("code");
		if (StringUtils.isNotBlank(code)) {
			Map<String, Object> map = getMap();
			SystemTicket bean = service.findByCode(code);
			map.put("bean", bean);
			handler.export(map, bean);
		}
	}

	@Autowired
	private SystemTicketService service;

}
