package com.sanluan.cms.logic.service.cms;

// Generated 2015-5-6 16:53:26 by SourceMaker

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanluan.cms.entities.cms.CmsBlockData;
import com.sanluan.cms.logic.dao.cms.CmsBlockDataDao;
import com.sanluan.common.base.BaseService;
import com.sanluan.common.handler.PageHandler;

@Service
@Transactional
public class CmsBlockDataService extends BaseService<CmsBlockData, CmsBlockDataDao> {

	@Autowired
	private CmsBlockDataDao dao;

	@Transactional(readOnly = true)
	public PageHandler getPage(Integer blockId, Date startCreateDate, Date endCreateDate, Integer isDisable, int pageNo, int pageSize) {
		return dao.getPage(blockId, startCreateDate, endCreateDate, isDisable, pageNo, pageSize);
	}

	@Override
	protected CmsBlockDataDao getDao() {
		return dao;
	}
}