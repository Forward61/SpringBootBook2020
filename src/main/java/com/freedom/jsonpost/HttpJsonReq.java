package com.freedom.jsonpost;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpJsonReq {

    public static String doPostJson(String url,int socketTimeout,String jsonParam){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            HttpPost httpPost = new HttpPost(url);
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(5000)
                    .setConnectionRequestTimeout(1000)
                    .setSocketTimeout(socketTimeout).build();
            httpPost.setConfig(requestConfig);
            StringEntity entity = new StringEntity(jsonParam, ContentType.APPLICATION_JSON);
            httpPost.setEntity(entity);
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(),"utf-8");

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if (null != httpClient){
                    httpClient.close();
                }
                if(null != response){
                    response.close();
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }

        }

        return resultString;
    }

    public static void main(String[] args) {
        String url = "http://localhost:8080/atcrowdfunding02_admin_webui_Web_exploded/send/array/three.html";
        String jsonParam = "[1,5,6]";
        String resultString = doPostJson(url,2000,jsonParam);
        System.out.println("响应报文： " + resultString);
    }
}
