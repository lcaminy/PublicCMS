package com.sanluan.cms.logic.service.cms;

// Generated 2015-5-8 16:50:23 by SourceMaker


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanluan.cms.entities.cms.CmsModel;
import com.sanluan.cms.logic.dao.cms.CmsModelDao;
import com.sanluan.common.base.BaseService;
import com.sanluan.common.handler.PageHandler;

@Service
@Transactional
public class CmsModelService extends BaseService<CmsModel, CmsModelDao> {

	@Autowired
	private CmsModelDao dao;

	@Transactional(readOnly = true)
	public PageHandler getPage(Boolean isDisable, int pageNo, int pageSize) {
		return dao.getPage(isDisable, pageNo, pageSize);
	}

	@Override
	protected CmsModelDao getDao() {
		return dao;
	}
}