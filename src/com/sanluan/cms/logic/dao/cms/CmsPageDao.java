package com.sanluan.cms.logic.dao.cms;

// Generated 2015-5-8 16:50:23 by SourceMaker


import org.springframework.stereotype.Repository;

import com.sanluan.cms.entities.cms.CmsPage;
import com.sanluan.common.base.BaseDao;
import com.sanluan.common.handler.PageHandler;
import com.sanluan.common.handler.QueryHandler;

@Repository
public class CmsPageDao extends BaseDao<CmsPage> {
	public PageHandler getPage(Integer parentId, Integer siteId, int pageNo, int pageSize) {
		QueryHandler queryMaker = getQueryMaker("from CmsPage bean");
		if (notEmpty(parentId)) {
			queryMaker.condition("bean.parentId = :parentId").setParameter("parentId", parentId);
		}
		if (notEmpty(siteId)) {
			queryMaker.condition("bean.siteId = :siteId").setParameter("siteId", siteId);
		}
		queryMaker.append("order by bean.id desc");
		return getPage(queryMaker, pageNo, pageSize);
	}

	@Override
	protected CmsPage init(CmsPage entity) {
		return entity;
	}

	@Override
	protected Class<CmsPage> getEntityClass() {
		return CmsPage.class;
	}

}