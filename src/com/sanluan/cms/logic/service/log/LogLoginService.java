package com.sanluan.cms.logic.service.log;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanluan.cms.entities.log.LogLogin;
import com.sanluan.cms.logic.dao.log.LogLoginDao;
import com.sanluan.common.base.BaseService;
import com.sanluan.common.handler.PageHandler;

/**
 * @author zhangxd
 * 
 */
@Service
@Transactional
public class LogLoginService extends BaseService<LogLogin, LogLoginDao> {

	@Autowired
	private LogLoginDao dao;

	@Transactional(readOnly = true)
	public PageHandler getPage(Integer userId, Boolean result, String name, String ip, Date startCreateDate, Date endCreateDate,
			int pageNo, int pageSize) {
		return dao.getPage(userId, result, name, ip, startCreateDate, endCreateDate, pageNo, pageSize);
	}

	@Override
	protected LogLoginDao getDao() {
		return dao;
	}
}
