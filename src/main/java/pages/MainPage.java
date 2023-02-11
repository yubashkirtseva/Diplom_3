package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By profileBtn = By.xpath("//p[contains(.,'Личный Кабинет')]");
    private By loginBtn = By.xpath("//button[contains(.,'Войти в аккаунт')]");
    private By mainTxt = By.xpath("//h1[contains(.,'Соберите бургер')]");
    private By bunLink = By.xpath("//span[contains(.,'Булки')]");
    private By nameOfBunSection = By.xpath("//h2[contains(.,'Булки')]");
    private By sauseLink = By.xpath("//span[contains(.,'Соусы')]");
    private By nameOfSauseSection = By.xpath("//h2[contains(.,'Соусы')]");
    private By fillingLink = By.xpath("//span[contains(.,'Начинки')]");
    private By nameOfFillingSection = By.xpath("//h2[contains(.,'Начинки')]");

    public MainPage clickOnProfileBtn(){
        driver.findElement(profileBtn).click();
        return this;
    }
    public MainPage clickOnLoginBtn(){
        driver.findElement(loginBtn).click();
        return this;
    }
    public String getMainText(){
        return driver.findElement(mainTxt).getText();
    }
    public MainPage clickOnBunLink(){
        driver.findElement(bunLink).click();
        return this;
    }
    public MainPage clickOnSauseLink(){
        driver.findElement(sauseLink).click();
        return this;
    }
    public MainPage clickOnFillingLink(){
        driver.findElement(fillingLink).click();
        return this;
    }
    public String getBunText(){
        return driver.findElement(nameOfBunSection).getText();
    }
    public String getSauseText(){
        return driver.findElement(nameOfSauseSection).getText();
    }
    public String getFillingText(){
        return driver.findElement(nameOfFillingSection).getText();
    }
}
