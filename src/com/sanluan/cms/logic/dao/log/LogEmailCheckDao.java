package com.sanluan.cms.logic.dao.log;

import java.util.Date;

import org.springframework.stereotype.Repository;

import com.sanluan.cms.entities.log.LogEmailCheck;
import com.sanluan.common.base.BaseDao;
import com.sanluan.common.handler.PageHandler;
import com.sanluan.common.handler.QueryHandler;

/**
 * @author zhangxd
 * 
 */
@Repository
public class LogEmailCheckDao extends BaseDao<LogEmailCheck> {
	public PageHandler getPage(Integer userId, Boolean checked, Date startCreateDate, Date endCreateDate, int pageNo, int pageSize) {
		QueryHandler queryMaker = getQueryMaker("from LogEmailCheck bean");
		if (notEmpty(userId)) {
			queryMaker.condition("bean.userId = :userId").setParameter("userId", userId);
		}
		if (notEmpty(checked)) {
			queryMaker.condition("bean.checked = :checked").setParameter("checked", checked);
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

	public LogEmailCheck findByCode(String code) {
		QueryHandler queryMaker = getQueryMaker("from LogEmailCheck bean where bean.code = :code and bean.checked = :checked")
				.setParameter("code", code).setParameter("checked", false);
		return getEntity(queryMaker);
	}

	@Override
	protected LogEmailCheck init(LogEmailCheck entity) {
		if (!notEmpty(entity.getCreateDate())) {
			entity.setCreateDate(getDate());
		}
		return entity;
	}

	@Override
	protected Class<LogEmailCheck> getEntityClass() {
		return LogEmailCheck.class;
	}

}
