package com.sanluan.cms.logic.service.cms;

// Generated 2015-5-8 16:50:23 by SourceMaker


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanluan.cms.entities.cms.CmsPage;
import com.sanluan.cms.logic.dao.cms.CmsPageDao;
import com.sanluan.common.base.BaseService;
import com.sanluan.common.handler.PageHandler;

@Service
@Transactional
public class CmsPageService extends BaseService<CmsPage, CmsPageDao> {

	@Autowired
	private CmsPageDao dao;

	@Transactional(readOnly = true)
	public PageHandler getPage(Integer parentId, Integer siteId, int pageNo, int pageSize) {
		return dao.getPage(parentId, siteId, pageNo, pageSize);
	}

	@Override
	protected CmsPageDao getDao() {
		return dao;
	}
}