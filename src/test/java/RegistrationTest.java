import base.UserGenerator;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;

import java.time.Duration;

public class RegistrationTest {
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
    @DisplayName("Проверка успешной регистрации")
    public void checkRegistration(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOnProfileBtn();
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.clickOnRegistrationLnk();
        RegisterPage objRegisterPage = new RegisterPage(driver);
        UserGenerator objUserGenerator = new UserGenerator();
        objRegisterPage.enterName(objUserGenerator.getName())
                .enterEmail(objUserGenerator.getRandomEmail())
                .enterPassword(objUserGenerator.getPassword())
                .clickOnRegistrationBtn();
        String expectedText = "Войти";
        String actualText = objLoginPage.getTextFromEnterBtn();

        Assert.assertEquals(expectedText,actualText);
    }

    @Test
    @DisplayName("Проверка неуспешной регистрации при использовании некорректного пароля")
    public void checkRegistrationWithIncorrectPassword(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOnProfileBtn();
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.clickOnRegistrationLnk();
        RegisterPage objRegisterPage = new RegisterPage(driver);
        UserGenerator objUserGenerator = new UserGenerator();
        objRegisterPage.enterName(objUserGenerator.getName())
                .enterEmail(objUserGenerator.getRandomEmail())
                .enterPassword(objUserGenerator.getShortPassword())
                .clickOnRegistrationBtn();
        String expectedText = "Некорректный пароль";
        String actualText = objRegisterPage.getTextFromErrorMssg();

        Assert.assertEquals(expectedText,actualText);
    }

}
