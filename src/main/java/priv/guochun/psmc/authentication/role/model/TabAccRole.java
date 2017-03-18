package priv.guochun.psmc.authentication.role.model;

import priv.guochun.psmc.authentication.role.model.base.BaseTabAccRole;



public class TabAccRole extends BaseTabAccRole {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public TabAccRole () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TabAccRole (
		java.lang.String accUuid,
		java.lang.String roleUuid) {

		super (
			accUuid,
			roleUuid);
	}

/*[CONSTRUCTOR MARKER END]*/


}