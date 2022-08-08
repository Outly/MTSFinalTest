package pages;

import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static tests.BaseTest.cfg;

public class HomePage {

    private final By CARDS_LINK = By.cssSelector(".styled__WrapperTextLink-sc-ip06ne-5.cKgtWc");
    private final By DEBIT_CARD_LINK = By.cssSelector("a[href='/chastnim-licam/karti/all/debet/']");

    public HomePage openPage() {
        open(cfg.baseUrl());
        return this;
    }

    public HomePage goToDebitCards() {
        $(CARDS_LINK).shouldBe(visible, Duration.ofSeconds(15)).hover();
        $(DEBIT_CARD_LINK).shouldBe(visible).click();
        return this;
    }

}
