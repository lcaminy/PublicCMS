package com.sanluan.logic.dao.log;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Repository;

import com.sanluan.common.base.BaseDao;
import com.sanluan.common.handler.PageHandler;
import com.sanluan.common.handler.QueryHandler;
import com.sanluan.entities.log.LogOperate;

/**
 * @author zhangxd
 * 
 */
@Repository
public class LogOperateDao extends BaseDao<LogOperate> {
	public PageHandler getPage(Integer userId, String operate, String content, Date startCreateDate, Date endCreateDate,
			int pageNo, int pageSize) {
		QueryHandler queryMaker = getQueryMaker("from LogOperate bean");
		if (notEmpty(userId)) {
			queryMaker.condition("bean.userId = :userId").setParameter("userId", userId);
		}
		if (notEmpty(operate)) {
			queryMaker.condition("bean.operate = :operate").setParameter("operate", operate);
		}
		if (notEmpty(startCreateDate)) {
			queryMaker.condition("bean.createDate >= :startCreateDate").setParameter("startCreateDate", startCreateDate);
		}
		if (notEmpty(endCreateDate)) {
			queryMaker.condition("bean.createDate < :endCreateDate").setParameter("endCreateDate",
					DateUtils.addDays(endCreateDate, 1));
		}
		if (notEmpty(content)) {
			queryMaker.condition("bean.content like :content").setParameter("content", like(content));
		}
		queryMaker.append("order by bean.createDate desc");
		return getPage(queryMaker, pageNo, pageSize);
	}

	@Override
	protected Class<LogOperate> getEntityClass() {
		return LogOperate.class;
	}

	@Override
	protected LogOperate init(LogOperate entity) {
		return entity;
	}

}
