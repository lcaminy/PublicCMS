package com.sanluan.views.directive.system;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sanluan.common.base.BaseDirective;
import com.sanluan.common.handler.DirectiveHandler;
import com.sanluan.entities.system.SystemUser;
import com.sanluan.logic.service.system.SystemUserService;

import freemarker.template.TemplateException;

/**
 * @author zhangxd
 * 
 */
@Component
public class UserDirective extends BaseDirective {

	@Override
	public void execute(DirectiveHandler handler) throws TemplateException, IOException {
		Integer id = handler.getInt("id");
		if (null != id) {
			Map<String, Object> map = getMap();
			SystemUser bean = service.getEntity(id);
			bean.setPassword(null);
			bean.setAuthToken(null);
			map.put("bean", bean);
			handler.export(map, bean);
		}
	}

	@Autowired
	private SystemUserService service;

}
