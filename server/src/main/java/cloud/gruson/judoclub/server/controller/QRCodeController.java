package cloud.gruson.judoclub.server.controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.qrcode.QRCodeWriter;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;

import javax.imageio.ImageIO;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("qrcode")
public class QRCodeController {
    
    private final QRCodeWriter qrCodeWriter;

    @GetMapping(path = "/{uuid}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] generateQRCodeUUID(@PathVariable UUID uuid) throws WriterException, IOException {
        var bi = generateQRCodeImage(uuid.toString());
        var baos = new ByteArrayOutputStream();
        ImageIO.write(bi, "png", baos);
        return baos.toByteArray();
    }

    private BufferedImage generateQRCodeImage(String barcodeText) throws WriterException {
        var bitMatrix = 
          qrCodeWriter.encode(barcodeText, BarcodeFormat.QR_CODE, 200, 200);
        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }

}
