package com.sanluan.views.controller.index.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sanluan.common.base.BaseController;
import com.sanluan.common.tools.RequestUtils;
import com.sanluan.entities.system.SystemUser;
import com.sanluan.entities.web.WebUserPage;
import com.sanluan.logic.component.HtmlComponent;
import com.sanluan.logic.service.web.WebUserPageService;

/**
 * @author zhangxd
 * 
 */
@Controller
@RequestMapping("user/page")
public class UserPage extends BaseController {
	@Autowired
	private HtmlComponent component;
	@Autowired
	private WebUserPageService service;

	@RequestMapping(value = { "save" + DO_SUFFIX })
	public String save(WebUserPage entity, HttpServletRequest request, ModelMap model) {
		if (virifyNotEmpty("template", entity.getTemplate(), model) || virifyNotEmpty("name", entity.getName(), model)) {
			return "user/page/create";
		} else {
			SystemUser user = RequestUtils.getUserFromSession(request);
			entity.setUserId(user.getId());
			if (null == entity.getId()) {
				service.save(entity);
			} else {
				if (virifyNotEquals("user.page", user, service.getEntity(entity.getId()).getUserId(), model)) {
					return "user/page/create";
				}
				entity.setLastUpdateDate(new Date());
				service.update(entity.getId(), entity, new String[] { "id", "createDate", "published", "userId" });
			}
			model.addAttribute("message", "page_save_success");
		}
		return REDIRECT + "../index" + PAGE_SUFFIX;
	}

	@RequestMapping(value = { "publish" + DO_SUFFIX })
	public String publish(Integer id, HttpServletRequest request, ModelMap model) {
		WebUserPage page = service.getEntity(id);
		if (virifyNotEmpty("id", id, model) || virifyNotEmpty("user.page", page, model)) {
			return REDIRECT + "../index" + PAGE_SUFFIX;
		} else {
			SystemUser user = RequestUtils.getUserFromSession(request);
			if (virifyNotEquals("user.page", user, page.getUserId(), model)) {
				return REDIRECT + "../index" + PAGE_SUFFIX;
			}
			if (page.isPublished()) {
				service.rePublish(id);
			} else {
				service.publish(id, user.getId());
			}
			model.addAttribute("message", "page_publish_success");
		}
		return REDIRECT + "../index" + PAGE_SUFFIX;
	}
}
