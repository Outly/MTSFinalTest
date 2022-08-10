package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import com.codeborne.pdftest.PDF;
import java.io.IOException;
import java.time.Duration;

import static com.codeborne.pdftest.assertj.Assertions.assertThat;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class DocsPage {

    @Step("Скачать документ и проверить наличие в нём некста")
    public DocsPage downloadAndCheckDocument(String documentName, String documentContent) {
        PDF creditCardTariffPDF = null;
        try {
            creditCardTariffPDF = new PDF($x(String.format("//p[contains(text(), '%s')]/parent::div/parent::a", documentName) )
                    .shouldBe(visible, Duration.ofSeconds(40))
                    .download());
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertThat(creditCardTariffPDF).containsTextCaseInsensitive(documentContent);
        return this;
    }
}
