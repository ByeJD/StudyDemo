package thinkinjavademo.chapter8;

import java.io.InputStream;

/**
 * @author Quan
 * @date 2017/9/6
 * @desciption
 */
enum Note {
    MIDDLE_C,C_SHARP,B_FLAT;
}

//class Instrument{
//    public void paly(Note n){
//        System.out.println("Instrument.play()");
//    }
//}
//
//class Wind extends Instrument{
//    public void paly(Note n){
//        System.out.println("Wind.play() " + n);
//    }
//}
//class Stringed extends Instrument{
//    public void paly(Note n){
//        System.out.println("Stringed.play() " + n);
//    }
//}
//class Brass extends Instrument{
//    public void paly(Note n){
//        System.out.println("Brass.play() " + n);
//    }
//}
//
//public class Music{
//    public static void main(String[] args) {
//        Wind flute = new Wind();
//        tune(flute);   // 向上转型
//    }
//
//    private static void tune(Instrument i) {
//        i.paly(Note.MIDDLE_C);
//    }
//}
