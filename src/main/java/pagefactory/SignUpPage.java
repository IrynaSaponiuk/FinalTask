package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage {
    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='customerName']")
    private WebElement nameField;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='ap_password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='ap_password_check']")
    private WebElement reenterPasswordField;

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueButton;

    public WebElement getNameField() {
        return nameField;
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getReenterPasswordField() {
        return reenterPasswordField;
    }

    public WebElement getContinueButton() {
        return continueButton;
    }

    public void inputNameInNameField(String name) {
        nameField.sendKeys(name);
    }

    public void inputEmailInEmailFiend(String email) {
        emailField.sendKeys(email);
    }

    public void inputPasswordInPasswordField(String password) {
        passwordField.sendKeys(password);
    }

    public void inputPasswordAgainInReenterPasswordField(String check_password) {
        reenterPasswordField.sendKeys(check_password);
    }

    public void clickOnContinueButton() {
        continueButton.click();
    }


}
