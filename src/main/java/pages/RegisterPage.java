package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }
    private By nameFld = By.xpath("//label[text()='Имя']//following::input[1]");
    private By emailFld = By.xpath("//label[text()='Email']//following::input[1]");
    private By passwordFld = By.xpath("//input[@type='password']");
    private By registrationBtn = By.xpath("//button[contains(.,'Зарегистрироваться')]");
    private By errorMssg = By.xpath("//p[contains(.,'Некорректный пароль')]");
    private By loginLnk = By.xpath("//a[contains(.,'Войти')]");

    public RegisterPage enterName(String name){
        driver.findElement(nameFld).sendKeys(name);
        return this;
    }
    public RegisterPage enterEmail(String email){
        driver.findElement(emailFld).sendKeys(email);
        return this;
    }
    public RegisterPage enterPassword(String password){
        driver.findElement(passwordFld).sendKeys(password);
        return this;
    }
    public RegisterPage clickOnRegistrationBtn(){
        driver.findElement(registrationBtn).click();
        return this;
    }
    public String getTextFromErrorMssg(){
        return driver.findElement(errorMssg).getText();
    }
    public RegisterPage clickOnLoginLnk(){
        driver.findElement(loginLnk).click();
        return this;
    }
}
