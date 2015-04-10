package com.sanluan.logic.dao.system;

import java.util.Date;

import org.springframework.stereotype.Repository;

import com.sanluan.common.base.BaseDao;
import com.sanluan.common.handler.PageHandler;
import com.sanluan.common.handler.QueryHandler;
import com.sanluan.entities.system.SystemGuestBook;

/**
 * @author zhangxd
 * 
 */
@Repository
public class SystemGuestBookDao extends BaseDao<SystemGuestBook> {
	public PageHandler getPage(Integer userId, String userName, Date startCreateDate, Date endCreateDate, int pageNo, int pageSize) {
		QueryHandler queryMaker = getQueryMaker("from SystemGuestBook bean");
		if (notEmpty(userId)) {
			queryMaker.condition("bean.userId = :userId").setParameter("userId", userId);
		}
		if (notEmpty(userName)) {
			queryMaker.condition("bean.userName = :userName").setParameter("userName", userName);
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
	public SystemGuestBook init(SystemGuestBook entity) {
		if (!notEmpty(entity.getCreateDate())) {
			entity.setCreateDate(getDate());
		}
		return entity;
	}

	@Override
	protected Class<SystemGuestBook> getEntityClass() {
		return SystemGuestBook.class;
	}
}
