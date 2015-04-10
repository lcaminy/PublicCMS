package com.sanluan.common.base;

import static com.sanluan.common.constants.CommonConstants.AJAX_SUFFIX;
import static com.sanluan.common.constants.CommonConstants.EMAIL_PATTERN;
import static com.sanluan.common.constants.CommonConstants.FORM_SUFFIX;
import static com.sanluan.common.constants.CommonConstants.MOBILE_PATTERN;
import static com.sanluan.common.constants.CommonConstants.NICKNAME_PATTERN;
import static com.sanluan.common.constants.CommonConstants.NUMBER_PATTERN;
import static com.sanluan.common.constants.CommonConstants.PATH_DELIMITER;
import static com.sanluan.common.constants.CommonConstants.REQUEST_SUFFIX;
import static com.sanluan.common.constants.CommonConstants.USERNAME_PATTERN;
import static org.springframework.web.servlet.view.UrlBasedViewResolver.FORWARD_URL_PREFIX;
import static org.springframework.web.servlet.view.UrlBasedViewResolver.REDIRECT_URL_PREFIX;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.ui.ModelMap;

import com.sanluan.entities.system.SystemUser;

/**
 * @author zhangxd
 * 
 */
public abstract class BaseController {
	protected static final String TEMPLATE_INDEX = "index";
	protected static final String MESSAGE = "message";
	protected static final String SUCCESS = "success";
	protected static final String ERROR = "error";
	protected static final String DELIMITER = PATH_DELIMITER;
	protected static final String REDIRECT = REDIRECT_URL_PREFIX;
	protected static final String FORWARD = FORWARD_URL_PREFIX;

	protected static final String PAGE_SUFFIX = REQUEST_SUFFIX;
	protected static final String DO_SUFFIX = FORM_SUFFIX;
	protected static final String JSON_SUFFIX = AJAX_SUFFIX;

	protected boolean virifyNotEmpty(String field, String value, ModelMap model) {
		if (StringUtils.isEmpty(value)) {
			model.addAttribute(ERROR, "verify.notEmpty." + field);
			return true;
		}
		return false;
	}
	
	protected boolean virifyCustom(String field, boolean value, ModelMap model) {
		if (value) {
			model.addAttribute(ERROR, "verify.custom." + field);
			return true;
		}
		return false;
	}

	protected boolean virifyNotEmpty(String field, Object value, ModelMap model) {
		if (null == value) {
			model.addAttribute(ERROR, "verify.notEmpty." + field);
			return true;
		}
		return false;
	}

	protected boolean virifyNotGreaterThen(String field, Integer value, int specific, ModelMap model) {
		if (null == value) {
			model.addAttribute(ERROR, "verify.notEmpty." + field);
			return true;
		} else if (value <= specific) {
			model.addAttribute(ERROR, "verify.notGreaterThen." + field);
			return true;
		}
		return false;
	}

	protected boolean virifyNotLongThen(String field, String value, int specific, ModelMap model) {
		if (null == value) {
			model.addAttribute(ERROR, "verify.notEmpty." + field);
			return true;
		} else if (value.length() > specific) {
			model.addAttribute(ERROR, "verify.notLongThen." + field);
			return true;
		}
		return false;
	}

	protected boolean virifyNotLessThen(String field, String value, int specific, ModelMap model) {
		if (null == value) {
			model.addAttribute(ERROR, "verify.notEmpty." + field);
			return true;
		} else if (value.length() < specific) {
			model.addAttribute(ERROR, "verify.notLessThen." + field);
			return true;
		}
		return false;
	}

	protected boolean virifyNotUserName(String field, String value, ModelMap model) {
		if (virifyNotUserName(value)) {
			model.addAttribute(ERROR, "verify.notUserName." + field);
			return true;
		}
		return false;
	}

	protected boolean virifyNotNickName(String field, String value, ModelMap model) {
		if (virifyNotNickName(value)) {
			model.addAttribute(ERROR, "verify.notNickName." + field);
			return true;
		}
		return false;
	}

	protected boolean virifyNotMobile(String field, String value, ModelMap model) {
		if (virifyNotMobile(value)) {
			model.addAttribute(ERROR, "verify.notMobile." + field);
			return true;
		}
		return false;
	}

	protected boolean virifyNotUserName(String value) {
		Pattern p = Pattern.compile(USERNAME_PATTERN);
		Matcher m = p.matcher(value);
		if (!m.matches()) {
			return true;
		}
		return false;
	}

	protected boolean virifyNotNickName(String value) {
		Pattern p = Pattern.compile(NICKNAME_PATTERN);
		Matcher m = p.matcher(value);
		if (!m.matches()) {
			return true;
		}
		return false;
	}
	
	protected boolean virifyNotMobile(String value) {
		Pattern p = Pattern.compile(MOBILE_PATTERN);
		Matcher m = p.matcher(value);
		if (!m.matches()) {
			return true;
		}
		return false;
	}

	protected boolean virifyNotEMail(String field, String value, ModelMap model) {
		if (virifyNotEMail(value)) {
			model.addAttribute(ERROR, "verify.notEmail." + field);
			return true;
		}
		return false;
	}

	protected boolean virifyNotEMail(String value) {
		Pattern p = Pattern.compile(EMAIL_PATTERN);
		Matcher m = p.matcher(value);
		if (!m.matches()) {
			return true;
		}
		return false;
	}

	protected boolean virifyNotNumber(String value) {
		Pattern p = Pattern.compile(NUMBER_PATTERN);
		Matcher m = p.matcher(value);
		if (!m.matches()) {
			return true;
		}
		return false;
	}

	protected boolean virifyNotEMailAndMobile(String field, String value, ModelMap model) {
		if (virifyNotEMail(value) && virifyNotMobile(value)) {
			model.addAttribute(ERROR, "verify.notEmailAndMobile." + field);
			return true;
		}
		return false;
	}

	protected boolean virifyNotExist(String field, Object value, ModelMap model) {
		if (null == value) {
			model.addAttribute(ERROR, "verify.notExist." + field);
			return true;
		}
		return false;
	}

	protected boolean virifyNotAdmin(SystemUser user, ModelMap model) {
		if (!user.isSuperuserAccess()) {
			model.addAttribute(ERROR, "verify.user.notAdmin");
			return true;
		}
		return false;
	}

	protected boolean virifyNotEnablie(SystemUser user, ModelMap model) {
		if (user.isDisable()) {
			model.addAttribute(ERROR, "verify.user.notEnablie");
			return true;
		}
		return false;
	}

	protected boolean virifyHasExist(String field, Object value, ModelMap model) {
		if (null != value) {
			model.addAttribute(ERROR, "verify.hasExist." + field);
			return true;
		}
		return false;
	}

	protected boolean virifyNotEquals(String field, String value1, String value2, ModelMap model) {
		if (null != value1 && !value1.equals(value2)) {
			model.addAttribute(ERROR, "verify.notEquals." + field);
			return true;
		}
		return false;
	}

	protected boolean virifyNotEquals(String field, Integer value1, Integer value2, ModelMap model) {
		if (null != value1 && !value1.equals(value2)) {
			model.addAttribute(ERROR, "verify.notEquals." + field);
			return true;
		}
		return false;
	}

	protected boolean virifyNotEquals(String field, SystemUser user, Integer value2, ModelMap model) {
		if (null != user && !user.getId().equals(value2)) {
			model.addAttribute(ERROR, "verify.notEquals." + field);
			return true;
		}
		return false;
	}
	
	protected boolean virifyEquals(String field, SystemUser user, Integer value2, ModelMap model) {
		if (null != user && user.getId().equals(value2)) {
			model.addAttribute(ERROR, "verify.notEquals." + field);
			return true;
		}
		return false;
	}
}
