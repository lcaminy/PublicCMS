package com.sanluan.cms.logic.service.cms;

// Generated 2015-5-6 16:53:26 by SourceMaker


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanluan.cms.entities.cms.CmsBlock;
import com.sanluan.cms.logic.dao.cms.CmsBlockDao;
import com.sanluan.common.base.BaseService;
import com.sanluan.common.handler.PageHandler;

@Service
@Transactional
public class CmsBlockService extends BaseService<CmsBlock, CmsBlockDao> {

	@Autowired
	private CmsBlockDao dao;

	@Transactional(readOnly = true)
	public PageHandler getPage(Integer pageId, Integer categoryId, Integer type, int pageNo, int pageSize) {
		return dao.getPage(pageId, categoryId, type, pageNo, pageSize);
	}

	@Override
	protected CmsBlockDao getDao() {
		return dao;
	}
}