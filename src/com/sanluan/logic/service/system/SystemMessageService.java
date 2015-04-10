package com.sanluan.logic.service.system;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanluan.common.base.BaseService;
import com.sanluan.common.handler.PageHandler;
import com.sanluan.entities.system.SystemMessage;
import com.sanluan.logic.dao.system.SystemMessageDao;

/**
 * @author zhangxd
 * 
 */
@Service
@Transactional
public class SystemMessageService extends BaseService<SystemMessage, SystemMessageDao> {

	@Autowired
	private SystemMessageDao dao;

	@Transactional(readOnly = true)
	public PageHandler getPage(Integer userId, String from, Date startCreateDate, Date endCreateDate, int pageNo, int pageSize) {
		return dao.getPage(userId, from, startCreateDate, endCreateDate, pageNo, pageSize);
	}

	@Override
	protected SystemMessageDao getDao() {
		return dao;
	}
}
