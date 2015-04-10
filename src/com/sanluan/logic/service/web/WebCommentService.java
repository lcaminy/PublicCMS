package com.sanluan.logic.service.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanluan.common.base.BaseService;
import com.sanluan.common.handler.PageHandler;
import com.sanluan.entities.web.WebComment;
import com.sanluan.logic.dao.web.WebCommentDao;

/**
 * @author zhangxd
 * 
 */
@Service
@Transactional
public class WebCommentService extends BaseService<WebComment, WebCommentDao> {

	@Autowired
	private WebCommentDao dao;

	@Transactional(readOnly = true)
	public PageHandler getPage(String type, Integer itemId, Integer userId, int pageNo, int pageSize) {
		return dao.getPage(type, itemId, userId, pageNo, pageSize);
	}

	@Override
	protected WebCommentDao getDao() {
		return dao;
	}
}
