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
 * CmsPage generated by hbm2java
 */
@Entity
@Table(name = "cms_page")
public class CmsPage implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	@MyColumn(title = "站点", condition = true)
	private int siteId;
	@MyColumn(title = "标题")
	private String title;
	@MyColumn(title = "父页面", condition = true)
	private Integer parentId;
	@MyColumn(title = "模板路径")
	private String templatePath;
	@MyColumn(title = "路径")
	private String path;

	public CmsPage() {
	}

	public CmsPage(int siteId, String title, String templatePath, String path) {
		this.siteId = siteId;
		this.title = title;
		this.templatePath = templatePath;
		this.path = path;
	}

	public CmsPage(int siteId, String title, Integer parentId, String templatePath, String path) {
		this.siteId = siteId;
		this.title = title;
		this.parentId = parentId;
		this.templatePath = templatePath;
		this.path = path;
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

	@Column(name = "site_id", nullable = false)
	public int getSiteId() {
		return this.siteId;
	}

	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}

	@Column(name = "title", nullable = false, length = 200)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "parent_id")
	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	@Column(name = "template_path", nullable = false)
	public String getTemplatePath() {
		return this.templatePath;
	}

	public void setTemplatePath(String templatePath) {
		this.templatePath = templatePath;
	}

	@Column(name = "path", nullable = false)
	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}