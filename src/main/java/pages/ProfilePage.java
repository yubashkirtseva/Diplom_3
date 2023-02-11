package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {
    private WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }
    private By profileBtn = By.xpath("//a[@href='/account/profile']");
    private By exitBtn = By.xpath("//button[contains(.,'Выход')]");
    private By constructorBtn = By.xpath("//p[contains(.,'Конструктор')]");
    private By logo = By.xpath("//div[contains(@class,'AppHeader_header__logo')]");

    public String getProfileTxt(){
        return driver.findElement(profileBtn).getText();
    }
    public ProfilePage clickOnConstructorBtn(){
        driver.findElement(constructorBtn).click();
        return this;
    }
    public ProfilePage clickOnLogo(){
        driver.findElement(logo).click();
        return this;
    }
    public ProfilePage clickOnExitBtn(){
        driver.findElement(exitBtn).click();
        return this;
    }

}
