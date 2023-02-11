package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private WebDriver driver;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }
    private By loginLnk = By.xpath("//a[contains(.,'Войти')]");

    public ForgotPasswordPage clickOnLoginLnk(){
        driver.findElement(loginLnk).click();
        return this;
    }
}
