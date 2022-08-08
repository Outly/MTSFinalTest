package pages;

import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ProductPage {

    private final By USER_NAME_INPUT = By.cssSelector("div[class='TextareaWrapper-sc-1ux9qvi-0 bUIboz'] textarea");
    private final By PHONE_INPUT = By.cssSelector("input[type='tel']");
    private final By EMAIL_INPUT = By.cssSelector("input[type='email']");
    private final By PHONE_ERROR_MASSAGE = By.cssSelector(".Wrapper-sc-1vydk7-0.OlnRe.HelperText-sc-jsokzo-0.hByJHf");

    public ProductPage sendUserName(String userName) {
        $(USER_NAME_INPUT).shouldHave(visible, Duration.ofSeconds(15))
                          .scrollTo()
                          .sendKeys(userName);
        return this;
    }

    public ProductPage sendPhone(String phone) {
        $(PHONE_INPUT).shouldHave(visible, Duration.ofSeconds(15))
                .scrollTo()
                .sendKeys(phone);
        return this;
    }

    public ProductPage sendEmail(String email) {
        $(EMAIL_INPUT).shouldHave(visible, Duration.ofSeconds(15))
                .scrollTo()
                .sendKeys(email);
        return this;
    }

    public ProductPage checkPhoneErrorMassage() {
        $(PHONE_ERROR_MASSAGE).shouldBe(visible).shouldHave(text("Введите верный номер телефона"));
        return this;
    }
}
