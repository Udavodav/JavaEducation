package org.pages.frameworkteam;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {

    @FindBy(xpath = "//a[@href='/contacts']/button")
    private SelenideElement contactsButton;

    @FindBy(xpath = "//a[@href='/jobs']")
    private SelenideElement jobsButton;

    @FindBy(xpath = "//button[@aria-label='закрыть меню']")
    private SelenideElement menuButton;

    @FindBy(xpath = "//div[@class='container burger']")
    private SelenideElement menu;

    @Step("Проверка наличия кнопки 'НАПИСАТЬ НАМ', она видима и кликабельна")
    public ContactsPage goToContactsPage() {
        contactsButton
                .should(exist)
                .shouldBe(visible)
                .shouldHave(text("НАПИСАТЬ НАМ"))
                .click();

        return page(ContactsPage.class);
    }

    @Step("Проверка что кнопка Карьера существует и кликабельна")
    public JobsPage goToJobsPage() {
        jobsButton
                .should(exist)
                .shouldBe(visible)
                .shouldHave(text("Карьера"))
                .click();

        return page(JobsPage.class);
    }

    @Step("Проверка что боковое меню скрыто")
    public MainPage menuIsHidden() {
        menu
                .shouldBe(hidden);

        return page(MainPage.class);
    }

    @Step("Проверка наличия кнопки меню и нажать на нее")
    public MainPage clickMenuButton() {
        menuButton
                .shouldBe(exist)
                .shouldBe(visible)
                .click();

        return page(MainPage.class);
    }

    @Step("Проверка что боковое меню показано")
    public MainPage menuIsShow() {
        menu
                .shouldBe(visible);

        return page(MainPage.class);
    }
}
