/**
 * 
 */
package com.grocery.store.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.grocery.store.enums.UserTypeEnum;

/**
 * @author Mumtaz
 *
 */

@Entity
@Table(name= "SITEUSER")
public class SiteUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name  = "name")
	private String userName;
	
	@Column(name = "user_type")
	private UserTypeEnum userType;

	@Column(name = "joining_date")
	private LocalDate joiningDate;
	
	public long getId() {
		return id;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public UserTypeEnum getUserType() {
		return userType;
	}

	public void setUserType(UserTypeEnum userType) {
		this.userType = userType;
	}
	
}
