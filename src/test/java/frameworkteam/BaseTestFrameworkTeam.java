package frameworkteam;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;

public class BaseTestFrameworkTeam {

    @BeforeClass
    void initBeforeClass(){
        Configuration.baseUrl = "https://framework.team";
        Configuration.browserSize = "1920x2100";
        Configuration.timeout = 15000;
    }
}
