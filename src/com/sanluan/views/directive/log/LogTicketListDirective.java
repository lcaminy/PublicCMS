package com.sanluan.views.directive.log;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sanluan.common.base.BaseDirective;
import com.sanluan.common.handler.DirectiveHandler;
import com.sanluan.common.handler.PageHandler;
import com.sanluan.logic.service.log.LogTicketService;

import freemarker.template.TemplateException;

/**
 * @author zhangxd
 * 
 */
@Component
public class LogTicketListDirective extends BaseDirective {

	@Override
	public void execute(DirectiveHandler handler) throws TemplateException, IOException {
		PageHandler page = service.getPage(handler.getInt("ticketId"), handler.getInt("userId"),
				handler.getDate("startCreateDate"), handler.getDate("endCreateDate"), handler.getPageNo(), handler.getCount());
		handler.export(page);
	}

	@Autowired
	private LogTicketService service;

}
