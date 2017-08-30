package httpclientdemo;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.SystemDefaultCredentialsProvider;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.net.URI;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

/**
 * @author Quan
 * @date 2017/8/30
 * @desciption
 */
public class ClientFormLogin {
    public static void main(String[] args) throws Exception {

        BasicCookieStore cookieStore = new BasicCookieStore();
        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCookieStore(cookieStore)
                .build();
        try {


            HttpGet httpget = new HttpGet("http://www.lzzfgjj.com/login.jspx");
            CloseableHttpResponse response1 = httpclient.execute(httpget);
            try {
                HttpEntity entity = response1.getEntity();

                System.out.println("Login form get: " + response1.getStatusLine());
                EntityUtils.consume(entity);

                System.out.println("Initial set of cookies:");
                List<Cookie> cookies = cookieStore.getCookies();
                if (cookies.isEmpty()) {
                    System.out.println("None");
                } else {
                    for (int i = 0; i < cookies.size(); i++) {
                        System.out.println("- " + cookies.get(i).toString());
                    }
                }
            } finally {
                response1.close();
            }

            HttpGet httpgetCaptcha = new HttpGet("http://www.lzzfgjj.com//captcha.svl");
            response1 = httpclient.execute(httpgetCaptcha);
            try {
                HttpEntity entity = response1.getEntity();


                System.out.println("Login form get: " + response1.getStatusLine());
                saveCaptcha(entity.getContent());
                EntityUtils.consume(entity);

                System.out.println("Initial set of cookies:");
                List<Cookie> cookies = cookieStore.getCookies();
                if (cookies.isEmpty()) {
                    System.out.println("None");
                } else {
                    for (int i = 0; i < cookies.size(); i++) {
                        System.out.println("- " + cookies.get(i).toString());
                    }
                }
            } finally {
                response1.close();
            }

            Scanner scanner = new Scanner(System.in);
            String captchaCode = scanner.nextLine();
            HttpUriRequest login = RequestBuilder.post()
                    .setUri(new URI("http://www.lzzfgjj.com/login.jspx"))
                    .addParameter("username", "450203197907081036")
                    .addParameter("password", "123456")
                    .addParameter("captcha",captchaCode)
                    .build();
            CloseableHttpResponse response2 = httpclient.execute(login);
            try {
                HttpEntity entity = response2.getEntity();

                System.out.println("Login form get: " + response2.getStatusLine());
                System.out.println(EntityUtils.toString(entity));
                EntityUtils.consume(entity);


                System.out.println("Post logon cookies:");
                List<Cookie> cookies = cookieStore.getCookies();
                if (cookies.isEmpty()) {
                    System.out.println("None");
                } else {
                    for (int i = 0; i < cookies.size(); i++) {
                        System.out.println("- " + cookies.get(i).toString());
                    }
                }
            } finally {
                response2.close();
            }


    // http://www.lzzfgjj.com/grcx/grcx_grjbqk.jspx
            HttpGet httpgetBriefPage = new HttpGet("http://www.lzzfgjj.com/grcx/grcx_grjbqk.jspx");
            response1 = httpclient.execute(httpgetBriefPage);
            try {
                HttpEntity entity = response1.getEntity();


                System.out.println("Login form get: " + response1.getStatusLine());
                System.out.println(EntityUtils.toString(entity));
                EntityUtils.consume(entity);

                System.out.println("Initial set of cookies:");
                List<Cookie> cookies = cookieStore.getCookies();
                if (cookies.isEmpty()) {
                    System.out.println("None");
                } else {
                    for (int i = 0; i < cookies.size(); i++) {
                        System.out.println("- " + cookies.get(i).toString());
                    }
                }
            } finally {
                response1.close();
            }
        } finally {
            httpclient.close();
        }
    }

    private static void saveCaptcha(InputStream inStream) throws Exception {
        byte[] data = readInputStream(inStream);
        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);
        //new一个文件对象用来保存图片，默认保存当前工程根目录
        File imageFile = new File(uuid+".png");
        //创建输出流
        FileOutputStream outStream = new FileOutputStream(imageFile);
        //写入数据
        outStream.write(data);
        //关闭输出流
        outStream.close();
    }


    public static byte[] readInputStream(InputStream inStream) throws Exception{
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        //创建一个Buffer字符串
        byte[] buffer = new byte[1024];
        //每次读取的字符串长度，如果为-1，代表全部读取完毕
        int len = 0;
        //使用一个输入流从buffer里把数据读取出来
        while( (len=inStream.read(buffer)) != -1 ){
            //用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
            outStream.write(buffer, 0, len);
        }
        //关闭输入流
        inStream.close();
        //把outStream里的数据写入内存
        return outStream.toByteArray();
    }

}
