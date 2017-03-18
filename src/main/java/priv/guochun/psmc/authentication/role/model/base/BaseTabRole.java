package priv.guochun.psmc.authentication.role.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the TAB_ROLE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="TAB_ROLE"
 */

public abstract class BaseTabRole  implements Serializable {

	public static String REF = "TabRole";
	public static String PROP_UUID = "uuid";
	public static String PROP_ROLE_NAME = "RoleName";
	public static String PROP_ROLE_NO = "RoleNo";
	public static String PROP_CREATOR = "Creator";
	public static String PROP_CREATE_TIME = "CreateTime";
	public static String PROP_REMARK = "Remark";


	// constructors
	public BaseTabRole () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTabRole (java.lang.String uuid) {
		this.setUuid(uuid);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String uuid;

	// fields
	private java.lang.String roleNo;
	private java.lang.String roleName;
	private java.lang.String creator;
	private java.util.Date createTime;
	private java.lang.String remark;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="UUID"
     */
	public java.lang.String getUuid () {
		return uuid;
	}

	/**
	 * Set the unique identifier of this class
	 * @param uuid the new ID
	 */
	public void setUuid (java.lang.String uuid) {
		this.uuid = uuid;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: ROLE_NO
	 */
	public java.lang.String getRoleNo () {
		return roleNo;
	}

	/**
	 * Set the value related to the column: ROLE_NO
	 * @param roleNo the ROLE_NO value
	 */
	public void setRoleNo (java.lang.String roleNo) {
		this.roleNo = roleNo;
	}



	/**
	 * Return the value associated with the column: ROLE_NAME
	 */
	public java.lang.String getRoleName () {
		return roleName;
	}

	/**
	 * Set the value related to the column: ROLE_NAME
	 * @param roleName the ROLE_NAME value
	 */
	public void setRoleName (java.lang.String roleName) {
		this.roleName = roleName;
	}



	/**
	 * Return the value associated with the column: CREATOR
	 */
	public java.lang.String getCreator () {
		return creator;
	}

	/**
	 * Set the value related to the column: CREATOR
	 * @param creator the CREATOR value
	 */
	public void setCreator (java.lang.String creator) {
		this.creator = creator;
	}



	/**
	 * Return the value associated with the column: CREATE_TIME
	 */
	public java.util.Date getCreateTime () {
		return createTime;
	}

	/**
	 * Set the value related to the column: CREATE_TIME
	 * @param createTime the CREATE_TIME value
	 */
	public void setCreateTime (java.util.Date createTime) {
		this.createTime = createTime;
	}



	/**
	 * Return the value associated with the column: REMARK
	 */
	public java.lang.String getRemark () {
		return remark;
	}

	/**
	 * Set the value related to the column: REMARK
	 * @param remark the REMARK value
	 */
	public void setRemark (java.lang.String remark) {
		this.remark = remark;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof priv.guochun.psmc.authentication.role.model.TabRole)) return false;
		else {
			priv.guochun.psmc.authentication.role.model.TabRole tabRole = (priv.guochun.psmc.authentication.role.model.TabRole) obj;
			if (null == this.getUuid() || null == tabRole.getUuid()) return false;
			else return (this.getUuid().equals(tabRole.getUuid()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getUuid()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getUuid().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}