package stepdefs;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.InventoryPage;
import pageObjects.LoginPage;

import static org.junit.Assert.assertEquals;

public class LoginStepDefinitions extends FunctionalTest {
    protected WebDriver driver = getDriver();
    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private String un = "standard_User", pw = "secret_sauce";

    @Given("I am on saucedemo homepage")
    public void i_am_on_saucedemo_homepage() throws Throwable {
        loginPage = new LoginPage(driver);
        loginPage.navigateToHomePage();
        System.out.println("logs in to site");
    }

    @When("I enter username (.*)")
    public void i_enter_username(String username) throws  Throwable{
        // Write code here that turns the phrase above into concrete actions
        loginPage.insertUsername(username);
        System.out.println("enters username");
    }

    @When("password (.*)")
    public void password(String password) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        loginPage.insertPassword(password);
        System.out.println("enters password");
    }


    @When("try to Login")
    public void try_to_Login() throws Throwable {
        loginPage.pressLoginBtn();
    }

    @Then("I will login into (.*)")
    public void i_will_login_into(String currentURL) throws Throwable{
        assertEquals(loginPage.getURL(),currentURL);
        System.out.println("User is logged in");
    }

    @Given("I am login on the inventory page")
    public InventoryPage i_am_login_on_the_inventory_page() throws Throwable {
        i_am_on_saucedemo_homepage();
        i_enter_username(un);
        password(pw);
        try_to_Login();
        return inventoryPage = new InventoryPage(driver);
    }


    @After
    public void closeDriver(){
        driver.quit();
    }

}
