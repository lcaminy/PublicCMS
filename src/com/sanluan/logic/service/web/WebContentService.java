package com.sanluan.logic.service.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanluan.common.base.BaseService;
import com.sanluan.common.handler.PageHandler;
import com.sanluan.entities.web.WebContent;
import com.sanluan.logic.dao.web.WebContentDao;

/**
 * @author zhangxd
 * 
 */
@Service
@Transactional
public class WebContentService extends BaseService<WebContent, WebContentDao> {

	@Autowired
	private WebContentDao dao;

	@Transactional(readOnly = true)
	public PageHandler getPage(Integer catalogId, Integer userId, Integer status, String title, Boolean showAll, int pageNo,
			int pageSize) {
		return dao.getPage(catalogId, userId, status, title, showAll, pageNo, pageSize);
	}

	@Override
	protected WebContentDao getDao() {
		return dao;
	}
}
