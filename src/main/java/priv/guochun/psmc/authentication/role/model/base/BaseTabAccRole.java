package priv.guochun.psmc.authentication.role.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the TAB_ACC_ROLE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="TAB_ACC_ROLE"
 */

public abstract class BaseTabAccRole  implements Serializable {

	public static String REF = "TabAccRole";


	// constructors
	public BaseTabAccRole () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTabAccRole (
		java.lang.String accUuid,
		java.lang.String roleUuid) {

		this.setAccUuid(accUuid);
		this.setRoleUuid(roleUuid);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key

	private java.lang.String accUuid;

	private java.lang.String roleUuid;



	/**
     * @hibernate.property
     *  column=ACC_UUID
	 * not-null=true
	 */
	public java.lang.String getAccUuid () {
		return this.accUuid;
	}

	/**
	 * Set the value related to the column: ACC_UUID
	 * @param accUuid the ACC_UUID value
	 */
	public void setAccUuid (java.lang.String accUuid) {
		this.accUuid = accUuid;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
     * @hibernate.property
     *  column=ROLE_UUID
	 * not-null=true
	 */
	public java.lang.String getRoleUuid () {
		return this.roleUuid;
	}

	/**
	 * Set the value related to the column: ROLE_UUID
	 * @param roleUuid the ROLE_UUID value
	 */
	public void setRoleUuid (java.lang.String roleUuid) {
		this.roleUuid = roleUuid;
		this.hashCode = Integer.MIN_VALUE;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof priv.guochun.psmc.authentication.role.model.TabAccRole)) return false;
		else {
			priv.guochun.psmc.authentication.role.model.TabAccRole tabAccRole = (priv.guochun.psmc.authentication.role.model.TabAccRole) obj;
			if (null != this.getAccUuid() && null != tabAccRole.getAccUuid()) {
				if (!this.getAccUuid().equals(tabAccRole.getAccUuid())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getRoleUuid() && null != tabAccRole.getRoleUuid()) {
				if (!this.getRoleUuid().equals(tabAccRole.getRoleUuid())) {
					return false;
				}
			}
			else {
				return false;
			}
			return true;
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			StringBuilder sb = new StringBuilder();
			if (null != this.getAccUuid()) {
				sb.append(this.getAccUuid().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getRoleUuid()) {
				sb.append(this.getRoleUuid().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			this.hashCode = sb.toString().hashCode();
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}