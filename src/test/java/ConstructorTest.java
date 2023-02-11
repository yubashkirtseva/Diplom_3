import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.MainPage;

import java.time.Duration;

public class ConstructorTest {

    private WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        //ДЛЯ ЗАПУСКА YANDEXBROWSER
        //System.setProperty("webdriver.chrome.driver", "chromedriver2.exe");
        //ChromeOptions options = new ChromeOptions();
        //options.setBinary("C:\\Users\\yubashkirtseva\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\new_browser.exe");
        //driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://stellarburgers.nomoreparties.site/");

    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    @DisplayName("Проверка успешного перехода к разделу Булки")
    public void checkRedirectToBunSection(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOnSauseLink();
        objMainPage.clickOnBunLink();
        String expectedText = "Булки";
        String actualText = objMainPage.getBunText();

        Assert.assertEquals(expectedText,actualText);

    }

    @Test
    @DisplayName("Проверка успешного перехода к разделу Соусы")
    public void checkRedirectToSauseSection(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOnSauseLink();
        String expectedText = "Соусы";
        String actualText = objMainPage.getSauseText();

        Assert.assertEquals(expectedText,actualText);
    }

    @Test
    @DisplayName("Проверка успешного перехода к разделу Начинки")
    public void checkRedirectToFillingSection(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOnFillingLink();
        String expectedText = "Начинки";
        String actualText = objMainPage.getFillingText();

        Assert.assertEquals(expectedText,actualText);

    }
}
