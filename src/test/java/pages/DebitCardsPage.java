package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DebitCardsPage {

    private final By CARD_NAMES = By.cssSelector("a h4");
    private final By TAKE_CARD_BUTTON = By.cssSelector(".Wrapper-sc-6nwvzq-0.fDVIhN");
    private final By DEBIT_CARD_HEADING = By.cssSelector(".Wrapper-sc-6nwvzq-0.jcdBAB");

    @Step("Проверить, что все названия карт содержат слово 'дебетовая'")
    public DebitCardsPage checkCardNames(String cardType) {
        $$(CARD_NAMES).shouldBe(sizeGreaterThan(0), Duration.ofSeconds(60)).stream().forEach(x -> x.getText().contains(cardType));
        return this;
    }

    @Step("Открыть страницу первой из списка дебетовой карты")
    public DebitCardsPage goToFirstDebitCard() {
        $$(TAKE_CARD_BUTTON).shouldBe(sizeGreaterThan(0), Duration.ofSeconds(60))
                            .first()
                            .shouldBe(visible)
                            .click();
        return this;
    }
}
