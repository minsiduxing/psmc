package priv.guochun.psmc.authentication.user.model;

import priv.guochun.psmc.authentication.user.model.base.BaseTabAccount;



public class TabAccount extends BaseTabAccount {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public TabAccount () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TabAccount (java.lang.String uuid) {
		super(uuid);
	}
	private String personId;
	private String roleUuid;

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

    public String getRoleUuid()
    {
        return roleUuid;
    }

    public void setRoleUuid(String roleUuid)
    {
        this.roleUuid = roleUuid;
    }
	
	

/*[CONSTRUCTOR MARKER END]*/


}