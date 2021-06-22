package priv.guochun.psmc.website.backstage.common;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.RequestBody;

import priv.guochun.psmc.website.backstage.report.model.TabReport;
import priv.guochun.psmc.website.backstage.topics.model.TabComment;
import priv.guochun.psmc.website.backstage.topics.model.TabTopics;

/**
 * 工会订阅号后台服务接口
 * @author guochun
 *
 */
@Path("/weChatService")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public interface ChjghWeChatService {

	
	/**
	 * 生成验证码
	 * @param type 验证码类型：登录、注册、。。。。
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
	public String register(@FormParam("name") String name,@FormParam("phone") String phone,@FormParam("code") String code, @FormParam("idCard") String idCard);
	
	
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
	public String infoDetail(@FormParam("uuid") String uuid,@FormParam("oneLevelClassify") String oneLevelClassify,@FormParam("twoLevelClassify") String twoLevelClassify);
	
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
	/**
	 * 查询申报列表
	 * @param page 分页信息
	 * @return
	 */
	@Path("/report_list/{pageSize}/{pageIndex}")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public String getReportListInfo(@PathParam("pageSize") String pageSize,
									@PathParam("pageIndex") String pageIndex,
									@QueryParam("queryParameter") String queryParameter,
									@QueryParam("reportType")String reportType,
									@QueryParam("reportUserUuid")String reportUserUuid


	);
	/**
	 * 查询申报明细
	 * @param reportUUid 查询参数
	 * @param personUuid
	 * @return
	 */
	@Path("/report_detail")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public String getReportInfoDetail(@QueryParam("reportUUid")String reportUUid, @QueryParam("personUuid")String personUuid);
	/**
	 * 新增申报信息
	 * @param report 新增的申报信息
	 * @return
	 */
	@Path("/report_add")
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	public String addReport(@RequestBody TabReport report);
	
	/**
	 * 查询部门列表
	 * @param pageJson 查询参数
	 * @return
	 */
	@Path("/getDeptList")
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	public String getDeptList(String pageJson) ;
	
	/**
	 * 获取部门详情
	 * @param deptUuid
	 * @return
	 */
	@Path("/deptDetail")
    @POST
	@Consumes("application/x-www-form-urlencoded")
	public String deptDetail(@FormParam("deptUuid") String deptUuid);
	
	/**
	 * 新增主题信息
	 * @param tabTopics 主题信息实体类
	 * @return
	 */
	@Path("/addTopics")
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	public String addTopics(@RequestBody TabTopics tabTopics);
	
	/**
	 * 查询主题信息列表
	 * @param pageJson 查询参数
	 * @return
	 */
	@Path("/queryTopicsList")
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	public String queryTopicsList(String pageJson);
	
	/**
	 * 查询主题详情以及对应的评论列表
	 * @param topicUuid 主题id
	 * @param personUuid 人员id
	 * @return
	 */
	@Path("/topicsDetail")
	@POST
	@Consumes("application/x-www-form-urlencoded")
	public String topicsDetail(@FormParam("topicUuid") String topicUuid, @FormParam("personUuid") String personUuid);
	
	/**
	 * 查询评论列表
	 * @param pageJson
	 * @return
	 */
	@Path("/commentList")
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	public String commentList(String pageJson);

	/**
	 * 新增评论信息
	 * @param tabComment 评论信息实体类
	 * @return
	 */
	@Path("/addTabComment")
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	public String addTabComment(@RequestBody TabComment tabComment);
	
	/**
	 * 删除评论信息
	 * @param commentUuid
	 * @return
	 */
	@Path("/deleteComment")
    @POST
	@Consumes("application/x-www-form-urlencoded")
	public String deleteComment(@FormParam("commentUuid") String commentUuid);
	
	/**
	 * 点赞
	 * @param moduleUuid 信息模型id
	 * @param personUuid 人员id
	 * @return
	 */
	@Path("/addLaud")
	@POST
	@Consumes("application/x-www-form-urlencoded")
	public String addLaud(@FormParam("moduleUuid") String moduleUuid, @FormParam("personUuid") String personUuid);
	
	/**
	 * 取消点赞
	 * @param moduleUuid 信息模型id
	 * @param personUuid 人员id
	 * @return
	 */
	@Path("/cancelLaud")
	@POST
	@Consumes("application/x-www-form-urlencoded")
	public String cancelLaud(@FormParam("moduleUuid") String moduleUuid, @FormParam("personUuid") String personUuid);
	
	/**
	 * 查询功能提示信息
	 * @param functionCode
	 * @return
	 */
	@Path("/getExplainbyCode")
	@POST
	@Consumes("application/x-www-form-urlencoded")
	public String getExplainbyCode(@FormParam("functionCode") String functionCode);
	
	/**
	 * 删除主题信息
	 * @param topicUuid
	 * @return
	 */
	@Path("/deleteTopic")
	@POST
	@Consumes("application/x-www-form-urlencoded")
	public String deleteTopic(@FormParam("topicUuid") String topicUuid);
	
	/**
	 * 删除上报信息信息
	 * @param reportUuid
	 * @return
	 */
	@Path("/deleteReport")
	@POST
	@Consumes("application/x-www-form-urlencoded")
	public String deleteReport(@FormParam("reportUuid") String reportUuid);
}
