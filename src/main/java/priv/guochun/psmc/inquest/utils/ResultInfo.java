package priv.guochun.psmc.inquest.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.Serializable;

/**
 * rest返回对象
 *
 * @author wangtao
 * @date 2022/5/22
 */
public class ResultInfo<T> implements Serializable {

    private T data;

    private int code;

    private String msg;

    public ResultInfo() {
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static ResultInfo ok() {
        ResultInfo result = new ResultInfo();
        result.setCode(200);
        result.setMsg("操作成功");
        return result;
    }

    public static ResultInfo ok(String msg) {
        ResultInfo result = new ResultInfo();
        result.setCode(200);
        result.setMsg(msg);
        return result;
    }

    public static <E> ResultInfo<E> ok(String msg, E data) {
        ResultInfo<E> result = new ResultInfo();
        result.setCode(200);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static ResultInfo error(String msg) {
        ResultInfo result = new ResultInfo();
        result.setCode(500);
        result.setMsg(msg);
        return result;
    }

    public static <E> ResultInfo<E> error(String msg, E data) {
        ResultInfo<E> result = new ResultInfo();
        result.setCode(500);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static <E> ResultInfo<E> error(int code, String msg) {
        ResultInfo<E> result = new ResultInfo();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public boolean isSuccess() {
        return this.code == 200;
    }

    public String buildResultJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", this.code);
        jsonObject.put("msg", this.msg);
        jsonObject.put("data", this.data);
        return JSON.toJSONString(jsonObject, new SerializerFeature[]{SerializerFeature.DisableCircularReferenceDetect});
    }

    @Override
    public String toString() {
        return "Result{, data=" + this.data + ", code='" + this.code + '\'' + ", msg='" + this.msg + '\'' + ", count='" + '}';
    }
}
