package com.sanluan.logic.service.system;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanluan.common.base.BaseService;
import com.sanluan.common.handler.PageHandler;
import com.sanluan.entities.system.SystemGuestBook;
import com.sanluan.logic.dao.system.SystemGuestBookDao;

/**
 * @author zhangxd
 * 
 */
@Service
@Transactional
public class SystemGuestBookService extends BaseService<SystemGuestBook, SystemGuestBookDao> {

	@Autowired
	private SystemGuestBookDao dao;

	@Transactional(readOnly = true)
	public PageHandler getPage(Integer userId, String userName, Date startCreateDate, Date endCreateDate, int pageNo, int pageSize) {
		return dao.getPage(userId, userName, startCreateDate, endCreateDate, pageNo, pageSize);
	}

	@Override
	protected SystemGuestBookDao getDao() {
		return dao;
	}
}
