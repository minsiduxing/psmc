package priv.guochun.psmc.inquest.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import priv.guochun.psmc.system.framework.util.GsonUtil;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.Map.Entry;

/**
 * http请求工具类
 *
 * @author wangtao
 * @date 2022/5/25
 */
public class HttpConnectUtil {
    protected static final Logger logger  = LoggerFactory.getLogger(HttpConnectUtil.class);

    public static final String content_type_image_png = "image/png";
    public static final String content_type_image_jpg = "image/jpg";

    public static final String content_type_image_svg_xml = "image/svg+xml";




    public static String get(String targetURL, Map<String, ?> paramMap) {
        HttpURLConnection httpConnection = null;

        String var6;
        try {
            String str = "?";
            if (targetURL.indexOf(str) == -1) {
                targetURL = targetURL + str;
            }

            targetURL = targetURL + uriMapToString(paramMap);
            logger.debug("http get请求 url:"+targetURL);
            httpConnection = getHttpConnection(targetURL);
            httpConnection.setRequestMethod("GET");
            httpConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            if (httpConnection.getResponseCode() != 200) {
                throw new RuntimeException("HTTP GET Request Failed with Error code : " + httpConnection.getResponseCode());
            }

            String bufBody = getBodyFieds(httpConnection);
            var6 = bufBody;
        } catch (Exception var10) {
            var10.printStackTrace();
            return "";
        } finally {
            disconnect(httpConnection);
        }

        return var6;
    }


    public static byte[] getFile(String targetURL, Map<String, String> paramMap) {
        HttpURLConnection httpConnection = null;
        String var6;
        try {
            String str = "?";
            if (targetURL.indexOf(str) == -1) {
                targetURL = targetURL + str;
            }

            targetURL = targetURL + uriMapToString(paramMap);
            logger.debug("http getFile请求 url:"+targetURL);
            httpConnection = getHttpConnection(targetURL);
            httpConnection.setRequestMethod("GET");
            httpConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            if (httpConnection.getResponseCode() != 200) {
                throw new RuntimeException("HTTP GET Request Failed with Error code : " + httpConnection.getResponseCode());
            }

            return getBodyFileStreamFieds(httpConnection);
        } catch (Exception var10) {
            var10.printStackTrace();
            return null;
        } finally {
            disconnect(httpConnection);
        }
    }

    public static String post(String targetURL, Map<String, String> paramMap) {
        HttpURLConnection httpConnection = null;

        String var6;
        try {
            String str = "?";
            if (targetURL.indexOf(str) == -1) {
                targetURL = targetURL + str;
            }
            targetURL = targetURL + uriMapToString(paramMap);
            logger.debug("http post请求 url:"+targetURL);
            httpConnection = getHttpConnection(targetURL);
            httpConnection.setRequestMethod("POST");
            httpConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

            String postData = uriMapToString(paramMap);
            OutputStream out = httpConnection.getOutputStream();
            if(StringUtils.isNotBlank(postData)){
                out.write(postData.substring(1,postData.length()).getBytes());
            }else
                out.write(postData.getBytes());
            out.flush();
            out.close();

            if (httpConnection.getResponseCode() != 200) {
                throw new RuntimeException("HTTP POST Request Failed with Error code : " + httpConnection.getResponseCode());
            }

            String bufBody = getBodyFieds(httpConnection);
            var6 = bufBody;
        } catch (Exception var10) {
            var10.printStackTrace();
            return "";
        } finally {
            disconnect(httpConnection);
        }

        return var6;
    }

    public static String postJson(String targetURL, Map<String, String> paramMap) {
       return postJson(targetURL,GsonUtil.toJsonForObject(paramMap));
    }

    public static byte[] postJsonGetFile(String targetURL, Map<String, String> paramMap) {
        HttpURLConnection httpConnection = null;
        logger.debug("http post Json 请求 url:"+targetURL);
        try {
            httpConnection = getHttpConnection(targetURL);
            httpConnection.setRequestMethod("POST");
            httpConnection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            httpConnection.addRequestProperty("Svc_UserName", "admin");
            httpConnection.addRequestProperty("Svc_Password", "1");
            DataOutputStream out = new DataOutputStream(httpConnection.getOutputStream());
            out.write(GsonUtil.toJsonForObject(paramMap).getBytes());
            out.flush();
            out.close();
            if (httpConnection.getResponseCode() != 200) {
                throw new RuntimeException("HTTP GET Request Failed with Error code : " + httpConnection.getResponseCode());
            }

            getHeadFieds(httpConnection);
            return getBodyFileStreamFieds(httpConnection);
        } catch (Exception var11) {
            var11.printStackTrace();
        } finally {
            disconnect(httpConnection);
        }
        return null;
    }

    public static String postJson(String targetURL, String paramJson) {
        HttpURLConnection httpConnection = null;
        logger.debug("http post Json 请求 url:"+targetURL);
        try {
            httpConnection = getHttpConnection(targetURL);
            httpConnection.setRequestMethod("POST");
            httpConnection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            httpConnection.addRequestProperty("Svc_UserName", "admin");
            httpConnection.addRequestProperty("Svc_Password", "1");
            DataOutputStream out = new DataOutputStream(httpConnection.getOutputStream());
            out.write(paramJson.getBytes());
            out.flush();
            out.close();
            if (httpConnection.getResponseCode() != 200) {
                throw new RuntimeException("HTTP GET Request Failed with Error code : " + httpConnection.getResponseCode());
            }

            getHeadFieds(httpConnection);
            String bufBody = getBodyFieds(httpConnection);
            String var7 = bufBody.toString();
            logger.debug("postJson请求结果"+var7);
            return var7;
        } catch (Exception var11) {
            var11.printStackTrace();
        } finally {
            disconnect(httpConnection);
        }

        return "";
    }


    public static String postXml(String targetURL, String parameter) {
        HttpURLConnection httpConnection = null;
        logger.debug("http postXml 请求 url:"+targetURL);
        String var7;
        try {
            httpConnection = getHttpConnection(targetURL);
            httpConnection.setRequestMethod("POST");
            httpConnection.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");
            DataOutputStream out = new DataOutputStream(httpConnection.getOutputStream());
            out.write(parameter.getBytes());
            out.flush();
            out.close();
            if (httpConnection.getResponseCode() != 200) {
                throw new RuntimeException("HTTP GET Request Failed with Error code : " + httpConnection.getResponseCode());
            }

            getHeadFieds(httpConnection);
            String bufBody = getBodyFieds(httpConnection);
            var7 = bufBody.toString();
        } catch (Exception var11) {
            var11.printStackTrace();
            return "";
        } finally {
            disconnect(httpConnection);
        }

        return var7;
    }


    public static String postFile(String serviceURL, Map<String, String> textMap, Map<String, LinkedHashSet<String>> fileMap) throws IOException {
        String res = "";
        HttpURLConnection conn = null;
        OutputStream out = null;
        BufferedReader reader = null;
        String BOUNDARY = "---------------------------" + System.currentTimeMillis(); // boundary就是request头和上传文件内容的分隔符
        try {
            URL url = new URL(serviceURL);
            conn = (HttpURLConnection) url.openConnection();
            logger.debug("http postFile请求 url:"+serviceURL);
            conn.setConnectTimeout(5000);// 30秒连接
            conn.setReadTimeout(5 * 60 * 1000);// 5分钟读数据
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);
            out = new DataOutputStream(conn.getOutputStream());
            // text
            if (!Objects.isNull(textMap) && !textMap.isEmpty()) {
                StringBuffer strBuf = new StringBuffer();
                Iterator<Map.Entry<String, String>> iter = textMap.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry<String, String> entry = iter.next();
                    String inputName = entry.getKey();
                    String inputValue = entry.getValue();
                    if (StringUtils.isAnyBlank(inputName, inputValue)) {
                        continue;
                    }
                    strBuf.append("\r\n").append("--").append(BOUNDARY).append("\r\n");
                    strBuf.append("Content-Disposition: form-data; name=\"" + inputName + "\"\r\n\r\n");
                    strBuf.append(inputValue);
                }
                out.write(strBuf.toString().getBytes());
            }

            // file
            if (!Objects.isNull(fileMap) && !fileMap.isEmpty()) {
                Iterator<Entry<String, LinkedHashSet<String>>> iter = fileMap.entrySet().iterator();
                while (iter.hasNext()) {
                    Entry<String, LinkedHashSet<String>> entry = iter.next();
                    String inputName = entry.getKey();
                    LinkedHashSet<String> inputValue = entry.getValue();
                    if (StringUtils.isAnyBlank(inputName) || inputValue.isEmpty()) {
                        continue;
                    }
                    for (String filePath : inputValue) {
                        File file = new File(filePath);
                        String filename = file.getName();
                        Path path = Paths.get(filePath);
                        String contentType = Files.probeContentType(path);
                        StringBuffer strBuf = new StringBuffer();
                        strBuf.append("\r\n").append("--").append(BOUNDARY).append("\r\n");
                        strBuf.append("Content-Disposition: form-data; name=\"" + inputName + "\"; filename=\"" + filename + "\"\r\n");
//                        strBuf.append(";filelength=\"" + file.length() + "\";\r\n");
                        strBuf.append("Content-Type:" + contentType + "\r\n\r\n");
                        logger.debug(String.format("filename:%s,contentType:%s", filename, contentType));
                        out.write(strBuf.toString().getBytes());

                        DataInputStream in = new DataInputStream(new FileInputStream(file));
                        int bytes = 0;
                        byte[] bufferOut = new byte[1024];
                        while ((bytes = in.read(bufferOut)) != -1) {
                            out.write(bufferOut, 0, bytes);
                        }
                        in.close();
                    }
                }
            }
            byte[] endData = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();
            out.write(endData);
            out.flush();
            // 读取返回数据
            logger.debug(String.format("http 返回状态:ResponseCode=%s,ResponseMessage=%s", conn.getResponseCode(), conn.getResponseMessage()));
            StringBuffer strBuf = new StringBuffer();
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = null;
            while ((line = reader.readLine()) != null) {
                strBuf.append(line).append("\n");
            }
            res = strBuf.toString();
            logger.debug(String.format("http 返回数据:%s", res));
            reader.close();
            reader = null;
        } catch (IOException e) {
            throw e;
        } finally {
            if (!Objects.isNull(out)) {
                out.close();
                out = null;
            }
            if (!Objects.isNull(reader)) {
                reader.close();
                reader = null;
            }
            if (conn != null) {
                conn.disconnect();
                conn = null;
            }
        }
        return res;
    }

    public static void main(String[] args){
        Map<String, LinkedHashSet<String>> fileMap = new HashMap<String, LinkedHashSet<String>>();
        LinkedHashSet set = new LinkedHashSet();
        set.add("D:/2.jpg");
        fileMap.put("file",set);
        try {
            System.out.println(postFile(" https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=image&media=@2.jpg",null,fileMap));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static HttpURLConnection getHttpConnection(String targetURL) {
        HttpURLConnection httpConnection = null;

        try {
            URL targetUrl = new URL(targetURL);
            httpConnection = (HttpURLConnection)targetUrl.openConnection();
            httpConnection.setDoOutput(true);
            httpConnection.setDoInput(true);
            httpConnection.setUseCaches(false);
            httpConnection.setInstanceFollowRedirects(true);
            httpConnection.setConnectTimeout(5000);
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        return httpConnection;
    }

    private static StringBuffer getHeadFieds(HttpURLConnection httpConnection) {
        StringBuffer bufs = new StringBuffer();

        try {
            Map<String, List<String>> headFieds = httpConnection.getHeaderFields();
            Iterator var4 = headFieds.keySet().iterator();

            while(var4.hasNext()) {
                String key = (String)var4.next();
                List<String> valList = (List)headFieds.get(key);
                StringBuffer buf = new StringBuffer();
                Iterator var8 = valList.iterator();

                while(var8.hasNext()) {
                    String val = (String)var8.next();
                    buf.append(URLDecoder.decode(val, "UTF-8")).append(",");
                }

                bufs.append(key).append("===>").append(buf).append("\n");
            }
        } catch (Exception var10) {
            var10.printStackTrace();
        }

        return bufs;
    }

    public static String getBodyFieds(HttpURLConnection httpConnection) {
        StringBuffer resultSb = new StringBuffer();
        InputStream is = null;
        InputStreamReader isreader = null;
        BufferedReader responseBuffer = null;
        String outStr = null;
        try {
            is = httpConnection.getInputStream();
            isreader = new InputStreamReader(is, "utf-8");
            responseBuffer = new BufferedReader(isreader);

            while((outStr = responseBuffer.readLine()) != null) {
                resultSb.append(outStr);
            }
        } catch (Exception var16) {
            var16.printStackTrace();
        } finally {
            try {
                responseBuffer.close();
                isreader.close();
                is.close();
            } catch (Exception var15) {
                var15.printStackTrace();
            }
        }
        return resultSb.toString();
    }

    public static byte[] getBodyFileStreamFieds(HttpURLConnection httpConnection) {
        InputStream is = null;
        ByteArrayOutputStream swapStream = null;
        try {
            is = httpConnection.getInputStream();
            swapStream = new ByteArrayOutputStream();
            int available = is.available();
            byte[] buff = new byte[available]; //buff用于存放循环读取的临时数据
            int rc = 0;
            while ((rc = is.read(buff, 0, available)) > 0) {
                swapStream.write(buff, 0, rc);
            }
            logger.debug("http getFile请求结果，文件二进制长度"+swapStream.toByteArray().length);
            return swapStream.toByteArray();
        } catch (Exception var16) {
            var16.printStackTrace();
            return null;
        }finally {
            try{
                if(is !=null)
                    is.close();
                if(swapStream !=null)
                    swapStream.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }


    public static void disconnect(HttpURLConnection httpConnection) {
        try {
            if (httpConnection != null) {
                httpConnection.disconnect();
            }
        } catch (Exception var3) {
            var3.printStackTrace();
        }
    }

    private static String uriMapToString(Map<String, ?> paramMap) {
        StringBuffer postedData = new StringBuffer();
        if(paramMap != null){
            Set<String> set = paramMap.keySet();
            for(Iterator it = set.iterator(); it.hasNext(); postedData.append("&")) {
                String key = (String)it.next();
                String value = (String)paramMap.get(key);
                postedData.append(key);
                postedData.append("=");

                try {
                    postedData.append(URLEncoder.encode(value, "UTF-8"));
                } catch (UnsupportedEncodingException var8) {
                    var8.printStackTrace();
                }
            }

            if (postedData.length() > 0) {
                postedData.deleteCharAt(postedData.length() - 1);
            }
        }
        return postedData.toString();
    }
}
