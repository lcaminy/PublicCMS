package com.sanluan.logic.dao.system;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Repository;

import com.sanluan.common.base.BaseDao;
import com.sanluan.common.handler.PageHandler;
import com.sanluan.common.handler.QueryHandler;
import com.sanluan.entities.system.SystemMessage;

/**
 * @author zhangxd
 * 
 */
@Repository
public class SystemMessageDao extends BaseDao<SystemMessage> {
	public PageHandler getPage(Integer userId, String from, Date startCreateDate, Date endCreateDate, int pageNo, int pageSize) {
		QueryHandler queryMaker = getQueryMaker("from SystemMessage bean");
		if (notEmpty(userId)) {
			queryMaker.condition("bean.userId = :userId").setParameter("userId", userId);
		}
		if (notEmpty(from)) {
			queryMaker.condition("bean.from = :from").setParameter("from", from);
		}
		if (notEmpty(startCreateDate)) {
			queryMaker.condition("bean.createDate >= :startCreateDate").setParameter("startCreateDate", startCreateDate);
		}
		if (notEmpty(endCreateDate)) {
			queryMaker.condition("bean.createDate < :endCreateDate").setParameter("endCreateDate",
					DateUtils.addDays(endCreateDate, 1));
		}
		queryMaker.append("order by bean.createDate desc");
		return getPage(queryMaker, pageNo, pageSize);
	}

	@Override
	protected Class<SystemMessage> getEntityClass() {
		return SystemMessage.class;
	}

	@Override
	protected SystemMessage init(SystemMessage entity) {
		return entity;
	}
}
