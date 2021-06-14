package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pagefactory.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {

    WebDriver driver;
    AddToCartPage addToCartPage;
    GiftCardsPage giftCardsPage;
    HomePage homePage;
    ProductPage productPage;
    SearchPage searchPage;
    SignInPage signInPage;
    SignUpPage signUpPage;
    PageFactoryManager pageFactoryManager;
    private static final long TIME_TO_WAIT = 30;
    private static final int NUMBER_OF_ELEMENT = 0;
    private static final String NAME_OF_COUNTRY = "Turkey";
    private static final String SELECTOR_ON_PRODUCT_PAGE = "HP";
    private static final String KEYWORD_IN_URL = "Galaxy+Buds";
    private static final String KEYWORD = "Galaxy Buds";
    private static final String TEST_NAME = "Stepan Lamark";
    private static final String TEST_EMAIL = "irasaponyuk@gmail.com";
    private static final String TEST_PASSWORD = "qZpM1945";
    private static final String TEST_MESSAGE = "Hello, world!";
    private static final  String TEST_QUANTITY = "1";

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }


    @And("User clicks on Menu button")
    public void userClicksOnMenuButton() {
        homePage.clickOnMenuOnHomePage();
    }

    @And("User clicks on Arts and crafts button in Menu")
    public void userClicksOnArtsAndCraftsButtonInMenu() {
        homePage.waitForVisibilityOfElement(TIME_TO_WAIT, homePage.getArtsAndCraftesButton());
        homePage.clickOnArtsAndCraftsButtonInMenu();
    }

    @And("User clicks on Painting, drawing and Art supplies button")
    public void userClicksOnPaintingDrawingAndArtSuppliesButton() {
        homePage.waitForVisibilityOfElement(TIME_TO_WAIT, homePage.getPaintingDrawingArtSuppliesButtonInMenu());
        homePage.clickOnPaintingDrawingArtSuppliesButtonInMenu();
    }


    @And("User clicks on the first product on Page")
    public void userClicksOnTheFirstProductOnPage() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForVisibilityOfElement(TIME_TO_WAIT, productPage.getFirstPriceOnProductPage());
        productPage.getListOfWholePrice().get(NUMBER_OF_ELEMENT).click();
    }


    @And("User adds product to Cart")
    public void userAddsProductToCart() {
        addToCartPage= pageFactoryManager.getAddToCartPage();;
        addToCartPage.waitForAjaxToComplete(TIME_TO_WAIT);
        addToCartPage.clickOnAddToCartButton();
    }


    @When("User goes to Cart")
    public void userGoesToCart() {
        addToCartPage= pageFactoryManager.getAddToCartPage();
        addToCartPage.waitForLoadingComplete(TIME_TO_WAIT);
        addToCartPage.refreshPage();
        addToCartPage.clickOnGoToCartButton();
    }


    @And("User clicks on comparing button in cart")
    public void userClicksOnComparingButtonInCart() {
        addToCartPage= pageFactoryManager.getAddToCartPage();
        addToCartPage.waitForLoadingComplete(TIME_TO_WAIT);
        addToCartPage.clickOnCompareWithOtherItemsButton();
    }

    @Then("User checks the visibility of other products in comparing window")
    public void userChecksTheVisibilityOfOtherProductsInComparingWindow() {
       addToCartPage = pageFactoryManager.getAddToCartPage();
        for (int i = 0; i < addToCartPage.getListOfComparingProducts().size(); i++) {
            assertTrue(addToCartPage.getListOfComparingProducts().get(i).isDisplayed());
        }
    }


    @And("User clicks on delete button")
    public void userClicksOnDeleteButton() {
        addToCartPage= pageFactoryManager.getAddToCartPage();
        addToCartPage.waitForLoadingComplete(TIME_TO_WAIT);
        addToCartPage.clickOnDeleteButton();
        addToCartPage.waitForLoadingComplete(TIME_TO_WAIT);
        addToCartPage.refreshPage();
    }


    @Then("User checks that there are no products in the Cart")
    public void userChecksThatThereAreNoProductsInTheCart() {
        addToCartPage= pageFactoryManager.getAddToCartPage();
        assertTrue(addToCartPage.getTextInEmptyCart().isDisplayed());
    }

    @And("User clicks on Deliver to button")
    public void userClicksOnDeliverToButton() {
        homePage.waitForVisibilityOfElement(TIME_TO_WAIT, homePage.getDeliverToButton());
        homePage.clickOnDeliverToButton();
    }

    @When("User changes country to deliver")
    public void userChangesCountryToDeliver() {
        homePage.waitForVisibilityOfElement(TIME_TO_WAIT, homePage.getChooseCountryButton());
        homePage.clickOnChooseYourCountryButton();
        homePage.chooseTurkeyFromTheList();
        homePage.refreshHomePage();
    }


    @Then("User checks that his country to deliver is visible")
    public void userChecksThatHisCountryToDeliverIsVisible() {
        homePage.waitForVisibilityOfElement(TIME_TO_WAIT, homePage.getDeliverToButton());
        assertEquals(homePage.getNameOfTheCountryToDeliver(), NAME_OF_COUNTRY);
    }

    @And("User clicks on Electronics button")
    public void userClicksOnElectronicsButton() {
        homePage.waitForLoadingComplete(TIME_TO_WAIT);
        homePage.clickOnElectronicsButton();
    }

    @And("User clicks on Headphones button")
    public void userClicksOnHeadphonesButton() {
        homePage.waitForLoadingComplete(TIME_TO_WAIT);
        homePage.clickOnHeadphonesButton();
    }

    @When("User sets certain price parameter")
    public void userSetsUnderDollarsParameter() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForLoadingComplete(TIME_TO_WAIT);
        productPage.setUnder25DollarsParameter();
    }

    @Then("User checks that all prices on the page are less than certain price he chose")
    public void userChecksThatAllPricesOnThePageAreLessThanDollars() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForLoadingComplete(TIME_TO_WAIT);
        for (int i = 0; i < productPage.getListOfWholePrice().size(); i++) {
            assertTrue(productPage.getPriceOfRandomElement(i) < 25);
        }
    }

    @And("User clicks on Computers button")
    public void userClicksOnComputersButton() {
        homePage.waitForLoadingComplete(TIME_TO_WAIT);
        homePage.clickOnComputersButtonInMenu();
    }

    @And("User clicks on Monitors button")
    public void userClicksOnMonitorsButton() {
        homePage.waitForVisibilityOfElement(TIME_TO_WAIT,homePage.getMonitorsButton());
        homePage.clickOnMonitorsButtonInMenu();
    }


    @When("User selects parameter HP")
    public void userSelectsParameterHP() {
        productPage= pageFactoryManager.getProductPage();
        productPage.waitForLoadingComplete(TIME_TO_WAIT);
        productPage.clickOnHpSelector();
    }

    @Then("User checks that all names of products contain chosen parameter")
    public void userChecksThatAllNamesOfProductsContainChosenParameter() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForLoadingComplete(TIME_TO_WAIT);
        for (int i = 0; i < productPage.getListOfProductNames().size(); i++) {
            assertTrue(productPage.getListOfProductNames()
                    .get(i).getText().contains(SELECTOR_ON_PRODUCT_PAGE));
        }

    }

    @When("User types keyword in search field")
    public void userTypesKeywordInSearchField() {
        homePage.searchByKeyword(KEYWORD);
    }

    @Then("User checks that current URL contains his keyword")
    public void userChecksThatCurrentURLContainsHisKeyword() {
        searchPage = pageFactoryManager.getSearchPage();
        searchPage.waitForLoadingComplete(TIME_TO_WAIT);
        assertTrue(driver.getCurrentUrl().contains(KEYWORD_IN_URL));
    }

    @And("User chooses ascendant order of price on the page")
    public void userChoosesAscendantOrderOfPriceOnThePage() {
        searchPage = pageFactoryManager.getSearchPage();
        searchPage.clickOnSortingByButton();
        searchPage.clickOnAscendantOrderOfPriceButton();
    }

    @Then("User checks that all prices are in ascendant order")
    public void userChecksThatAllPricesAreInAscendantOrder() {
        searchPage = pageFactoryManager.getSearchPage();
        for (int i = 0; i < searchPage.getListOfWholePrice().size(); i++) {
            assertTrue(searchPage.getPriceOfElementOnSearchPage(i)
                    < searchPage.getPriceOfElementOnSearchPage(i + 1));
        }
    }

    @And("User clicks on Sign In field")
    public void userClicksOnSignInField() {
        homePage.clickOnSignInField();
    }


    @And("User clicks on Create Account button")
    public void userClicksOnCreateAccountButton() {
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.waitForLoadingComplete(TIME_TO_WAIT);
        signInPage.clickOnCreateAccountButton();
    }


    @When("User enters all his information to register in certain fields")
    public void userEntersAllHisInformationToRegisterInCertainFields() {
        signUpPage = pageFactoryManager.getSignUpPage();
        signUpPage.inputNameInNameField(TEST_NAME);
        signUpPage.inputEmailInEmailFiend(TEST_EMAIL);
        signUpPage.inputPasswordInPasswordField(TEST_PASSWORD);
        signUpPage.inputPasswordAgainInReenterPasswordField(TEST_PASSWORD);
    }

    @Then("User checks that all these fields are visible")
    public void userChecksThatAllTheseFieldsAreVisible() {
        signUpPage = pageFactoryManager.getSignUpPage();
        assertTrue(signUpPage.getEmailField().isDisplayed());
        assertTrue(signUpPage.getNameField().isDisplayed());
        assertTrue(signUpPage.getPasswordField().isDisplayed());
        assertTrue(signUpPage.getReenterPasswordField().isDisplayed());
        assertTrue(signUpPage.getContinueButton().isDisplayed());
    }

    @And("User clicks on Continue button")
    public void userClicksOnContinueButton() {
        signUpPage = pageFactoryManager.getSignUpPage();
        signUpPage.clickOnContinueButton();
    }

    @When("User checks the visibility of email field and continue on page")
    public void userChecksTheVisibilityOfEmailFieldAndContinueOnPage() {
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.waitForLoadingComplete(TIME_TO_WAIT);
        assertTrue(signInPage.getEmailField().isDisplayed());
        assertTrue(signInPage.getContinueButton().isDisplayed());
    }


    @And("User enters his email in email field and clicks on continue")
    public void userEntersHisEmailInEmailFieldAndClicksOnContinue() {
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.enterEmailInEmailField(TEST_EMAIL);
        signInPage.moveToContinueButton();
    }

    @And("User checks the visibility of password field and sign in button")
    public void userChecksTheVisibilityOfPasswordFieldAndSignInButton() {
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.waitForLoadingComplete(TIME_TO_WAIT);
        assertTrue(signInPage.getPasswordField().isDisplayed());
        assertTrue(signInPage.getSignInButton().isDisplayed());
    }

    @Then("User enters his password and clicks on sign in button")
    public void userEntersHisPasswordAndClicksOnSignInButton() {
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.inputPasswordInPasswordField(TEST_PASSWORD);
        signInPage.clickOnSignInButton();
    }

    @And("User clicks on Gift Cards button")
    public void userClicksOnGiftCardsButton() {
        homePage.refreshHomePage();
        homePage.waitForVisibilityOfElement(TIME_TO_WAIT,homePage.getGiftCards());
        homePage.clickOnGiftCardsButton();
    }

    @And("User clicks on eGift button")
    public void userClicksOnEGiftButton() {
        giftCardsPage = pageFactoryManager.getGiftCardsPage();
        giftCardsPage.waitForLoadingComplete(TIME_TO_WAIT);
        giftCardsPage.clickOnEGiftButton();
    }

    @When("User enters all information to order eGift Card and checks the visibility of elements on page")
    public void userEntersAllInformationToOrderEGiftCardAndChecksTheVisibilityOfElementsOnPage() {
        giftCardsPage = pageFactoryManager.getGiftCardsPage();
        giftCardsPage.waitForVisibilityOfElement(TIME_TO_WAIT,giftCardsPage.getStandardGiftCard());
        giftCardsPage.clickOnStandardGiftCardButton();
        assertTrue(giftCardsPage.getStandardGiftCardButton().isDisplayed());
        giftCardsPage.waitForVisibilityOfElement(TIME_TO_WAIT,giftCardsPage.getPrice150Dollars());
        giftCardsPage.clickOnPrice150DollarsButton();
        assertTrue(giftCardsPage.getPrice150DollarsButton().isDisplayed());
        giftCardsPage.waitForVisibilityOfElement(TIME_TO_WAIT,giftCardsPage.getReceiveByEmail());
        giftCardsPage.clickOnReceiveByEmailButton();
        assertTrue(giftCardsPage.getReceiveByEmailButton().isDisplayed());
        giftCardsPage.waitForVisibilityOfElement(TIME_TO_WAIT,giftCardsPage.getEmailOfRecipient());
        giftCardsPage.enterEmailOfRecipient(TEST_EMAIL);
        assertTrue(giftCardsPage.getEnterEmailOfRecipientField().isDisplayed());
        giftCardsPage.enterYourName(TEST_NAME);
        assertTrue(giftCardsPage.getYourNameField().isDisplayed());
        giftCardsPage.enterYourMessage(TEST_MESSAGE);
        assertTrue(giftCardsPage.getMessageField().isDisplayed());
        giftCardsPage.enterQuantityOfGiftCards(TEST_QUANTITY);
        assertTrue(giftCardsPage.getQuantityField().isDisplayed());
       assertTrue(giftCardsPage.getDeliveryDateField().isDisplayed());
        giftCardsPage.clickOnCalendarToChooseDateOfDelivery();
        giftCardsPage.chooseDayOfDelivery();
        giftCardsPage.clickOnAddToCartButton();
    }

    @Then("User checks that his eGift Card is added to Cart")
    public void userChecksThatHisEGiftCardIsAddedToCart() {
       addToCartPage = pageFactoryManager.getAddToCartPage();
        addToCartPage.waitForVisibilityOfElement(TIME_TO_WAIT,addToCartPage.getAddedToCart());
       assertTrue(addToCartPage.getTextAddedToCart().isDisplayed());
    }


    @After
    public void tearDown() {
        driver.close();
    }
}
