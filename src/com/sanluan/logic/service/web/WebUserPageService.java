package com.sanluan.logic.service.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanluan.common.base.BaseService;
import com.sanluan.common.handler.PageHandler;
import com.sanluan.entities.web.WebPage;
import com.sanluan.entities.web.WebUserPage;
import com.sanluan.logic.dao.web.WebPageDao;
import com.sanluan.logic.dao.web.WebUserPageDao;

/**
 * @author zhangxd
 * 
 */
@Service
@Transactional
public class WebUserPageService extends BaseService<WebUserPage, WebUserPageDao> {

	@Autowired
	private WebUserPageDao dao;
	@Autowired
	private WebPageDao publicPageDao;

	@Transactional(readOnly = true)
	public PageHandler getPage(Integer userId, String name, Boolean published, int pageNo, int pageSize) {
		return dao.getPage(userId, name, published, pageNo, pageSize);
	}

	public void publish(Integer id, int userId) {
		WebUserPage page = dao.getEntity(id);
		if (null != page) {
			WebPage entity = new WebPage();
			entity.setUserPageId(page.getId());
			entity.setName(page.getName());
			entity.setTemplate(page.getTemplate());
			entity.setUserId(userId);
			publicPageDao.save(entity);
			page.setPublished(true);
		}
	}

	public boolean rePublish(Integer id) {
		WebUserPage page = dao.getEntity(id);
		WebPage entity = publicPageDao.getEntityByUserPageId(id);
		if (null != page && null != entity) {
			entity.setName(page.getName());
			entity.setTemplate(page.getTemplate());
			return true;
		}
		return false;
	}

	@Override
	protected WebUserPageDao getDao() {
		return dao;
	}
}
