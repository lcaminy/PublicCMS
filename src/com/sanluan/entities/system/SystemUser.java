package com.sanluan.entities.system;

// Generated 2015-1-27 11:53:39 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * SystemUser generated by hbm2java
 */
@Entity
@Table(name = "system_user", uniqueConstraints = { @UniqueConstraint(columnNames = "nick_name"),
		@UniqueConstraint(columnNames = "name") })
public class SystemUser implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String password;
	private String nickName;
	private String email;
	private boolean emailChecked;
	private boolean superuserAccess;
	private boolean disable;
	private String authToken;
	private Date lastLoginDate;
	private String lastLoginIp;
	private int loginCount;
	private Date dateRegistered;

	public SystemUser() {
	}

	public SystemUser(String name, String password, String nickName, boolean emailChecked, boolean superuserAccess,
			boolean disable, int loginCount) {
		this.name = name;
		this.password = password;
		this.nickName = nickName;
		this.emailChecked = emailChecked;
		this.superuserAccess = superuserAccess;
		this.disable = disable;
		this.loginCount = loginCount;
	}

	public SystemUser(String name, String password, String nickName, String email, boolean emailChecked, boolean superuserAccess,
			boolean disable, String authToken, Date lastLoginDate, String lastLoginIp, int loginCount, Date dateRegistered) {
		this.name = name;
		this.password = password;
		this.nickName = nickName;
		this.email = email;
		this.emailChecked = emailChecked;
		this.superuserAccess = superuserAccess;
		this.disable = disable;
		this.authToken = authToken;
		this.lastLoginDate = lastLoginDate;
		this.lastLoginIp = lastLoginIp;
		this.loginCount = loginCount;
		this.dateRegistered = dateRegistered;
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

	@Column(name = "name", unique = true, nullable = false, length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "password", nullable = false, length = 32)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "nick_name", unique = true, nullable = false, length = 45)
	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Column(name = "email", length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "email_checked", nullable = false)
	public boolean isEmailChecked() {
		return this.emailChecked;
	}

	public void setEmailChecked(boolean emailChecked) {
		this.emailChecked = emailChecked;
	}

	@Column(name = "superuser_access", nullable = false)
	public boolean isSuperuserAccess() {
		return this.superuserAccess;
	}

	public void setSuperuserAccess(boolean superuserAccess) {
		this.superuserAccess = superuserAccess;
	}

	@Column(name = "disable", nullable = false)
	public boolean isDisable() {
		return this.disable;
	}

	public void setDisable(boolean disable) {
		this.disable = disable;
	}

	@Column(name = "auth_token", length = 40)
	public String getAuthToken() {
		return this.authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_login_date", length = 19)
	public Date getLastLoginDate() {
		return this.lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	@Column(name = "last_login_ip", length = 20)
	public String getLastLoginIp() {
		return this.lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	@Column(name = "login_count", nullable = false)
	public int getLoginCount() {
		return this.loginCount;
	}

	public void setLoginCount(int loginCount) {
		this.loginCount = loginCount;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_registered", length = 19)
	public Date getDateRegistered() {
		return this.dateRegistered;
	}

	public void setDateRegistered(Date dateRegistered) {
		this.dateRegistered = dateRegistered;
	}

}
