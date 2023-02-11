import base.CreatedUser;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;

import java.time.Duration;

public class LoginTest {
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
    @DisplayName("Проверка успешного входа по кнопке «Войти в аккаунт» на главной")
    public void checkLoginUsingBtnOnTheMainPage(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOnLoginBtn();
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.enterEmail(CreatedUser.EMAIL)
                .enterPassword(CreatedUser.PASSWORD)
                .clickOnTheLoginBtn();
        String expectedText = "Соберите бургер";
        String actualText = objMainPage.getMainText();

        Assert.assertEquals(expectedText,actualText);

    }
    @Test
    @DisplayName("Проверка успешного входа через кнопку «Личный кабинет»")
    public void checkLoginUsingProfileBtn(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOnProfileBtn();
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.enterEmail(CreatedUser.EMAIL)
                .enterPassword(CreatedUser.PASSWORD)
                .clickOnTheLoginBtn();
        String expectedText = "Соберите бургер";
        String actualText = objMainPage.getMainText();

        Assert.assertEquals(expectedText,actualText);
    }

    @Test
    @DisplayName("Проверка успешного входа через кнопку в форме регистрации")
    public void checkLoginUsingLnkOnTheRegisterPage(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOnProfileBtn();
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.clickOnRegistrationLnk();
        RegisterPage objRegisterPage = new RegisterPage(driver);
        objRegisterPage.clickOnLoginLnk();
        objLoginPage.enterEmail(CreatedUser.EMAIL)
                .enterPassword(CreatedUser.PASSWORD)
                .clickOnTheLoginBtn();
        String expectedText = "Соберите бургер";
        String actualText = objMainPage.getMainText();

        Assert.assertEquals(expectedText,actualText);
    }

    @Test
    @DisplayName("Проверка успешного входа через кнопку в форме восстановления пароля")
    public void checkLoginUsingLnkOnTheForgotPasswordPage(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOnLoginBtn();
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.clickOnTheForgotPasswordLnk();
        ForgotPasswordPage objForgotPasswordPage = new ForgotPasswordPage(driver);
        objForgotPasswordPage.clickOnLoginLnk();
        objLoginPage.enterEmail(CreatedUser.EMAIL)
                .enterPassword(CreatedUser.PASSWORD)
                .clickOnTheLoginBtn();
        String expectedText = "Соберите бургер";
        String actualText = objMainPage.getMainText();

        Assert.assertEquals(expectedText,actualText);
    }
}
