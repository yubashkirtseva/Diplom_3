package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By registrationLnk = By.xpath("//a[contains(.,'Зарегистрироваться')]");
    private By loginBtn = By.xpath("//button[contains(.,'Войти')]");
    private By emailFld = By.xpath("//label[text()='Email']//following::input[1]");
    private By passwordFld = By.xpath("//input[@type='password']");
    private By forgotPasswordLnk = By.xpath("//a[contains(.,'Восстановить пароль')]");

    public LoginPage clickOnRegistrationLnk(){
        driver.findElement(registrationLnk).click();
        return this;
    }
    public String getTextFromEnterBtn(){
        return driver.findElement(loginBtn).getText();
    }
    public LoginPage enterEmail(String email){
        driver.findElement(emailFld).sendKeys(email);
        return this;
    }
    public LoginPage enterPassword(String password){
        driver.findElement(passwordFld).sendKeys(password);
        return this;
    }
    public LoginPage clickOnTheLoginBtn(){
        driver.findElement(loginBtn).click();
        return this;
    }
    public LoginPage clickOnTheForgotPasswordLnk(){
        driver.findElement(forgotPasswordLnk).click();
        return this;
    }
}
