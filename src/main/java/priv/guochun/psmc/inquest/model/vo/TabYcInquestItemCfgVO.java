package priv.guochun.psmc.inquest.model.vo;

import priv.guochun.psmc.inquest.model.TabYcInquestOptionCfg;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author wangtao
 * @date 2022/5/29
 */
public class TabYcInquestItemCfgVO implements Serializable {

    private static final long serialVersionUID = 6557534536978347973L;

    /**
     * 主键
     */
    private String itemUuid;
    /**
     * 勘验阶段id
     */
    private String stageUuid;
    /**
     * 题目类型(1：单选，2多选)
     */
    private Integer questionType;
    /**
     * 标题
     */
    private String questionName;
    /**
     * 标准答案
     */
    private String standardAnswer;
    /**
     * 提示信息
     */
    private String tipsInfo;
    /**
     * 是否受特殊群体影响
     */
    private Boolean isAffectedBsg;
    /**
     * 是否进行距离测算
     */
    private Boolean isAffectedJlcl;
    /**
     * 是否进行饱和度测算
     */
    private Boolean isAffectedBhdcs;
    /**
     * 展示图集地址 英文;分割
     */
    private String displayAtlas;
    /**
     * 展示视频地址
     */
    private String displayVidio;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 所属专卖局code
     */
    private String orgCode;
    /**
     * 关联题目id
     */
    private String releationItemUuid;
    /**
     * 是否负面清单
     */
    private Integer isNegative;
    /**
     * 是否有效
     */
    private Boolean isActive;
    /**
     * 创建人
     */
    private String creator;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 阶段编码
     */
    private String stageCode;
    /**
     * 阶段名称
     */
    private String stageName;
    /**
     * 阶段层级
     */
    private Integer stageLevel;
    /**
     * 下辖题目展示方式 1、平铺。2、单条引导。
     */
    private Integer itemDisplayType;
    /**
     * 结果判定
     */
    private String resultJudge;
    /**
     * 下阶段UUID
     */
    private String nextStageUuid;
    /**
     * 上级阶段id
     */
    private String parentId;
    /**
     * 选项列表
     */
    List<TabYcInquestOptionCfg> optionCfgList;

    public String getItemUuid() {
        return itemUuid;
    }

    public void setItemUuid(String itemUuid) {
        this.itemUuid = itemUuid;
    }

    public String getStageUuid() {
        return stageUuid;
    }

    public void setStageUuid(String stageUuid) {
        this.stageUuid = stageUuid;
    }

    public Integer getQuestionType() {
        return questionType;
    }

    public void setQuestionType(Integer questionType) {
        this.questionType = questionType;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public String getStandardAnswer() {
        return standardAnswer;
    }

    public void setStandardAnswer(String standardAnswer) {
        this.standardAnswer = standardAnswer;
    }

    public String getTipsInfo() {
        return tipsInfo;
    }

    public void setTipsInfo(String tipsInfo) {
        this.tipsInfo = tipsInfo;
    }

    public Boolean getAffectedBsg() {
        return isAffectedBsg;
    }

    public void setAffectedBsg(Boolean affectedBsg) {
        isAffectedBsg = affectedBsg;
    }

    public Boolean getAffectedJlcl() {
        return isAffectedJlcl;
    }

    public void setAffectedJlcl(Boolean affectedJlcl) {
        isAffectedJlcl = affectedJlcl;
    }

    public Boolean getAffectedBhdcs() {
        return isAffectedBhdcs;
    }

    public void setAffectedBhdcs(Boolean affectedBhdcs) {
        isAffectedBhdcs = affectedBhdcs;
    }

    public String getDisplayAtlas() {
        return displayAtlas;
    }

    public void setDisplayAtlas(String displayAtlas) {
        this.displayAtlas = displayAtlas;
    }

    public String getDisplayVidio() {
        return displayVidio;
    }

    public void setDisplayVidio(String displayVidio) {
        this.displayVidio = displayVidio;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getReleationItemUuid() {
        return releationItemUuid;
    }

    public void setReleationItemUuid(String releationItemUuid) {
        this.releationItemUuid = releationItemUuid;
    }

    public Integer getIsNegative() {
        return isNegative;
    }

    public void setIsNegative(Integer isNegative) {
        this.isNegative = isNegative;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStageCode() {
        return stageCode;
    }

    public void setStageCode(String stageCode) {
        this.stageCode = stageCode;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public List<TabYcInquestOptionCfg> getOptionCfgList() {
        return optionCfgList;
    }

    public void setOptionCfgList(List<TabYcInquestOptionCfg> optionCfgList) {
        this.optionCfgList = optionCfgList;
    }

    public Integer getStageLevel() {
        return stageLevel;
    }

    public void setStageLevel(Integer stageLevel) {
        this.stageLevel = stageLevel;
    }

    public Integer getItemDisplayType() {
        return itemDisplayType;
    }

    public void setItemDisplayType(Integer itemDisplayType) {
        this.itemDisplayType = itemDisplayType;
    }

    public String getResultJudge() {
        return resultJudge;
    }

    public void setResultJudge(String resultJudge) {
        this.resultJudge = resultJudge;
    }

    public String getNextStageUuid() {
        return nextStageUuid;
    }

    public void setNextStageUuid(String nextStageUuid) {
        this.nextStageUuid = nextStageUuid;
    }
}
