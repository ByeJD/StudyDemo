package designpatternstudy;


import java.io.*;

interface Target {

    public void submitCaptcha();

}

class qqchaoren {

    public void QQChaoren_m1(){}
    public void QQChaoren_m2(){}
    public void QQChaoren_m3(){}

}

public class QQChaoRenProvider extends qqchaoren implements Target {

    public void submitCaptcha() {
        QQChaoren_m1();
        QQChaoren_m2();
    }
}
public class Adapter {
    public static void main(String[] args) throws Exception{
//        String filePath = Thread.currentThread().getContextClassLoader().getResource("log4j.properties").getPath();
//        BufferedReader br = new BufferedReader(new FileReader(filePath));
//        String str;
//        while ((str=br.readLine())!= null){
//            System.out.println(str);
//        }
    }
}
