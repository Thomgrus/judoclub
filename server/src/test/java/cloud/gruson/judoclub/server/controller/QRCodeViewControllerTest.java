package cloud.gruson.judoclub.server.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.NONE, properties = {
    "springdoc.api-docs.enabled=false"
})
class QRCodeViewControllerTest {

    @Autowired
    QRCodeViewController qrCodeViewController;

    @Test
    void testHomeTemplate() {
        Assertions.assertEquals("home", qrCodeViewController.home());
    }

    @Test
    void testAboutTemplate() {
        Assertions.assertEquals("about", qrCodeViewController.about());
    }

    @Test
    void testScannerTemplate() {
        Assertions.assertEquals("scanner", qrCodeViewController.scanner());
    }
    
}
