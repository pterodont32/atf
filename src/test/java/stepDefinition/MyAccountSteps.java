package stepDefinition;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import pageObjects.MyAccountPage;
import utils.DriverManager;
import java.util.List;
import java.util.Map;


public class MyAccountSteps {
    WebDriver driver = DriverManager.getDriver();
    MyAccountPage myAccountPage;


    @Given("^user is on My account page$")
    public void userIsOnMyAccountPage() {
        myAccountPage = new MyAccountPage(driver);
    }

    @When("^user populate \"([^\"]*)\" and \"([^\"]*)\" fields$")
    public void userPopulateFields(String username, String password) {
        myAccountPage.enterUsername(username);
        myAccountPage.enterPassword(password);
    }

    @And("^'LOG IN' button is clicked$")
    public void logINButtonIsClicked() {
        myAccountPage.clickLoginButton();
    }


    @Then("^user is successfully logged in$")
    public void userIsSuccessfullyLoggedIn() {
        Assertions.assertThat(myAccountPage.getHelloMessage()).isEqualTo("From your account dashboard you can view your recent orders, manage your shipping and billing addresses, and edit your password and account details.");
    }

    @Then("^user is successfully logged out$")
    public void userIsSuccessfullyLoggedOut() {
        Assertions.assertThat(myAccountPage.loginMesage()).isEqualTo("LOGIN");

    }

    @When("^'LOG OUT' button is clicked$")
    public void logOUTButtonIsClicked() {
        myAccountPage.clickLogoutButton();
    }

    @Then("^user should see an error message$")
    public void userShouldSeeAnErrorMessage() {
        Assertions.assertThat(myAccountPage.getErrorMessage()).isEqualTo("ERROR: The username or password you entered is incorrect. Lost your password?");
//        driver.quit();
    }

    @When("^user fill in the registration form with the following details:$")
    public void userFillInTheRegistrationFormWithTheFollowingDetails(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> row : data) {
            String username = row.get("USERNAME");
            String email = row.get("EMAIL ADDRESS");
            String password = row.get("PASSWORD");

            myAccountPage.fillRegistrationForm(username, email, password);
        }
    }


    @And("^'Register' button is clicked$")
    public void registerButtonIsClicked() {
        myAccountPage.clickRegisterButton();
    }


    @Then("^user should see an error message indicating the email is already registered$")
    public void userShouldSeeAnErrorMessageIndicatingTheEmailIsAlreadyRegistered() {
        Assertions.assertThat(myAccountPage.getErrorMessage()).isEqualTo("Error: An account is already registered with your email address. Please log in.");


    }
}