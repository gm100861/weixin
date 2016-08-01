package org.linuxsogood.weixin.controller.qrcode;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by m on 16/8/1.
 * java生成识别二维码.
 */
@Controller
@RequestMapping(value = "/qrcode")
public class QRCodeController {

    /**
     *
     * @param content 要生成二维码的数据
     * @param height 生成二维码的高度
     * @param width 生成二维码的宽度
     * @param format 二维码图片类型: png jpg jpeg bmp等
     * @param response http响应对象
     */
    @RequestMapping(value = "/create")
    public void createQRCode(String content, int height , int width , String format , HttpServletResponse response) {
        try {
            ServletOutputStream outputStream = response.getOutputStream();
            HashMap<EncodeHintType, Object> hints = new HashMap<>();
            hints.put(EncodeHintType.MARGIN, 2); //设置边距
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8"); //设置编码方式
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M); //设置纠错级别

            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix encode = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, width, height);
            MatrixToImageWriter.writeToStream(encode,format,outputStream);
            outputStream.flush();
        } catch (IOException e) {
            //exception handler
        } catch (WriterException e) {
            //
        }
    }

    /**
     *
     * @param file 要识别的二维码图片.
     * @return 返回JSON格式的字符串
     */
    @RequestMapping(value = "/read")
    @ResponseBody
    public String parseQRCode(MultipartFile file) {
        try {
            if (file == null) {
                return "没有二维码图像文件";
            }
            BufferedImage img = ImageIO.read(file.getInputStream());
            BufferedImageLuminanceSource source = new BufferedImageLuminanceSource(img);
            HybridBinarizer binarizer = new HybridBinarizer(source);
            BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);

            Map<DecodeHintType, Object> hints = new HashMap<>();
            hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
            Result decode = new MultiFormatReader().decode(binaryBitmap, hints);

            StringBuffer sb = new StringBuffer();
            sb.append("{\"result\":\"");
            sb.append(decode.getText());
            sb.append("\"}");
            return sb.toString();

        } catch (IOException e) {
            //
        } catch (NotFoundException e) {
            //
        }
        return "";
    }


}
