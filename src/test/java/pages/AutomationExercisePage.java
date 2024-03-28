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

import java.util.List;

import static org.junit.Assert.*;

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

    @FindBy (xpath = "//*[@data-qa='name']")
    public WebElement contactUsNameBox;

    @FindBy (xpath = "//*[@name='upload_file']")
    public WebElement contactUsUpoadImageButton;

    @FindBy (xpath = "//*[@name='submit']")
    public WebElement contactUsSubmitButton;

    @FindBy (xpath = "//*[@class='btn btn-success']")
    public WebElement contactUsHomeButton;

    @FindBy (xpath = "(//*[@class='fa fa-plus-square'])[1]")
    public WebElement productsFirstElementViewProductButton;

    @FindBy (id = "search_product")
    public WebElement productsSearchBox;

    @FindBy (id = "submit_search")
    public WebElement productSearchButton;

    @FindBy (xpath = "//*[@class='product-image-wrapper']")
    public List<WebElement> searchedProductsList;

    public void accessHomePageMethod(String navigateUrl){
        Driver.getDriver().get(ConfigReader.getProperty(navigateUrl));
        assertTrue(featuresItemsText.isDisplayed());
    }

    public void accessSignInPageMethod(){
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
    public void existEmailErrorMethod(String existEmail, String textToVerify){
        signUpNameBox.sendKeys(faker.name().firstName());
        signUpEmailBox.sendKeys(ConfigReader.getProperty(existEmail));
        signUpButton.click();
        ReusableMethods.findElementWithTextAndVerifyDisplaying(textToVerify);
    }

    public void clickAndVerifyTextMethod(String elementText, String verifyText){
        ReusableMethods.findElementWithTextAndClick(elementText);
        ReusableMethods.findElementWithTextAndVerifyDisplaying(verifyText);
    }
    public void clickHomeAndVerifyPageMethod(String pageTitle){
        contactUsHomeButton.click();
        ReusableMethods.bekle(5);
        assertEquals(ConfigReader.getProperty(pageTitle),Driver.getDriver().getTitle());
    }
    public void clickAndVerifyPageMethod(String buttonName,String urlName){
        ReusableMethods.findElementWithTextAndClick(buttonName);
        assertEquals(ConfigReader.getProperty(urlName),Driver.getDriver().getCurrentUrl());
    }

    public void fillContactUsForm(String imageName){
        contactUsNameBox.sendKeys(faker.name().firstName());
        actions.sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.date().birthday().toString())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.backToTheFuture().quote()).perform();
        ReusableMethods.sayfayiIstenilenKadarKaydirma(0,200);
        ReusableMethods.uploadImageMethod(imageName,contactUsUpoadImageButton);
        contactUsSubmitButton.click();
        Driver.getDriver().switchTo().alert().accept();
    }
    public void verifyAndClickMethod(String textToVerify, String textToClick){
        ReusableMethods.findElementWithTextAndVerifyDisplaying(textToVerify);
        ReusableMethods.findElementWithTextAndClick(textToClick);
    }

    public void searchPorductMethod(String textToSearch){
        productsSearchBox.sendKeys(textToSearch);
        productSearchButton.click();
        ReusableMethods.findElementWithTextAndVerifyDisplaying("Searched Products");
    }

    public void isListVisible(List<WebElement> list){
        boolean flag=true;
        for (int i = 0; i <list.size() ; i++) {
            if (!list.get(i).isDisplayed()){
                flag=false;
            }
        }
        assertTrue(flag);
    }






}
