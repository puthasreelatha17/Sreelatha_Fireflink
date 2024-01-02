package captcha_Practise;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Crop {

	public static void main(String[] args) throws IOException, TesseractException {
		BufferedImage fullImg=ImageIO.read(new File("./Screenshots/screenshot1.png"));
		System.out.println("Image Dimensions  " + fullImg.getHeight()  + "and" +  fullImg.getWidth());
		BufferedImage subimg=fullImg.getSubimage(0,10,100,30);
		ImageIO.write(subimg, "png", new File("./Screenshotss/screenshotss.png"));
		File f=new File("./Screenshotss/screenshotss.png");
		ITesseract image=new Tesseract();
		image.setDatapath("C:\\Users\\User\\eclipse-workspace\\pantaloons\\Testdata");
		String result=image.doOCR(f);
		System.out.println(result);

	}

}
