package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static tests.BaseTest.cfg;

public class HomePage {

    private final By CARDS_LINK = By.cssSelector(".styled__WrapperTextLink-sc-ip06ne-5.cKgtWc");
    private final By DEPOSIT_LINK = By.cssSelector("a[href='/chastnim-licam/vkladi/']");
    private final By DEBIT_CARD_LINK = By.cssSelector("a[href='/chastnim-licam/karti/all/debet/']");
    private final By MTS_DEPOSIT_7PER_LINK = By.cssSelector("a[href='/chastnim-licam/vkladi/mts-schet/']");
    private final By TELEGRAM_LINK = By.cssSelector("a[href='https://t.me/mts_bank_official'] svg");

    @Step("Открыть домашнюю страницу")
    public HomePage openPage() {
        open(cfg.baseUrl());
        return this;
    }

    @Step("Навести курсор на 'Карты' и нажать пункт 'Дебетовые карты'")
    public HomePage goToDebitCards() {
        $(CARDS_LINK).shouldBe(visible, Duration.ofSeconds(15)).hover();
        $(DEBIT_CARD_LINK).shouldBe(visible).click();
        return this;
    }

    @Step("Навести курсор на 'Вклады и счета' и нажать пункт 'Накопительный МТС Счет до 7%'")
    public HomePage goToDeposit() {
        $(DEPOSIT_LINK).shouldBe(visible, Duration.ofSeconds(15)).hover();
        $(MTS_DEPOSIT_7PER_LINK).shouldBe(visible).click();
        return this;
    }

    @Step("Нажать кнопку соцсети telegram")
    public HomePage goToTelegram() {
        $(TELEGRAM_LINK).shouldBe(visible).click();
        return this;
    }
}
