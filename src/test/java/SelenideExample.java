import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class SelenideExample {

    @Test
    public void test1() {
        open("https://www.simbirsoft.com");
        $(By.cssSelector("a[data-gclick='showModalFeedback']"))
                .shouldBe(visible)
                .shouldHave(text("Написать нам"))
                .click();
        sleep(3000);
    }

    @Test
    public void test2() {
        open("https://www.simbirsoft.com");
        $(By.xpath("//*[contains(@class,'gh-nav-item--about')]"))
                .shouldHave(text("О нас"))
                .hover();
        $(By.linkText("Контакты"))
                .shouldHave(text("Контакты"))
                .click();
        $(By.xpath("//h1"))
                .shouldHave(text("Контакты"))
                .shouldBe(visible);
        webdriver().shouldHave(url("https://www.simbirsoft.com/contacts/"));

        sleep(3000);
    }

}
