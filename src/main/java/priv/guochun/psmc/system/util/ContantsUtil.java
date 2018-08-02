package priv.guochun.psmc.system.util;


public class ContantsUtil {

    //数据字典常量
    
    public final static String DICTY_TYPE_IF = "IF";

    public final static String DICTY_TYPE_SEX = "SEX";
    
    //角色编号常量
    /**
     * 创新工作室维护人员
     */
    public final static String SYS_INNOVATE_STUDIO_MAINTAIN = "sys_innovate_studio_maintain";
    /**
     * 工会维护人员
     */
    public final static String SYS_UNION_MAINTAIN = "sys_union_maintain";
    /**
     * 文体协会维护人员
     */
    public final static String SYS_LITERARY_FORM_MAINTAIN = "sys_literary_form_maintain";
    /**
     * 后勤中心维护人员
     */
    public final static String SYS_LOGISTICS_CENTER_MAINTIAN = "sys_Logistics_center_maintain";
    
    //信息分类
    /**
     * 创新工作室-工作管理
     */
    public final static String ONE_LEVEL_CLASSIFY_11 = "11";
    /**
     * 援助帮扶-法条维护
     */
    public final static String ONE_LEVEL_CLASSIFY_12 = "12";
    /**
     * 文体协会-工作发布
     */
    public final static String ONE_LEVEL_CLASSIFY_13 = "13";
    /**
     * 后勤中心-早知道
     */
    public final static String ONE_LEVEL_CLASSIFY_14 = "14";
    
    /**
     * 部门类型
     */
    public final static String DEPT_TYPE_1 = "1"; //创新工作室
    public final static String DEPT_TYPE_2 = "2"; //文体协会
    
    //各分类的图片路径
    public final static String INNOVATION = "innovation"; //优秀创新
    public final static String ASSISTANCE = "assistance"; //援助帮扶
    public final static String LITERARY_FORM = "literaryForm"; //文体协会
    public final static String LOGISTICS_CENTER = "logisticsCenter"; //后勤中心
    public final static String DEPT_INNOVATION = "deptInnovation";//创新工作室
    public final static String DEPT_LITERARY_FORM = "deptLiteraryForm";//文体协会
    
    /**
     * 是否自定义配图
     */
    public final static Integer IS_CUSTOM_0 = 0; //否
    public final static Integer IS_CUSTOM_1 = 1; //是
    
    /**
     * 版块、话题、评论状态
     */
    public final static Integer BLOCK_STATUS_1 = 1; //正常
    public final static Integer BLOCK_STATUS_2 = 2; //暂停（屏蔽）
    public final static Integer BLOCK_STATUS_3 = 3; //删除
}