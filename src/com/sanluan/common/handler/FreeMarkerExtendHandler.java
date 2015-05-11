package com.sanluan.common.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.sanluan.common.tools.MyClassUtils;

import freemarker.template.SimpleHash;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

public class FreeMarkerExtendHandler implements ApplicationContextAware {
	private ApplicationContext applicationContext;
	private String directiveBasePackage;
	private String methodBasePackage;
	private String directivePrefix;
	private String methodPrefix;
	private String directiveRemoveString;
	private String methodRemoveString;
	protected final Log logger = LogFactory.getLog(getClass());

	public FreeMarkerExtendHandler() {
		logger.info("Freemarker directives and methods Handler started");
		FreeMarkerConfigurer freeMarkerConfigurer = applicationContext.getBean(FreeMarkerConfigurer.class);
		Map<String, Object> freemarkerVariables = new HashMap<String, Object>();

		StringBuffer directives = new StringBuffer();
		List<Class<?>> directiveClasses = MyClassUtils.getAllAssignedClass(TemplateDirectiveModel.class, directiveBasePackage);
		for (Class<?> c : directiveClasses) {
			String directiveName = StringUtils.uncapitalize(c.getSimpleName());
			directiveName = directivePrefix + directiveName.replace(directiveRemoveString, "");
			freemarkerVariables.put(directiveName, applicationContext.getBean(c));
			if (0 != directives.length())
				directives.append(",");
			directives.append(directiveName);
		}

		List<Class<?>> methodClasses = MyClassUtils.getAllAssignedClass(TemplateMethodModelEx.class, methodBasePackage);
		StringBuffer methods = new StringBuffer();
		for (Class<?> c : methodClasses) {
			String methodName = StringUtils.uncapitalize(c.getSimpleName());
			methodName = methodPrefix + methodName.replace(methodRemoveString, "");
			freemarkerVariables.put(methodName, applicationContext.getBean(c));
			if (0 != methods.length())
				methods.append(",");
			methods.append(methodName);
		}

		try {
			freeMarkerConfigurer.getConfiguration().setAllSharedVariables(
					new SimpleHash(freemarkerVariables, freeMarkerConfigurer.getConfiguration().getObjectWrapper()));
			logger.info((directiveClasses.size() + 1) + " directives created:[" + directives.toString() + "];"
					+ methodClasses.size() + " methods created:[" + methods.toString() + "]");
		} catch (TemplateModelException e) {
		}
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	/**
	 * @param directiveBasePackage
	 *            the directiveBasePackage to set
	 */
	public void setDirectiveBasePackage(String directiveBasePackage) {
		this.directiveBasePackage = directiveBasePackage;
	}

	/**
	 * @param methodBasePackage
	 *            the methodBasePackage to set
	 */
	public void setMethodBasePackage(String methodBasePackage) {
		this.methodBasePackage = methodBasePackage;
	}

	/**
	 * @param directivePrefix
	 *            the directivePrefix to set
	 */
	public void setDirectivePrefix(String directivePrefix) {
		this.directivePrefix = directivePrefix;
	}

	/**
	 * @param methodPrefix
	 *            the methodPrefix to set
	 */
	public void setMethodPrefix(String methodPrefix) {
		this.methodPrefix = methodPrefix;
	}

	/**
	 * @param directiveRemoveString
	 *            the directiveRemoveString to set
	 */
	public void setDirectiveRemoveString(String directiveRemoveString) {
		this.directiveRemoveString = directiveRemoveString;
	}

	/**
	 * @param methodRemoveString
	 *            the methodRemoveString to set
	 */
	public void setMethodRemoveString(String methodRemoveString) {
		this.methodRemoveString = methodRemoveString;
	}
}
