package priv.guochun.psmc.system.util;


public class ContantsUtil {

    //数据字典常量
    
    public final static String DICTY_TYPE_IF = "IF";

    public final static String DICTY_TYPE_SEX = "SEX";
    
    public final static String DICTY_ACC_TYPE = "ACC_TYPE";
    
    
    //信息分类
    /**
     * 创新工作室-创新成果
     */
    public final static String ONE_LEVEL_CLASSIFY_11 = "11";
    /**
     * 援助帮扶-法条维护
     */
    public final static String ONE_LEVEL_CLASSIFY_12 = "12";
    /**
     * 文体协会-最新活动
     */
    public final static String ONE_LEVEL_CLASSIFY_13 = "13";
    /**
     * 后勤中心-早知道
     */
    public final static String ONE_LEVEL_CLASSIFY_14 = "14";
    
    //后勤中心-早知道信息分类
    /**
     * 美味食谱
     */
    public final static String TOW_LEVEL_CLASSIFY_1401 = "1401";
    /**
     * 日常通知
     */
    public final static String TOW_LEVEL_CLASSIFY_1402 = "1402";
    /**
     * 大院新闻
     */
    public final static String TOW_LEVEL_CLASSIFY_1403 = "1403";
    /**
     * 政策法律
     */
    public final static String TOW_LEVEL_CLASSIFY_1405 = "1405";
    
    /**
     * 转载
     */
    public final static String TOW_LEVEL_CLASSIFY_1406 = "1406";
    
    /**
     * 部门类型
     */
    public final static String DEPT_TYPE_1 = "1"; //创新工作室
    public final static String DEPT_TYPE_2 = "2"; //文体协会
    
    /**
     * 活动
     */
    public final static String ACTIVITY = "3";
    
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
    
    /** 版块 **/
    public final static String BLOCK_01 = "01";	//跳蚤市场
    public final static String BLOCK_02 = "02";	//曝光台
    public final static String BLOCK_03 = "03";	//合理化建议
    public final static String BLOCK_04 = "04";	//表扬
    public final static String BLOCK_05 = "05";	//投诉
    
    /** 通知类型 */
    public final static Integer NOTICE_TYPE_1 = 1; //消费金额
    public final static Integer NOTICE_TYPE_2 = 2; //消费项目
    public final static Integer NOTICE_TYPE_3 = 3; //充值
    
    /** 评价状态 **/
    public final static Integer EVALUATE_STATUS_1 = 1; //待评价
    public final static Integer EVALUATE_STATUS_2 = 2; //已评价
    public final static Integer EVALUATE_STATUS_3 = 3; //无，不用评价
    
    /** 短信通知内容-消费金额 */
    public final static String MSG_CONTENT_1 = "【四季花城】尊敬的{evaluateName}，您{consumptionDate}的消费金额为{consumptionAmount}元，剩余金额{surplusAmount}元，剩余积分{surplusScore}分。为提升品牌服务，诚邀您参与满意度测评，点击{visitShortUrl} 可对本次体验作出评价，期待您的宝贵建议！";
    /** 短信通知内容-消费项目*/
    public final static String MSG_CONTENT_2 = "【四季花城】尊敬的{evaluateName}，您{consumptionDate}的消费项目为{consumptionItem}，剩余{surplusNumber}次，剩余积分{surplusScore}分。为提升品牌服务，诚邀您参与满意度测评，点击{visitShortUrl} 可对本次体验作出评价，期待您的宝贵建议！";
    /** 短信通知内容-充值金额 */
    public final static String MSG_CONTENT_3 = "【四季花城】尊敬的{evaluateName}，您{consumptionDate}的充值金额为{rechargeAmount}，剩余{surplusAmount}元.";
}