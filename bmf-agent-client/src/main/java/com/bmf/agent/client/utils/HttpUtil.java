package com.bmf.agent.client.utils;

import com.alibaba.fastjson.JSON;
import com.bmf.api.application.dto.BusinessApiCmdReqDTO;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.*;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.message.BasicHeader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * http工具类
 */
public class HttpUtil {

    public static int post(BusinessApiCmdReqDTO businessApiCmdReqDTO) {
        String url = "http://localhost:8080/business/api/create";
        HttpPost httpPost = new HttpPost(url);
        // 构建对象
        HttpEntity httpEntity = new StringEntity(JSON.toJSONString(businessApiCmdReqDTO));
        httpPost.setEntity(httpEntity);
        HttpClient httpClient = buildHttpClient();
        try {
            HttpResponse response = httpClient.execute(httpPost);
            return response.getCode();
        } catch (IOException ioe) {

        } catch (Exception ex) {

        }
        return 0;
    }

    /**
     * 构建HttpClient
     * @return
     */
    private static HttpClient buildHttpClient() {
        List<Header> headers = new ArrayList<>();
        headers.add(new BasicHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON));
        headers.add(new BasicHeader(HttpHeaders.ACCEPT_ENCODING, "gzip, x-gzip, deflate"));
        headers.add(new BasicHeader(HttpHeaders.CONNECTION, "keep-alive"));

        CloseableHttpClient httpClient = HttpClients.custom()
                .setDefaultHeaders(headers)
                .build();
        return httpClient;
    }
}
