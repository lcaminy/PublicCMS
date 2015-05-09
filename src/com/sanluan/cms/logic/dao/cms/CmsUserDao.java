package com.sanluan.cms.logic.dao.cms;

// Generated 2015-5-8 16:50:23 by SourceMaker


import org.springframework.stereotype.Repository;

import com.sanluan.cms.entities.cms.CmsUser;
import com.sanluan.common.base.BaseDao;
import com.sanluan.common.handler.PageHandler;
import com.sanluan.common.handler.QueryHandler;

@Repository
public class CmsUserDao extends BaseDao<CmsUser> {
	public PageHandler getPage(int pageNo, int pageSize) {
		QueryHandler queryMaker = getQueryMaker("from CmsUser bean");
		queryMaker.append("order by bean.id desc");
		return getPage(queryMaker, pageNo, pageSize);
	}

	@Override
	protected CmsUser init(CmsUser entity) {
		return entity;
	}

	@Override
	protected Class<CmsUser> getEntityClass() {
		return CmsUser.class;
	}

}