package priv.guochun.psmc.system.framework.wx;

import priv.guochun.psmc.system.framework.model.MsgModel;

import java.io.File;
import java.util.Map;

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
     * 得到临时素材(视频)
     * @param media_id
     * @return
     */
    public MsgModel getTemporaryMediaForVideo(String media_id);

    /**
     * 得到临时素材（除视频外）因为视频返回的是下载地址而不是流
     * @param media_id
     * @return
     */
    public byte[] getTemporaryMedia(String media_id);


    /**
     * 上传持久图片素材 如果isMsgMedia为true，则返回的内容为上传文件的url，如果为否，则是上传文件的media_id和url
     * @param file
     * @return
     */
    public MsgModel uploadPersistentMediaForImage(File file,boolean isMsgMedia);

    /**
     * 上传持久音频素材 如果isMsgMedia为true，则返回的内容为上传文件的url，如果为否，则是上传文件的media_id和url
     * @param file
     * @return
     */
    public MsgModel uploadPersistentMediaForVoice(File file,boolean isMsgMedia);

    /**
     * 上传持久素材（音频） 如果isMsgMedia为true，则返回的内容为上传文件的json串，如果为否，则是上传文件的media_id和url
     * @return
     */
    public MsgModel uploadPersistentMediaForVideo(File file,boolean isMsgMedia);

    /**
     * 上传持久素材（主要用于视频与音乐格式的缩略图） 如果isMsgMedia为true，则返回的内容为上传文件的url，如果为否，则是上传文件的media_id和url
     * @return
     */
    public MsgModel uploadPersistentMediaForThumb(File file,boolean isMsgMedia);


    /**
     * 删除持久素材(暂时还没测)
     * @param media_id
     * @return
     */
    public MsgModel delPersistentMedia(String media_id);

    /**
     * 获取持久素材
     * @param media_id
     * @return
     */
    public byte[] getPersistentMedia(String media_id);


    /**
     * 获取持久素材List
     * @return
     */
    public MsgModel getPersistentMediaList(String mediaType);

    /**
     * 新增草稿箱
     * @param paramJsonStr
     * @return
     */
    public MsgModel saveDrafts(String paramJsonStr);



}
