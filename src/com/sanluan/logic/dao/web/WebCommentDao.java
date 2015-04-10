package com.sanluan.logic.dao.web;

import org.springframework.stereotype.Repository;

import com.sanluan.common.base.BaseDao;
import com.sanluan.common.handler.PageHandler;
import com.sanluan.common.handler.QueryHandler;
import com.sanluan.entities.web.WebComment;

/**
 * @author zhangxd
 * 
 */
@Repository
public class WebCommentDao extends BaseDao<WebComment> {
	public PageHandler getPage(String type, Integer itemId, Integer userId, int pageNo, int pageSize) {
		QueryHandler queryMaker = getQueryMaker("select new WebComment(id, itemId, title, userId, status, published, realPublished, url, cover) from WebComment bean");
		if (notEmpty(type)) {
			queryMaker.condition("bean.type = :type").setParameter("type", type);
		}
		if (notEmpty(itemId)) {
			queryMaker.condition("bean.itemId = :itemId").setParameter("itemId", itemId);
		}
		if (notEmpty(userId)) {
			queryMaker.condition("bean.userId = :userId").setParameter("userId", userId);
		}
		return getPage(queryMaker, pageNo, pageSize);
	}

	@Override
	protected Class<WebComment> getEntityClass() {
		return WebComment.class;
	}

	@Override
	protected WebComment init(WebComment entity) {
		if (!notEmpty(entity.getCreateDate())) {
			entity.setCreateDate(getDate());
		}
		return entity;
	}

}
