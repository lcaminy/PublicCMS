package com.sanluan.logic.service.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanluan.common.base.BaseService;
import com.sanluan.common.handler.PageHandler;
import com.sanluan.entities.web.WebPage;
import com.sanluan.logic.dao.web.WebPageDao;

/**
 * @author zhangxd
 * 
 */
@Service
@Transactional
public class WebPageService extends BaseService<WebPage, WebPageDao> {

	@Autowired
	private WebPageDao dao;

	@Transactional(readOnly = true)
	public PageHandler getPage(Integer userId, String name, int pageNo, int pageSize) {
		return dao.getPage( userId, name, pageNo, pageSize);
	}

	public WebPage getEntityByUserPageId(int userPageId) {
		return dao.getEntityByUserPageId(userPageId);
	}
	
	@Override
	protected WebPageDao getDao() {
		return dao;
	}
}
