package myQRcode;

import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QRcode {
    public static void main(String[] args) {
        QRcode zxing = new QRcode();
       zxing.outputCode("物联网192\n2019124049\n吴转体", "D:\\myQRcode.png");
    }



    private void outputCode(String content, String path) {

        int width = 300;
        int height = 300;
    	String format="png";
    	int flag=1;
       
        HashMap<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();

        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");

        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.Q);

        hints.put(EncodeHintType.MARGIN, 2);

        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
            Path file = new File(path).toPath();
            MatrixToImageWriter.writeToPath(bitMatrix, format, file);
            flag=1;
        } catch (Exception e) {

            e.printStackTrace();
            flag= 0;
        }
        if(flag==1) {
            System.out.println("二维码生成成功\n请前往D盘下查看myQRcode.png");
        }
        else {
        	System.out.println("二维码生成失败!");
        }

    }

}