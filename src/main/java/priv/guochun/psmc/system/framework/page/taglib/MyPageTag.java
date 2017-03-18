package priv.guochun.psmc.system.framework.page.taglib;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import priv.guochun.psmc.system.framework.page.MyPage;

public class MyPageTag extends TagSupport
{
    private static final long serialVersionUID = 1L;  
    
    private static final Logger logger = LoggerFactory.getLogger(MyPageTag.class.getName());
    
    private  final static String NO_EXITS_ERROR="分页组件无法从缓存中获取[mypage]对象......";
    
    private String url;
    
    private String paramUrl;
    
    private MyPage myPage;
    

    private void processPageRequestURL(){
        
        HttpServletRequest request =(HttpServletRequest)pageContext.getRequest();
        Enumeration<String> em = request.getParameterNames();
        StringBuffer paramUrl = new StringBuffer();
        int indexflag =0;
        while(em.hasMoreElements()){
            String paramName = em.nextElement();
            String paramValue = request.getParameter(paramName);
            if(!"".equals(paramValue)){
                if(!"pageIndex".equals(paramName) 
                        && !"pageSize".equals(paramName)
                        ){
                    if(indexflag ==0){
                        paramUrl.append("?"+paramName+"="+paramValue);
                    }else{
                        paramUrl.append("&"+paramName+"="+paramValue);
                    }
                    indexflag++;
                }
            }
        }
        this.paramUrl = paramUrl.toString();
        this.url = this.myPage.getRequestUrl() +this.paramUrl;
        logger.debug("process paramUrl : "+this.paramUrl);
        logger.debug("process url : "+this.url);
    }
    @Override  
    public int doStartTag() throws JspException {  
        
        JspWriter out = this.pageContext.getOut();  
       
        processPageRequestURL();
   
        try {
            if(myPage == null){
                out.print(NO_EXITS_ERROR);  
            }else{
                    MyPage page = myPage;
                    StringBuffer sb1 = new StringBuffer();
                    sb1.append("当前第["+page.getPageIndex()+"]页,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                    
                    sb1.append(getFirstassembly(page));
                    sb1.append(getLastassembly(page));
                    sb1.append(getNextassembly(page));
                    sb1.append(getEndassembly(page));
                    
                    sb1.append("共["+page.getTotalPage()+"]页,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                    sb1.append("数据总共["+page.getTotalData()+"]条,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                    //sb1.append("还剩余["+page.getSurplusData()+"]条&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                    //改变行数
                    sb1.append(changePageSize(page));
                    
                    out.print(sb1.toString());  
            }
            
        } catch (IOException e) {  
            logger.warn(e.getMessage());
            throw new RuntimeException(e);  
        }  
        return super.doStartTag();  
    }
    
    private String getFirstassembly(MyPage page)
    {
        if(page.getPageIndex()>1){
            
            String nextUrl = this.url+"&pageIndex=1"+
                    "&pageSize="+page.getPageSize();
           
            String str = "<input type=\"button\" class=\"button\"  value=\"首页\"   onclick=\"window.location.href='"+nextUrl+"'\" /> &nbsp;&nbsp;";
            return str;
        }
        return "";
    }
    
    private String getNextassembly(MyPage page)
    {
        if(page.getPageIndex()<page.getTotalPage()){
            
            String nextUrl = this.url+"&pageIndex="+(page.getPageIndex()+1)+
                    "&pageSize="+page.getPageSize();
           
            String str = "<input type=\"button\" class=\"button\"  value=\"下一页\"   onclick=\"window.location.href='"+nextUrl+"'\" /> &nbsp;&nbsp;";
            return str;
        }
        return "";
    }
    
    private String getLastassembly(MyPage page)
    {
        if(page.getPageIndex()>1){
            
            String lastUrl = this.url+"&pageIndex="+(page.getPageIndex()-1)+
                    "&pageSize="+page.getPageSize();
           
            String str = "<input type=\"button\" class=\"button\"  value=\"上一页\"   onclick=\"window.location.href='"+lastUrl+"'\" /> &nbsp;&nbsp;";
            return str;
        }
        return "";
    }
    
    private String getEndassembly(MyPage page)
    {
        if(page.getPageIndex()<page.getTotalPage()){
            
            String nextUrl = this.url+"&pageIndex="+page.getTotalPage()+
                    "&pageSize="+page.getPageSize();
           
            String str = "<input type=\"button\" class=\"button\"  value=\"尾页\"   onclick=\"window.location.href='"+nextUrl+"'\" /> &nbsp;&nbsp;";
            return str;
        }
        return "";
    }
    
    private String changePageSize(MyPage page)
    {
        String changeUrl = this.url+"&pageIndex=1"+"&pageSize=";
      //  if(page.getPageIndex()>1){
            StringBuffer sb1 = new StringBuffer();
            sb1.append("<script type=\"text/javascript\">function changePage(id){");
            sb1.append(" window.location.href='"+changeUrl+"'+id ");
            sb1.append(" }</script> ");
            sb1.append("<select onchange=\"changePage(this.value)\"> ");
            sb1.append("<option value=10"+(page.getPageSize()==10?" selected":" ")+">10</option>");
            sb1.append("<option value=20"+(page.getPageSize()==20?" selected":" ")+">20</option>");
            sb1.append("<option value=50"+(page.getPageSize()==50?" selected":" ")+">50</option>");
            sb1.append("<option value=100"+(page.getPageSize()==100?" selected":" ")+">100</option>");
            sb1.append("<option value=200"+(page.getPageSize()==200?" selected":" ")+">200</option>");
            sb1.append("</select>");
            return "每页显示"+sb1.toString()+"行";
     //   }
    //    return "";
        
       
    }
    public MyPage getMyPage()
    {
        return myPage;
    }
    public void setMyPage(MyPage myPage)
    {
        this.myPage = myPage;
    }
    
    
}
