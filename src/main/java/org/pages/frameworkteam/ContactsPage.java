package org.pages.frameworkteam;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class ContactsPage {

    @FindBy(xpath = "//form[@class='form contacts__form']")
    private SelenideElement contactForm;

    @Step("Проверка что страница открыта")
    public ContactsPage contactsPageIsOpen() {
        $(By.xpath("//h1[@class='contacts__title']"))
                .should(exist)
                .shouldBe(visible)
                .shouldHave(text("Доверьте нам"));

        return this;
    }

    @Step("Проверка существования формы и ее видно")
    public ContactsPage contactFormExist() {
        contactForm
                .should(exist)
                .shouldBe(visible);

        return this;
    }
}
