package frameworkteam;

import org.pages.frameworkteam.MainPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class FrameworkTeamTests extends BaseTestFrameworkTeam {

    @BeforeMethod
    void initBeforeMethod(){
        open("/");
    }

    @Test(description = "Open Contacts page")
    public void openContactsPageTest(){
        page(MainPage.class)
                .goToContactsPage()
                .contactsPageIsOpen()
                .contactFormExist();

        sleep(5000);
    }

    @Test(description = "Check menu button")
    public void showAndHideMenuTest(){
        page(MainPage.class)
                .menuIsHidden()
                .clickMenuButton()
                .menuIsShow()
                .clickMenuButton()
                .menuIsHidden();

        sleep(5000);
    }

    @Test(description = "Check hh link")
    public void linkHhTest(){
        page(MainPage.class)
                .menuIsHidden()
                .clickMenuButton()
                .menuIsShow()
                .goToJobsPage()
                .jobsPageIsOpen()
                .buttonExists();

        sleep(5000);
    }

}
