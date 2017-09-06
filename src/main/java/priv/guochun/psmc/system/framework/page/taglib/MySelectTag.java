package priv.guochun.psmc.system.framework.page.taglib;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import priv.guochun.psmc.system.exception.PsmcBuisnessException;

public class MySelectTag extends TagSupport
{
    private static final long serialVersionUID = 1L;  
    
    private static final Logger logger = LoggerFactory.getLogger(MySelectTag.class.getName());
    
    private  final static String ERROR_MESSAGE="select控件的参数keyid、keyname、list为空,无法绘制控件.";
    
    //控件id name
    private String keyid="";
    private String keyname="";
    
    private String value="";
    
    private boolean defaultOption=false;
    
    //数据集合
    private List list = null;
    
    @Override  
    public int doStartTag() throws JspException {  
    	
        
    	HttpServletRequest request = (HttpServletRequest)this.pageContext.getRequest();  
        JspWriter out = this.pageContext.getOut();  
        try {
        	
        	if(StringUtils.isBlank(keyid) || StringUtils.isBlank(keyname) || list == null ||list.size()<=0){
        		out.println(ERROR_MESSAGE);
        		return super.doStartTag();  
        	}
        	StringBuffer outSb = new StringBuffer();
        	outSb.append("<select class=\"\" id=\""+keyid+"\" name=\""+keyname+"\"> ");
        	
        	if(defaultOption){
        		outSb.append("<option "+("".equals(value)?"selected":"")+" value=\"\">请选择</option> ");
        	}

        	for(int i=0;i<list.size();i++) {
        		Map map = (Map)list.get(i);
        		String id = map.get("ID")!=null?map.get("ID").toString():"";
        		String name = map.get("NAME")!=null?map.get("NAME").toString():"";
        		outSb.append("<option  "+(id.equals(value)?"selected":"")+" value=\""+id+"\">"+name+"</option> ");
        	}
        		
        	outSb.append("</select> ");
        	out.println(outSb.toString());
        
        } catch (IOException e) {  
            logger.warn(e.getMessage());
            throw new PsmcBuisnessException(e);  
        }  
        return super.doStartTag();  
    }

	public String getKeyid() {
		return keyid;
	}

	public void setKeyid(String keyid) {
		this.keyid = keyid;
	}

	public String getKeyname() {
		return keyname;
	}

	public void setKeyname(String keyname) {
		this.keyname = keyname;
	}

	

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isDefaultOption() {
		return defaultOption;
	}

	public void setDefaultOption(boolean defaultOption) {
		this.defaultOption = defaultOption;
	}

	
    
  
    
    
    
    
}
