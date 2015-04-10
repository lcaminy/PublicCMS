package com.sanluan.logic.service.system;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanluan.common.base.BaseService;
import com.sanluan.common.handler.PageHandler;
import com.sanluan.entities.system.SystemTask;
import com.sanluan.logic.dao.system.SystemTaskDao;

/**
 * @author zhangxd
 * 
 */
@Service
@Transactional
public class SystemTaskService extends BaseService<SystemTask, SystemTaskDao> {

	@Autowired
	private SystemTaskDao dao;

	@Transactional(readOnly = true)
	public PageHandler getPage(Integer userId, String status, Date startCreateDate,
			Date endCreateDate, Date startTimeoutDate, Date endTimeoutDate, int pageNo, int pageSize) {
		return dao.getPage(userId, status, startCreateDate, endCreateDate, startTimeoutDate,
				endTimeoutDate, pageNo, pageSize);
	}

	@Override
	protected SystemTaskDao getDao() {
		return dao;
	}
}
