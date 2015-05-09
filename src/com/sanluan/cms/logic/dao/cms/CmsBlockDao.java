package com.sanluan.cms.logic.dao.cms;

// Generated 2015-5-8 16:50:22 by SourceMaker


import org.springframework.stereotype.Repository;

import com.sanluan.cms.entities.cms.CmsBlock;
import com.sanluan.common.base.BaseDao;
import com.sanluan.common.handler.PageHandler;
import com.sanluan.common.handler.QueryHandler;

@Repository
public class CmsBlockDao extends BaseDao<CmsBlock> {
	public PageHandler getPage(Integer pageId, Integer categoryId, Integer type, int pageNo, int pageSize) {
		QueryHandler queryMaker = getQueryMaker("from CmsBlock bean");
		if (notEmpty(pageId)) {
			queryMaker.condition("bean.pageId = :pageId").setParameter("pageId", pageId);
		}
		if (notEmpty(categoryId)) {
			queryMaker.condition("bean.categoryId = :categoryId").setParameter("categoryId", categoryId);
		}
		if (notEmpty(type)) {
			queryMaker.condition("bean.type = :type").setParameter("type", type);
		}
		queryMaker.append("order by bean.id desc");
		return getPage(queryMaker, pageNo, pageSize);
	}

	@Override
	protected CmsBlock init(CmsBlock entity) {
		return entity;
	}

	@Override
	protected Class<CmsBlock> getEntityClass() {
		return CmsBlock.class;
	}

}