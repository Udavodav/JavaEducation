package simbirsoft;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;

public class BaseTestSimbirsoft {

    @BeforeClass
    void initBeforeClass() {
        Configuration.baseUrl = "https://www.simbirsoft.com";
        Configuration.browserSize = "1920x2100";
        Configuration.timeout = 30000;
    }
}
