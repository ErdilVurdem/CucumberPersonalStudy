package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v120.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class QualityDemyPage {
    public QualityDemyPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

        @FindBy (xpath = "//*[@class='btn btn-sign-in-simple']")
        public WebElement homePageLoginButton;

        @FindBy (xpath = "//*[@name='email']")
        public WebElement emailBox;

        @FindBy (xpath = "//*[@name='password']")
        public WebElement passwordBox;

        @FindBy (xpath = "//*[@class='btn red radius-5 mt-4 w-100']")
        public WebElement submitBox;

        @FindBy (xpath = "//*[@onclick='cookieAccept();']")
        public WebElement acceptCookiesButton;


}
