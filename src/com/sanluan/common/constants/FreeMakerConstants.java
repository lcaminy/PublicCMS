package com.sanluan.common.constants;

import static com.sanluan.common.constants.CommonConstants.REQUEST_SUFFIX;

import com.sanluan.common.base.BaseDirective;
import com.sanluan.common.base.BaseMethod;

/**
 * @author zhangxd
 * 
 */
public class FreeMakerConstants {
	public static final String TEMPLATE_BASE_PREFIX = "/WEB-INF/template/";
	public static final String TEMPLATE_INDEX_PREFIX = "web/";
	public static final String TEMPLATE_SUFFIX = REQUEST_SUFFIX;

	public static final String CONTEXT_BASE = "base";
	public static final String CONTEXT_NOCACHE = "nocache";
	public static final String CONTEXT_INCLUDE = "include_page";
	public static final String CACHE_VAR = "cache";

	public static final String TAG_PREFIX = "t_";
	public static final String DIRECTIVE_PREFIX = "d_";
	public static final String METHOD_PREFIX = "m_";

	public static final Class<BaseDirective> DIRECTIVE_BASE_CLASS = BaseDirective.class;
	public static final String DIRECTIVE_CUT_STRING = "Directive";

	public static final Class<BaseMethod> METHOD_BASE_CLASS = BaseMethod.class;
	public static final String METHOD_CUT_STRING = "Method";
}
