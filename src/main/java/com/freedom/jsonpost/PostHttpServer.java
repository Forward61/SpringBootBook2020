package com.freedom.jsonpost;


import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;

public class PostHttpServer extends HttpServlet {

    private static final  long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String inJson = null;//请求报文
        String outJson = null;//输出报文

        inJson = getInJson(req);
        System.out.println(" 服务端日志--- post方式接受请求，收到的请求报文如下：" );
        System.out.println(inJson);

        System.out.println("接收报文结束--");

        outJson = "{\"Response\":{\"code\":\"0\",\"msg\":\"成功\",\"data\":\"12345\"}}";
        resp.setContentType("application/json; charset = UTF-8");
        resp.getWriter().println(outJson);
    }

    private String getInJson(HttpServletRequest req) throws IOException {
        byte buffer [] = new byte[64*1024];
        InputStream in = req.getInputStream();
        int len = in.read(buffer);
        if (len < 0){
            throw  new IOException("请求报文为空");
        }
        String encode = req.getCharacterEncoding();
        if (null == encode || encode.trim().length() < 0){
            throw new IOException("请求报文未指明请求编码");
        }

        byte data[]  = new byte[len];

        System.arraycopy(buffer, 0, data, 0, len);
        String inJson = new String(data,encode);
        return inJson;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    public static void main(String[] args) throws IOException {
            // 创建 http 服务器, 绑定本地 8080 端口
            HttpServer httpServer = HttpServer.create(new InetSocketAddress(8080), 0);

            // 创上下文监听, "/" 表示匹配所有 URI 请求
            httpServer.createContext("/", new HttpHandler() {
                @Override
                public void handle(HttpExchange httpExchange) throws IOException {
                    System.out.println("addr: " + httpExchange.getRemoteAddress() +     // 客户端IP地址
                            "; protocol: " + httpExchange.getProtocol() +               // 请求协议: HTTP/1.1
                            "; method: " + httpExchange.getRequestMethod() +            // 请求方法: GET, POST 等
                            "; URI: " + httpExchange.getRequestURI());                  // 请求 URI

                    // 获取请求头
                    String userAgent = httpExchange.getRequestHeaders().getFirst("User-Agent");
                    System.out.println("User-Agent: " + userAgent);

                    // 响应内容
                    byte[] respContents = "Hello World".getBytes("UTF-8");

                    // 设置响应头
                    httpExchange.getResponseHeaders().add("Content-Type", "text/html; charset=UTF-8");
                    // 设置响应code和内容长度
                    httpExchange.sendResponseHeaders(200, respContents.length);

                    // 设置响应内容
                    httpExchange.getResponseBody().write(respContents);

                    // 关闭处理器
                    httpExchange.close();
                }
            });

            // 创建上下文监听, 处理 URI 以 "/aa" 开头的请求
            httpServer.createContext("/aa", new HttpHandler() {
                @Override
                public void handle(HttpExchange httpExchange) throws IOException {
                    byte[] respContents = "Hello World AA".getBytes("UTF-8");

                    httpExchange.getResponseHeaders().add("Content-Type", "text/html; charset=UTF-8");
                    httpExchange.sendResponseHeaders(200, respContents.length);

                    httpExchange.getResponseBody().write(respContents);
                    httpExchange.close();
                }
            });

            // 启动服务
            httpServer.start();
        }
}

