package com.log4j;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by quan on 2017/8/10.
 */
public class MyApp {
    private static final Logger logger = LoggerFactory.getLogger(MyApp.class);

    public static void main(String[] args) {

        logger.info("test");
    }
}
