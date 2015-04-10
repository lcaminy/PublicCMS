package com.sanluan.views.method;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import com.sanluan.common.base.BaseMethod;
import com.sanluan.logic.component.HtmlComponent;

import freemarker.template.TemplateCollectionModel;
import freemarker.template.TemplateHashModelEx;
import freemarker.template.TemplateModelException;
import freemarker.template.TemplateModelIterator;
import freemarker.template.TemplateScalarModel;

/**
 * @author zhangxd
 * 
 */
@Component
public class DealTemplateMethod extends BaseMethod {
	@Autowired
	private HtmlComponent component;

	/*
	 * (non-Javadoc)
	 * 
	 * @see freemarker.template.TemplateMethodModelEx#exec(java.util.List)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Object exec(@SuppressWarnings("rawtypes") List arguments) throws TemplateModelException {
		String html = null;
		if (arguments.size() > 0) {
			if (arguments.size() > 1) {
				TemplateHashModelEx hashModel = getHashModel(1, arguments);
				ModelMap model = new ModelMap();
				if (null != hashModel) {
					TemplateCollectionModel keys = hashModel.keys();
					TemplateModelIterator iterator = keys.iterator();
					while (iterator.hasNext()) {
						String key = ((TemplateScalarModel) iterator.next()).getAsString();
						model.addAttribute(key, hashModel.get(key));
					}
				}

				html = component.dealTemplateContent(getString(0, arguments), model);
			} else {
				html = component.dealTemplateContent(getString(0, arguments));
			}
		}
		return html;
	}
}
