package httpclientdemo;

import org.apache.http.HttpEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by quan on 2017/7/20.
 */
public final class htmlContent {

    public static String getContent(HttpEntity httpEntity) throws  IOException{
        final StringBuilder  sb = new StringBuilder();
        BufferedReader br = null;
        try {
             br = new BufferedReader(new InputStreamReader(httpEntity.getContent()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String str = null;
        while((str=br.readLine()) != null){
            sb.append(str);
        }
        return sb.toString();
    }
}
