package cn.flik1337.vision.common.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Base64;
import java.util.Hashtable;

@Component
public class QrCodeUtil {
    private static final String CHARSET = "UTF-8";
    private static final int QRCODE_SIZE = 400;
    private static final String FORMAT_NAME = "JPG";

    private static final String BASE64_PREFIX = "data:image/png;base64,";

    public static BufferedImage createImage(String content) throws Exception {
        Hashtable<EncodeHintType, Object> hints = new Hashtable<>();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
        hints.put(EncodeHintType.MARGIN, 1);
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content,
                BarcodeFormat.QR_CODE, QRCODE_SIZE, QRCODE_SIZE, hints);
        // 去掉白边 enclosing
        int[] rec = bitMatrix.getEnclosingRectangle();
        //System.out.println(rec.toString());
        if (rec != null) {
            int resWidth = rec[2] + 1;
            int resHeight = rec[3] + 1;
            BitMatrix resMatrix = new BitMatrix(resWidth, resHeight);
            resMatrix.clear();
            for (int i = 0; i < resWidth; i++) {
                for (int j = 0; j < resHeight; j++) {
                    if (bitMatrix.get(i + rec[0], j + rec[1])) {
                        resMatrix.set(i, j);
                    }
                }
            }
        }

        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF); // 透明转白色
            }
        }


        return image;
    }
    public static void encodeToImg(String content,HttpServletResponse resp) throws Exception {
        BufferedImage image = createImage(content);
        ImageIO.write(image, FORMAT_NAME, resp.getOutputStream());
    }
    public static String encodeToBase64(String content) throws Exception {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        BufferedImage image = createImage(content);
        ImageIO.write(image, FORMAT_NAME, os);
        String imgBase64 = Base64.getEncoder().encodeToString(os.toByteArray());
        String result = new String(BASE64_PREFIX  + imgBase64);
        return result;
    }


}