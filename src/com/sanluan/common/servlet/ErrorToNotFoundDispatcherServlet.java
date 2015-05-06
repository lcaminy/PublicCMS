package com.sanluan.common.servlet;

import static com.sanluan.common.constants.FreeMakerConstants.CONTEXT_BASE;
import static com.sanluan.common.constants.FreeMakerConstants.CONTEXT_NOCACHE;
import static com.sanluan.common.constants.FreeMakerConstants.DIRECTIVE_BASE_CLASS;
import static com.sanluan.common.constants.FreeMakerConstants.DIRECTIVE_CUT_STRING;
import static com.sanluan.common.constants.FreeMakerConstants.DIRECTIVE_PREFIX;
import static com.sanluan.common.constants.FreeMakerConstants.METHOD_BASE_CLASS;
import static com.sanluan.common.constants.FreeMakerConstants.METHOD_CUT_STRING;
import static com.sanluan.common.constants.FreeMakerConstants.METHOD_PREFIX;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.sanluan.common.tools.MyClassUtils;

import freemarker.template.SimpleHash;
import freemarker.template.TemplateModelException;

/**
 * @author zhangxd
 * 
 */
public class ErrorToNotFoundDispatcherServlet extends DispatcherServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String directiveBasePackage;
	private String methodBasePackage;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.DispatcherServlet#render(org.springframework
	 * .web.servlet.ModelAndView, javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	public void render(ModelAndView mv, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			super.render(mv, request, response);
		} catch (ServletException e) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}

	/*
	 * (non-Javadoc) 第一次启动时调用
	 * 
	 * @see
	 * org.springframework.web.servlet.FrameworkServlet#initFrameworkServlet()
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void initFrameworkServlet() throws ServletException {
		super.initFrameworkServlet();
		logger.info("Creating Freemarker directives and methods started");
		FreeMarkerConfigurer freeMarkerConfigurer = getWebApplicationContext().getBean(FreeMarkerConfigurer.class);
		Map freemarkerVariables = new HashMap();

		StringBuffer directives = new StringBuffer();
		List<Class<?>> directiveClasses = MyClassUtils.getAllAssignedClass(DIRECTIVE_BASE_CLASS, directiveBasePackage);
		for (Class<?> c : directiveClasses) {
			String directiveName = StringUtils.uncapitalize(c.getSimpleName());
			directiveName = DIRECTIVE_PREFIX + directiveName.substring(0, directiveName.indexOf(DIRECTIVE_CUT_STRING));
			freemarkerVariables.put(directiveName, getWebApplicationContext().getBean(c));
			if (0 != directives.length())
				directives.append(",");
			directives.append(directiveName);
		}
		if (0 != directives.length())
			directives.append(",");
		directives.append(CONTEXT_NOCACHE);

		List<Class<?>> methodClasses = MyClassUtils.getAllAssignedClass(METHOD_BASE_CLASS, methodBasePackage);
		StringBuffer methods = new StringBuffer();
		for (Class<?> c : methodClasses) {
			String methodName = StringUtils.uncapitalize(c.getSimpleName());
			methodName = METHOD_PREFIX + methodName.substring(0, methodName.indexOf(METHOD_CUT_STRING));
			freemarkerVariables.put(methodName, getWebApplicationContext().getBean(c));
			if (0 != methods.length())
				methods.append(",");
			methods.append(methodName);
		}

		freemarkerVariables.put(CONTEXT_BASE, getServletContext().getContextPath());

		try {
			freeMarkerConfigurer.getConfiguration().setAllSharedVariables(
					new SimpleHash(freemarkerVariables, freeMarkerConfigurer.getConfiguration().getObjectWrapper()));
			logger.info((directiveClasses.size() + 1) + " directives created:[" + directives.toString() + "];"
					+ methodClasses.size() + " methods created:[" + methods.toString() + "]");
		} catch (TemplateModelException e) {
		}
	}

	/**
	 * @param directiveBasePackage
	 *            the directiveBasePackage to set
	 */
	public void setDirectiveBasePackage(String directiveBasePackage) {
		this.directiveBasePackage = directiveBasePackage;
	}

	/**
	 * @param methodBasePackage the methodBasePackage to set
	 */
	public void setMethodBasePackage(String methodBasePackage) {
		this.methodBasePackage = methodBasePackage;
	}
}
