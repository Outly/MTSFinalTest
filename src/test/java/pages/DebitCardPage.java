package pages;

import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DebitCardPage {

    private final By CARD_NAMES = By.cssSelector("a h4");
    private final By TAKE_CARD_BUTTON = By.cssSelector(".Wrapper-sc-1vydk7-0.buKOfJ.ButtonText-sc-48arcs-2.ivMpRV");

    public DebitCardPage checkCardNames(String cardType) {
        $$(CARD_NAMES).shouldBe(sizeGreaterThan(0), Duration.ofSeconds(10)).stream().forEach(x -> x.getText().contains(cardType));
        return this;
    }

    public DebitCardPage goToFirstProduct() {
        $(TAKE_CARD_BUTTON).shouldBe(visible).click();
        return this;
    }
}
