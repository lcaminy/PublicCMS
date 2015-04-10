package com.sanluan.views.controller.admin.system;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sanluan.common.base.BaseController;
import com.sanluan.entities.web.WebRss;
import com.sanluan.logic.service.web.WebRssService;

/**
 * @author zhangxd
 * 
 */
@Controller
@RequestMapping("rss")
public class RssController extends BaseController {
	@Autowired
	private WebRssService service;

	@RequestMapping(value = { "save" + DO_SUFFIX })
	public String save(WebRss entity, HttpServletRequest request) {
		if (null != entity.getId()) {
			service.update(entity.getId(), entity, new String[] { "id", "parentId", "createDate", "enable" });
		} else {
			entity.setEnable(true);
			service.save(entity);
		}
		return "common/ajaxDone";
	}

	@RequestMapping(value = { "delete" + DO_SUFFIX })
	public String delete(Integer id) {
		service.disable(id);
		return "common/ajaxDone";
	}
}
