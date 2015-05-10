package com.sanluan.cms.admin.views.controller;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.sanluan.common.base.BaseController;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * @author zhangxd
 * 
 */
@Controller
public class IndexController extends BaseController {
	@Autowired
	FreeMarkerConfigurer freeMarkerConfigurer;
	
	@RequestMapping(value = { "create" + PAGE_SUFFIX })
	public String create(HttpServletRequest request, ModelMap model) {
		Configuration c = freeMarkerConfigurer.getConfiguration();
		try {
			Template t = c.getTemplate("admin/cmsContent/list.html");
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E://a.html"), "utf-8"));
			model.addAttribute("random", new Random().nextInt());
			t.process(model, writer);
			model.addAttribute("message", "success");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
		return "common/ajaxDone";
	}
	
	@RequestMapping(value = { "{path}" + PAGE_SUFFIX })
	public String page(HttpServletRequest request, @PathVariable String path, ModelMap model) {
		return path;
	}

	@RequestMapping(value = { DELIMITER })
	public String page(HttpServletRequest request, ModelMap model) {
		return page(request, TEMPLATE_INDEX, model);
	}

	@RequestMapping(value = { "{dir}", "{dir}" + DELIMITER })
	public String domainAndPage(HttpServletRequest request, @PathVariable String dir, ModelMap model) {
		return domainAndPage(request, dir, TEMPLATE_INDEX, model);
	}

	@RequestMapping(value = { "{dir}" + DELIMITER + "{path}" + PAGE_SUFFIX })
	public String domainAndPage(HttpServletRequest request, @PathVariable String dir, @PathVariable String path, ModelMap model) {
		return dir + DELIMITER + page(request, path, model);
	}
}
