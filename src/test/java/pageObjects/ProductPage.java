package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {

    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"pa_color\"]")
    private WebElement colorDropdown;

    @FindBy(xpath = "//*[@id=\"pa_size\"]")
    private WebElement sizeDropdown;

    @FindBy(xpath = "//*[@id=\"product-1287\"]/div[1]/div[2]/form/div/div[2]/button")
    private WebElement addToChartButton;

    public void selectColor(String color) {
        Select colorSelect = new Select(colorDropdown);
        colorSelect.selectByVisibleText(color);
    }

    public void selectSize(String size) {
        Select sizeSelect = new Select(sizeDropdown);
        sizeSelect.selectByVisibleText(size);

    }
    public void clickAddToChartButton() {
        addToChartButton.click();
    }
}
