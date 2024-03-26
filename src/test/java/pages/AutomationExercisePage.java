package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepdefinitions.AutomationExerciseStepDefinitions;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import static org.junit.Assert.assertTrue;

public class AutomationExercisePage {


    public AutomationExercisePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy (xpath = "//*[@class='fa fa-lock']")
    public WebElement mainPageSignUpButton;

    @FindBy (xpath = "//*[@data-qa='signup-name']")
    public WebElement signUpNameBox;

    @FindBy (xpath = "//*[@data-qa='signup-email']")
    public WebElement signUpEmailBox;

    @FindBy (xpath = "//*[@data-qa='signup-button']")
    public WebElement signUpButton;

    @FindBy (xpath = "//*[@id='id_gender1']")
    public WebElement mrRadioButton;

    @FindBy (xpath = "//*[@data-qa='create-account']")
    public WebElement createAccountButton;

    @FindBy (xpath = "//*[@data-qa='account-created']")
    public WebElement accountCreatedText;

    @FindBy (xpath = "(//*[@class='title text-center'])[1]")
    public WebElement featuresItemsText;

    @FindBy (xpath = "//*[text()='New User Signup!']")
    public WebElement newUserSignUpText;

    @FindBy (xpath = "(//*[@class='title text-center'])[1]")
    public WebElement enterAccountInformationText;

    @FindBy (xpath = "//*[@id='newsletter']")
    public WebElement newsletterButton;

    @FindBy (xpath = "//*[@id='optin']")
    public WebElement specialOfferButton;

    @FindBy (xpath = "//*[@id='first_name']")
    public WebElement firstNameBox;

    @FindBy (xpath = "//*[@data-qa='continue-button']")
    public WebElement accountCreatedDeletedPageContinueButton;

    @FindBy (xpath = "//*[@class='fa fa-trash-o']")
    public WebElement deleteAccountButton;

    @FindBy(xpath = "//*[@data-qa='account-deleted']")
    public WebElement accountDeletedText;

    @FindBy(xpath = "//*[text()='Login to your account']")
    public WebElement loginToYourAccountText;

    @FindBy(xpath = "//*[@data-qa='login-email']")
    public WebElement loginEmailBox;

    @FindBy(xpath = "//*[@data-qa='login-password']")
    public WebElement loginPasswordBox;

    @FindBy (xpath = "//*[@data-qa='login-button']")
    public WebElement loginLoginButton;

    @FindBy (xpath = "//*[text()='mahmut']")
    public WebElement registeredUserLogged;

    @FindBy (xpath = "//*[@style='color: red;']")
    public WebElement incorrectDataText;

    @FindBy (xpath = "//*[text()=' Logout']")
    public WebElement homePageLogoutButton;

    public void accessSignInPageMethod(String navigateUrl){
        Driver.getDriver().get(ConfigReader.getProperty(navigateUrl));
        assertTrue(featuresItemsText.isDisplayed());
        mainPageSignUpButton.click();
        assertTrue(loginToYourAccountText.isDisplayed());
    }

    public  void newUserSignUpMethod(String name,String email){
        signUpNameBox.sendKeys(name);
        signUpEmailBox.sendKeys(email);
        signUpButton.click();
        assertTrue(enterAccountInformationText.isDisplayed());
    }

    Faker faker=new Faker();
    Actions actions=new Actions(Driver.getDriver());
    String name=faker.name().firstName();
    String email=faker.internet().emailAddress();

    String password=faker.internet().password();

    public void setNewUserSignUpEnterInfoMethod(){
        mrRadioButton.click();
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
        newsletterButton.click();
        specialOfferButton.click();
        firstNameBox.sendKeys(name);
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
        createAccountButton.click();
    }

    public void verifyAccontCreatedAndLoginMethod(){
        assertTrue(accountCreatedText.isDisplayed());
        accountCreatedDeletedPageContinueButton.click();
        assertTrue(deleteAccountButton.isDisplayed());
    }
    public void deleteAccountMethod(){
        deleteAccountButton.click();
        assertTrue(accountDeletedText.isDisplayed());
        accountCreatedDeletedPageContinueButton.click();
    }
    public void newUserSignUpEnterInfoMethodForMahmut(){
        mrRadioButton.click();
        actions.sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("aeValidPassword"))
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
        newsletterButton.click();
        specialOfferButton.click();
        firstNameBox.sendKeys(name);
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
        createAccountButton.click();
        accountCreatedDeletedPageContinueButton.click();
    }

    public void loginWithValidInfo(){
        ReusableMethods.loginInAEPage(loginEmailBox,ConfigReader.getProperty("aeValidEmail"),
                                loginPasswordBox,ConfigReader.getProperty("aeValidPassword"));
        loginLoginButton.click();
        assertTrue(registeredUserLogged.isDisplayed());
    }
    public void loginWithInValidInfo(){
        ReusableMethods.loginInAEPage(loginEmailBox,ConfigReader.getProperty("aeInvalidEmail"),
                loginPasswordBox,ConfigReader.getProperty("aeInvalidPassword"));
        loginLoginButton.click();
    }



}
