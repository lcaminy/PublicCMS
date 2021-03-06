package com.sanluan.cms.entities.cms;

// Generated 2015-5-6 15:49:39 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CmsContentAttribute generated by hbm2java
 */
@Entity
@Table(name = "cms_content_attribute")
public class CmsContentAttribute implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int contentId;
	private String data;
	private String text;
	private String text1;
	private String text2;
	private String text3;
	private String text4;
	private int wordCount;

	public CmsContentAttribute() {
	}

	public CmsContentAttribute(int contentId, int wordCount) {
		this.contentId = contentId;
		this.wordCount = wordCount;
	}

	public CmsContentAttribute(int contentId, String data, String text, String text1, String text2, String text3, String text4,
			int wordCount) {
		this.contentId = contentId;
		this.data = data;
		this.text = text;
		this.text1 = text1;
		this.text2 = text2;
		this.text3 = text3;
		this.text4 = text4;
		this.wordCount = wordCount;
	}

	@Id
	@Column(name = "content_id", unique = true, nullable = false)
	public int getContentId() {
		return this.contentId;
	}

	public void setContentId(int contentId) {
		this.contentId = contentId;
	}

	@Column(name = "data", length = 65535)
	public String getData() {
		return this.data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Column(name = "text", length = 65535)
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
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

	@Column(name = "word_count", nullable = false)
	public int getWordCount() {
		return this.wordCount;
	}

	public void setWordCount(int wordCount) {
		this.wordCount = wordCount;
	}

}
