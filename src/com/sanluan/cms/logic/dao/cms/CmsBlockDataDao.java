package com.sanluan.cms.logic.dao.cms;

// Generated 2015-5-8 16:50:23 by SourceMaker

import java.util.Date;

import org.springframework.stereotype.Repository;

import com.sanluan.cms.entities.cms.CmsBlockData;
import com.sanluan.common.base.BaseDao;
import com.sanluan.common.handler.PageHandler;
import com.sanluan.common.handler.QueryHandler;

@Repository
public class CmsBlockDataDao extends BaseDao<CmsBlockData> {
	public PageHandler getPage(Integer blockId, Date startCreateDate, Date endCreateDate, Integer isDisable, int pageNo, int pageSize) {
		QueryHandler queryMaker = getQueryMaker("from CmsBlockData bean");
		if (notEmpty(blockId)) {
			queryMaker.condition("bean.blockId = :blockId").setParameter("blockId", blockId);
		}
		if (notEmpty(startCreateDate)) {
			queryMaker.condition("bean.createDate >= :startCreateDate").setParameter("startCreateDate", startCreateDate);
		}
		if (notEmpty(endCreateDate)) {
			queryMaker.condition("bean.createDate < :endCreateDate").setParameter("endCreateDate", tomorrow(endCreateDate));
		}
		if (notEmpty(isDisable)) {
			queryMaker.condition("bean.isDisable = :isDisable").setParameter("isDisable", isDisable);
		}
		queryMaker.append("order by bean.id desc");
		return getPage(queryMaker, pageNo, pageSize);
	}

	@Override
	protected CmsBlockData init(CmsBlockData entity) {
		return entity;
	}

	@Override
	protected Class<CmsBlockData> getEntityClass() {
		return CmsBlockData.class;
	}

}