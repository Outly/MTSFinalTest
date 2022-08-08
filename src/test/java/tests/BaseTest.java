package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import config.ProjectConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

public abstract class BaseTest {

    public static final ProjectConfig cfg = ConfigFactory.create(ProjectConfig.class);

    @Before
    public void setUp() {

        // Настройки для локального запуска
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.headless = false;
        Configuration.browserSize = "1920x1080";

        // Настройки для локального запуска в Docker
//        Configuration.browser = "chrome";
//        Configuration.browserSize = "1920x1080";
//        Configuration.remote = "http://172.17.213.90:4444/wd/hub";
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//
//        capabilities.setCapability("enableVNC", true);
//        capabilities.setCapability("enableVideo", true);
//
//        HashMap<String, Object> options = new HashMap<>();
//        options.put("enableVNC", true);
//        options.put("enableVideo", true);
//        capabilities.setCapability("selenoid:options", options);
//
//        Configuration.browserCapabilities = capabilities;

        // Настройки для запуска Github Actions
//        Configuration.browser = "chrome";
//        Configuration.browserSize = "1920x1080";
//        Configuration.remote = "http://localhost:4444/wd/hub";
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("enableVNC", true);
//        capabilities.setCapability("enableVideo", true);
//        Configuration.browserCapabilities = capabilities;

    }

    @After
    public void turnDown() {
        Selenide.closeWebDriver();
    }
}
