package tests;

import org.junit.Test;
import pages.DebitCardPage;
import pages.HomePage;
import pages.ProductPage;

public class MTSBankTest extends BaseTest {

    final String cardType = "дебетовая";
    final String userName = "Тестов Тест Тестович";
    final String phone = "900900";
    final String email = "test@testex.ru";

//    @Before
//    public void someName() {
//        HomePage homePage = new HomePage();
//        homePage.openPage()
//                .sendDestination(destinationTown)
//                .sendCheckInCheckOutDates(checkIn, checkOut)
//                .sendGuestsAndRooms(adultCount, childrenCount, roomCount)
//                .searchBoxButtonClick();
//    }


//    1. На сайте https://www.mtsbank.ru/ выбрать раздел "карты" и нажать в появившемся меню "дебетовые карты"
//    2. Проверить, что в названиях всех предложенных продуктов содержится слово "дебетовая"
    @Test
    public void productNameTest() {
        HomePage homePage = new HomePage();
        homePage.openPage()
                .goToDebitCards();

        DebitCardPage debitCardPage = new DebitCardPage();
        debitCardPage.checkCardNames(cardType);
    }

//    1. На сайте https://www.mtsbank.ru/ выбрать раздел "карты" и нажать в появившемся меню "дебетовые карты"
//    2. В предложенных продуктах выбрать первый и нажать кнопку "оформить карту"
//    3. Корректно заполнить поле "Фамилия, имя, отчество"
//    4. Некорректно заполнить поле "Мобильный телефон"
//    5. Корректно заполнить поле "Электронная почта"
//    6. Проветить, что под полем "Мобильный телефон" появился текст "Введите верный номер телефона"
    @Test
    public void incorrectPhoneMassageTest() {
        HomePage homePage = new HomePage();
        homePage.openPage()
                .goToDebitCards();

        DebitCardPage debitCardPage = new DebitCardPage();
        debitCardPage.goToFirstProduct();

        ProductPage productPage = new ProductPage();
        productPage.sendUserName(userName)
                   .sendPhone(phone)
                   .sendEmail(email)
                   .checkPhoneErrorMassage();
    }

}
