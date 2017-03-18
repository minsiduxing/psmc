package priv.guochun.psmc.system.common.dict.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the TAB_DATA_DICT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="TAB_DATA_DICT"
 */

public abstract class BaseTabDataDict  implements Serializable {

	public static String REF = "TabDataDict";
	public static String PROP_ORDERNUM = "Ordernum";
	public static String PROP_DICT_ID = "DictId";
	public static String PROP_DICT_NAME = "DictName";
	public static String PROP_ID = "Id";
	public static String PROP_DICT_NO = "DictNo";
	public static String PROP_DICT_TYPE = "DictType";
	public static String PROP_REMARK = "Remark";


	// constructors
	public BaseTabDataDict () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTabDataDict (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String dictId;
	private java.lang.String dictName;
	private java.lang.String remark;
	private java.lang.Integer dictType;
	private java.lang.Integer ordernum;
	private java.lang.String dictNo;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="ID"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: DICT_ID
	 */
	public java.lang.String getDictId () {
		return dictId;
	}

	/**
	 * Set the value related to the column: DICT_ID
	 * @param dictId the DICT_ID value
	 */
	public void setDictId (java.lang.String dictId) {
		this.dictId = dictId;
	}



	/**
	 * Return the value associated with the column: DICT_NAME
	 */
	public java.lang.String getDictName () {
		return dictName;
	}

	/**
	 * Set the value related to the column: DICT_NAME
	 * @param dictName the DICT_NAME value
	 */
	public void setDictName (java.lang.String dictName) {
		this.dictName = dictName;
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
	 * Return the value associated with the column: DICT_TYPE
	 */
	public java.lang.Integer getDictType () {
		return dictType;
	}

	/**
	 * Set the value related to the column: DICT_TYPE
	 * @param dictType the DICT_TYPE value
	 */
	public void setDictType (java.lang.Integer dictType) {
		this.dictType = dictType;
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
	 * Return the value associated with the column: DICT_NO
	 */
	public java.lang.String getDictNo () {
		return dictNo;
	}

	/**
	 * Set the value related to the column: DICT_NO
	 * @param dictNo the DICT_NO value
	 */
	public void setDictNo (java.lang.String dictNo) {
		this.dictNo = dictNo;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof priv.guochun.psmc.system.common.dict.model.TabDataDict)) return false;
		else {
			priv.guochun.psmc.system.common.dict.model.TabDataDict tabDataDict = (priv.guochun.psmc.system.common.dict.model.TabDataDict) obj;
			if (null == this.getId() || null == tabDataDict.getId()) return false;
			else return (this.getId().equals(tabDataDict.getId()));
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


	public String toString () {
		return super.toString();
	}


}