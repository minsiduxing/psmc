package priv.guochun.psmc.website.backstage.news.model;

import java.io.Serializable;

public class NewsImage implements Serializable {
	private static final long serialVersionUID = 5606315649994369820L;
	/**
	 * 新文件名
	 */
	private String newName;
	/**
	 * 源文件名
	 */
	private String oldName;
	/**
	 * 上传之后的临时图片宽度
	 */
	private int imgWidth;
	/**
	 * 上传之后的临时图片高度
	 */
	private int imgHeight;
	/**
	 * 新闻图片宽度
	 */
	private int newsPicWidth;
	/**
	 * 新闻图片高度
	 */
	private int newsPicHeight;
	public String getNewName() {
		return newName;
	}
	public void setNewName(String newName) {
		this.newName = newName;
	}
	public String getOldName() {
		return oldName;
	}
	public void setOldName(String oldName) {
		this.oldName = oldName;
	}
	public int getImgWidth() {
		return imgWidth;
	}
	public void setImgWidth(int imgWidth) {
		this.imgWidth = imgWidth;
	}
	public int getImgHeight() {
		return imgHeight;
	}
	public void setImgHeight(int imgHeight) {
		this.imgHeight = imgHeight;
	}
	public int getNewsPicWidth() {
		return newsPicWidth;
	}
	public void setNewsPicWidth(int newsPicWidth) {
		this.newsPicWidth = newsPicWidth;
	}
	public int getNewsPicHeight() {
		return newsPicHeight;
	}
	public void setNewsPicHeight(int newsPicHeight) {
		this.newsPicHeight = newsPicHeight;
	}
	

}
