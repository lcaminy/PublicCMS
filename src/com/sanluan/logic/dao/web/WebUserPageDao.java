package com.sanluan.logic.dao.web;

import org.springframework.stereotype.Repository;

import com.sanluan.common.base.BaseDao;
import com.sanluan.common.handler.PageHandler;
import com.sanluan.common.handler.QueryHandler;
import com.sanluan.entities.web.WebUserPage;

/**
 * @author zhangxd
 * 
 */
@Repository
public class WebUserPageDao extends BaseDao<WebUserPage> {
	public PageHandler getPage(Integer userId, String name, Boolean published, int pageNo, int pageSize) {
		QueryHandler queryMaker = getQueryMaker("select new WebUserPage(id,name,lastUpdateDate,userId,published,createDate) from WebUserPage bean");
		if (notEmpty(userId)) {
			queryMaker.condition("bean.userId = :userId").setParameter("userId", userId);
		}
		if (notEmpty(published)) {
			queryMaker.condition("bean.published = :published").setParameter("published", published);
		}
		if (notEmpty(name)) {
			queryMaker.condition("bean.name like :name").setParameter("name", like(name));
		}
		queryMaker.append("order by bean.createDate desc");
		return getPage(queryMaker, pageNo, pageSize);
	}

	@Override
	protected Class<WebUserPage> getEntityClass() {
		return WebUserPage.class;
	}

	@Override
	protected WebUserPage init(WebUserPage entity) {
		if (!notEmpty(entity.getCreateDate())) {
			entity.setCreateDate(getDate());
		}
		return entity;
	}

}
