package priv.guochun.psmc.website.backstage.common;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.RequestBody;

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
	 * @param pageJson 查询参数
	 * @return
	 */
	@Path("/getInfoList")
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	public String getInfoList(String pageJson);
	
	/**
	 * 获取日常工作详细信息（工作管理、法条维护、工作发布、早知道详细信息均使用此接口）
	 * @param newsUuid 信息主键
	 * @return
	 */
	@Path("/getDetailInfo")
    @POST
	@Consumes("application/x-www-form-urlencoded")
	public String infoDetail(@FormParam("uuid") String uuid);
	
	/**
	 * 获取优秀创新列表
	 * @param pageJson 查询参数
	 * @return
	 */
	@Path("/getInnovationList")
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	public String getInnovationList(String pageJson);
	
	/**
	 * 获取优秀创新详细信息
	 * @param innovationUuid 优秀创新信息主键
	 * @return
	 */
	@Path("/getDetailInnovation")
    @POST
	@Consumes("application/x-www-form-urlencoded")
	public String innovationDetail(@FormParam("innovationUuid") String innovationUuid);
	
	/**
	 * 查询活动列表
	 * @param pageJson 查询参数
	 * @return
	 */
	@Path("/getActivityList")
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	public String getActivityList(String pageJson);
	
	/**
	 * 查看活动详情
	 * @param activityUuid 活动id
	 * @param phone 用户手机号（账号）
	 * @return
	 */
	@Path("/getActivityDetail")
    @POST
	@Consumes("application/x-www-form-urlencoded")
	public String activityDetail(@FormParam("activityUuid") String activityUuid, @FormParam("phone") String phone);
	
	/**
	 * 报名
	 * @param activityUuid 活动ID
	 * @param phone 用户手机号（账号）
	 * @return
	 */
	@Path("/signUp")
    @POST
	@Consumes("application/x-www-form-urlencoded")
	public String signUp(@FormParam("activityUuid") String activityUuid,@FormParam("phone") String phone);
	
	/**
	 * 取消报名
	 * @param activityUuid 活动ID
	 * @param phone 用户手机号（账号）
	 * @return
	 */
	@Path("/cancelSignUp")
    @POST
	@Consumes("application/x-www-form-urlencoded")
	public String cancelSignUp(@FormParam("activityUuid") String activityUuid,@FormParam("phone") String phone);
	
	/**
	 * 获取报名人员列表
	 * @param activityUuid 活动ID
	 * @return
	 */
	@Path("/getSignUpList")
    @POST
	@Consumes("application/x-www-form-urlencoded")
	public String getSignUpList(@FormParam("activityUuid") String activityUuid);

}
