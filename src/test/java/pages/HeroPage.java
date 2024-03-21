package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HeroPage {

    public HeroPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//*[@onclick='addElement()']")
    public WebElement addElementButton;

    @FindBy (xpath = "//*[@onclick='deleteElement()']")
    public WebElement deleteButton;

    @FindBy (xpath = "//*[text()='Add/Remove Elements']")
    public WebElement addRemoveElementText;




}
