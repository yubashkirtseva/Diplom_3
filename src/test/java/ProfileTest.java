import base.CreatedUser;
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
import pages.ProfilePage;

import java.time.Duration;

public class ProfileTest {
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
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOnLoginBtn();
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.enterEmail(CreatedUser.EMAIL)
                .enterPassword(CreatedUser.PASSWORD)
                .clickOnTheLoginBtn();
        objMainPage.clickOnProfileBtn();
    }
    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    @DisplayName("Проверка успешного перехода в личный кабинет")
    public void checkLoginToProfile(){
        ProfilePage objProfilePage = new ProfilePage(driver);
        String expectedText = "Профиль";
        String actualText = objProfilePage.getProfileTxt();

        Assert.assertEquals(expectedText,actualText);
    }

    @Test
    @DisplayName("Проверка успешного перехода в конструктор из личного кабинета по клику на «Конструктор»")
    public void checkRedirectToConstructorByClickConstructorBtn(){
        ProfilePage objProfilePage = new ProfilePage(driver);
        objProfilePage.clickOnConstructorBtn();
        MainPage objMainPage = new MainPage(driver);
        String expectedText = "Соберите бургер";
        String actualText = objMainPage.getMainText();

        Assert.assertEquals(expectedText,actualText);
    }

    @Test
    @DisplayName("Проверка успешного перехода в конструктор из личного кабинета по клику на логотип Stellar Burgers")
    public void checkRedirectToConstructorByClickLogo(){
        ProfilePage objProfilePage = new ProfilePage(driver);
        objProfilePage.clickOnLogo();
        MainPage objMainPage = new MainPage(driver);
        String expectedText = "Соберите бургер";
        String actualText = objMainPage.getMainText();

        Assert.assertEquals(expectedText,actualText);
    }

    @Test
    @DisplayName("Проверка успешного выхода из личного кабинета")
    public void checkExit(){
        ProfilePage objProfilePage = new ProfilePage(driver);
        objProfilePage.clickOnExitBtn();
        LoginPage objLoginPage = new LoginPage(driver);
        String expectedText = "Войти";
        String actualText = objLoginPage.getTextFromEnterBtn();

        Assert.assertEquals(expectedText,actualText);
    }
}
