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
 * CmsCategory generated by hbm2java
 */
@Entity
@Table(name = "cms_category")
public class CmsCategory implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	@MyColumn(title = "站点", condition = true)
	private int siteId;
	@MyColumn(title = "名称", condition = true, like = true)
	private String name;
	@MyColumn(title = "父分类", condition = true)
	private Integer parentId;
	private String childIds;
	@MyColumn(title = "英文名")
	private String englishName;
	@MyColumn(title = "路径")
	private String path;
	@MyColumn(title = "列表路径")
	private String listPath;
	@MyColumn(title = "路径1")
	private String path1;
	@MyColumn(title = "列表路径1")
	private String listPath1;
	@MyColumn(title = "内容路径")
	private String contentPath;
	@MyColumn(title = "内容路径1")
	private String contentPath1;
	@MyColumn(title = "每页数据")
	private Integer pageSize;
	@MyColumn(title = "是否删除", condition = true)
	private boolean isDisable;
	@MyColumn(title = "内容数")
	private int contents;
	@MyColumn(title = "扩展字段1", condition = true)
	private String extend1;
	@MyColumn(title = "扩展字段2", condition = true)
	private String extend2;
	@MyColumn(title = "扩展字段3", condition = true)
	private String extend3;
	@MyColumn(title = "扩展字段4", condition = true)
	private String extend4;
	@MyColumn(title = "扩展数字字段1", condition = true)
	private Integer extendNumber1;
	@MyColumn(title = "扩展数字字段2", condition = true)
	private Integer extendNumber2;
	@MyColumn(title = "扩展数字字段3", condition = true)
	private Integer extendNumber3;
	@MyColumn(title = "扩展数字字段4", condition = true)
	private Integer extendNumber4;

	public CmsCategory() {
	}

	public CmsCategory(int siteId, String name, String path, String listPath, String contentPath, boolean isDisable, int contents) {
		this.siteId = siteId;
		this.name = name;
		this.path = path;
		this.listPath = listPath;
		this.contentPath = contentPath;
		this.isDisable = isDisable;
		this.contents = contents;
	}

	public CmsCategory(int siteId, String name, Integer parentId, String childIds, String englishName, String path,
			String listPath, String path1, String listPath1, String contentPath, String contentPath1, Integer pageSize,
			boolean isDisable, int contents, String extend1, String extend2, String extend3, String extend4,
			Integer extendNumber1, Integer extendNumber2, Integer extendNumber3, Integer extendNumber4) {
		this.siteId = siteId;
		this.name = name;
		this.parentId = parentId;
		this.childIds = childIds;
		this.englishName = englishName;
		this.path = path;
		this.listPath = listPath;
		this.path1 = path1;
		this.listPath1 = listPath1;
		this.contentPath = contentPath;
		this.contentPath1 = contentPath1;
		this.pageSize = pageSize;
		this.isDisable = isDisable;
		this.contents = contents;
		this.extend1 = extend1;
		this.extend2 = extend2;
		this.extend3 = extend3;
		this.extend4 = extend4;
		this.extendNumber1 = extendNumber1;
		this.extendNumber2 = extendNumber2;
		this.extendNumber3 = extendNumber3;
		this.extendNumber4 = extendNumber4;
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

	@Column(name = "name", nullable = false, length = 200)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "parent_id")
	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	@Column(name = "child_ids", length = 500)
	public String getChildIds() {
		return this.childIds;
	}

	public void setChildIds(String childIds) {
		this.childIds = childIds;
	}

	@Column(name = "english_name", length = 200)
	public String getEnglishName() {
		return this.englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	@Column(name = "path", nullable = false, length = 200)
	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Column(name = "list_path", nullable = false, length = 200)
	public String getListPath() {
		return this.listPath;
	}

	public void setListPath(String listPath) {
		this.listPath = listPath;
	}

	@Column(name = "path1", length = 200)
	public String getPath1() {
		return this.path1;
	}

	public void setPath1(String path1) {
		this.path1 = path1;
	}

	@Column(name = "list_path1", length = 200)
	public String getListPath1() {
		return this.listPath1;
	}

	public void setListPath1(String listPath1) {
		this.listPath1 = listPath1;
	}

	@Column(name = "content_path", nullable = false, length = 500)
	public String getContentPath() {
		return this.contentPath;
	}

	public void setContentPath(String contentPath) {
		this.contentPath = contentPath;
	}

	@Column(name = "content_path1", length = 500)
	public String getContentPath1() {
		return this.contentPath1;
	}

	public void setContentPath1(String contentPath1) {
		this.contentPath1 = contentPath1;
	}

	@Column(name = "page_size")
	public Integer getPageSize() {
		return this.pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	@Column(name = "is_disable", nullable = false)
	public boolean isIsDisable() {
		return this.isDisable;
	}

	public void setIsDisable(boolean isDisable) {
		this.isDisable = isDisable;
	}

	@Column(name = "contents", nullable = false)
	public int getContents() {
		return this.contents;
	}

	public void setContents(int contents) {
		this.contents = contents;
	}

	@Column(name = "extend1", length = 200)
	public String getExtend1() {
		return this.extend1;
	}

	public void setExtend1(String extend1) {
		this.extend1 = extend1;
	}

	@Column(name = "extend2", length = 200)
	public String getExtend2() {
		return this.extend2;
	}

	public void setExtend2(String extend2) {
		this.extend2 = extend2;
	}

	@Column(name = "extend3", length = 200)
	public String getExtend3() {
		return this.extend3;
	}

	public void setExtend3(String extend3) {
		this.extend3 = extend3;
	}

	@Column(name = "extend4", length = 200)
	public String getExtend4() {
		return this.extend4;
	}

	public void setExtend4(String extend4) {
		this.extend4 = extend4;
	}

	@Column(name = "extend_number1")
	public Integer getExtendNumber1() {
		return this.extendNumber1;
	}

	public void setExtendNumber1(Integer extendNumber1) {
		this.extendNumber1 = extendNumber1;
	}

	@Column(name = "extend_number2")
	public Integer getExtendNumber2() {
		return this.extendNumber2;
	}

	public void setExtendNumber2(Integer extendNumber2) {
		this.extendNumber2 = extendNumber2;
	}

	@Column(name = "extend_number3")
	public Integer getExtendNumber3() {
		return this.extendNumber3;
	}

	public void setExtendNumber3(Integer extendNumber3) {
		this.extendNumber3 = extendNumber3;
	}

	@Column(name = "extend_number4")
	public Integer getExtendNumber4() {
		return this.extendNumber4;
	}

	public void setExtendNumber4(Integer extendNumber4) {
		this.extendNumber4 = extendNumber4;
	}

}
