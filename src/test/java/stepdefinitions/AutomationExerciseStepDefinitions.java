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

    @Given("user Create Account butonuna basar")
    public void user_create_account_butonuna_basar() {
       automationExercisePage.createAccountButton.click();
    }
    @Then("hesap olustugunu test eder")
    public void hesap_olustugunu_test_eder() {
        Assert.assertTrue(automationExercisePage.accountCreatedText.isDisplayed());
    }

//----------------  Tests With Sites Cases  ----------------

    @Given("Access to {string} SignIn Page and verify Login to your account is visible")
    public void accessToAutomationUrlSignInPageAndVerifyLoginToYourAccountIsVisible(String navigateUrl) {
        automationExercisePage.accessSignInPageMethod(navigateUrl);
    }
    @Then("Enter {string} and {string} address and click SignUp button and Verify that ENTER ACCOUNT INFORMATION is visible")
    public void enter_name_and_email_address(String name, String email) {
        automationExercisePage.newUserSignUpMethod(name,email);
    }
    @And("Enter account informations and click create account button")
    public void enterAccountInformations() {
        automationExercisePage.setNewUserSignUpEnterInfoMethod();
    }
    @And("Verify that ACCOUNT CREATED! and Logged in as username visible")
    public void verifyThatACCOUNTCREATEDAndLoggedInAsUsernameVisible() {
        automationExercisePage.verifyAccontCreatedAndLoginMethod();
    }
    @Then("Click Delete Account button and Verify that ACCOUNT DELETED! is visible")
    public void clickDeleteAccountButtonAndVerifyThatACCOUNTDELETEDIsVisible() {
        automationExercisePage.deleteAccountMethod();
    }
    @And("Enter account informations and click create account button for mahmut")
    public void enterAccountInformationsAndClickCreateAccountButtonForMahmut() {
        automationExercisePage.newUserSignUpEnterInfoMethodForMahmut();
    }
    @Given("Login with correct email and password")
    public void loginWithCorrectEmailAndPassword() {
        automationExercisePage.loginWithValidInfo();
    }
    @Given("Login with incorrect email and password")
    public void loginWithIncorrectEmailAndPassword() {
        automationExercisePage.loginWithInValidInfo();
    }
    @Then("close page")
    public void close_page() {
        Driver.closeDriver();
    }
    @And("Verify that Logged in as username is visible registered user")
    public void verifyThatLoggedInAsUsernameIsVisibleRegisteredUser() {
        assertTrue(automationExercisePage.registeredUserLogged.isDisplayed());
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
