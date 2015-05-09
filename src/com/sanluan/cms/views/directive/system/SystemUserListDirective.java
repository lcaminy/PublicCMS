package com.sanluan.cms.views.directive.system;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sanluan.cms.logic.service.system.SystemUserService;
import com.sanluan.common.base.BaseDirective;
import com.sanluan.common.handler.DirectiveHandler;
import com.sanluan.common.handler.PageHandler;

import freemarker.template.TemplateException;

/**
 * @author zhangxd
 * 
 */
@Component
public class SystemUserListDirective extends BaseDirective {

	@Override
	public void execute(DirectiveHandler handler) throws TemplateException, IOException {
		PageHandler page = service.getPage(handler.getString("name"), handler.getBoolean("superuserAccess"),
				handler.getBoolean("disable"), handler.getDate("startDateRegistered"), handler.getDate("endDateRegistered"),
				handler.getPageNo(), handler.getCount());
		handler.render(page);
	}

	@Autowired
	private SystemUserService service;

}
