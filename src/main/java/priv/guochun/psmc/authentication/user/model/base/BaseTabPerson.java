package priv.guochun.psmc.authentication.user.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the TAB_PERSON table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="TAB_PERSON"
 */

public abstract class BaseTabPerson  implements Serializable {

	public static String REF = "TabPerson";
	public static String PROP_UUID = "Uuid";
	public static String PROP_CITY_ID = "cityId";
	public static String PROP_ACC_UUID = "AccUuid";
	public static String PROP_AGE = "Age";
	public static String PROP_EMAIL = "Email";
	public static String PROP_TELEPHONE = "Telephone";
	public static String PROP_PERSON_NAME = "PersonName";
	public static String PROP_SEX = "Sex";
	
	public static String GROUPID = "groupid";
	

	// constructors
	public BaseTabPerson () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTabPerson (java.lang.String uuid) {
		this.setUuid(uuid);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String uuid;

	// fields
	private java.lang.String personName;
	private java.lang.Integer sex;
	private java.lang.Integer age;
	private java.lang.String telephone;
	private java.lang.String email;
	private java.lang.String accUuid;
	private java.lang.String cityId;
	private java.lang.String groupid;


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
	 * Return the value associated with the column: PERSON_NAME
	 */
	public java.lang.String getPersonName () {
		return personName;
	}

	/**
	 * Set the value related to the column: PERSON_NAME
	 * @param personName the PERSON_NAME value
	 */
	public void setPersonName (java.lang.String personName) {
		this.personName = personName;
	}



	/**
	 * Return the value associated with the column: SEX
	 */
	public java.lang.Integer getSex () {
		return sex;
	}

	/**
	 * Set the value related to the column: SEX
	 * @param sex the SEX value
	 */
	public void setSex (java.lang.Integer sex) {
		this.sex = sex;
	}



	/**
	 * Return the value associated with the column: AGE
	 */
	public java.lang.Integer getAge () {
		return age;
	}

	/**
	 * Set the value related to the column: AGE
	 * @param age the AGE value
	 */
	public void setAge (java.lang.Integer age) {
		this.age = age;
	}



	/**
	 * Return the value associated with the column: TELEPHONE
	 */
	public java.lang.String getTelephone () {
		return telephone;
	}

	/**
	 * Set the value related to the column: TELEPHONE
	 * @param telephone the TELEPHONE value
	 */
	public void setTelephone (java.lang.String telephone) {
		this.telephone = telephone;
	}



	/**
	 * Return the value associated with the column: EMAIL
	 */
	public java.lang.String getEmail () {
		return email;
	}

	/**
	 * Set the value related to the column: EMAIL
	 * @param email the EMAIL value
	 */
	public void setEmail (java.lang.String email) {
		this.email = email;
	}



	/**
	 * Return the value associated with the column: ACC_UUID
	 */
	public java.lang.String getAccUuid () {
		return accUuid;
	}

	/**
	 * Set the value related to the column: ACC_UUID
	 * @param accUuid the ACC_UUID value
	 */
	public void setAccUuid (java.lang.String accUuid) {
		this.accUuid = accUuid;
	}



	/**
	 * Return the value associated with the column: CITY_ID
	 */
	public java.lang.String getCityId () {
		return cityId;
	}

	/**
	 * Set the value related to the column: CITY_ID
	 * @param cityId the CITY_ID value
	 */
	public void setCityId (java.lang.String cityId) {
		this.cityId = cityId;
	}



	public java.lang.String getGroupid() {
		return groupid;
	}

	public void setGroupid(java.lang.String groupid) {
		this.groupid = groupid;
	}

	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof priv.guochun.psmc.authentication.user.model.TabPerson)) return false;
		else {
			priv.guochun.psmc.authentication.user.model.TabPerson tabPerson = (priv.guochun.psmc.authentication.user.model.TabPerson) obj;
			if (null == this.getUuid() || null == tabPerson.getUuid()) return false;
			else return (this.getUuid().equals(tabPerson.getUuid()));
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