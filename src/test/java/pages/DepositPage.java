package pages;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.Assert.assertTrue;

public class DepositPage {

    private final By INITIAL_INVESTMENT_INPUT = By.cssSelector("div[label='Первоначальное вложение'] input");
    private final By MONTHLY_REPLENISHMENT_INPUT = By.cssSelector("div[label='Ежемесячное пополнение'] input");
    private final By ACCUMULATION_PERIOD_INPUT = By.cssSelector("div[label='Срок накопления'] input");
    private final By PROFIT = By.cssSelector(".Wrapper-sc-6nwvzq-0.iExIpy");

    @Step("Заполнить поле 'Первоначальное вложение' корректно")
    public DepositPage sendInitialInvestment(int initialInvestment) {
        $(INITIAL_INVESTMENT_INPUT).shouldHave(visible, Duration.ofSeconds(15))
                .scrollTo()
                .sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE, String.valueOf(initialInvestment));
        return this;
    }

    @Step("Заполнить поле 'Ежемесячное пополнение' корректно")
    public DepositPage sendMonthlyReplenishment(int monthlyReplenishment) {
        $(MONTHLY_REPLENISHMENT_INPUT).shouldHave(visible, Duration.ofSeconds(15))
                .scrollTo()
                .sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE, String.valueOf(monthlyReplenishment));
        return this;
    }

    @Step("Заполнить поле 'Срок накопления' корректно")
    public DepositPage sendAccumulationPeriod(int accumulationPeriod) {
        $(ACCUMULATION_PERIOD_INPUT).shouldHave(visible, Duration.ofSeconds(15))
                .scrollTo()
                .sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE, String.valueOf(accumulationPeriod));
        return this;
    }

    @Step("Проверить доход по счету")
    public DepositPage depositProfitCheck(int initialInvestment, int monthlyReplenishment, int accumulationPeriod) {

        $(PROFIT).shouldNotBe(text($(PROFIT).getText()));
        Selenide.sleep(3000);
        String actualProfit = $(PROFIT).shouldBe(visible)
                .scrollTo().getText().replace(" ", "");
        int actualProfitInt = Integer.parseInt(actualProfit.substring(0, actualProfit.length() - 1));

        double currentProfit = 0;
        double currentInvestment = initialInvestment;
        for (int i = 0; i < accumulationPeriod; i++) {
            if (currentInvestment <= 1000000)
                currentProfit = currentProfit + currentInvestment * 0.07 / 12;

            else {
                currentProfit = currentProfit + ((currentInvestment - 1000000) * 0.03 + 1000000 * 0.07) / 12;
            }
                currentInvestment = currentInvestment + currentProfit + monthlyReplenishment;
            }
        System.out.println(currentProfit);
        int expectedProfit = (int) Math.ceil(currentProfit);

        assertTrue(expectedProfit - actualProfitInt <= 1);
        return this;
    }
}
