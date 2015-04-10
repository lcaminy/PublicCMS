package com.sanluan.logic.dao.web;

import org.springframework.stereotype.Repository;

import com.sanluan.common.base.BaseDao;
import com.sanluan.common.handler.PageHandler;
import com.sanluan.common.handler.QueryHandler;
import com.sanluan.entities.web.WebContent;

/**
 * @author zhangxd
 * 
 */
@Repository
public class WebContentDao extends BaseDao<WebContent> {
	public PageHandler getPage(Integer catalogId, Integer userId, Integer status, String title, Boolean showAll, int pageNo,
			int pageSize) {
		QueryHandler queryMaker = getQueryMaker("select new WebContent(id, catalogId, title, userId, status, published, realPublished) from WebContent bean");
		if (notEmpty(catalogId)) {
			queryMaker.condition("bean.catalogId = :catalogId").setParameter("catalogId", catalogId);
		}
		if (notEmpty(userId)) {
			queryMaker.condition("bean.userId = :userId").setParameter("userId", userId);
		}
		if (notEmpty(status)) {
			queryMaker.condition("bean.status = :status").setParameter("status", status);
		}
		if (notEmpty(title)) {
			queryMaker.condition("bean.title like :title").setParameter("title", like(title));
		}
		if (notEmpty(showAll) && showAll) {
			queryMaker.append("order by bean.realPublished desc");
		} else {
			queryMaker.condition("bean.published <= :now").setParameter("now", getDate());
			queryMaker.append("order by bean.published desc");
		}
		return getPage(queryMaker, pageNo, pageSize);
	}

	@Override
	protected Class<WebContent> getEntityClass() {
		return WebContent.class;
	}

	@Override
	protected WebContent init(WebContent entity) {
		if (!notEmpty(entity.getPublished())) {
			entity.setPublished(getDate());
		}
		if (!notEmpty(entity.getRealPublished())) {
			entity.setRealPublished(getDate());
		}
		return entity;
	}

}
