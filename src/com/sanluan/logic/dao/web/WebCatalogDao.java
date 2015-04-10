package com.sanluan.logic.dao.web;

import org.springframework.stereotype.Repository;

import com.sanluan.common.base.BaseDao;
import com.sanluan.common.handler.PageHandler;
import com.sanluan.common.handler.QueryHandler;
import com.sanluan.entities.web.WebCatalog;

/**
 * @author zhangxd
 * 
 */
@Repository
public class WebCatalogDao extends BaseDao<WebCatalog> {
	public PageHandler getPage(Integer userId, String type, int pageNo, int pageSize) {
		QueryHandler queryMaker = getQueryMaker("from WebCatalog bean");
		if (notEmpty(userId)) {
			queryMaker.condition("bean.userId = :userId").setParameter("userId", userId);
		}
		if (notEmpty(type)) {
			queryMaker.condition("bean.type = :type").setParameter("type", type);
		}
		queryMaker.append("order by bean.id asc");
		return getPage(queryMaker, pageNo, pageSize);
	}

	@Override
	protected Class<WebCatalog> getEntityClass() {
		return WebCatalog.class;
	}

	@Override
	protected WebCatalog init(WebCatalog entity) {
		return entity;
	}

}
