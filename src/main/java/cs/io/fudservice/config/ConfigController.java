package cs.io.fudservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class ConfigController {

    @Value("${config-test-name: Dvn Default}")
    private String configTestName;

    @RequestMapping("/testconfig")
    public String getTest() {
        System.out.println("configTestName = " + configTestName);

        return configTestName;
    }

}
