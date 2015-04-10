package com.sanluan.views.directive.log;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sanluan.common.base.BaseDirective;
import com.sanluan.common.handler.DirectiveHandler;
import com.sanluan.common.handler.PageHandler;
import com.sanluan.logic.service.log.LogEmailCheckService;

import freemarker.template.TemplateException;

/**
 * @author zhangxd
 * 
 */
@Component
public class LogEmailCheckListDirective extends BaseDirective {

	@Override
	public void execute(DirectiveHandler handler) throws TemplateException, IOException {
		PageHandler page = service.getPage(handler.getInt("userId"), handler.getBool("checked"),
				handler.getDate("startCreateDate"), handler.getDate("endCreateDate"), handler.getPageNo(), handler.getCount());
		handler.export(page);
	}

	@Autowired
	private LogEmailCheckService service;

}
