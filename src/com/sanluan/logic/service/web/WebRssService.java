package com.sanluan.logic.service.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanluan.common.base.BaseService;
import com.sanluan.common.handler.PageHandler;
import com.sanluan.entities.web.WebRss;
import com.sanluan.logic.dao.web.WebRssDao;

/**
 * @author zhangxd
 * 
 */
@Service
@Transactional
public class WebRssService extends BaseService<WebRss, WebRssDao> {

	@Autowired
	private WebRssDao dao;

	@Transactional(readOnly = true)
	public PageHandler getPage(String name, Integer parentId, Boolean tree, int pageNo, int pageSize) {
		return dao.getPage(name, parentId, tree, pageNo, pageSize);
	}

	public void disable(Integer id) {
		WebRss page = dao.getEntity(id);
		if (null != page) {
			page.setEnable(false);
		}
	}

	@Override
	protected WebRssDao getDao() {
		return dao;
	}
}
