package com.sanluan.logic.service.system;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanluan.common.base.BaseService;
import com.sanluan.common.handler.PageHandler;
import com.sanluan.entities.log.LogLogin;
import com.sanluan.entities.log.LogPassword;
import com.sanluan.entities.system.SystemUser;
import com.sanluan.logic.dao.log.LogLoginDao;
import com.sanluan.logic.dao.log.LogPasswordDao;
import com.sanluan.logic.dao.system.SystemUserDao;

/**
 * @author zhangxd
 * 
 */
@Service
@Transactional
public class SystemUserService extends BaseService<SystemUser, SystemUserDao> {
	@Autowired
	private SystemUserDao dao;
	@Autowired
	private LogPasswordDao logPasswordDao;
	@Autowired
	private LogLoginDao logLogindao;

	@Transactional(readOnly = true)
	public PageHandler getPage(String name, Boolean superuserAccess, Boolean disable, Date startDateRegistered,
			Date endDateRegistered, int pageNo, int pageSize) {
		return dao.getPage(name, superuserAccess, disable, startDateRegistered, endDateRegistered, pageNo, pageSize);
	}

	public SystemUser findByName(String name) {
		return dao.findByName(name);
	}

	public SystemUser findByNickName(String nickName) {
		return dao.findByNickName(nickName);
	}

	public SystemUser findByEmail(String email) {
		return dao.findByEmail(email);
	}

	public SystemUser findByAuthToken(String authToken) {
		return dao.findByAuthToken(authToken);
	}

	public void updatePassword(Integer id, String ip, String password) {
		SystemUser entity = dao.getEntity(id);
		if (null != entity) {
			LogPassword log = new LogPassword(entity.getId(), ip, dao.getDate(), password, entity.getPassword());
			logPasswordDao.save(log);
			entity.setPassword(password);
		}
	}

	public void updateLoginStatus(Integer id, String username, String authToken, String ip) {
		SystemUser entity = dao.getEntity(id);
		if (null != entity) {
			LogLogin log = new LogLogin();
			log.setName(username);
			log.setUserId(id);
			log.setResult(true);
			log.setIp(ip);
			log.setErrorPassword(null);
			logLogindao.save(log);
			entity.setAuthToken(authToken);
			entity.setLastLoginDate(dao.getDate());
			entity.setLastLoginIp(ip);
			entity.setLoginCount(entity.getLoginCount() + 1);
		}
	}

	public void checked(Integer userId, String email) {
		SystemUser entity = dao.getEntity(userId);
		if (null != entity) {
			entity.setEmail(email);
			entity.setEmailChecked(true);
		}
	}

	public void updateStatus(Integer id, boolean status) {
		SystemUser entity = dao.getEntity(id);
		if (null != entity) {
			entity.setDisable(status);
		}
	}

	@Override
	protected SystemUserDao getDao() {
		return dao;
	}
}
