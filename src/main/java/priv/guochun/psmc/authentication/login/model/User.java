package priv.guochun.psmc.authentication.login.model;

import java.util.List;
import java.util.Map;

public class User
{
  
    private Map tabAccount;
    private Map tabPerson;
    private Map tabRole;
    private List operateList;
    
    
    private String accountName;
    
    private String personName;
    private String personTelephone;
    private String personEmail;
    private String personCityId;
    
    private String roleUuid;
    private String roleNo;
    private String roleName;
    
    
    public User(Map tabAccount,Map tabPerson,Map tabRole,List operateList){
    	this.tabAccount = tabAccount;
    	this.tabPerson = tabPerson;
    	this.tabRole = tabRole;
    	this.operateList = operateList;
    	
    	
    	accountName = tabAccount.get("ACCOUNT_NAME").toString();
    	
    	personName = tabPerson.get("PERSON_NAME").toString();
    	personTelephone = tabPerson.get("TELEPHONE").toString();
    	personEmail = tabPerson.get("EMAIL")!=null?
    					tabPerson.get("EMAIL").toString():"";
    	personCityId = tabPerson.get("cityId").toString();

    	roleUuid = tabRole.get("UUID").toString();
    	roleNo = tabRole.get("ROLE_NO").toString();
    	roleName = tabRole.get("ROLE_NAME").toString();
    		
    }


	public String getAccountName() {
		return accountName;
	}


	public String getPersonName() {
		return personName;
	}


	public String getPersonTelephone() {
		return personTelephone;
	}


	public String getPersonEmail() {
		return personEmail;
	}


	public String getPersonCityId() {
		return personCityId;
	}


	public String getRoleUuid() {
		return roleUuid;
	}


	public String getRoleNo() {
		return roleNo;
	}


	public String getRoleName() {
		return roleName;
	}


    public List getOperateList()
    {
        return operateList;
    }


    public void setOperateList(List operateList)
    {
        this.operateList = operateList;
    }

    


	

	

    
    
    
}
