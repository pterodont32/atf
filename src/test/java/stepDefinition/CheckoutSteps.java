package stepDefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pageObjects.CheckoutPage;
import pageObjects.GeneralPage;
import utils.DriverManager;

import java.util.List;
import java.util.Map;

public class CheckoutSteps {


    WebDriver driver = DriverManager.getDriver();
    CheckoutPage checkoutPage = new CheckoutPage(driver);
    GeneralPage generalPage = new GeneralPage(driver);
    Actions actions = new Actions(driver);


    @And("^user proceeds to checkout$")
    public void userProceedsToCheckout() {
        generalPage.clickCheckoutLink();
    }

    @When("^user completes the purchase with shipping information:$")
    public void userCompletesPurchaseWithShippingInformation(DataTable dataTable) {
        List<Map<String, String>> shippingInfo = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> row : shippingInfo) {
            String name = row.get("NAME");
            String lastName = row.get("LAST NAME");
            String streetAddress = row.get("STREET ADDRESS");
            String town = row.get("TOWN");
            String pinCode = row.get("PIN CODE");
            String phone = row.get("PHONE");
            String email = row.get("EMAIL");
            checkoutPage.populateShippingInformation(name, lastName, streetAddress, town, pinCode, phone, email);
        }
    }


    @And("^user clicks the 'Place Order' button$")
    public void userClicksThePlaceOrderButton() {
        checkoutPage.clickCheckboxTerms();
        checkoutPage.placeOrder();
    }

    @Then("^product should be successfully purchased$")
    public void productShouldBeSuccessfullyPurchased() throws InterruptedException {
        Thread.sleep(2000);
        Assertions.assertThat(checkoutPage.getCheckoutErrorMessage()).isEqualTo("Error processing checkout. Please try again.");

    }

}
