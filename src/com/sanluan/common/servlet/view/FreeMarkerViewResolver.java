package com.sanluan.common.servlet.view;

import org.springframework.web.servlet.view.AbstractTemplateViewResolver;

/**
 * @author zhangxd
 *
 */
public class FreeMarkerViewResolver extends AbstractTemplateViewResolver {
	public FreeMarkerViewResolver() {
		setViewClass(InitializeFreeMarkerView.class);
	}
}