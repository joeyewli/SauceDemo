package stepdefs;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.InventoryPage;

public class InventoryStepDefinitions {
    private InventoryPage inventoryPage;

    @When("I click on all the links")
    public void i_click_on_all_the_links() throws Throwable{
        inventoryPage.showlinks();

    }

    @Then("all links works")
    public void all_links_works() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        inventoryPage.checkLinks();
    }
}
