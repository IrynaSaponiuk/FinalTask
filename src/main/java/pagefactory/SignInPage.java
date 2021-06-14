package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {
    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[contains(@id,'ap_email')]")
    private WebElement emailField;

    @FindBy(xpath = "//input[contains(@class,'a-button')]")
    private WebElement continueButton;

    @FindBy(xpath = "//a[@id='createAccountSubmit']")
    private WebElement createAccountButton;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement enterYourEmailField;

    @FindBy(xpath = "//input[@id='ap_password']")
    private WebElement passwordField;

    public WebElement getSignInButton() {
        return signInButton;
    }

    @FindBy(xpath = "//input[@id='signInSubmit']")
    private WebElement signInButton;

    public WebElement getEmailField() {
        return emailField;
    }

    public void clickOnCreateAccountButton() {
        createAccountButton.click();
    }

    public void enterEmailInEmailField(String email) {
        enterYourEmailField.sendKeys(email);
    }

    public void inputPasswordInPasswordField(String password) {
        Actions actions = new Actions(driver);
        actions.moveToElement(passwordField).sendKeys(password).perform();
        actions.release().perform();
    }

    public void clickOnSignInButton() {
        Actions actions = new Actions(driver);
        actions.moveToElement(signInButton).click().perform();
        actions.release().perform();
    }

    public void moveToContinueButton() {
        Actions actions = new Actions(driver);
        actions.moveToElement(continueButton).click().perform();
        actions.release().perform();

    }

    public WebElement getContinueButton(){
        return continueButton;
    }


    public WebElement getPasswordField(){
        return passwordField;
    }

}
