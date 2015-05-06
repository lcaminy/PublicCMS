package com.sanluan.cms.logic.dao.cms;

// Generated 2015-5-6 16:53:26 by SourceMaker


import org.springframework.stereotype.Repository;

import com.sanluan.cms.entities.cms.CmsSite;
import com.sanluan.common.base.BaseDao;
import com.sanluan.common.handler.PageHandler;
import com.sanluan.common.handler.QueryHandler;

@Repository
public class CmsSiteDao extends BaseDao<CmsSite> {
	public PageHandler getPage(Boolean isDisable, int pageNo, int pageSize) {
		QueryHandler queryMaker = getQueryMaker("from CmsSite bean");
		if (notEmpty(isDisable)) {
			queryMaker.condition("bean.isDisable = :isDisable").setParameter("isDisable", isDisable);
		}
		queryMaker.append("order by bean.id desc");
		return getPage(queryMaker, pageNo, pageSize);
	}

	@Override
	protected CmsSite init(CmsSite entity) {
		return entity;
	}

	@Override
	protected Class<CmsSite> getEntityClass() {
		return CmsSite.class;
	}

}