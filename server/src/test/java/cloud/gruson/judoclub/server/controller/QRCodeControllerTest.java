package cloud.gruson.judoclub.server.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.UUID;

import javax.imageio.ImageIO;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import cloud.gruson.judoclub.server.config.ExternalBeanConfiguration;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
class QRCodeControllerTest {

    @Autowired
    QRCodeController qrCodeController;

    @Autowired
    ExternalBeanConfiguration externalBeanConfiguration;

    @Test
    void testExternalBeanQRCodeWriter() {
        Assertions.assertNotNull(externalBeanConfiguration.qrCodeWriter());
    }

    @Test
    void testGenerateQRCodeUUID() throws WriterException, IOException, NotFoundException {
        var randomUUID = UUID.randomUUID();
        var byteQRCode = qrCodeController.generateQRCodeUUID(randomUUID);
        Assertions.assertNotNull(byteQRCode);
        Assertions.assertTrue(
            byteQRCode.length > 0,
            "The Byte Array generated from an UUID is not empty"    
        );

        Assertions.assertEquals(decodeQR(byteQRCode), randomUUID.toString());
    }

    private String decodeQR(byte[] ba) throws IOException, NotFoundException {
        var is = new ByteArrayInputStream(ba);
        var bi = ImageIO.read(is);
        var binaryBitmap = new BinaryBitmap(
            new HybridBinarizer(new BufferedImageLuminanceSource(bi))
        );
        return new MultiFormatReader().decode(binaryBitmap).getText();
    }
}
