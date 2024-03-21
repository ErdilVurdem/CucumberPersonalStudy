package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class WebdriverUniversityPage {

    public WebdriverUniversityPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

        @FindBy (xpath = "//*[text()='LOGIN PORTAL']")
        public WebElement loginPortalButton;

    @FindBy (xpath = "//*[@placeholder='Username']")
    public WebElement usernameButton;

    @FindBy (xpath = "//*[@placeholder='Password']")
    public WebElement passwordButton;

    @FindBy (xpath = "//*[@id='login-button']")
    public WebElement loginButton;





}

