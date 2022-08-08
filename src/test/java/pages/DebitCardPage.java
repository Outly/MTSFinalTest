package pages;

import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DebitCardPage {

    private final By CARD_NAMES = By.cssSelector("a h4");
    private final By TAKE_CARD_BUTTON = By.cssSelector(".Wrapper-sc-6nwvzq-0.fDVIhN");
    private final By DEBIT_CARD_HEADING = By.cssSelector(".Wrapper-sc-6nwvzq-0.jcdBAB");

    public DebitCardPage checkCardNames(String cardType) {
//        $(DEBIT_CARD_HEADING).shouldBe(visible, Duration.ofSeconds(10));
        $$(CARD_NAMES).shouldBe(sizeGreaterThan(0), Duration.ofSeconds(10)).stream().forEach(x -> x.getText().contains(cardType));
        return this;
    }

    public DebitCardPage goToFirstProduct() {
//        $(DEBIT_CARD_HEADING).shouldBe(visible, Duration.ofSeconds(10));
        $$(TAKE_CARD_BUTTON).shouldBe(sizeGreaterThan(0), Duration.ofSeconds(10))
                            .first()
                            .shouldBe(visible)
                            .click();
        return this;
    }
}