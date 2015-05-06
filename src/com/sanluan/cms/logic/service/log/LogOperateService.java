package com.sanluan.cms.logic.service.log;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanluan.cms.entities.log.LogOperate;
import com.sanluan.cms.logic.dao.log.LogOperateDao;
import com.sanluan.common.base.BaseService;
import com.sanluan.common.handler.PageHandler;

/**
 * @author zhangxd
 * 
 */
@Service
@Transactional
public class LogOperateService extends BaseService<LogOperate, LogOperateDao> {

	@Autowired
	private LogOperateDao dao;

	@Transactional(readOnly = true)
	public PageHandler getPage(Integer userId, String operate, String content, Date startCreateDate, Date endCreateDate,
			int pageNo, int pageSize) {
		return dao.getPage(userId, operate, content, startCreateDate, endCreateDate, pageNo, pageSize);
	}

	@Override
	protected LogOperateDao getDao() {
		return dao;
	}
}
