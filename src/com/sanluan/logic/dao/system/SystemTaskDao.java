package com.sanluan.logic.dao.system;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Repository;

import com.sanluan.common.base.BaseDao;
import com.sanluan.common.handler.PageHandler;
import com.sanluan.common.handler.QueryHandler;
import com.sanluan.entities.system.SystemTask;

/**
 * @author zhangxd
 * 
 */
@Repository
public class SystemTaskDao extends BaseDao<SystemTask> {
	public PageHandler getPage(Integer userId, String status, Date startCreateDate, Date endCreateDate, Date startTimeoutDate,
			Date endTimeoutDate, int pageNo, int pageSize) {
		QueryHandler queryMaker = getQueryMaker("from SystemTask bean");
		if (notEmpty(userId)) {
			queryMaker.condition("bean.userId = :userId").setParameter("userId", userId);
		}
		if (notEmpty(userId)) {
			queryMaker.condition("bean.userId = :userId").setParameter("userId", userId);
		}
		if (notEmpty(startCreateDate)) {
			queryMaker.condition("bean.createDate >= :startCreateDate").setParameter("startCreateDate", startCreateDate);
		}
		if (notEmpty(endCreateDate)) {
			queryMaker.condition("bean.createDate < :endCreateDate").setParameter("endCreateDate",
					DateUtils.addDays(endCreateDate, 1));
		}
		if (notEmpty(startTimeoutDate)) {
			queryMaker.condition("bean.timeoutDate >= :startTimeoutDate").setParameter("startTimeoutDate", startTimeoutDate);
		}
		if (notEmpty(endTimeoutDate)) {
			queryMaker.condition("bean.timeoutDate < :endTimeoutDate").setParameter("endTimeoutDate",
					DateUtils.addDays(endTimeoutDate, 1));
		}
		queryMaker.append("order by bean.createDate desc");
		return getPage(queryMaker, pageNo, pageSize);
	}

	@Override
	protected Class<SystemTask> getEntityClass() {
		return SystemTask.class;
	}

	@Override
	protected SystemTask init(SystemTask entity) {
		return entity;
	}

}
