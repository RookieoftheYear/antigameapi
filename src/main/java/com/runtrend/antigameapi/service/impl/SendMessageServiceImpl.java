package com.runtrend.antigameapi.service.impl;

import com.runtrend.antigameapi.dao.UserAdMapper;
import com.runtrend.antigameapi.service.SendMessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.List;

/**
 * @author GanZY
 * @Title: SendMessageServiceImpl
 * @ProjectName antigameapi
 * @Description: TODO
 * @date 2019/11/2717:02
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SendMessageServiceImpl implements SendMessageService {

    private final UserAdMapper userAdMapper;
    private static final String POST_URL = "http://plugins.awifi.cn/pluginsmanage/open/sendMsg.api?mobile={0}&content={1}";
    private static final String CANCEL_MSG = "您办理的空中卫士宽带版业务（{0}）已经取消。";

    @Override
    public void sendMessage(List<String> phoneList, String ad) {

        phoneList.forEach(x -> {
            String msg = MessageFormat.format(CANCEL_MSG, x);

            try {
                msg = URLEncoder.encode(msg, "UTF-8");
            } catch (UnsupportedEncodingException e) {

                log.info("Encode Message to User Fail : {}", e.getMessage());
            }
            String url = MessageFormat.format(POST_URL, x, msg);
            try {
                String rep = sendPost(url);
                log.debug("=== Send Message to User {} , status : {}", ad, rep);
            } catch (Exception e) {
                log.info("Send Message to User error: {}", e.getMessage());
            }
        });

    }

    @Override
    public List<String> listPhone(String ad) {
        return userAdMapper.selecttUserPhoneNums(ad);
    }

    private String sendPost(String urlParam) throws IOException {
        // 创建httpClient实例对象
        HttpClient httpClient = new HttpClient();
        // 设置httpClient连接主机服务器超时时间：15000毫秒
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(15000);
        // 创建post请求方法实例对象
        PostMethod postMethod = new PostMethod(urlParam);
        // 设置post请求超时时间
        postMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 60000);
        postMethod.addRequestHeader("Content-Type", "application/json");
        httpClient.executeMethod(postMethod);

        String result = postMethod.getResponseBodyAsString();
        postMethod.releaseConnection();
        return result;
    }
}
