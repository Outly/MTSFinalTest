package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.*;

import static com.codeborne.selenide.Selenide.switchTo;

public class MTSBankTests extends BaseTest {

//    1. На сайте https://www.mtsbank.ru/ выбрать раздел "карты" и нажать в появившемся меню "дебетовые карты"
//    2. Проверить, что в названиях всех предложенных продуктов содержится слово "дебетовая"

    final String cardType = "дебетовая";

    @Test
    @Owner("Долженко Артём")
    @Description("На странице с дебетовыми картами выполняется проверка того, что все названия карт содержат слово 'дебетовая'.")
    @DisplayName("Проверка имён дебетовых карт")
    @Severity(value = SeverityLevel.MINOR)
    public void productNameTest() {
        HomePage homePage = new HomePage();
        homePage.openPage()
                .goToDebitCards();

        DebitCardsPage debitCardsPage = new DebitCardsPage();
        debitCardsPage.checkCardNames(cardType);
    }

//    1. На сайте https://www.mtsbank.ru/ выбрать раздел "карты" и нажать в появившемся меню "дебетовые карты"
//    2. В предложенных продуктах выбрать первый и нажать кнопку "оформить карту"
//    3. Корректно заполнить поле "Фамилия, имя, отчество"
//    4. Некорректно заполнить поле "Мобильный телефон"
//    5. Корректно заполнить поле "Электронная почта"
//    6. Проветить, что под полем "Мобильный телефон" появился текст "Введите верный номер телефона"

    final String userName = "Тестов Тест Тестович";
    final String phone = "900900";
    final String email = "test@testex.ru";

    @Test
    @Owner("Долженко Артём")
    @Description("На странице дебетовой карты проверяется вывод сообщения 'Введите верный номер телефона' " +
            "при некорректном вводе номера телефона.")
    @DisplayName("Некорректный ввод номера телефона при оформлении дебетовой карты")
    @Severity(value = SeverityLevel.NORMAL)
    public void incorrectPhoneMassageTest() {
        HomePage homePage = new HomePage();
        homePage.openPage()
                .goToDebitCards();

        DebitCardsPage debitCardsPage = new DebitCardsPage();
        debitCardsPage.goToFirstDebitCard();

        DebitCardPage debitCardPage = new DebitCardPage();
        debitCardPage.sendUserName(userName)
                   .sendPhone(phone)
                   .sendEmail(email)
                   .checkPhoneErrorMassage();
    }

//    1. На главной странице сайта https://www.mtsbank.ru/ выбрать раздел "вклады и счета" и нажать в появившемся меню "Накопительный МТС Счет до 7%"
//    2. Корректно заполнить поле 'Первоначальное вложение'
//    3. Корректно заполнить поле 'Ежемесячное пополнение'
//    4. Корректно заполнить поле 'Срок накопления'
//    5. Корректно заполнить поле "Электронная почта"
//    6. Проветить, что калькулятор сайта корректно отображает 'Доход по счёту'

    final int initialInvestment = 1100000;
    final int monthlyReplenishment = 10000;
    final int accumulationPeriod = 2;

    @Test
    @Owner("Долженко Артём")
    @Description("На странице вклада заполняются поля, необходимые для работы онлайн-калкулятора, " +
            "проверяется корректность работы онлайн-калькулятора и вывод 'Дохода по счету'")
    @DisplayName("Проверка работы онлайн-калькулятора вклада")
    @Severity(value = SeverityLevel.MINOR)
    public void depositIncomeTest() {
        HomePage homePage = new HomePage();
        homePage.openPage()
                .goToDeposit();

        DepositPage depositPage = new DepositPage();
        depositPage.sendInitialInvestment(initialInvestment)
                   .sendMonthlyReplenishment(monthlyReplenishment)
                   .sendAccumulationPeriod(accumulationPeriod)
                   .depositProfitCheck(initialInvestment, monthlyReplenishment, accumulationPeriod);
    }

//    1. На главной странице сайта https://www.mtsbank.ru/ нажать кнопку выбора соцсети "Телеграмм"
//    2. Проверить, что открывается страница чата МТС Банка в Telegram
    @Test
    @Owner("Долженко Артём")
    @Description("На главной странице сайта нажимается кнопка соцсети 'Telegram', " +
            "проверяется открытие страницы чата МТС Банка в 'Telegram'")
    @DisplayName("Проверка кнопки со ссылкой на Telegram")
    @Severity(value = SeverityLevel.TRIVIAL)
    public void telegramLinkTest() {
        HomePage homePage = new HomePage();
        homePage.openPage()
                .goToTelegram();

        switchTo().window(1);

        TelegramPage telegramPage = new TelegramPage();
        telegramPage.checkTelegramChatButton()
                        .checkChatName();
    }

//    1. На главной странице сайта https://www.mtsbank.ru/ в разделе "Помощь клинтам" нажать "Тарифы и документы"
//    2. Найти документ по имени documentName и скачать
//    3. Проверить, что скачанный файл содержит необходимый текст documentContent

    final String documentName = "Условия предоставления сервиса по переводу денежных средств с использованием номера мобильного телефона";
    final String documentContent = "Условия предоставления сервиса по переводу денежных средств с использованием номера мобильного телефона";

    @Test
    @Owner("Долженко Артём")
    @Description("На главной странице сайта в разделе 'Помощь клиентам' нажимаем 'Тарифы и документы', " +
            "скачивается документ по имени, проверяется, что документ содержит текст")
    @DisplayName("Проверка скачивания и содержимого документа")
    @Severity(value = SeverityLevel.MINOR)
    public void downloadDocumentTest() {
        HomePage homePage = new HomePage();
        homePage.openPage()
                .goToDocuments();

        DocsPage docsPage = new DocsPage();
        docsPage.downloadAndCheckDocument(documentName, documentContent);
    }
}
