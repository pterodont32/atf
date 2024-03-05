package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.GeneralPage;
import pageObjects.ProductPage;
import utils.DriverManager;

public class PurchaseProductSteps {
    WebDriver driver = DriverManager.getDriver();
    GeneralPage generalPage = new GeneralPage(driver);
    ProductPage productPage= new ProductPage(driver);


    @When("^user adds a product \"([^\"]*)\" to the cart$")
    public void userAddsProductToCart(String productName) {
        generalPage.bannerDissmis();
        generalPage.clickSearchElement();
        generalPage.searchProduct(productName);
        generalPage.pressEnterAfterSearch();
        productPage.selectColor("Rose Gold");
        productPage.selectSize("36");
        productPage.clickAddToChartButton();
    }

}
