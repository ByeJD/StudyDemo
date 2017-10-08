/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015 - 2017
 */
package httpclientdemo;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.*;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用途描述
 *
 * @author 刘全权
 * @version $Id: BOCSpider, v0.1

 * @date 2017年09月15日 15:17 Exp $
 */

public class BOCSpider {

    // Create a custom response handler


    public static class MyX509TrustManager implements X509TrustManager {


        public void checkClientTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
        }


        public void checkServerTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

    }


    public static CloseableHttpClient CreatHttpClientSSL() {

        CloseableHttpClient httpclient = null;
        CookieStore cookieStore = new BasicCookieStore();
        try {
            SSLContext sslcontext = SSLContext.getInstance("SSL");
            sslcontext.init(null, new javax.net.ssl.TrustManager[] { new MyX509TrustManager() }, null);

//            SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslcontext);
            SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslcontext ,SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            HttpClientBuilder httpClientBuilder = HttpClients.custom();
            httpClientBuilder = httpClientBuilder.setSSLSocketFactory(sslConnectionSocketFactory);
            httpClientBuilder = httpClientBuilder.setDefaultCookieStore(cookieStore);
            httpClientBuilder = httpClientBuilder.setSSLContext(sslcontext);

            httpclient = httpClientBuilder.build();


        }catch (Exception e) {
            e.printStackTrace();
        } finally {
//            if (httpclient != null) {
//                try {
//                    httpclient.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
        }
         Map<String,String> m = new HashMap<String,String>();

        return httpclient;
    }


    private static StringEntity jsonBasedPost(String jsonText){
        StringEntity entity = new StringEntity(jsonText,"UTF-8");//解决中文乱码问题
        entity.setContentEncoding("UTF-8");
        entity.setContentType("text/json");
        return entity;
    }
    public static void test() {
        try {
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
                public String handleResponse(
                        final HttpResponse response) throws ClientProtocolException, IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                }

            };

            CloseableHttpClient httpClient = CreatHttpClientSSL();
            HttpGet httpGet = new HttpGet("https://ebsnew.boc.cn/boc15/login.html");
            String str = httpClient.execute(httpGet,responseHandler);
            System.out.println(str);
            System.out.println("*********************************8");

            HttpPost httpPost = new HttpPost("https://ebsnew.boc.cn/BII/PsnGetUserProfile.do?_locale=zh_CN");
            httpPost.setHeader(new BasicHeader("bfw-ctrl","json"));
            httpPost.setHeader(new BasicHeader("X-id","4"));
            httpPost.setHeader(new BasicHeader("Host","ebsnew.boc.cn"));
            httpPost.setHeader(new BasicHeader("Origin","https://ebsnew.boc.cn"));
            httpPost.setHeader(new BasicHeader("Referer","https://ebsnew.boc.cn/boc15/login.html"));
            httpPost.setHeader(new BasicHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.91 Safari/537.36"));
            httpPost.setHeader(new BasicHeader("Content-Type","text/json"));
            httpPost.setHeader(new BasicHeader("X-Requested-With","XMLHttpRequest"));
            httpPost.setHeader(new BasicHeader("Accept","*/*"));
            httpPost.setHeader(new BasicHeader("Accept-Encoding","gzip, deflate, br"));
            httpPost.setHeader(new BasicHeader("Accept-Language","zh-CN,zh;q=0.8"));


            String parameter = "{\"header\":{\"local\":\"zh_CN\",\"agent\":\"WEB15\",\"bfw-ctrl\":\"json\",\"version\":\"\",\"device\":\"\",\"platform\":\"\",\"plugins\":\"\",\"page\":\"\",\"ext\":\"\"},\"request\":[{\"id\":3,\"method\":\"PSNCreatConversationLoginPre\",\"conversationId\":null,\"params\":null}]}";

            httpPost.setEntity(jsonBasedPost(parameter));

            CloseableHttpResponse response = httpClient.execute(httpPost);
            HttpEntity httpEntity = response.getEntity();



            System.out.println(EntityUtils.toString(httpEntity));

        }catch (Exception e){
            e.printStackTrace();
        }








    }

    public static void main(String[] args) throws Exception {

        test();
//        BasicCookieStore cookieStore = new BasicCookieStore();
//        CloseableHttpClient httpclient = HttpClients.custom()
//                .setDefaultCookieStore(cookieStore)
//                .build();
//        try {
//            // http://www.boc.cn/
//            HttpGet httpget = new HttpGet("http://www.boc.cn/");
//            httpget.setHeader(new BasicHeader("Referer","http://www.baidu.com"));
//            httpget.setHeader(new BasicHeader("Host","www.boc.cn"));
//            httpget.setHeader(new BasicHeader("Upgrade-Insecure-Requests","1"));
//            httpget.setHeader(new BasicHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.91 Safari/537.36"));
//            httpget.setHeader(new BasicHeader("Upgrade-Insecure-Requests","1"));
//            CloseableHttpResponse response1 = httpclient.execute(httpget);
//
//            System.out.println(response1.getStatusLine());
//            System.out.println(EntityUtils.toString(response1.getEntity(),"UTF-8"));
//            List<Cookie> cookies = cookieStore.getCookies();
//            if (cookies.isEmpty()) {
//                System.out.println("None");
//            } else {
//                for (int i = 0; i < cookies.size(); i++) {
//                    System.out.println("- " + cookies.get(i).toString());
//                }
//            }
//            // http://www.boc.cn/ebanking/bocnet_login/
//            // https://ebsnew.boc.cn/boc15/login.html https://ebsnew.boc.cn/boc15/login.html
//
//            CloseableHttpClient httpClientSSL = CreatHttpClientSSL();
//            httpget = new HttpGet("https://ebsnew.boc.cn/boc15/login.html");
//            httpget.setHeader(new BasicHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.91 Safari/537.36"));
//            httpget.setHeader(new BasicHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8"));
//            httpget.setHeader(new BasicHeader("Referer","http://www.boc.cn/ebanking/bocnet_login/"));
//            httpget.setHeader(new BasicHeader("Host","ebsnew.boc.cn"));
//
//
//            response1 = httpClientSSL.execute(httpget);
//
//            System.out.println(EntityUtils.toString(response1.getEntity()));
//            cookies = cookieStore.getCookies();
//            if (cookies.isEmpty()) {
//                System.out.println("None");
//            } else {
//                for (int i = 0; i < cookies.size(); i++) {
//                    System.out.println("- " + cookies.get(i).toString());
//                }
//            }
//
//            // https://ebsnew.boc.cn/boc15/login.html
//
//            httpget = new HttpGet("https://ebsnew.boc.cn/boc15/login.html");
//            response1 = httpclient.execute(httpget);
//
//            cookies = cookieStore.getCookies();
//            if (cookies.isEmpty()) {
//                System.out.println("None");
//            } else {
//                for (int i = 0; i < cookies.size(); i++) {
//                    System.out.println("- " + cookies.get(i).toString());
//                }
//            }










//            try {
//                HttpEntity entity = response1.getEntity();
//
//                System.out.println("Login form get: " + response1.getStatusLine());
//                System.out.println(EntityUtils.toString(entity,"utf-8"));
//                EntityUtils.consume(entity);
//
//                System.out.println("Initial set of cookies:");
//                List<Cookie> cookies = cookieStore.getCookies();
//                if (cookies.isEmpty()) {
//                    System.out.println("None");
//                } else {
//                    for (int i = 0; i < cookies.size(); i++) {
//                        System.out.println("- " + cookies.get(i).toString());
//                    }
//                }
//            } finally {
//                response1.close();
//            }


//            CloseableHttpResponse response2 = null;
//            try {
//                HttpPost httpPost = new HttpPost("https://ebsnew.boc.cn/BII/PsnGetUserProfile.do?_locale=zh_CN");
//
//                String str = "{\"header\":{\"local\":\"zh_CN\",\"agent\":\"WEB15\",\"bfw-ctrl\":\"json\",\"version\":\"\",\"device\":\"\",\"platform\":\"\",\"plugins\":\"\",\"page\":\"\",\"ext\":\"\"},\"request\":[{\"id\":10,\"method\":\"PsnAccBocnetCreateConversationPre\",\"conversationId\":null,\"params\":null}]}";
//                StringEntity entity = new StringEntity(str,"utf-8");//解决中文乱码问题
//                entity.setContentEncoding("UTF-8");
//                entity.setContentType("application/json");
//                httpPost.setEntity(entity);
//                response2 = httpclient.execute(httpPost);
//
//                System.out.println(EntityUtils.toString(response2.getEntity()));
//                System.out.println("Login form get: " + response2.getStatusLine());
//                EntityUtils.consume(entity);
//
//                System.out.println("Post logon cookies:");
//                List<Cookie> cookies = cookieStore.getCookies();
//                if (cookies.isEmpty()) {
//                    System.out.println("None");
//                } else {
//                    for (int i = 0; i < cookies.size(); i++) {
//                        System.out.println("- " + cookies.get(i).toString());
//                    }
//                }
//            } finally {
//                response2.close();
//            }
//        } finally {
//            httpclient.close();
//        }
    }
}
