package com.sanluan.logic.dao.web;

import org.springframework.stereotype.Repository;

import com.sanluan.common.base.BaseDao;
import com.sanluan.common.handler.PageHandler;
import com.sanluan.common.handler.QueryHandler;
import com.sanluan.entities.web.WebRss;

/**
 * @author zhangxd
 * 
 */
@Repository
public class WebRssDao extends BaseDao<WebRss> {
	public PageHandler getPage(String name, Integer parentId, Boolean tree, int pageNo, int pageSize) {
		QueryHandler queryMaker = getQueryMaker("from WebRss bean");
		if (notEmpty(parentId)) {
			queryMaker.condition("bean.parentId = :parentId").setParameter("parentId", parentId);
		} else if (notEmpty(tree) && tree) {
			queryMaker.condition("bean.parentId is null");
		}
		
		if (notEmpty(name)) {
			queryMaker.condition("bean.name like :name").setParameter("name", like(name));
		}
		queryMaker.condition("bean.enable = :enable").setParameter("enable", true);
		queryMaker.append("order by bean.createDate desc");
		return getPage(queryMaker, pageNo, pageSize);
	}

	@Override
	protected Class<WebRss> getEntityClass() {
		return WebRss.class;
	}

	@Override
	protected WebRss init(WebRss entity) {
		if (!notEmpty(entity.getCreateDate())) {
			entity.setCreateDate(getDate());
		}
		return entity;
	}

}
