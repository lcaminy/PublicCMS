package com.sanluan.cms.admin.views.controller.cms;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sanluan.common.base.BaseController;
import com.sanluan.cms.entities.cms.CmsCategoryModel;
import com.sanluan.cms.logic.service.cms.CmsCategoryModelService;
@Controller
@RequestMapping("cmsCategoryModel")
public class CmsCategoryModelController extends BaseController {
	@Autowired
	private CmsCategoryModelService service;

	@RequestMapping(value = { "save" + DO_SUFFIX })
	public String save(CmsCategoryModel entity, HttpServletRequest request) {
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