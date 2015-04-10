package com.sanluan.logic.dao.log;

import java.util.Date;

import org.springframework.stereotype.Repository;

import com.sanluan.common.base.BaseDao;
import com.sanluan.common.handler.PageHandler;
import com.sanluan.common.handler.QueryHandler;
import com.sanluan.entities.log.LogLogin;

/**
 * @author zhangxd
 * 
 */
@Repository
public class LogLoginDao extends BaseDao<LogLogin> {
	public PageHandler getPage(Integer userId, Boolean result, String name, String ip, Date startCreateDate, Date endCreateDate,
			int pageNo, int pageSize) {
		QueryHandler queryMaker = getQueryMaker("from LogLogin bean");
		if (notEmpty(userId)) {
			queryMaker.condition("bean.userId = :userId").setParameter("userId", userId);
		}
		if (notEmpty(result)) {
			queryMaker.condition("bean.result = :result").setParameter("result", result);
		}
		if (notEmpty(startCreateDate)) {
			queryMaker.condition("bean.createDate >= :startCreateDate").setParameter("startCreateDate", startCreateDate);
		}
		if (notEmpty(endCreateDate)) {
			queryMaker.condition("bean.createDate < :endCreateDate").setParameter("endCreateDate", endCreateDate);
		}
		if (notEmpty(name)) {
			queryMaker.condition("bean.name like:name").setParameter("name", like(name));
		}
		if (notEmpty(ip)) {
			queryMaker.condition("bean.ip like :ip").setParameter("ip", like(ip));
		}
		queryMaker.append("order by bean.createDate desc");
		return getPage(queryMaker, pageNo, pageSize);
	}

	@Override
	protected LogLogin init(LogLogin entity) {
		if (!notEmpty(entity.getCreateDate())) {
			entity.setCreateDate(getDate());
		}
		return entity;
	}

	@Override
	protected Class<LogLogin> getEntityClass() {
		return LogLogin.class;
	}

}
