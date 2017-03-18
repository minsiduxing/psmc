package priv.guochun.psmc.authentication.operate.model;

import priv.guochun.psmc.authentication.operate.model.base.BaseTabRoleOperate;



public class TabRoleOperate extends BaseTabRoleOperate {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public TabRoleOperate () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TabRoleOperate (
		java.lang.String operateUuid,
		java.lang.String roleUuid) {

		super (
			operateUuid,
			roleUuid);
	}

/*[CONSTRUCTOR MARKER END]*/


}