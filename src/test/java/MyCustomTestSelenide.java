import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class MyCustomTestSelenide {

    @BeforeClass
    public void setUpBeforeClass() {
        Configuration.baseUrl = "https://www.gosuslugi.ru";
    }

    @Test
    public void gosuslugi_click_login_test() {
        open("/");
        $x("//button[contains(@class, 'login-button')]")
                .shouldBe(visible)
                .shouldHave(text("Войти"))
                .click();
        webdriver().shouldHave(url("https://esia.gosuslugi.ru/login/"));

        sleep(3000);
    }

    @Test
    public void gosuslugi_click_help_test() {
        open("/");
        $(By.cssSelector("a[href='/help']"))
                .shouldBe(visible)
                .shouldHave(text("Помощь"))
                .click();
        webdriver().shouldHave(url("https://www.gosuslugi.ru/help"));
        $x("//div[contains(@class, 'popular-faq-wrapper')]")
                .shouldHave(text("Популярные вопросы"));

        sleep(3000);
    }

    @Test(dataProvider = "login")
    public void gosuslugi_login_fail_test(String login, String password) {
        open("/");
        $x("//button[contains(@class, 'login-button')]")
                .shouldBe(visible)
                .shouldHave(text("Войти"))
                .click();
        webdriver().shouldHave(url("https://esia.gosuslugi.ru/login/"));

        $("#login").val(login);
        $("#password").val(password).pressEnter();

        $x("//div[contains(@class, 'error-label')]")
                .shouldBe(visible)
                .shouldHave(text("Неверные логин или пароль"));

        sleep(3000);
    }

    @DataProvider(name = "login")
    public Object[][] login() {
        return new Object[][]{
                {"+7 (800) 555-35-35", "12345667"}
        };
    }

}
