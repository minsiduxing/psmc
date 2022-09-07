package priv.guochun.psmc.system.framework.wx;

import priv.guochun.psmc.system.framework.model.MsgModel;

import java.io.File;

public interface PsmcWxService {

    /**
     * 获取getAccessToken
     * @return
     */
    public String getAccessToken();

    /**
     * 获取手机号
     * @param code
     * @return
     */
    public MsgModel getPhoneNo(String code);

    /**
     * 模拟登陆
     * @param js_code
     * @param mobile
     * @return
     */
    public String codeToSession(String js_code, String mobile);

    /**
     * 上传临时素材（图片）
     * @return
     */
    public MsgModel uploadTemporaryMediaForImage(File file);

    /**
     * 上传临时素材（语音）
     * @return
     */
    public MsgModel uploadTemporaryMediaForVoice(File file);

    /**
     * 上传临时素材（视频）
     * @return
     */
    public MsgModel uploadTemporaryMediaForVideo(File file);

    /**
     * 上传临时素材（主要用于视频与音乐格式的缩略图）
     * @return
     */
    public MsgModel uploadTemporaryMediaForThumb(File file);

    /**
     * 得到临时素材
     * @param media_id
     * @return
     */
    public MsgModel getTemporaryMedia(String media_id);

    /**
     * 删除临时素材
     * @param media_id
     * @return
     */
    public MsgModel delTemporaryMedia(String media_id);

    public String uploadPersistentMedia( String type,String mediaFormData);

    public String delPersistentMedia(String js_code, String mobile);

}
