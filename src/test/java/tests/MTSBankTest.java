package tests;

import org.junit.Test;
import pages.DebitCardPage;
import pages.HomePage;

import static java.lang.Thread.sleep;

public class MTSBankTest extends BaseTest {

    final String cardType = "дебетовая";

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
//    @Test
    public void incorrectPhoneMassageTest() throws InterruptedException {
        HomePage homePage = new HomePage();
        homePage.openPage()
                .goToDebitCards();

        DebitCardPage debitCardPage = new DebitCardPage();
        debitCardPage.goToFirstProduct();

        sleep(5000);
    }

}
