package com.quan.lingyu.main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

/**
 * Created by quan on 2017/7/30.
 */
public class Main {
    public static void main(String[] args) throws IOException {

        String url = "http://www.208xs.com/dingdian/0_332/n35607.html";
        while(true){
            Document doc = Jsoup.connect(url).get();
            Element bodyContent = doc.select("div#mains .book_content_text").first();

            Element nextChapter = doc.select(".book_content_text_next a:nth-child(3)").first();
            url  = nextChapter.attr("abs:href");
        }
    }
}
