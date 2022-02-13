package cloud.gruson.judoclub.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QRCodeViewController {

    @GetMapping("/")
    public String home() {
        return "home";
    }
    @GetMapping("/scanner")
    public String scanner() {
        return "scanner";
    }
    @GetMapping("/about")
    public String about() {
        return "about";
    }
    
}
