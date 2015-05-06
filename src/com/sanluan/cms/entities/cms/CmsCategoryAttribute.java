package com.sanluan.cms.entities.cms;

// Generated 2015-5-6 15:49:39 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CmsCategoryAttribute generated by hbm2java
 */
@Entity
@Table(name = "cms_category_attribute")
public class CmsCategoryAttribute implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int categoryId;
	private String data;
	private String text1;
	private String text2;
	private String text3;
	private String text4;

	public CmsCategoryAttribute() {
	}

	public CmsCategoryAttribute(int categoryId) {
		this.categoryId = categoryId;
	}

	public CmsCategoryAttribute(int categoryId, String data, String text1, String text2, String text3, String text4) {
		this.categoryId = categoryId;
		this.data = data;
		this.text1 = text1;
		this.text2 = text2;
		this.text3 = text3;
		this.text4 = text4;
	}

	@Id
	@Column(name = "category_id", unique = true, nullable = false)
	public int getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	@Column(name = "data", length = 65535)
	public String getData() {
		return this.data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Column(name = "text1", length = 65535)
	public String getText1() {
		return this.text1;
	}

	public void setText1(String text1) {
		this.text1 = text1;
	}

	@Column(name = "text2", length = 65535)
	public String getText2() {
		return this.text2;
	}

	public void setText2(String text2) {
		this.text2 = text2;
	}

	@Column(name = "text3", length = 65535)
	public String getText3() {
		return this.text3;
	}

	public void setText3(String text3) {
		this.text3 = text3;
	}

	@Column(name = "text4", length = 65535)
	public String getText4() {
		return this.text4;
	}

	public void setText4(String text4) {
		this.text4 = text4;
	}

}
