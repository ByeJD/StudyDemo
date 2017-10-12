//package com.Tess4j;
//
///**
// * @author Quan
// * @date 2017/10/6
// * @desciption
// */
//import org.apache.xmlgraphics.image.codec.tiff.TIFFEncodeParam;
//
//import java.awt.image.BufferedImage;
//import java.awt.image.RenderedImage;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.util.ArrayList;
//import java.util.List;
//
//class SetDDPI
//{
//    static void tiff_Maker(List<BufferedImage> output, String result) throws   IOException
//    {
//        TIFFEncodeParam params = new TIFFEncodeParam();
//        OutputStream out = new FileOutputStream(result);
//        List<BufferedImage> imageList = new ArrayList<BufferedImage>();
//        for (int i = 1; i < output.size(); i++)
//        {
//            imageList.add(output.get(i));
//        }
//        params.setWriteTiled(true);
//        params.setCompression(TIFFEncodeParam.COMPRESSION_GROUP4);
//        params.setExtraImages(imageList.iterator());
//        TIFFField[] extras = new TIFFField[2];
//        extras[0] = new TIFFField(282, TIFFField.TIFF_RATIONAL, 1, (Object) new long[][] { { (long) 300, (long) 1 },
//                { (long) 0, (long) 0 } });
//        extras[1] = new TIFFField(283, TIFFField.TIFF_RATIONAL, 1, (Object) new long[][] { { (long) 300, (long) 1 },
//                { (long) 0, (long) 0 } });
//        params.setExtraFields(extras);
//        ImageEncoder encoder = ImageCodec.createImageEncoder("tiff", out, params);
//        encoder.encode(output.get(0));
//        out.close();
//    }
//    static List<BufferedImage> tiff_Extractor(File tiff) throws IOException
//    {
//        List<BufferedImage> images = new ArrayList<BufferedImage>();
//        SeekableStream ss = new FileSeekableStream(tiff);
//        ImageDecoder decoder = ImageCodec.createImageDecoder("tiff", ss, null);
//        int numPages = decoder.getNumPages();
//        for (int j = 0; j < numPages; j++)
//        {
//            PlanarImage op = new NullOpImage(decoder.decodeAsRenderedImage(j), null, null, OpImage.OP_IO_BOUND);
//            images.add(op.getAsBufferedImage());
//
//        }
//        return images;
//    }
//}