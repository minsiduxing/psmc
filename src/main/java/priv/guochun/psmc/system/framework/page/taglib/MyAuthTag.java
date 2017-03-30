package priv.guochun.psmc.system.framework.page.taglib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringUtils;

import priv.guochun.psmc.authentication.auth.PsmcAuthentication;
import priv.guochun.psmc.authentication.login.model.User;

public class MyAuthTag extends TagSupport
{
    private static final long serialVersionUID = 1L;  
    
    private String operateNo;
    
    
    @Override  
    public int doStartTag() throws JspException {  
        //JspWriter out = this.pageContext.getOut();  
        HttpServletRequest request =(HttpServletRequest)pageContext.getRequest();
        HttpSession session  = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user == null || StringUtils.isBlank(operateNo)){
            //表示…之间的内容被忽略 
            return Tag.SKIP_BODY;
        }else{
            boolean isAuth = PsmcAuthentication.authentication(user.getRoleUuid(), operateNo);
            if(isAuth)
                return Tag.EVAL_BODY_INCLUDE;
            else
                return Tag.SKIP_BODY;
        }
    }


    public String getOperateNo()
    {
        return operateNo;
    }


    public void setOperateNo(String operateNo)
    {
        this.operateNo = operateNo;
    }
    
    
    
    
}
