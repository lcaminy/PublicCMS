package com.sanluan.logic.service.log;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanluan.common.base.BaseService;
import com.sanluan.common.handler.PageHandler;
import com.sanluan.entities.log.LogPassword;
import com.sanluan.logic.dao.log.LogPasswordDao;

/**
 * @author zhangxd
 * 
 */
@Service
@Transactional
public class LogPasswordService extends BaseService<LogPassword, LogPasswordDao> {

	@Autowired
	private LogPasswordDao dao;

	@Transactional(readOnly = true)
	public PageHandler getPage(Integer userId, String ip, Date startCreateDate, Date endCreateDate, int pageNo, int pageSize) {
		return dao.getPage(userId, ip, startCreateDate, endCreateDate, pageNo, pageSize);
	}

	@Override
	protected LogPasswordDao getDao() {
		return dao;
	}
}
