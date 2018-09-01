package priv.guochun.psmc.authentication.user.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the TAB_ACCOUNTS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="TAB_ACCOUNTS"
 */

public abstract class BaseTabAccount  implements Serializable {

	public static String REF = "TabAccount";
	public static String PROP_UUID = "Uuid";
	public static String PROP_IS_LOCKED = "IsLocked";
	public static String PROP_ACCOUNT_NAME = "AccountName";
	public static String PROP_ACCOUNT_PASS = "AccountPass";
	public static String PROP_ACCOUNT_TYPE = "AccountType";
	

	// constructors
	public BaseTabAccount () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTabAccount (java.lang.String uuid) {
		this.setUuid(uuid);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String uuid;

	// fields
	private java.lang.String accountName;
	private java.lang.String accountPass;
	private java.lang.String isLocked;
	private Integer accountType;
	private Integer isAuth; //是否实名认证（1是，2否）
	private Integer anthType; //实名认证方式（1身份证，2其他）

	

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
	 * Return the value associated with the column: ACCOUNT_NAME
	 */
	public java.lang.String getAccountName () {
		return accountName;
	}

	/**
	 * Set the value related to the column: ACCOUNT_NAME
	 * @param accountName the ACCOUNT_NAME value
	 */
	public void setAccountName (java.lang.String accountName) {
		this.accountName = accountName;
	}



	/**
	 * Return the value associated with the column: ACCOUNT_PASS
	 */
	public java.lang.String getAccountPass () {
		return accountPass;
	}

	/**
	 * Set the value related to the column: ACCOUNT_PASS
	 * @param accountPass the ACCOUNT_PASS value
	 */
	public void setAccountPass (java.lang.String accountPass) {
		this.accountPass = accountPass;
	}



	/**
	 * Return the value associated with the column: IS_LOCKED
	 */
	public java.lang.String getIsLocked () {
		return isLocked;
	}

	/**
	 * Set the value related to the column: IS_LOCKED
	 * @param isLocked the IS_LOCKED value
	 */
	public void setIsLocked (java.lang.String isLocked) {
		this.isLocked = isLocked;
	}

	public Integer getAccountType() {
		return accountType;
	}

	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}

	public Integer getIsAuth() {
		return isAuth;
	}

	public void setIsAuth(Integer isAuth) {
		this.isAuth = isAuth;
	}

	public Integer getAnthType() {
		return anthType;
	}

	public void setAnthType(Integer anthType) {
		this.anthType = anthType;
	}

	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof priv.guochun.psmc.authentication.user.model.TabAccount)) return false;
		else {
			priv.guochun.psmc.authentication.user.model.TabAccount tabAccount = (priv.guochun.psmc.authentication.user.model.TabAccount) obj;
			if (null == this.getUuid() || null == tabAccount.getUuid()) return false;
			else return (this.getUuid().equals(tabAccount.getUuid()));
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