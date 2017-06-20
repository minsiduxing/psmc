package priv.guochun.psmc.system.framework.page;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.github.pagehelper.Page;

public class MyPage implements Serializable {
    
	private static final long serialVersionUID = 1L;
	// 默认当前页面页数为第一页  
	private static final int DEFAULT_PAGE_INDEX = 1;  
	// 默认页面大小为10  
	private static final int DEFAULT_PAGE_SIZE = 10;  
	//结果集
	
	private String requestUrl;
	
	private List<?> dataList;
	
	String[] tableColumns;
	
	String[] tableTitles;
	
	// 当前页面的页数  
    private int pageIndex;  
    // 页面大小  
    private int pageSize;  
    // 数据总量  
    private int totalData = -1;  
    // 剩余数据量  
    private int surplusData;  
    // 页面总量  
    private int totalPage;  
    // 是否仅取第一页  
    private boolean firstPage;  
    // 是否可以工作。默认为false，只有设置了数据总量才为true。  
    private boolean ready = false;  
    // 查询参数
    private Map<String,Object> queryParams ;
    public MyPage(){
         init();
    	 this.pageIndex = DEFAULT_PAGE_INDEX;  
    	 this.pageSize = DEFAULT_PAGE_SIZE;  
    }
    
    public MyPage(int pageIndex, int pageSize) {  
        init();
        this.pageIndex = pageIndex > 0 ? pageIndex : DEFAULT_PAGE_INDEX;  
        this.pageSize = pageSize > 0 ? pageSize : DEFAULT_PAGE_SIZE;  
    }  
    
    
    public void init(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        this.requestUrl = request.getRequestURI();
    }
    
    public void buildMyPage(List<?> list){
    	if (list instanceof Page) {
            Page<?> page = (Page<?>) list;
            this.setTotalData((int)page.getTotal());
            this.dataList = page;
        }
    }
    
    /** 
     * 获取当前分页对象的页面范围，包含当前页面的起始行和结束行。 
     * 如果未先调用setTotalData()方法设置数据总量，则会抛出运行时异常。 
     * @return 当前分页对象的页面范围。 
     * @throws java.lang.IllegalArgumentException 异常。 
     */  
    public PageScope getPageScope() {  
        if (!ready) {  
            throw new IllegalArgumentException("Page has not seted data amount.");  
        }  
      
        //如果当前页数>总页数,返回Null
        if (this.pageIndex > this.totalPage) {  
            return null;  
        }  
      
        PageScope scope = new PageScope();  
        
        
        int startLine = (this.pageIndex - 1) * this.pageSize;  
        int endLine = startLine+this.pageSize;

        if (startLine < 0) {  
            startLine = 0;  
        }  
        if (endLine < 0) {  
            endLine = 0;  
        }  

        scope.setStartLine(startLine);  
        scope.setEndLine(endLine);  
      
        return scope;  
    }  
    
    

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalData() {
		return totalData;
	}
	

	public Map<String, Object> getQueryParams() {
		return queryParams;
	}

	public void setQueryParams(Map<String, Object> queryParams) {
		this.queryParams = queryParams;
	}

	/** 
	 * 设置数据总量。在使用时，需提前调用此方法进行设置。 
	 * 当数据总量设置好之后，会计算页面总量、修正当前页面页数、计算剩余数据量， 
	 * 并设置该分页对象已经准备好，可以正常工作。 
	 * @param totalData 数据总量。 
	 */  
	public void setTotalData(int totalData) {
		this.totalData = totalData;  
		  
	    this.totalPage = this.totalData / pageSize +  
	            (this.totalData % pageSize == 0 ? 0 : 1);  
	  
	    if (this.pageIndex > this.totalPage) {  
	        this.pageIndex = this.totalPage;  
	    }  
	   
	    this.surplusData = this.totalData - (this.pageIndex) * this.pageSize;  
	    
	    if(this.surplusData<0)
	        this.surplusData = 0;
	    this.ready = true;  
	}

	public int getSurplusData() {
		return surplusData;
	}

	public void setSurplusData(int surplusData) {
		this.surplusData = surplusData;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public boolean isFirstPage() {
		return firstPage;
	}

	public void setFirstPage(boolean firstPage) {
		this.firstPage = firstPage;
	}

	public boolean isReady() {
		return ready;
	}

	public void setReady(boolean ready) {
		this.ready = ready;
	}


    public List<?> getDataList() {
		return dataList;
	}

	public void setDataList(List<?> dataList) {
		this.dataList = dataList;
	}

	public String[] getTableColumns()
    {
        return tableColumns;
    }

    public void setTableColumns(String[] tableColumns)
    {
        this.tableColumns = tableColumns;
    }

    public String[] getTableTitles()
    {
        return tableTitles;
    }

    public void setTableTitles(String[] tableTitles)
    {
        this.tableTitles = tableTitles;
    }

    public String getRequestUrl()
    {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl)
    {
        this.requestUrl = requestUrl;
    }

	
	
    
    
}
