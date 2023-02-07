package priv.guochun.psmc.system.framework.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.guochun.psmc.system.framework.openai.PsmcAiService;

import java.io.IOException;

@Controller
@RequestMapping("/system/psmcAiServiceController")
public class PsmcAiServiceController extends MyController {

    @Autowired
    private PsmcAiService psmcAiService;

    /**
     * AI聊天
     * @param text 文本内容
     * @throws IOException
     */
    @RequestMapping(params="method=chat")
    @ResponseBody
    public void chat(String text) throws IOException {
        JSONObject data = new JSONObject();
        data.put("model","text-davinci-003");
        data.put("prompt",text);
        data.put("n",1);
        data.put("max_tokens",2048);
        data.put("top_p",1); //，0.1意味着只考虑包含最高10%概率质量的内容
        data.put("temperature",0);
        super.responseMsgModel(psmcAiService.completions(data),response());
    }
}
