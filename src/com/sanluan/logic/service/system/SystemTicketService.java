package com.sanluan.logic.service.system;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanluan.common.base.BaseService;
import com.sanluan.common.handler.PageHandler;
import com.sanluan.entities.log.LogTicket;
import com.sanluan.entities.system.SystemTicket;
import com.sanluan.logic.dao.log.LogTicketDao;
import com.sanluan.logic.dao.system.SystemTicketDao;

/**
 * @author zhangxd
 * 
 */
@Service
@Transactional
public class SystemTicketService extends BaseService<SystemTicket, SystemTicketDao> {

	@Autowired
	private SystemTicketDao dao;
	@Autowired
	private LogTicketDao logDao;

	@Transactional(readOnly = true)
	public PageHandler getPage(Integer userId, Date startCreateDate, Date endCreateDate, int pageNo, int pageSize) {
		return dao.getPage(userId, startCreateDate, endCreateDate, pageNo, pageSize);
	}

	@Transactional(readOnly = true)
	public SystemTicket findByCode(String code) {
		return dao.findByCode(code);
	}

	/**
	 * @param username
	 * @return
	 */
	public void use(Integer id, Integer userId) {
		SystemTicket entity = dao.getEntity(id);
		if (null != entity) {
			entity.setRemainder(entity.getRemainder() - 1);
			LogTicket log = new LogTicket(id, userId, entity.getRemainder(), 1, dao.getDate());
			logDao.save(log);
		}
	}

	@Override
	protected SystemTicketDao getDao() {
		return dao;
	}
}
