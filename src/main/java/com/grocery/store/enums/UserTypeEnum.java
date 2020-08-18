/**
 * 
 */
package com.grocery.store.enums;

/**
 * @author Mumtaz
 *
 */
public enum UserTypeEnum {

	STAFF("1"),
	AFFILIATE("2") ,
	EXISTINGUSER("3"),
	NORMALUSER("4");
	
	private final String userType;
	private UserTypeEnum(final String userType)
	{
		this.userType = userType;
	}

	public static UserTypeEnum valueOfLabel(String label) {
		for (UserTypeEnum e : values()) {
			if (e.userType.equals(label)) {
				return e;
			}
		}
		return null;
	}

}
