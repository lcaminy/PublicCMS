package com.sanluan.logic.dao.log;

import java.util.Date;

import org.springframework.stereotype.Repository;

import com.sanluan.common.base.BaseDao;
import com.sanluan.common.handler.PageHandler;
import com.sanluan.common.handler.QueryHandler;
import com.sanluan.entities.log.LogPassword;

/**
 * @author zhangxd
 * 
 */
@Repository
public class LogPasswordDao extends BaseDao<LogPassword> {
	public PageHandler getPage(Integer userId, String ip, Date startCreateDate, Date endCreateDate, int pageNo, int pageSize) {
		QueryHandler queryMaker = getQueryMaker("from LogPassword bean");
		if (notEmpty(userId)) {
			queryMaker.condition("bean.userId = :userId").setParameter("userId", userId);
		}
		if (notEmpty(startCreateDate)) {
			queryMaker.condition("bean.createDate >= :startCreateDate").setParameter("startCreateDate", startCreateDate);
		}
		if (notEmpty(endCreateDate)) {
			queryMaker.condition("bean.createDate < :endCreateDate").setParameter("endCreateDate", endCreateDate);
		}
		if (notEmpty(ip)) {
			queryMaker.condition("bean.ip like :ip").setParameter("ip", like(ip));
		}
		queryMaker.append("order by bean.createDate desc");
		return getPage(queryMaker, pageNo, pageSize);
	}

	@Override
	protected LogPassword init(LogPassword entity) {
		if (!notEmpty(entity.getCreateDate())) {
			entity.setCreateDate(getDate());
		}
		return entity;
	}

	@Override
	protected Class<LogPassword> getEntityClass() {
		return LogPassword.class;
	}

}
