package com.sanluan.cms.entities.cms;

// Generated 2015-5-6 15:49:39 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sanluan.common.source.entity.MyColumn;

/**
 * CmsSite generated by hbm2java
 */
@Entity
@Table(name = "cms_site")
public class CmsSite implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	@MyColumn(title = "站点名称")
	private String name;
	@MyColumn(title = "站点简称")
	private String shortName;
	@MyColumn(title = "页面路径")
	private String htmlPath;
	@MyColumn(title = "动态站点路径")
	private String dynamicSitePath;
	@MyColumn(title = "站点访问地址")
	private String sitePath;
	@MyColumn(title = "附近路径")
	private String attachmentPath;
	@MyColumn(title = "用户数")
	private int users;
	@MyColumn(title = "已删除", condition = true)
	private boolean isDisable;

	public CmsSite() {
	}

	public CmsSite(String name, String htmlPath, String dynamicSitePath, String sitePath, String attachmentPath, int users,
			boolean isDisable) {
		this.name = name;
		this.htmlPath = htmlPath;
		this.dynamicSitePath = dynamicSitePath;
		this.sitePath = sitePath;
		this.attachmentPath = attachmentPath;
		this.users = users;
		this.isDisable = isDisable;
	}

	public CmsSite(String name, String shortName, String htmlPath, String dynamicSitePath, String sitePath,
			String attachmentPath, int users, boolean isDisable) {
		this.name = name;
		this.shortName = shortName;
		this.htmlPath = htmlPath;
		this.dynamicSitePath = dynamicSitePath;
		this.sitePath = sitePath;
		this.attachmentPath = attachmentPath;
		this.users = users;
		this.isDisable = isDisable;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "short_name", length = 100)
	public String getShortName() {
		return this.shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	@Column(name = "html_path", nullable = false)
	public String getHtmlPath() {
		return this.htmlPath;
	}

	public void setHtmlPath(String htmlPath) {
		this.htmlPath = htmlPath;
	}

	@Column(name = "dynamic_site_path", nullable = false)
	public String getDynamicSitePath() {
		return this.dynamicSitePath;
	}

	public void setDynamicSitePath(String dynamicSitePath) {
		this.dynamicSitePath = dynamicSitePath;
	}

	@Column(name = "site_path", nullable = false)
	public String getSitePath() {
		return this.sitePath;
	}

	public void setSitePath(String sitePath) {
		this.sitePath = sitePath;
	}

	@Column(name = "attachment_path", nullable = false)
	public String getAttachmentPath() {
		return this.attachmentPath;
	}

	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
	}

	@Column(name = "users", nullable = false)
	public int getUsers() {
		return this.users;
	}

	public void setUsers(int users) {
		this.users = users;
	}

	@Column(name = "is_disable", nullable = false)
	public boolean isIsDisable() {
		return this.isDisable;
	}

	public void setIsDisable(boolean isDisable) {
		this.isDisable = isDisable;
	}

}
