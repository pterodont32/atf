package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GeneralPage {
    WebDriver driver;

    public GeneralPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"noo-site\"]/header/div[2]/div/div/div/a")
    private WebElement search;
    @FindBy(xpath = "//*[@id=\"noo-site\"]/header/div[3]/div[2]/form/input[1]")
    private WebElement searchInput;

    @FindBy(xpath = "//*[@id=\"noo-site\"]/header/div[1]/div/ul[2]/li[3]/a")
    private WebElement checkoutLink;

    @FindBy(xpath = "/html/body/p[1]/a")
    private WebElement bannerDismiss;

    public void clickSearchElement() {
        search.click();
    }
    public void clickCheckoutLink() {
        checkoutLink.click();
    }
    public void bannerDismiss() {
        bannerDismiss.click();
    }
    public void searchProduct(String productName) {
        searchInput.sendKeys(productName);
    }
    public void pressEnterAfterSearch() {
        searchInput.sendKeys(Keys.ENTER);
    }

}