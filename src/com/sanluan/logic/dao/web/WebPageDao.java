package com.sanluan.logic.dao.web;

import org.springframework.stereotype.Repository;

import com.sanluan.common.base.BaseDao;
import com.sanluan.common.handler.PageHandler;
import com.sanluan.common.handler.QueryHandler;
import com.sanluan.entities.web.WebPage;

/**
 * @author zhangxd
 * 
 */
@Repository
public class WebPageDao extends BaseDao<WebPage> {
	public PageHandler getPage(Integer userId, String name, int pageNo, int pageSize) {
		QueryHandler queryMaker = getQueryMaker("select new WebPage(id, userPageId, name, userId, createDate) from WebPage bean");
		if (notEmpty(userId)) {
			queryMaker.condition("bean.userId = :userId").setParameter("userId", userId);
		}
		if (notEmpty(name)) {
			queryMaker.condition("bean.name like :name").setParameter("name", like(name));
		}
		queryMaker.append("order by bean.createDate desc");
		return getPage(queryMaker, pageNo, pageSize);
	}

	public WebPage getEntityByUserPageId(int userPageId) {
		QueryHandler queryMaker = getQueryMaker("from WebPage bean");
		queryMaker.condition("bean.userPageId = :userPageId").setParameter("userPageId", userPageId);
		return getEntity(queryMaker);
	}

	@Override
	protected Class<WebPage> getEntityClass() {
		return WebPage.class;
	}

	@Override
	protected WebPage init(WebPage entity) {
		if (!notEmpty(entity.getCreateDate())) {
			entity.setCreateDate(getDate());
		}
		return entity;
	}

}
