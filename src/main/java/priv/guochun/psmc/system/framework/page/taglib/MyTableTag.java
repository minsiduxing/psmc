package priv.guochun.psmc.system.framework.page.taglib;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import priv.guochun.psmc.system.framework.page.MyPage;

public class MyTableTag extends TagSupport
{
    private static final long serialVersionUID = 1L;  
    
    private static final Logger logger = LoggerFactory.getLogger(MyPageTag.class.getName());
    
    private String url;
    
    private String id;
    
    private MyPage myPage;
    
    
    
    @Override  
    public int doStartTag() throws JspException {  
        JspWriter out = this.pageContext.getOut();  
        try{
            if(myPage == null ||myPage.getTableColumns() == null || myPage.getTableTitles() == null
                    || myPage.getDataList() == null || StringUtils.isBlank(url) ){
                out.print("table组件参数数据缺失....请核查");
            }
            
            StringBuffer sb1 = new StringBuffer();
            sb1.append("<table id=\""+id+"\" class=\"table ui-border \">");
            sb1.append(this.createTableThead());
            sb1.append(this.createTableBody());
            sb1.append(this.createTableFoot());
            sb1.append("</table>");
            logger.debug("create table over "+sb1.toString());
            
            out.print(sb1.toString());
           
        }catch (IOException e) {
            e.printStackTrace();
            logger.warn(e.getMessage());
        }
        return super.doStartTag();  
    }

    private String createTableThead(){
        StringBuffer sb1 = new StringBuffer();
        sb1.append("<thead><tr>");
        String[] titles = myPage.getTableTitles();
                sb1.append("<th>序号</th>");
            for(int i=0;i<titles.length;i++){
                sb1.append("<th>"+titles[i]+"</th>");
            }
        sb1.append("</tr></thead>");
        logger.debug("create thead  "+sb1.toString());
        return sb1.toString();
    }
    
    private String createTableBody(){
        StringBuffer sb1 = new StringBuffer();
        sb1.append("<tbody>");
        List dataList = myPage.getDataList();
        for(int i=0;i<dataList.size();i++){
            Map map = (Map)dataList.get(i);
            sb1.append("</tr>");
            String[] columns = myPage.getTableColumns();
            sb1.append("<td>"+map.get("index_id").toString()+"</td>");
            for(int x=0;x<columns.length;x++){
                sb1.append("<td class=\"td\">");
                    if(map.containsKey(columns[x])){
                        sb1.append(map.get(columns[x])!=null?map.get(columns[x]).toString():"");
                    }
                sb1.append("</td>");
            }
            sb1.append("</tr>");
        }
        sb1.append("</tbody>");
        logger.debug("create tbody  "+sb1.toString());
        return sb1.toString();
    }
    

    private String createTableFoot(){
        
        StringBuffer sb1 = new StringBuffer();
        int colspans = myPage.getTableTitles().length+1;
        sb1.append("<tfoot><td colspan=\""+colspans+"\">");
    
        sb1.append("当前第["+myPage.getPageIndex()+"]页,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
        
        sb1.append(getFirstassembly());
        sb1.append(getLastassembly());
        sb1.append(getNextassembly());
        sb1.append(getEndassembly());
     
        sb1.append("共["+myPage.getTotalPage()+"]页,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
        sb1.append("数据总共["+myPage.getTotalData()+"]条,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
        sb1.append("还剩余["+myPage.getSurplusData()+"]条&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
        
        sb1.append("</td></tfoot>");
        logger.debug("create tfoot  "+sb1.toString());
        return sb1.toString();
    }


    
    private String getFirstassembly()
    {
        if(myPage.getPageIndex()>1){
            
            String nextUrl = this.pageContext.getServletContext().getContextPath()+url+"&pageIndex=1"+
                    "&pageSize="+myPage.getPageSize();
           
            String str = "<input type=\"button\" class=\"button\"  value=\"首页\"   onclick=\"window.location.href='"+nextUrl+"'\" /> &nbsp;&nbsp;";
            return str;
        }
        return "";
    }
    
    private String getNextassembly()
    {
        if(myPage.getPageIndex()<myPage.getTotalPage()){
            
            String nextUrl = this.pageContext.getServletContext().getContextPath()+url+"&pageIndex="+(myPage.getPageIndex()+1)+
                    "&pageSize="+myPage.getPageSize();
           
            String str = "<input type=\"button\" class=\"button\"  value=\"下一页\"   onclick=\"window.location.href='"+nextUrl+"'\" /> &nbsp;&nbsp;";
            return str;
        }
        return "";
    }
    
    private String getLastassembly()
    {
        if(myPage.getPageIndex()>1){
            
            String lastUrl = this.pageContext.getServletContext().getContextPath()+url+"&pageIndex="+(myPage.getPageIndex()-1)+
                    "&pageSize="+myPage.getPageSize();
           
            String str = "<input type=\"button\" class=\"button\"  value=\"上一页\"   onclick=\"window.location.href='"+lastUrl+"'\" /> &nbsp;&nbsp;";
            return str;
        }
        return "";
    }
    
    private String getEndassembly()
    {
        if(myPage.getPageIndex()<myPage.getTotalPage()){
            
            String nextUrl = this.pageContext.getServletContext().getContextPath()+url+"&pageIndex="+myPage.getTotalPage()+
                    "&pageSize="+myPage.getPageSize();
           
            String str = "<input type=\"button\" class=\"button\"  value=\"尾页\"   onclick=\"window.location.href='"+nextUrl+"'\" /> &nbsp;&nbsp;";
            return str;
        }
        return "";
    }


    public void setUrl(String url)
    {
        this.url = url;
    }

    public void setMyPage(MyPage myPage)
    {
        this.myPage = myPage;
    }

    public void setId(String id)
    {
        this.id = id;
    }
    
    
    
    
}
