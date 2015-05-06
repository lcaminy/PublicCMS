package com.sanluan.cms.admin.views.controller.cms;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sanluan.common.base.BaseController;
import com.sanluan.cms.entities.cms.CmsBlockData;
import com.sanluan.cms.logic.service.cms.CmsBlockDataService;
@Controller
@RequestMapping("cmsBlockData")
public class CmsBlockDataController extends BaseController {
	@Autowired
	private CmsBlockDataService service;

	@RequestMapping(value = { "save" + DO_SUFFIX })
	public String save(CmsBlockData entity, HttpServletRequest request) {
		if (null != entity.getId()) {
			service.update(entity.getId(), entity);
		} else {
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