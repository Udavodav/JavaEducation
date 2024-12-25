package org.pages.frameworkteam;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class JobsPage {

    @FindBy(xpath = "//button[@class='button dark footer__button']")
    private SelenideElement hhButton;

    @Step("Проверка что страница открыта")
    public JobsPage jobsPageIsOpen() {
        $(By.xpath("//h2/div[@class='hero__heading']"))
                .should(exist)
                .shouldBe(visible)
                .shouldHave(text("Мы всегда в"));

        return this;
    }

    @Step("Проверка что кнопка просмотра вакансий присутствует")
    public JobsPage buttonExists() {
        hhButton
                .should(exist)
                .shouldBe(visible)
                .shouldHave(text("Посмотреть вакансии"));

        return this;
    }
}
