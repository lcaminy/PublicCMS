package com.sanluan.cms.logic.component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.template.Template;

/**
 * Html帮助类，用于生成html
 * 
 * @author zhangxd
 * 
 */
@Component
public class HtmlComponent {
	private Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;

	public boolean makeHtml(String templatePath, String htmlPath, ModelMap model) {
		try {
			Template template = freeMarkerConfigurer.getConfiguration().getTemplate(templatePath);
			template.setEncoding("utf-8");
			File dest = new File(htmlPath);
			File parent = dest.getParentFile();
			if (parent != null) {
				parent.mkdirs();
			}
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dest), "utf-8"));
			template.process(model, out);
			out.close();
			return true;
		} catch (Exception e) {
			log.error(e.getMessage());
			return false;
		}
	}
	
	public String dealTemplateFile(String template) {
		return this.dealTemplateFile(template, new ModelMap());
	}

	public String dealTemplateFile(String template, ModelMap model) {
		try {
			Template tpl = freeMarkerConfigurer.getConfiguration().getTemplate(template);
			return FreeMarkerTemplateUtils.processTemplateIntoString(tpl, model);
		} catch (Exception e) {
			log.error(e.getMessage());
			return "";
		}
	}

	public String dealTemplateContent(String templateContent) {
		return dealTemplateContent(templateContent, new ModelMap());
	}

	public String dealTemplateContent(String templateContent, ModelMap model) {
		try {
			Template tpl = new Template(String.valueOf(templateContent.hashCode()), templateContent,
					freeMarkerConfigurer.getConfiguration());
			return FreeMarkerTemplateUtils.processTemplateIntoString(tpl, model);
		} catch (Exception e) {
			log.error(e.getMessage());
			return "";
		}
	}

	/**
	 * @return the freeMarkerConfigurer
	 */
	public FreeMarkerConfigurer getFreeMarkerConfigurer() {
		return freeMarkerConfigurer;
	}
}
