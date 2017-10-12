package com.Tess4j;

import javax.imageio.*;
import javax.imageio.metadata.IIOInvalidTreeException;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataNode;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * @author Quan
 * @date 2017/10/6
 * @desciption
 */
public class ChangeDPI {
    private static double INCH_2_CM = 2.54;
    //private BufferedImage gridImage;
    private static void saveGridImage(File output,BufferedImage gridImage) throws IOException {
        output.delete();

        final String formatName = "png";

        for (Iterator<ImageWriter> iw = ImageIO.getImageWritersByFormatName(formatName); iw.hasNext();) {
            ImageWriter writer = iw.next();
            ImageWriteParam writeParam = writer.getDefaultWriteParam();
            ImageTypeSpecifier typeSpecifier = ImageTypeSpecifier.createFromBufferedImageType(BufferedImage.TYPE_INT_RGB);
            IIOMetadata metadata = writer.getDefaultImageMetadata(typeSpecifier, writeParam);
            if (metadata.isReadOnly() || !metadata.isStandardMetadataFormatSupported()) {
                continue;
            }

            setDPI(metadata);

            final ImageOutputStream stream = ImageIO.createImageOutputStream(output);
            try {
                writer.setOutput(stream);
                writer.write(metadata, new IIOImage(gridImage, null, metadata), writeParam);

            } finally {
                stream.close();
            }
            break;
        }
    }

    private static void setDPI(IIOMetadata metadata) throws IIOInvalidTreeException {

        // for PMG, it's dots per millimeter
        double dotsPerMilli = 1.0 * 300 / 10 / INCH_2_CM;

        IIOMetadataNode horiz = new IIOMetadataNode("HorizontalPixelSize");
        horiz.setAttribute("value", Double.toString(dotsPerMilli));

        IIOMetadataNode vert = new IIOMetadataNode("VerticalPixelSize");
        vert.setAttribute("value", Double.toString(dotsPerMilli));

        IIOMetadataNode dim = new IIOMetadataNode("Dimension");
        dim.appendChild(horiz);
        dim.appendChild(vert);

        IIOMetadataNode root = new IIOMetadataNode("javax_imageio_1.0");
        root.appendChild(dim);

        metadata.mergeTree("javax_imageio_1.0", root);
    }

    public static void main(String[] args) {
        try {
            BufferedImage bufferedImage = ImageIO.read(new File("C:\\Users\\quan\\Desktop\\huangshi\\3.png"));
            saveGridImage(new File("C:\\Users\\quan\\Desktop\\huangshi\\tesss.png"),bufferedImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
