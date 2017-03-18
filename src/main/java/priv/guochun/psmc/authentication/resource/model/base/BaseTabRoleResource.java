package priv.guochun.psmc.authentication.resource.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the TAB_ROLE_RESOURCE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="TAB_ROLE_RESOURCE"
 */

public abstract class BaseTabRoleResource  implements Serializable {

	public static String REF = "TabRoleResource";


	// constructors
	public BaseTabRoleResource () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTabRoleResource (
		java.lang.String resourceId,
		java.lang.String roleId) {

		this.setResourceId(resourceId);
		this.setRoleId(roleId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key

	private java.lang.String resourceId;

	private java.lang.String roleId;



	/**
     * @hibernate.property
     *  column=RESOURCE_ID
	 * not-null=true
	 */
	public java.lang.String getResourceId () {
		return this.resourceId;
	}

	/**
	 * Set the value related to the column: RESOURCE_ID
	 * @param resourceId the RESOURCE_ID value
	 */
	public void setResourceId (java.lang.String resourceId) {
		this.resourceId = resourceId;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
     * @hibernate.property
     *  column=ROLE_ID
	 * not-null=true
	 */
	public java.lang.String getRoleId () {
		return this.roleId;
	}

	/**
	 * Set the value related to the column: ROLE_ID
	 * @param roleId the ROLE_ID value
	 */
	public void setRoleId (java.lang.String roleId) {
		this.roleId = roleId;
		this.hashCode = Integer.MIN_VALUE;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof priv.guochun.psmc.authentication.resource.model.TabRoleResource)) return false;
		else {
			priv.guochun.psmc.authentication.resource.model.TabRoleResource tabRoleResource = (priv.guochun.psmc.authentication.resource.model.TabRoleResource) obj;
			if (null != this.getResourceId() && null != tabRoleResource.getResourceId()) {
				if (!this.getResourceId().equals(tabRoleResource.getResourceId())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getRoleId() && null != tabRoleResource.getRoleId()) {
				if (!this.getRoleId().equals(tabRoleResource.getRoleId())) {
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
			if (null != this.getResourceId()) {
				sb.append(this.getResourceId().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getRoleId()) {
				sb.append(this.getRoleId().hashCode());
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