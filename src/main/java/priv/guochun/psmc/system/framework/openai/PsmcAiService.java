package priv.guochun.psmc.system.framework.openai;

import com.alibaba.fastjson.JSONObject;
import priv.guochun.psmc.system.framework.model.MsgModel;

public interface PsmcAiService {


    public MsgModel testAiService();


    public MsgModel completions(JSONObject param);

    /**
     * 图片生成模型，返回生成的图片网址或者base64编码的内容
     * @param param
     * @return
     */
    public MsgModel createImage(JSONObject param);
}
