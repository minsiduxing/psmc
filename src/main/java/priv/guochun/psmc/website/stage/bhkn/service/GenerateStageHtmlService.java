package priv.guochun.psmc.website.stage.bhkn.service;

/**
 *生成网站前台页面的service
 *
 */
public interface GenerateStageHtmlService {
	/**
	 * 生成网站头部导航栏
	 */
	public void generateHeadHtml();
	/**
	 * 生成首页
	 */
	public void generateIndexHtml();
	/**
	 * 生成行情资讯
	 */
	public void generateInofHtml();
	/**
	 * <p>Description:生成会员信息页面<p>
	 * @author wanglei 2017年11月8日
	 */
	public void generateMemberInofHtml();
	/**
	 * 生成产品列表
	 */
	public void generateProductlistHtml();
	/**
	 * 生成关于我们
	 */
	public void generateAboutUsHtml();
	/**
	 * 生成选择我们
	 */
	public void generateChooseUsHtml();
	/**
	 * 生成团队展示
	 */
	public void generateTeamShowHtml();
	/**
	 * 生成页脚
	 */
	public void generateFooterHtml();
	/**
	 * 生成除首页外其他页面
	 */
	public void genetateOtherStageHtmls();
	/**
	 * 生成全部页面
	 */
	public void genetateAllStageHtmls();
}
