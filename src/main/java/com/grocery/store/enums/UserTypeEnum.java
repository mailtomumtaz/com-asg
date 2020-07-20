/**
 * 
 */
package com.grocery.store.enums;

/**
 * @author Mumtaz
 *
 */
public enum UserTypeEnum {

	STAFF("Staff", "1"),
	AFFILIATE("Affiliate", "2") ,
	EXISTINGUSER("ExistingUser", "3"),
	NORMALUSER("NormalUser", "4");
	
	private final String userType;
	private final String value;
	private UserTypeEnum(final String userType, final String value)
	{
		this.userType = userType;
		this.value = value;
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
