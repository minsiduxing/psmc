package priv.guochun.psmc.system.framework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.guochun.psmc.system.framework.gd.GdWebApiService;

import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/system/gdWebServiceController")
public class GdWebServiceController extends MyController {

    @Autowired
    private GdWebApiService gdWebApiService;

    /**
     * 高德距离测量服务
     * @param param
     * @throws IOException
     */
    @RequestMapping(params="method=distances")
    @ResponseBody
    public void distances(@RequestParam Map<String,Object> param) throws IOException {
        super.responseMsgModel(gdWebApiService.distances(param),response());
    }
}
