package com.sanluan.logic.dao.system;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Repository;

import com.sanluan.common.base.BaseDao;
import com.sanluan.common.handler.PageHandler;
import com.sanluan.common.handler.QueryHandler;
import com.sanluan.entities.system.SystemUser;

/**
 * @author zhangxd
 * 
 */
@Repository
public class SystemUserDao extends BaseDao<SystemUser> {
	public PageHandler getPage(String name, Boolean superuserAccess, Boolean disable, Date startDateRegistered,
			Date endDateRegistered, int pageNo, int pageSize) {
		QueryHandler queryMaker = getQueryMaker("from SystemUser bean");
		if (notEmpty(superuserAccess)) {
			queryMaker.condition("bean.superuserAccess = :superuserAccess")
					.setParameter("superuserAccess", superuserAccess);
		}
		if (notEmpty(disable)) {
			queryMaker.condition("bean.disable = :disable").setParameter("disable", disable);
		}

		if (notEmpty(startDateRegistered)) {
			queryMaker.condition("bean.dateRegistered >= :startDateRegistered").setParameter("startDateRegistered",
					startDateRegistered);
		}
		if (notEmpty(endDateRegistered)) {
			queryMaker.condition("bean.dateRegistered < :endDateRegistered").setParameter("endDateRegistered",
					DateUtils.addDays(endDateRegistered, 1));
		}
		if (notEmpty(name)) {
			queryMaker.condition("bean.name like :name or bean.nickName like :name").setParameter("name", like(name));
		}
		queryMaker.append("order by bean.dateRegistered desc");
		return getPage(queryMaker, pageNo, pageSize);
	}

	public SystemUser findByName(String name) {
		QueryHandler queryMaker = getQueryMaker("from SystemUser bean where bean.name = :name").setParameter("name", name);
		return getEntity(queryMaker);
	}

	public SystemUser findByNickName(String nickName) {
		QueryHandler queryMaker = getQueryMaker("from SystemUser bean where bean.nickName = :nickName").setParameter("nickName",
				nickName);
		return getEntity(queryMaker);
	}

	public SystemUser findByEmail(String email) {
		QueryHandler queryMaker = getQueryMaker(
				"from SystemUser bean where bean.email = :email and bean.emailChecked = :emailChecked ").setParameter("email",
				email).setParameter("emailChecked", true);
		return getEntity(queryMaker);
	}

	public SystemUser findByAuthToken(String authToken) {
		QueryHandler queryMaker = getQueryMaker("from SystemUser bean where bean.authToken = :authToken").setParameter("authToken",
				authToken);
		return getEntity(queryMaker);
	}

	@Override
	protected Class<SystemUser> getEntityClass() {
		return SystemUser.class;
	}

	@Override
	protected SystemUser init(SystemUser entity) {
		if (!notEmpty(entity.getDateRegistered())) {
			entity.setDateRegistered(getDate());
		}
		return entity;
	}
}
