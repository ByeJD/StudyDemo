package com.Tess4j;

import net.sourceforge.lept4j.DPix;
import net.sourceforge.lept4j.Leptonica1;
import net.sourceforge.lept4j.Pix;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.ImageHelper;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.io.File;
import java.io.IOException;

/**
 * @author Quan
 * @date 2017/10/5
 * @desciption
 */
public class tess4jDemo {

    public static void main(String[] args) throws IOException {
        File imageFile = new File("C:\\Users\\quan\\Desktop\\huangshi\\4.png");

       BufferedImage bufferedImage = ImageIO.read(imageFile);
        System.out.println(bufferedImage.getWidth());
        System.out.println(bufferedImage.getColorModel().getPixelSize());
        System.out.println(bufferedImage.getTransparency());
//        BufferedImage bufferedImage1 = zoomInImage(bufferedImage,1);
        BufferedImage bufferedImageScale = ImageHelper.getScaledInstance(bufferedImage,(int)(bufferedImage.getWidth()*1.5),(int)((bufferedImage.getHeight())*1.5));


//        File file = new File("C:\\Users\\quan\\Desktop\\huangshi\\test_scale.tif");
//
//        ImageIO.write(bufferedImageScale,"tif",file);
//        IIOImage iioImage = new IIOImage(bufferedImage,null,null);
//        IIOImage iioImage1 = ImageHelper.getScaledInstance(iioImage,2);
//        RenderedImage renderedImage  = iioImage1.getRenderedImage();
//        BufferedImage mine =
//                new BufferedImage(renderedImage.getWidth(),
//                        renderedImage.getHeight(),
//                        BufferedImage.TYPE_BYTE_GRAY);
//        mine.getGraphics().drawImage(renderedImage,0,0,null);

        ITesseract instance = new Tesseract();  // JNA Interface Mapping
        instance.setDatapath("C:\\Users\\quan\\eclipse-workspace\\Tess4jDemo\\tessdata");
        instance.setLanguage("chi_sim");


     // ITesseract instance = new Tesseract1(); // JNA Direct Mapping

        try {
            String result = instance.doOCR(ImageHelper.convertImageToGrayscale(bufferedImageScale));
            System.out.println(result);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
//
//        test();
    }

    public static void test(){
        Pix pix = Leptonica1.pixRead("C:\\Users\\quan\\Desktop\\huangshi\\2.png");
        Pix pix1 =  Leptonica1.pixScaleColorLI(pix,1200,900);
        int t = Leptonica1.pixWriteAutoFormat("ii",pix1);
        System.out.println(t);

//        System.out.println(pix.w);
//        System.out.println(pix.h);
//
//        DPix dPix = Leptonica1.dpixRead("C:\\Users\\quan\\Desktop\\huangshi\\12313.tiff");
//        System.out.println(dPix.data);
//        System.out.println(dPix.h);
//        System.out.println(dPix.w);
//        Leptonica1.dpixSetResolution(dPix)
    }

    public static BufferedImage  zoomInImage(BufferedImage  originalImage, Integer times){
        int width = originalImage.getWidth()*times;
        int height = originalImage.getHeight()*times;
        BufferedImage newImage = new BufferedImage(width,height,originalImage.getType());
        Graphics g = newImage.getGraphics();
        g.drawImage(originalImage, 0,0,width,height,null);
        g.dispose();
        return newImage;
    }
}
