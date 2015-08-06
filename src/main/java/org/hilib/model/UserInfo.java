// -*- mode: java; coding: utf-8; tab-width: 4; -*-
package org.hilib.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;


@Entity
@Table(name="user_info")
public class UserInfo implements Serializable {
	private Integer id;

	@Column
	private String userId;
	@Column
	private String userPassword;

	public void setId(Integer id) {
		this.id = id;
	}

	@Id
	public Integer getId() {
		return id;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
}
