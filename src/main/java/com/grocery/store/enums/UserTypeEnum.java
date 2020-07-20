/**
 * 
 */
package com.grocery.store.enums;

/**
 * @author Mumtaz
 *
 */
public enum UserTypeEnum {

	STAFF("Staff"),
	AFFILIATE("Affiliate") , 
	EXISTINGUSER("ExistingUser"),
	NORMALUSER("NormalUser");
	
	private final String userType;
	
	private UserTypeEnum(final String userType) {
		this.userType = userType;
	}
}
