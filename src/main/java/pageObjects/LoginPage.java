package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class LoginPage extends PageObject{
    @FindBy (id="user-name")
    private WebElement username;
    @FindBy (id="password")
    private WebElement password;
    @FindBy(xpath = "//*[@value = 'LOGIN']")
    private WebElement login;
    @FindBy (tagName = "a")
    private List<WebElement> links;

    /*
    @FindBy(xpath = "//*[@placeholder = 'Username']")
    private WebElement username;

    @FindBy(xpath = "//*[@placeholder = 'Password']")
    private WebElement password;

    @FindBy(xpath = "//*[@value = 'LOGIN']")
    private WebElement login;

    @FindBy(xpath = "//*[@data-test = 'error']")
    private WebElement errorMessage;


     */

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void insertUsername(String un) {
        username.sendKeys(un);
    }

    public void insertPassword(String pw) {
        password.sendKeys(pw);
    }


    public void pressLoginBtn() {
        login.click();
    }

    public void checkLinks(){
        String url = "";
        HttpURLConnection huc = null;
        int respCode = 200;
        Iterator<WebElement> it = links.iterator();
        while (it.hasNext()){
            url = it.next().getAttribute("href");
            System.out.println(url);
            if(url == null){
                System.out.println("URL is either not configured for anchor tag or it is empty");
                continue;
            }
            if (!url.startsWith(getHomepage())){
                System.out.println("URL belongs to another domain, skipping it");
                continue;
            }
            try {
                huc = (HttpURLConnection)(new URL(url).openConnection());
                huc.connect();
                respCode = huc.getResponseCode();
                if (respCode >= 400){
                    System.out.println(url + " is a broken link");
                } else {
                    System.out.println(url + " is a valid link");
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}

