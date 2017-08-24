package httpclientdemo;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by quan on 2017/7/20.
 * 使用登陆过后的Cookie里面的值，访问其他页面
 */
public class getContentUsingCookie {

    public final static void main(String[] args) throws Exception {
        BasicCookieStore basicCookieStore = new BasicCookieStore();

        BasicClientCookie cookie1 = new BasicClientCookie("JSESSIONID","E74703D8BFB2EFF13FD2C684111988D8");
        cookie1.setDomain("122.224.134.195");
        cookie1.setPath("/");

        BasicClientCookie cookie2 = new BasicClientCookie("token","b486a0aa-ded3-495c-a031-fdf73f0c47aa");
        cookie2.setDomain("122.224.134.195");
        cookie2.setPath("/");

        BasicClientCookie cookie3 = new BasicClientCookie("username","quanquanliu");
        cookie3.setDomain("122.224.134.195");
        cookie3.setPath("/");

        basicCookieStore.addCookie(cookie1);
        basicCookieStore.addCookie(cookie2);
        basicCookieStore.addCookie(cookie3);

        CloseableHttpClient httpclient = HttpClients.custom().setDefaultCookieStore(basicCookieStore).build();
        try {
            HttpGet httpget = new HttpGet("http://122.224.134.195:8092/shopxx/member/obs/cardCharge.jhtml");

            System.out.println("Executing request " + httpget.getRequestLine());
            CloseableHttpResponse closeableHttpResponse = httpclient.execute(httpget);
            HttpEntity httpEntity = closeableHttpResponse.getEntity();


            Document doc = Jsoup.parse(htmlContent.getContent(httpEntity));

            Element element = doc.select("title").first();

            System.out.println(element.html());

            //if(element.)


//            // Create a custom response handler
//            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
//
//                @Override
//                public String handleResponse(
//                        final HttpResponse response) throws ClientProtocolException, IOException {
//                    int status = response.getStatusLine().getStatusCode();
//                    if (status >= 200 && status < 300) {
//                        HttpEntity entity = response.getEntity();
//                        return entity != null ? EntityUtils.toString(entity) : null;
//                    } else {
//                        throw new ClientProtocolException("Unexpected response status: " + status);
//                    }
//                }
//
//            };
//            String responseBody = httpclient.execute(httpget, responseHandler);
//            System.out.println("----------------------------------------");
//            System.out.println(responseBody);
        } finally {
            httpclient.close();
        }
    }
}
