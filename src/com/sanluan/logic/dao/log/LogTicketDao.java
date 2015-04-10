package com.sanluan.logic.dao.log;

import java.util.Date;

import org.springframework.stereotype.Repository;

import com.sanluan.common.base.BaseDao;
import com.sanluan.common.handler.PageHandler;
import com.sanluan.common.handler.QueryHandler;
import com.sanluan.entities.log.LogTicket;

/**
 * @author zhangxd
 * 
 */
@Repository
public class LogTicketDao extends BaseDao<LogTicket> {
	public PageHandler getPage(Integer ticketId, Integer userId, Date startCreateDate, Date endCreateDate,
			int pageNo, int pageSize) {
		QueryHandler queryMaker = getQueryMaker("from LogTicket bean");
		if (notEmpty(ticketId)) {
			queryMaker.condition("bean.ticketId = :ticketId").setParameter("ticketId", ticketId);
		}
		if (notEmpty(userId)) {
			queryMaker.condition("bean.userId = :userId").setParameter("userId", userId);
		}
		if (notEmpty(startCreateDate)) {
			queryMaker.condition("bean.createDate >= :startCreateDate").setParameter("startCreateDate", startCreateDate);
		}
		if (notEmpty(endCreateDate)) {
			queryMaker.condition("bean.createDate < :endCreateDate").setParameter("endCreateDate", endCreateDate);
		}
		queryMaker.append("order by bean.createDate desc");
		return getPage(queryMaker, pageNo, pageSize);
	}

	@Override
	protected LogTicket init(LogTicket entity) {
		if (!notEmpty(entity.getCreateDate())) {
			entity.setCreateDate(getDate());
		}
		return entity;
	}

	@Override
	protected Class<LogTicket> getEntityClass() {
		return LogTicket.class;
	}

}
