package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.AutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;

import static org.junit.Assert.*;

public class AutomationExerciseStepDefinitions {

    AutomationExercisePage automationExercisePage=new AutomationExercisePage();

    Actions actions=new Actions(Driver.getDriver());

    Faker faker=new Faker();
    String name=faker.name().firstName();
    String email=faker.internet().emailAddress();

    String password=faker.internet().password();

    @Given("user sign up linkine tiklar")
    public void user_sign_up_linkine_tiklar() {
        automationExercisePage.mainPageSignUpButton.click();
    }
    @Given("user Create an account bolumune email adresi girer")
    public void user_create_an_account_bolumune_email_adresi_girer() {
        automationExercisePage.signUpNameBox.sendKeys(name);
        automationExercisePage.signUpEmailBox.sendKeys(email);

    }
    @Given("signUp butonuna basar")
    public void sign_up_butonuna_basar() {
        automationExercisePage.signUpButton.click();
    }
    @Given("user kisisel bilgilerini ve iletisim bilgilerini girer")
    public void user_kisisel_bilgilerini_ve_iletisim_bilgilerini_girer() {
        automationExercisePage.mrRadioButton.click();
        actions.sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(password)
                .sendKeys(Keys.TAB)
                .sendKeys("18")
                .sendKeys(Keys.TAB)
                .sendKeys("March")
                .sendKeys(Keys.TAB)
                .sendKeys("2001")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(name)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys("-")
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress())
                .sendKeys(Keys.TAB)
                .sendKeys("United States")
                .sendKeys(Keys.TAB)
                .sendKeys("Viginia")
                .sendKeys(Keys.TAB)
                .sendKeys("Norfolk")
                .sendKeys(Keys.TAB)
                .sendKeys("06000")
                .sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone())
                .sendKeys(Keys.TAB).perform();

    }
    @Given("user Create Account butonuna basar")
    public void user_create_account_butonuna_basar() {
       automationExercisePage.createAccountButton.click();
    }
    @Then("hesap olustugunu test eder")
    public void hesap_olustugunu_test_eder() {
        Assert.assertTrue(automationExercisePage.accountCreatedText.isDisplayed());
    }

//----------------  Tests In Site  ----------------

    @Given("Navigate to url {string}")
    public void navigate_to_url(String navigateUrl) {
       Driver.getDriver().get(ConfigReader.getProperty(navigateUrl));
    }
    @Then("Verify that home page is visible successfully")
    public void verify_that_home_page_is_visible_successfully() {
        assertTrue(automationExercisePage.featuresItemsText.isDisplayed());
    }
    @And("Click on Signup-Login button")
    public void clickOnSignupLoginButton() {
        automationExercisePage.mainPageSignUpButton.click();
    }

    @Then("Verify New User Signup! is visible")
    public void verifyNewUserSignupIsVisible() {
        assertTrue(automationExercisePage.newUserSignUpText.isDisplayed());
    }
    @Then("Enter name and email address")
    public void enter_name_and_email_address() {
        automationExercisePage.signUpNameBox.sendKeys("mahmut");
        automationExercisePage.signUpEmailBox.sendKeys(ConfigReader.getProperty("aeValidEmail"));
    }
    @Then("Click Signup button")
    public void clickSignupButton() {
        automationExercisePage.signUpButton.click();
    }
    @And("Verify that ENTER ACCOUNT INFORMATION is visible")
    public void verifyThatENTERACCOUNTINFORMATIONIsVisible() {
        assertTrue(automationExercisePage.enterAccountInformationText.isDisplayed());
    }
    @Then("Fill details: Title, Name, Email, Password, Date of birth")
    public void fill_details_title_name_email_password_date_of_birth() {
        automationExercisePage.mrRadioButton.click();
        actions.sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys("18")
                .sendKeys(Keys.TAB)
                .sendKeys("March")
                .sendKeys(Keys.TAB)
                .sendKeys("2001").perform();

    }
    @And("Select checkbox Sign up for our newsletter!")
    public void selectCheckboxSignUpForOurNewsletter() {
        automationExercisePage.newsletterButton.click();
    }
    @And("Select checkbox Receive special offers from our partners!")
    public void selectCheckboxReceiveSpecialOffersFromOurPartners() {
        automationExercisePage.specialOfferButton.click();
    }

    @Then("Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number")
    public void fill_details_first_name_last_name_company_address_address2_country_state_city_zipcode_mobile_number() {
        automationExercisePage.firstNameBox.sendKeys(name);
        actions.sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys("-")
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress())
                .sendKeys(Keys.TAB)
                .sendKeys("United States")
                .sendKeys(Keys.TAB)
                .sendKeys("Viginia")
                .sendKeys(Keys.TAB)
                .sendKeys("Norfolk")
                .sendKeys(Keys.TAB)
                .sendKeys("06000")
                .sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone())
                .sendKeys(Keys.TAB).perform();

    }
    @And("Click Create Account button")
    public void clickCreateAccountButton() {
        automationExercisePage.createAccountButton.click();
    }

    @And("Verify that ACCOUNT CREATED! is visible")
    public void verifyThatACCOUNTCREATEDIsVisible() {
        assertTrue(automationExercisePage.accountCreatedText.isDisplayed());
    }
    @Then("Click Continue button")
    public void click_continue_button() {
       automationExercisePage.accountCreatedDeletedPageContinueButton.click();
    }
    @Then("Verify that Logged in as username is visible")
    public void verify_that_logged_in_as_username_is_visible() {
        WebElement usernameButton=Driver.getDriver().findElement(By.xpath("//*[text()='"+name+"']"));
        assertTrue(usernameButton.isDisplayed());
    }
    @Then("Click Delete Account button")
    public void click_delete_account_button() {
        automationExercisePage.deleteAccountButton.click();
    }
    @Then("Verify that ACCOUNT DELETED! is visible and click Continue button")
    public void verify_that_account_deleted_is_visible_and_click_continue_button() {
      assertTrue(automationExercisePage.accountDeletedText.isDisplayed());
      automationExercisePage.accountCreatedDeletedPageContinueButton.click();
    }

    @Then("close page")
    public void close_page() {
        Driver.closeDriver();
    }


    @And("Verify Login to your account is visible")
    public void verifyLoginToYourAccountIsVisible() {
        assertTrue(automationExercisePage.loginToYourAccountText.isDisplayed());
    }

    @Then("Enter correct email address and password")
    public void enterCorrectEmailAddressAndPassword() {
        automationExercisePage.loginEmailBox.sendKeys(ConfigReader.getProperty("aeValidEmail"));
        automationExercisePage.loginPasswordBox.sendKeys(ConfigReader.getProperty("aeValidPassword"));
    }

    @And("Click login button")
    public void clickLoginButton() {
        automationExercisePage.loginLoginButton.click();
    }


    @And("Verify that Logged in as username is visible registered user")
    public void verifyThatLoggedInAsUsernameIsVisibleRegisteredUser() {
        assertTrue(automationExercisePage.registeredUserLogged.isDisplayed());
    }

    @And("Fill details: Title, Name, Email, Password, Date of birth for mahmut")
    public void fillDetailsTitleNameEmailPasswordDateOfBirthForMahmut() {
        automationExercisePage.mrRadioButton.click();
        actions.sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("aeValidPassword"))
                .sendKeys(Keys.TAB)
                .sendKeys("18")
                .sendKeys(Keys.TAB)
                .sendKeys("March")
                .sendKeys(Keys.TAB)
                .sendKeys("2001").perform();
    }

    @Then("Enter incorrect email address and password")
    public void enterIncorrectEmailAddressAndPassword() {
        automationExercisePage.loginEmailBox.sendKeys(ConfigReader.getProperty("aeInvalidEmail"));
        automationExercisePage.loginPasswordBox.sendKeys(ConfigReader.getProperty("aeInvalidPassword"));
    }


    @Then("Verify error Your email or password is incorrect! is visible")
    public void verifyErrorYourEmailOrPasswordIsIncorrectIsVisible() {
        assertTrue(automationExercisePage.incorrectDataText.isDisplayed());
    }

    @Then("Click Logout button")
    public void clickLogoutButton() {
        automationExercisePage.homePageLogoutButton.click();
    }

    @And("Verify that user is navigated to login page")
    public void verifyThatUserIsNavigatedToLoginPage() {
        assertTrue(automationExercisePage.featuresItemsText.isDisplayed());
    }
}
