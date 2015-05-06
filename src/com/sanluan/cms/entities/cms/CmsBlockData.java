package com.sanluan.cms.entities.cms;

// Generated 2015-5-6 15:49:39 by Hibernate Tools 4.0.0

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sanluan.common.source.entity.MyColumn;

/**
 * CmsBlockData generated by hbm2java
 */
@Entity
@Table(name = "cms_block_data")
public class CmsBlockData implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	@MyColumn(title = "块", condition = true)
	private int blockId;
	@MyColumn(title = "标题")
	private String title;
	@MyColumn(title = "图片")
	private String image;
	@MyColumn(title = "描述")
	private String description;
	private String data;
	@MyColumn(title = "创建日期", condition = true)
	private Date createDate;
	@MyColumn(title = "已删除", condition = true)
	private int isDisable;

	public CmsBlockData() {
	}

	public CmsBlockData(int blockId, String title, Date createDate, int isDisable) {
		this.blockId = blockId;
		this.title = title;
		this.createDate = createDate;
		this.isDisable = isDisable;
	}

	public CmsBlockData(int blockId, String title, String image, String description, String data, Date createDate, int isDisable) {
		this.blockId = blockId;
		this.title = title;
		this.image = image;
		this.description = description;
		this.data = data;
		this.createDate = createDate;
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

	@Column(name = "block_id", nullable = false)
	public int getBlockId() {
		return this.blockId;
	}

	public void setBlockId(int blockId) {
		this.blockId = blockId;
	}

	@Column(name = "title", nullable = false, length = 200)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "image")
	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "description", length = 500)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "data", length = 65535)
	public String getData() {
		return this.data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", nullable = false, length = 19)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "is_disable", nullable = false)
	public int getIsDisable() {
		return this.isDisable;
	}

	public void setIsDisable(int isDisable) {
		this.isDisable = isDisable;
	}

}