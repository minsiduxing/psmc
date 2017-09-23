package priv.guochun.psmc.authentication.resource.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the TAB_RESOURCE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="TAB_RESOURCE"
 */

public abstract class BaseTabResource  implements Serializable {

	public static String REF = "TabResource";
	public static String PROP_ORDERNUM = "Ordernum";
	public static String PROP_RESOURCE_TYPE = "ResourceType";
	public static String PROP_CREATOR_NAME = "CreatorName";
	public static String PROP_CREATE_TIME = "CreateTime";
	public static String PROP_ID = "Id";
	public static String PROP_RESOURCE_NAME = "ResourceName";
	public static String PROP_REMARK = "Remark";
	public static String PROP_RESOURCE_URL = "ResourceUrl";
	public static String PROP_PARENT_RESOURCE_UUID = "ParentResourceUuid";


	// constructors
	public BaseTabResource () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTabResource (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String resourceName;
	private java.lang.Integer resourceType;
	private java.lang.String resourceUrl;
	private java.lang.String parentResourceUuid;
	private java.lang.String creatorName;
	private java.util.Date createTime;
	private java.lang.String remark;
	private java.lang.Integer ordernum;
	private java.lang.Integer isView;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="UUID"
     */
	public java.lang.String getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.String id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: RESOURCE_NAME
	 */
	public java.lang.String getResourceName () {
		return resourceName;
	}

	/**
	 * Set the value related to the column: RESOURCE_NAME
	 * @param resourceName the RESOURCE_NAME value
	 */
	public void setResourceName (java.lang.String resourceName) {
		this.resourceName = resourceName;
	}



	/**
	 * Return the value associated with the column: RESOURCE_TYPE
	 */
	public java.lang.Integer getResourceType () {
		return resourceType;
	}

	/**
	 * Set the value related to the column: RESOURCE_TYPE
	 * @param resourceType the RESOURCE_TYPE value
	 */
	public void setResourceType (java.lang.Integer resourceType) {
		this.resourceType = resourceType;
	}



	/**
	 * Return the value associated with the column: RESOURCE_URL
	 */
	public java.lang.String getResourceUrl () {
		return resourceUrl;
	}

	/**
	 * Set the value related to the column: RESOURCE_URL
	 * @param resourceUrl the RESOURCE_URL value
	 */
	public void setResourceUrl (java.lang.String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}



	/**
	 * Return the value associated with the column: PARENT_RESOURCE_UUID
	 */
	public java.lang.String getParentResourceUuid () {
		return parentResourceUuid;
	}

	/**
	 * Set the value related to the column: PARENT_RESOURCE_UUID
	 * @param parentResourceUuid the PARENT_RESOURCE_UUID value
	 */
	public void setParentResourceUuid (java.lang.String parentResourceUuid) {
		this.parentResourceUuid = parentResourceUuid;
	}



	/**
	 * Return the value associated with the column: CREATOR_NAME
	 */
	public java.lang.String getCreatorName () {
		return creatorName;
	}

	/**
	 * Set the value related to the column: CREATOR_NAME
	 * @param creatorName the CREATOR_NAME value
	 */
	public void setCreatorName (java.lang.String creatorName) {
		this.creatorName = creatorName;
	}

	public java.util.Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(java.util.Date createTime)
    {
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



	/**
	 * Return the value associated with the column: ORDERNUM
	 */
	public java.lang.Integer getOrdernum () {
		return ordernum;
	}

	/**
	 * Set the value related to the column: ORDERNUM
	 * @param ordernum the ORDERNUM value
	 */
	public void setOrdernum (java.lang.Integer ordernum) {
		this.ordernum = ordernum;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof priv.guochun.psmc.authentication.resource.model.TabResource)) return false;
		else {
			priv.guochun.psmc.authentication.resource.model.TabResource tabResource = (priv.guochun.psmc.authentication.resource.model.TabResource) obj;
			if (null == this.getId() || null == tabResource.getId()) return false;
			else return (this.getId().equals(tabResource.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}
	public java.lang.Integer getIsView() {
		return isView;
	}

	public void setIsView(java.lang.Integer isView) {
		this.isView = isView;
	}

	public String toString () {
		return super.toString();
	}


}