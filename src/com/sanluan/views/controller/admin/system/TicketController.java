package com.sanluan.views.controller.admin.system;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sanluan.common.base.BaseController;
import com.sanluan.common.tools.RequestUtils;
import com.sanluan.entities.system.SystemTicket;
import com.sanluan.logic.service.system.SystemTicketService;

/**
 * @author zhangxd
 * 
 */
@Controller
@RequestMapping("ticket")
public class TicketController extends BaseController {
	@Autowired
	private SystemTicketService service;

	@RequestMapping(value = { "save" + DO_SUFFIX })
	public String save(SystemTicket entity, HttpServletRequest request) {
		if (null != entity.getId()) {
			service.update(entity.getId(), entity, new String[] { "id", "userId", "code", "createDate" });
		} else {
			entity.setUserId(RequestUtils.getAdminFromSession(request).getId());
			entity.setCode(UUID.randomUUID().toString());
			service.save(entity);
		}
		return "common/ajaxDone";
	}

	@RequestMapping(value = { "delete" + DO_SUFFIX })
	public String delete(Integer id) {
		service.delete(id);
		return "common/ajaxDone";
	}
}
