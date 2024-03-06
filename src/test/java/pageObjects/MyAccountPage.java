package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    WebDriver driver;
    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"customer_login\"]/div[1]/form/p[3]/button")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"post-8\"]/div/div/div/p[2]")
    private WebElement helloMessage;

    @FindBy(xpath = "//*[@id=\"post-8\"]/div/div/nav/ul/li[6]/a")
    private WebElement logoutButton;

    @FindBy(xpath = "//*[@id=\"customer_login\"]/div[1]/h2")
    private WebElement loginText;

    @FindBy(xpath = "//*[@id=\"post-8\"]/div/div/div[1]/div/div")
    private WebElement ErrorMessage;

    // Register
    @FindBy(xpath = "//*[@id=\"post-8\"]/div/div/div[1]/div/div")
    private WebElement RegisterErrorMessage;

    @FindBy(xpath = "//*[@id=\"reg_username\"]")
    private WebElement RegisterUsername;

    @FindBy(xpath = "//*[@id=\"reg_email\"]")
    private WebElement RegisterEmail;

    @FindBy(xpath = "//*[@id=\"reg_password\"]")
    private WebElement RegisterPassword;

    @FindBy(xpath = "//*[@id=\"customer_login\"]/div[2]/form/p[4]/button")
    private WebElement RegisterButton;

    public void enterUsername(String username) {
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickLogoutButton() {
        logoutButton.click();
    }

    public String getHelloMessage() {
        return helloMessage.getText();
    }

    public String loginMesage() {
        return loginText.getText();
    }

    public String getErrorMessage() {
        return ErrorMessage.getText();
    }

    public void fillRegistrationForm(String username, String email, String password) {
        RegisterUsername.sendKeys(username);
        RegisterEmail.sendKeys(email);
        RegisterPassword.sendKeys(password);
    }

    public void clickRegisterButton() {
        RegisterButton.click();
    }

}

