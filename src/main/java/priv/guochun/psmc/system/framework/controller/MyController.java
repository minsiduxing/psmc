package priv.guochun.psmc.system.framework.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.servlet.View;

import priv.guochun.psmc.authentication.login.model.User;
import priv.guochun.psmc.system.framework.excel.CreateExcelDataFileFactory;
import priv.guochun.psmc.system.framework.myspringview.DownloadByFileView;
import priv.guochun.psmc.system.framework.myspringview.DownloadByURLView;
import priv.guochun.psmc.system.framework.util.ReturnModel;


public class MyController
{

	private String[] titles;
	private String[] columns;
	private List<?> exportList;
	private String fileName;
	
	/**
	 * 获取保存在session里的登录人信息
	 * @param request
	 * @return
	 */
	protected User getUserBySeesion(HttpServletRequest request){
		HttpSession seesion = request.getSession();
		Object obj = seesion.getAttribute("user");
		return (User)obj;
	}
	
	/**
	 * 生成excel文件给客户端下载
	 * @param response
	 * @return
	 * @throws IOException
	 */
	protected View responseExcelFile(HttpServletResponse response) throws IOException{
		File file = CreateExcelDataFileFactory.CreateExcelDataFileClass().getExcelFile
		(fileName, exportList, columns, titles);
		return responseFile(file,fileName,response);
	}
	
	/**
	 * 生成文件给客户端下载
	 * @param file
	 * @param exportFileName 文件下载名称
	 * @param response
	 * @return
	 * @throws IOException
	 */
	protected View responseFile(File file,String exportFileName,HttpServletResponse response) throws IOException{
			return new DownloadByFileView(file,exportFileName);
	}
	
	/**
	 * 生成文件给客户端下载
	 * @param url 文件地址
	 * @param exportFileName 文件下载名称
	 * @param response
	 * @return
	 * @throws IOException
	 */
	protected View responseFile(URL url,String exportFileName,HttpServletResponse response) throws IOException{
		return new DownloadByURLView(url,exportFileName);
	}
	
	/**
	 * 返回一个包装好的json对象给前端{res:success/error,rmsg:rmsg}
	 * @param result
	 * @param rmsg
	 * @param response
	 * @throws IOException
	 */
	protected void responseJson(Boolean result,String rmsg,HttpServletResponse response) throws IOException{
		if(result)
			responseSuccessJson(rmsg,response);
		else
			responseFailJson(rmsg,response);
	}
	
	/**
	 * 返回一个包装好的json对象给前端{res:success,rmsg:rmsg}
	 * @param rvalue 返回业务值 
	 * @param rmsg	  返回描述
	 * @param response
	 * @throws IOException
	 */
	
	private void responseSuccessJson(String rmsg,HttpServletResponse response) throws IOException{
        JSONObject jo = ReturnModel.createSuccessJSONObject(rmsg);
        this.responseJson(jo, response);
    }
	
	/**
	 * 返回一个包装好的json对象给前端{res:fail,rvalue:rvalue,rmsg:rmsg}
	 * @param rvalue 返回业务值 
	 * @param rmsg	  返回描述
	 * @param response
	 * @throws IOException
	 */
	private void responseFailJson(String rmsg,HttpServletResponse response) throws IOException{
		JSONObject jo = ReturnModel.createFailJSONObject(rmsg);
        this.responseJson(jo, response);
    }
	
	
	/**
	 * 生成json串给前端
	 * @param jo
	 * @param response
	 * @throws IOException
	 */
    protected void responseJson(JSONObject jo,HttpServletResponse response) throws IOException{
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");  
        PrintWriter pw =  response.getWriter();
        pw.append(jo.toString());
        pw.close();
    }
    /**
	 * 生成json串给前端
	 * @param jo
	 * @param response
	 * @throws IOException
	 */
    protected void responseJson(JSONArray jo,HttpServletResponse response) throws IOException{
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");  
        PrintWriter pw =  response.getWriter();
        pw.append(jo.toString());
        pw.close();
    }
    /**
     * 生成字符串给前端
     * @param htmlText
     * @param response
     * @throws IOException
     */
    protected void responseHtmltext(String htmlText,HttpServletResponse response) throws IOException{
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");  
        PrintWriter pw =  response.getWriter();
        pw.append(htmlText);
        pw.close();
    }
    
    /**
     * forward跳转
     * @param path 目标路径
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void forward(String path,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");  
        request.getRequestDispatcher(path).forward(request, response);
    }
    
    /**
     * 重定向
     * @param path 目标地址
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void redirect(String path,HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");  
        response.sendRedirect(path);
    }

	public String[] getTitles() {
		return titles;
	}

	public void setTitles(String[] titles) {
		this.titles = titles;
	}

	public String[] getColumns() {
		return columns;
	}

	public void setColumns(String[] columns) {
		this.columns = columns;
	}

	public List<?> getExportList() {
		return exportList;
	}

	public void setExportList(List<?> exportList) {
		this.exportList = exportList;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
    

    
}
