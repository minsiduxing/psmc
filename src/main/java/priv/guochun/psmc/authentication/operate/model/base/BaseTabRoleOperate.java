package priv.guochun.psmc.authentication.operate.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the TAB_ROLE_OPERATE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="TAB_ROLE_OPERATE"
 */

public abstract class BaseTabRoleOperate  implements Serializable {

	public static String REF = "TabRoleOperate";


	// constructors
	public BaseTabRoleOperate () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTabRoleOperate (
		java.lang.String operateUuid,
		java.lang.String roleUuid) {

		this.setOperateUuid(operateUuid);
		this.setRoleUuid(roleUuid);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key

	private java.lang.String operateUuid;

	private java.lang.String roleUuid;



	/**
     * @hibernate.property
     *  column=OPERATE_UUID
	 * not-null=true
	 */
	public java.lang.String getOperateUuid () {
		return this.operateUuid;
	}

	/**
	 * Set the value related to the column: OPERATE_UUID
	 * @param operateUuid the OPERATE_UUID value
	 */
	public void setOperateUuid (java.lang.String operateUuid) {
		this.operateUuid = operateUuid;
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
		if (!(obj instanceof priv.guochun.psmc.authentication.operate.model.TabRoleOperate)) return false;
		else {
			priv.guochun.psmc.authentication.operate.model.TabRoleOperate tabRoleOperate = (priv.guochun.psmc.authentication.operate.model.TabRoleOperate) obj;
			if (null != this.getOperateUuid() && null != tabRoleOperate.getOperateUuid()) {
				if (!this.getOperateUuid().equals(tabRoleOperate.getOperateUuid())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getRoleUuid() && null != tabRoleOperate.getRoleUuid()) {
				if (!this.getRoleUuid().equals(tabRoleOperate.getRoleUuid())) {
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
			if (null != this.getOperateUuid()) {
				sb.append(this.getOperateUuid().hashCode());
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