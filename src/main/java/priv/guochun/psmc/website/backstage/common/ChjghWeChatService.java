package priv.guochun.psmc.website.backstage.common;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import priv.guochun.psmc.system.framework.page.MyPage;

@Path("/weChatService")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public interface ChjghWeChatService {

	
	/**
	 * 生成验证码
	 * @param type
	 * @return
	 */
	@Path("/getVcode")//某个方法的操作的资源
    @GET
    @Produces({MediaType.APPLICATION_JSON})
	public String createVcode(@QueryParam("type") int type,@QueryParam("phone") String phone);
	
	/**
	 * 用户登录
	 * @param phone 手机号
	 * @param code 手机验证码
	 * @return
	 */
	@Path("/login")//某个方法的操作的资源
    @GET
    @Produces({MediaType.APPLICATION_JSON})
	public String login(@QueryParam("phone") String phone,@QueryParam("code") String code);
	
	
	/**
	 * 用户注册
	 * @param name
	 * @param phone
	 * @param code
	 * @return
	 */
	@Path("/register")//某个方法的操作的资源
    @POST
	@Consumes("application/x-www-form-urlencoded")
	public String register(@FormParam("name") String name,@FormParam("phone") String phone,@FormParam("code") String code);
	
	
	/**
	 * 获取日常工作信息列表(工作管理、法条维护、工作发布、早知道列表均使用此接口)
	 * @param infoType 信息一级分类
	 * @param queryParameter 查询参数
	 * @param page 分页信息
	 * @return
	 */
	public String getInfoList(String infoType, String queryParameter, MyPage page);
	
	/**
	 * 获取日常工作详细信息（工作管理、法条维护、工作发布、早知道详细信息均使用此接口）
	 * @param newsUuid 信息主键
	 * @return
	 */
	public String getDetailInfo(String newsUuid);
	
	/**
	 * 获取优秀创新列表
	 * @param queryParameter 查询参数
	 * @param page 分页信息
	 * @return
	 */
	public String getInnovationList(String queryParameter, MyPage page);
	
	/**
	 * 获取优秀创新详细信息
	 * @param innovationUuid 优秀创新信息主键
	 * @return
	 */
	public String getDetailInnovation(String innovationUuid);
	
	/**
	 * 查询活动列表
	 * @param queryParameter 查询参数
	 * @param page 分页信息
	 * @return
	 */
	public String getActivityList(String queryParameter, MyPage page);
	
	/**
	 * 查看活动详情
	 * @param activityUuid 活动id
	 * @param phone 用户手机号（账号）
	 * @return
	 */
	public String getActivityDetail(String activityUuid, String phone);
	
	/**
	 * 报名
	 * @param activityUuid 活动ID
	 * @param phone 用户手机号（账号）
	 * @return
	 */
	public String signUp(String activityUuid, String phone);
	
	/**
	 * 取消报名
	 * @param activityUuid 活动ID
	 * @param phone 用户手机号（账号）
	 * @return
	 */
	public String cancelSignUp(String activityUuid, String phone);
	
	/**
	 * 获取报名人员列表
	 * @param activityUuid 活动ID
	 * @return
	 */
	public String getSignUpList(String activityUuid);

}
