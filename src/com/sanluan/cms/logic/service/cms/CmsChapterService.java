package com.sanluan.cms.logic.service.cms;

// Generated 2015-5-6 16:53:26 by SourceMaker


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanluan.cms.entities.cms.CmsChapter;
import com.sanluan.cms.logic.dao.cms.CmsChapterDao;
import com.sanluan.common.base.BaseService;
import com.sanluan.common.handler.PageHandler;

@Service
@Transactional
public class CmsChapterService extends BaseService<CmsChapter, CmsChapterDao> {

	@Autowired
	private CmsChapterDao dao;

	@Transactional(readOnly = true)
	public PageHandler getPage(Integer extendNumber3, Integer extendNumber4, String extend1, String extend3, String image, String extend2, String extend4, Integer contentId, Integer parentId, String title, String description, Integer extendNumber2, Integer extendNumber1, int pageNo, int pageSize) {
		return dao.getPage(extendNumber3, extendNumber4, extend1, extend3, image, extend2, extend4, contentId, parentId, title, description, extendNumber2, extendNumber1, pageNo, pageSize);
	}

	@Override
	protected CmsChapterDao getDao() {
		return dao;
	}
}