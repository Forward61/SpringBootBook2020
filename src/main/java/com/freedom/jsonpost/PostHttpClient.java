package com.freedom.jsonpost;


import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.EntityEnclosingMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;

import java.io.IOException;

public class PostHttpClient  {
    public static String  postHttpReq(String json,String url){
        HttpClient httpClient = new HttpClient();
        byte b [] = json.getBytes();
        RequestEntity requestEntity = new ByteArrayRequestEntity(b);
        EntityEnclosingMethod postMethod = new PostMethod();
        postMethod.setRequestEntity(requestEntity);
        postMethod.setPath(url);
        postMethod.setRequestHeader("Content-type", "text/html;charset=GBK");

        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(5*1000);

        httpClient.getHttpConnectionManager().getParams().setSoTimeout(20*1000);

        String responseMsg = "";
        int statusCode = 0;
        try{
            statusCode = httpClient.executeMethod(postMethod);
            responseMsg = postMethod.getResponseBodyAsString();
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            postMethod.releaseConnection();
        }
        if (statusCode!= HttpStatus.SC_OK){
            System.out.println("Http服务异常");
        }
        return responseMsg;
    }

    public static void main(String[] args) {
        String json = "{\"data\":\"测试\"}";
        String url ="localhost:8080/http";
        String outpackage = null;
        outpackage = postHttpReq(json,url);
        System.out.println("客户端日志： post方式调用Http,请求报文为 ：" + json);
        System.out.println("客户端日志： 响应报文： " + outpackage);
        System.out.println("客户端接收结束");

    }
}
