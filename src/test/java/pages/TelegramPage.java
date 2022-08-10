package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class TelegramPage {

    private final By CHAT_NAME = By.cssSelector(".tgme_page_title span");
    private final By VIEW_IN_TELEGRAM_BUTTON = By.cssSelector(".tgme_action_button_new.shine");

    @Step("Проверить название чата")
    public TelegramPage checkChatName() {
        $(CHAT_NAME).shouldBe(visible).shouldHave(text("МТС Банк"));
        return this;
    }

    @Step("Проверить отображение кнопки 'View in Telegram'")
    public TelegramPage checkTelegramChatButton() {
        $(VIEW_IN_TELEGRAM_BUTTON).shouldBe(visible).shouldHave(text("View in Telegram"));
        return this;
    }
}
