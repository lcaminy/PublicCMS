package com.sanluan.logic.service.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanluan.common.base.BaseService;
import com.sanluan.common.handler.PageHandler;
import com.sanluan.entities.web.WebCatalog;
import com.sanluan.logic.dao.web.WebCatalogDao;

/**
 * @author zhangxd
 * 
 */
@Service
@Transactional
public class WebCatalogService extends BaseService<WebCatalog, WebCatalogDao> {

	@Autowired
	private WebCatalogDao dao;

	@Transactional(readOnly = true)
	public PageHandler getPage(Integer userId, String type, int pageNo, int pageSize) {
		return dao.getPage(userId, type, pageNo, pageSize);
	}

	@Override
	protected WebCatalogDao getDao() {
		return dao;
	}
}
