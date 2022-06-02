package priv.guochun.psmc.inquest.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import priv.guochun.psmc.inquest.service.impl.InquestServiceImpl;
import priv.guochun.psmc.system.framework.util.GsonUtil;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * http请求工具类
 *
 * @author wangtao
 * @date 2022/5/25
 */
public class HttpConnectUtil {
    protected static final Logger logger  = LoggerFactory.getLogger(HttpConnectUtil.class);
    public static String get(String targetURL, Map<String, String> paramMap) {
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
            out.write(postData.substring(1,postData.length()).getBytes());
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
            String bufBody = getBodyFieds(httpConnection);
            String var7 = bufBody.toString();
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

    public static void disconnect(HttpURLConnection httpConnection) {
        try {
            if (httpConnection != null) {
                httpConnection.disconnect();
            }
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    private static String uriMapToString(Map<String, String> paramMap) {
        Set<String> set = paramMap.keySet();
        StringBuffer postedData = new StringBuffer();

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

        return postedData.toString();
    }
}
