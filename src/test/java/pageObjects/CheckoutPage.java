package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    WebDriver driver;
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "billing_first_name")
    private WebElement nameInput;

    @FindBy(name = "billing_last_name")
    private WebElement lastNameInput;

    @FindBy(xpath = "//*[@id=\"select2-billing_country-container\"]")
    private WebElement countryDropdown;

    @FindBy(name = "billing_address_1")
    private WebElement streetAddressInput;

    @FindBy(name = "billing_city")
    private WebElement townInput;

    @FindBy(xpath = "//*[@id=\"billing_country_field\"]/span/span/span[1]/span/span[2]/b")
    private WebElement stateDropdown;

    @FindBy(name = "billing_postcode")
    private WebElement pinCodeInput;

    @FindBy(name = "billing_phone")
    private WebElement phoneInput;

    @FindBy(name = "billing_email")
    private WebElement emailInput;

    @FindBy(id = "terms")
    private WebElement checkBoxTerms;

    @FindBy(xpath = "//*[@id=\"place_order\"]")
    private WebElement placeOrderButton;

    @FindBy(xpath = "//*[@id=\"post-7\"]/div/div/form[3]/div[1]/div")
    private WebElement checkoutError;


    public void populateShippingInformation(String name, String lastName, String streetAddress, String town, String pinCode, String phone, String email) {
        nameInput.sendKeys(name);
        lastNameInput.sendKeys(lastName);
        streetAddressInput.sendKeys(streetAddress);
        townInput.sendKeys(town);
        pinCodeInput.sendKeys(pinCode);
        phoneInput.sendKeys(phone);
        emailInput.sendKeys(email);

    }

    public void clickCheckboxTerms() {
        // scrool
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight / 2)", checkBoxTerms);
        checkBoxTerms.click();
    }

    public void placeOrder() {
        placeOrderButton.click();
    }
    public String getCheckoutErrorMessage() {
        return checkoutError.getText();
    }

}
