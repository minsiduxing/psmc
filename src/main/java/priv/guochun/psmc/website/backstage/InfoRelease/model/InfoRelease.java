package priv.guochun.psmc.website.backstage.InfoRelease.model;

import java.io.Serializable;
import java.sql.Timestamp;

import priv.guochun.psmc.website.backstage.module.model.TabModule;

/**
 * <p>Title:信息发布实体类 </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright ICSS(c) 2017</p>
 * @version 1.0
 * @history:
 * Created by wangtao 2018年5月14日
 */
public class InfoRelease extends TabModule implements Serializable{

	private static final long serialVersionUID = 8275476533223527027L;
	/**
	 * 新闻标示
	 */
	private String newsUuid;
	/**
	 * 新闻标题
	 */
	private String newsTitle;
	/**
	 * 新闻副标题
	 */
	private String newSubTitle;
	/**
	 * 新闻内容
	 */
	private String newsContent;
	/**
	 * 新闻概要
	 */
	private String newsAbstarct;
	/**
	 * 新闻时间
	 */
	private Timestamp newsDate;
	/**
	 * 新闻作者
	 */
	private String newAutor;
	/**
	 * 新闻缩略图地址
	 */
	private String thumbnailImageUrl;
	
	/**
	 * 新闻配图（移动端展示用）
	 */
	private String imagePath;
	
	/**
     * 是否自定义配图
     */
    private Integer isCustom;
	
	public InfoRelease(String newsUuid, String newsTitle,
			String newSubTitle, String newsContent, String newsAbstarct,
			Timestamp newsDate, String newAutor, String thumbnailImageUrl, String imagepath,Integer isCustom) {
		this.newsUuid = newsUuid;
		this.newsTitle = newsTitle;
		this.newSubTitle = newSubTitle;
		this.newsContent = newsContent;
		this.newsAbstarct = newsAbstarct;
		this.newsDate = newsDate;
		this.newAutor = newAutor;
		this.thumbnailImageUrl = thumbnailImageUrl;
		this.imagePath = imagePath;
		this.isCustom = isCustom;
	}
	public InfoRelease() {
	}
	public String getNewsUuid() {
		return newsUuid;
	}
	public void setNewsUuid(String newsUuid) {
		this.newsUuid = newsUuid;
	}
	public String getNewsTitle() {
		return newsTitle;
	}
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
	public String getNewSubTitle() {
		return newSubTitle;
	}
	public void setNewSubTitle(String newSubTitle) {
		this.newSubTitle = newSubTitle;
	}
	public String getNewsContent() {
		return newsContent;
	}
	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}
	public String getNewsAbstarct() {
		return newsAbstarct;
	}
	public void setNewsAbstarct(String newsAbstarct) {
		this.newsAbstarct = newsAbstarct;
	}
	public Timestamp getNewsDate() {
		return newsDate;
	}
	public void setNewsDate(Timestamp newsDate) {
		this.newsDate = newsDate;
	}
	public String getNewAutor() {
		return newAutor;
	}
	public void setNewAutor(String newAutor) {
		this.newAutor = newAutor;
	}
	public String getThumbnailImageUrl() {
		return thumbnailImageUrl;
	}
	public void setThumbnailImageUrl(String thumbnailImageUrl) {
		this.thumbnailImageUrl = thumbnailImageUrl;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public Integer getIsCustom() {
		return isCustom;
	}
	public void setIsCustom(Integer isCustom) {
		this.isCustom = isCustom;
	}
	@Override
	public String toString() {
		return "InfoRelease [newsUuid=" + newsUuid + ", newsTitle=" + newsTitle + ", newSubTitle=" + newSubTitle
				+ ", newsContent=" + newsContent + ", newsAbstarct=" + newsAbstarct + ", newsDate=" + newsDate
				+ ", newAutor=" + newAutor + ", thumbnailImageUrl=" + thumbnailImageUrl + ", imagePath=" + imagePath
				+ ", isCustom=" + isCustom + "]";
	}
	
}
