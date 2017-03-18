package priv.guochun.psmc.system.common.city.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the TAB_CITY table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="TAB_CITY"
 */

public abstract class BaseTabCity  implements Serializable {

	public static String REF = "TabCity";
	public static String PROP_ORDERNUM = "Ordernum";
	public static String PROP_CITY_ID = "CityId";
	public static String PROP_PARENT_ID = "ParentId";
	public static String PROP_CITY_NAME = "CityName";
	public static String PROP_REMARK = "Remark";
	public static String PROP_CITY_LAYER = "CityLayer";


	// constructors
	public BaseTabCity () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTabCity (java.lang.String cityId) {
		this.setCityId(cityId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String cityId;

	// fields
	private java.lang.String cityName;
	private java.lang.String parentId;
	private java.lang.String remark;
	private java.lang.Integer ordernum;
	private java.lang.Integer cityLayer;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="CITY_ID"
     */
	public java.lang.String getCityId () {
		return cityId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param cityId the new ID
	 */
	public void setCityId (java.lang.String cityId) {
		this.cityId = cityId;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: CITY_NAME
	 */
	public java.lang.String getCityName () {
		return cityName;
	}

	/**
	 * Set the value related to the column: CITY_NAME
	 * @param cityName the CITY_NAME value
	 */
	public void setCityName (java.lang.String cityName) {
		this.cityName = cityName;
	}



	/**
	 * Return the value associated with the column: PARENT_ID
	 */
	public java.lang.String getParentId () {
		return parentId;
	}

	/**
	 * Set the value related to the column: PARENT_ID
	 * @param parentId the PARENT_ID value
	 */
	public void setParentId (java.lang.String parentId) {
		this.parentId = parentId;
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



	/**
	 * Return the value associated with the column: CITY_LAYER
	 */
	public java.lang.Integer getCityLayer () {
		return cityLayer;
	}

	/**
	 * Set the value related to the column: CITY_LAYER
	 * @param cityLayer the CITY_LAYER value
	 */
	public void setCityLayer (java.lang.Integer cityLayer) {
		this.cityLayer = cityLayer;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof priv.guochun.psmc.system.common.city.model.TabCity)) return false;
		else {
			priv.guochun.psmc.system.common.city.model.TabCity tabCity = (priv.guochun.psmc.system.common.city.model.TabCity) obj;
			if (null == this.getCityId() || null == tabCity.getCityId()) return false;
			else return (this.getCityId().equals(tabCity.getCityId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getCityId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getCityId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}