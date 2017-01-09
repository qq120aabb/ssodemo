package com.example.common;

import com.example.mode.Auth;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpStatus;
import sun.net.www.http.HttpClient;

/**
 * Created by Administrator on 2016/12/21 0021.
 */
public class HttpUtil {
    public void post() {
        //向认证中心发送验证token请求
      /*  String verifyURL = "http://" + server + PropertiesConfigUtil.getProperty("sso.server.verify");
        HttpClient httpClient = new DefaultHttpClient(); //serverName作为本应用标识
        HttpGet httpGet = new HttpGet(verifyURL + "?token=" + token + "&localId=" + request.getSession().getId());
        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                String result = EntityUtils.toString(httpResponse.getEntity(), "utf-8"); //解析json数据
                ObjectMapper objectMapper = new ObjectMapper();
                VerifyBean verifyResult = objectMapper.readValue(result, VerifyBean.class); //验证通过,应用返回浏览器需要验证的页面
                if (verifyResult.getRet().equals("0")) {
                    Auth auth = new Auth();
                    auth.setUserId(verifyResult.getUserId());
                    auth.setUsername(verifyResult.getUsername());
                    auth.setGlobalId(verifyResult.getGlobalId());
                    request.getSession().setAttribute("auth", auth); //建立本地会话
                    return "redirect:http://" + returnURL;
                }
            }
        } catch (Exception e) {
            return "redirect:" + loginURL;
        }*/
    }
}
