package com.sanluan.logic.service.log;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanluan.common.base.BaseService;
import com.sanluan.common.handler.PageHandler;
import com.sanluan.entities.log.LogEmailCheck;
import com.sanluan.logic.dao.log.LogEmailCheckDao;

/**
 * @author zhangxd
 * 
 */
@Service
@Transactional
public class LogEmailCheckService extends BaseService<LogEmailCheck, LogEmailCheckDao> {

	@Autowired
	private LogEmailCheckDao dao;

	@Transactional(readOnly = true)
	public PageHandler getPage(Integer userId, Boolean checked, Date startCreateDate, Date endCreateDate, int pageNo, int pageSize) {
		return dao.getPage(userId, checked, startCreateDate, endCreateDate, pageNo, pageSize);
	}

	public LogEmailCheck findByCode(String code) {
		return dao.findByCode(code);
	}

	public void checked(Integer id) {
		LogEmailCheck entity = dao.getEntity(id);
		if (null != entity) {
			entity.setChecked(true);
		}
	}

	@Override
	protected LogEmailCheckDao getDao() {
		return dao;
	}
}
