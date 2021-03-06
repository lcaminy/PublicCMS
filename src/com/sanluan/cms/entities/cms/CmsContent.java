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
 * CmsContent generated by hbm2java
 */
@Entity
@Table(name = "cms_content")
public class CmsContent implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	@MyColumn(title = "标题", condition = true, like = true, or = true)
	private String title;
	@MyColumn(title = "发布用户", condition = true)
	private int userId;
	@MyColumn(title = "分类", condition = true)
	private String categoryId;
	@MyColumn(title = "模型", condition = true)
	private int modelId;
	@MyColumn(title = "是否转载")
	private boolean isCopied;
	@MyColumn(title = "来源")
	private String source;
	@MyColumn(title = "作者")
	private String author;
	@MyColumn(title = "编辑")
	private String editor;
	@MyColumn(title = "地址")
	private String url;
	@MyColumn(title = "描述")
	private String description;
	@MyColumn(title = "封面")
	private String cover;
	@MyColumn(title = "章节数")
	private int chapters;
	@MyColumn(title = "分数", order = true)
	private int scores;
	@MyColumn(title = "评论数", order = true)
	private int comments;
	@MyColumn(title = "点击数", order = true)
	private int clicks;
	@MyColumn(title = "发布日期", condition = true, order = true)
	private Date publishDate;
	@MyColumn(title = "创建日期")
	private Date createDate;
	@MyColumn(title = "状态", condition = true)
	private int status;
	@MyColumn(title = "已删除", condition = true)
	private boolean isDisable;
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

	public CmsContent() {
	}

	public CmsContent(String title, int userId, String categoryId, int modelId, boolean isCopied, String description,
			int chapters, int scores, int comments, int clicks, Date publishDate, Date createDate, int status, boolean isDisable) {
		this.title = title;
		this.userId = userId;
		this.categoryId = categoryId;
		this.modelId = modelId;
		this.isCopied = isCopied;
		this.description = description;
		this.chapters = chapters;
		this.scores = scores;
		this.comments = comments;
		this.clicks = clicks;
		this.publishDate = publishDate;
		this.createDate = createDate;
		this.status = status;
		this.isDisable = isDisable;
	}

	public CmsContent(String title, int userId, String categoryId, int modelId, boolean isCopied, String source, String author,
			String editor, String url, String description, String cover, int chapters, int scores, int comments, int clicks,
			Date publishDate, Date createDate, int status, boolean isDisable, String extend1, String extend2, String extend3,
			String extend4, Integer extendNumber1, Integer extendNumber2, Integer extendNumber3, Integer extendNumber4) {
		this.title = title;
		this.userId = userId;
		this.categoryId = categoryId;
		this.modelId = modelId;
		this.isCopied = isCopied;
		this.source = source;
		this.author = author;
		this.editor = editor;
		this.url = url;
		this.description = description;
		this.cover = cover;
		this.chapters = chapters;
		this.scores = scores;
		this.comments = comments;
		this.clicks = clicks;
		this.publishDate = publishDate;
		this.createDate = createDate;
		this.status = status;
		this.isDisable = isDisable;
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

	@Column(name = "title", nullable = false)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "user_id", nullable = false)
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name = "category_id", nullable = false)
	public String getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	@Column(name = "model_id", nullable = false)
	public int getModelId() {
		return this.modelId;
	}

	public void setModelId(int modelId) {
		this.modelId = modelId;
	}

	@Column(name = "is_copied", nullable = false)
	public boolean isIsCopied() {
		return this.isCopied;
	}

	public void setIsCopied(boolean isCopied) {
		this.isCopied = isCopied;
	}

	@Column(name = "source", length = 100)
	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Column(name = "author", length = 100)
	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Column(name = "editor", length = 100)
	public String getEditor() {
		return this.editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	@Column(name = "url")
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "description", nullable = false, length = 500)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "cover")
	public String getCover() {
		return this.cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	@Column(name = "chapters", nullable = false)
	public int getChapters() {
		return this.chapters;
	}

	public void setChapters(int chapters) {
		this.chapters = chapters;
	}

	@Column(name = "scores", nullable = false)
	public int getScores() {
		return this.scores;
	}

	public void setScores(int scores) {
		this.scores = scores;
	}

	@Column(name = "comments", nullable = false)
	public int getComments() {
		return this.comments;
	}

	public void setComments(int comments) {
		this.comments = comments;
	}

	@Column(name = "clicks", nullable = false)
	public int getClicks() {
		return this.clicks;
	}

	public void setClicks(int clicks) {
		this.clicks = clicks;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "publish_date", nullable = false, length = 19)
	public Date getPublishDate() {
		return this.publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", nullable = false, length = 19)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "status", nullable = false)
	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Column(name = "is_disable", nullable = false)
	public boolean isIsDisable() {
		return this.isDisable;
	}

	public void setIsDisable(boolean isDisable) {
		this.isDisable = isDisable;
	}

	@Column(name = "extend1", length = 100)
	public String getExtend1() {
		return this.extend1;
	}

	public void setExtend1(String extend1) {
		this.extend1 = extend1;
	}

	@Column(name = "extend2", length = 100)
	public String getExtend2() {
		return this.extend2;
	}

	public void setExtend2(String extend2) {
		this.extend2 = extend2;
	}

	@Column(name = "extend3", length = 100)
	public String getExtend3() {
		return this.extend3;
	}

	public void setExtend3(String extend3) {
		this.extend3 = extend3;
	}

	@Column(name = "extend4", length = 100)
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
