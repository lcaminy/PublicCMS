package com.sanluan.logic.dao.system;

import java.util.Date;

import org.springframework.stereotype.Repository;

import com.sanluan.common.base.BaseDao;
import com.sanluan.common.handler.PageHandler;
import com.sanluan.common.handler.QueryHandler;
import com.sanluan.entities.system.SystemTicket;

/**
 * @author zhangxd
 * 
 */
@Repository
public class SystemTicketDao extends BaseDao<SystemTicket> {
	public PageHandler getPage(Integer userId, Date startCreateDate, Date endCreateDate, int pageNo, int pageSize) {
		QueryHandler queryMaker = getQueryMaker("from SystemTicket bean");
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
	
	public SystemTicket findByCode(String code) {
		QueryHandler queryMaker = getQueryMaker("from SystemTicket bean where bean.code = :code").setParameter("code", code);
		return getEntity(queryMaker);
	}

	@Override
	public SystemTicket init(SystemTicket entity) {
		if (!notEmpty(entity.getCreateDate())) {
			entity.setCreateDate(getDate());
		}
		if (0 == entity.getRemainder()) {
			entity.setRemainder(entity.getCount());
		}
		return entity;
	}

	@Override
	protected Class<SystemTicket> getEntityClass() {
		return SystemTicket.class;
	}
}
