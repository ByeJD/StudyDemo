package designpatternstudy;


import java.io.*;


// 目标(Target)角色,要适配的接口
interface Target {

    void submitCaptcha();

}

// 源(Adapee)角色：现在需要适配的类。
class qqchaoren {

    public void QQChaoren_m1(){}
    public void QQChaoren_m2(){}
    public void QQChaoren_m3(){}

}

// 源(Adapee)角色：现在需要适配的类。
class damatu{
    public void damatu_m1(){}
    public void damatu_m2(){}
    public void damatu_m3(){}
}

// QQ超人打码：适配器角色QQChaoRenProviderr扩展了qqchaoren,同时又实现了目标(Target)接口。由于Adaptee没有提供sampleOperation2()方法，而目标接口又要求这个方法，因此适配器角色Adapter实现了这个方法。
class QQChaoRenProvider extends qqchaoren implements Target {

    public void submitCaptcha() {
        QQChaoren_m1();
        QQChaoren_m2();
        QQChaoren_m3();
    }
}

// 打码兔子：适配器角色DaMaTuProvider扩展了damatu,同时又实现了目标(Target)接口。
class DaMaTuProvider extends damatu implements Target {

    public void submitCaptcha() {
        damatu_m1();
        damatu_m2();
        damatu_m3();
        daMaTuExtraMethod();
    }

    public void daMaTuExtraMethod(){

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
