package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {

    public FacebookPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//*[@data-testid='open-registration-form-button']")
    public WebElement addNewAccountButton;

    @FindBy (xpath = "//*[@placeholder='Adın']")
    public WebElement registerFormNameButton;

    @FindBy (xpath = "//*[@name='websubmit']")
    public WebElement registerSubmitButton;

}
