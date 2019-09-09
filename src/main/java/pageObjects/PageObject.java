package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {
    protected WebDriver driver;
    private String homePageURL = "https://www.saucedemo.com/index.html";
    public PageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public LoginPage navigateToHomePage(){
        driver.navigate().to(homePageURL);
        return new LoginPage(driver);
    }

    public String getURL() {
        System.out.println(driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }
    public String getHomepage(){
        return homePageURL;
    }
}
