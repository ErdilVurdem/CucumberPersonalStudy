package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepdefinitions.AutomationExerciseStepDefinitions;
import utilities.Driver;

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


}
