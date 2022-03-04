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

    /**
     * 通用信息发布
     */
    public final static String ONE_LEVEL_CLASSIFY_15 = "15";
    
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


    public final static Integer NOTICE_TYPE_4 = 4; //卡余提醒一类
    public final static Integer NOTICE_TYPE_5 = 5; //卡余提醒二类
    public final static Integer NOTICE_TYPE_6 = 6; //卡余提醒三类
    public final static Integer NOTICE_TYPE_7 = 7; //未体验提醒一
    public final static Integer NOTICE_TYPE_8 = 8; //未体验提醒二
    public final static Integer NOTICE_TYPE_9 = 9; //专属福利提醒

    
    /** 评价状态 **/
    public final static Integer EVALUATE_STATUS_1 = 1; //待评价
    public final static Integer EVALUATE_STATUS_2 = 2; //已评价
    public final static Integer EVALUATE_STATUS_3 = 3; //无，不用评价
    public final static Integer EVALUATE_STATUS_4 = 4; //短信发送失败

    /** 短信通知内容-消费金额*/
    public final static String MSG_CONTENT_1 = "7370";
    public final static String MSG_CONTENT_REMARK_1 = "【四季花城】尊敬的${evaluateNickName}，您${consumptionDate}的消费金额为${consumptionAmount}元，剩余金额${surplusAmount}元，剩余积分${surplusScore}分。为提升品牌服务，诚邀您参与满意度测评，点击${visitShortUrl} 可对本次体验作出评价，期待您的宝贵建议！退订回复TD";

    //** 短信通知内容-消费项目*/
    public final static String MSG_CONTENT_2 = "7371";
    public final static String MSG_CONTENT_REMARK_2 = "【四季花城】尊敬的${evaluateNickName}，您${consumptionDate}的消费项目为：${itemContent}剩余积分${surplusScore}分。为提升品牌服务，欢迎您参与满意度测评，点击${visitShortUrl} 可对本次体验作出评价，期待您的宝贵建议！退订回复TD";

    //** 短信通知内容-充值金额*/
    public final static String MSG_CONTENT_3 = "7372";
    public final static String MSG_CONTENT_REMARK_3 = "【四季花城】尊敬的${evaluateNickName}，您${consumptionDate}的充值金额为${rechargeAmount}元，赠送金额为${giveAmount}，剩余${surplusAmount}元。退订回复TD";

    public final static String MSG_CONTENT_4 = "17762";
    public final static String MSG_CONTENT_REMARK_4 = "【四季花城功能SPA】尊敬的花城会员${evaluateNickName}，截止目前,您的会员卡余额为${surplusAmount}元,待体验项目有${consumptionItem}等共计${surplusNumber}次,${otherRemark}。退订回复TD";

    public final static String MSG_CONTENT_5 = "17762";
    public final static String MSG_CONTENT_REMARK_5 = "【四季花城功能SPA】尊敬的花城会员${evaluateNickName}，截止目前,您的会员卡余额为${surplusAmount}元,待体验项目有${consumptionItem}。退订回复TD";

    public final static String MSG_CONTENT_6 = "17762";
    public final static String MSG_CONTENT_REMARK_6 = "【四季花城功能SPA】尊敬的花城会员${evaluateNickName}，截止目前,您的会员卡余额为${surplusAmount}元,${otherRemark}。退订回复TD";

    public final static String MSG_CONTENT_7 = "17762";
    public final static String MSG_CONTENT_REMARK_7 = "【四季花城功能SPA】尊敬的花城会员${evaluateNickName}，截止目前,您会员卡内未体验的项目有${consumptionItem}。退订回复TD";

    public final static String MSG_CONTENT_8 = "17762";
    public final static String MSG_CONTENT_REMARK_8 = "【四季花城功能SPA】尊敬的花城会员${evaluateNickName}，截止目前,您会员卡内未体验的项目有${consumptionItem}等共计${surplusNumber}次,${otherRemark}。退订回复TD";

    public final static String MSG_CONTENT_9 = "17762";
    public final static String MSG_CONTENT_REMARK_9 = "【四季花城功能SPA】尊敬的花城会员${evaluateNickName}，您的专属福利：最近店内${otherRemark},您回店后,联系您的管家${butler},即可专享${vipRemark},有效期截止到${consumptionDate},期待与您相遇~退订回复TD";

}