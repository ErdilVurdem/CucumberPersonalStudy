package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DemoQaPage {

    public DemoQaPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//*[text()='Alerts']")
    public WebElement leftMenuAlertsButton;

    @FindBy (xpath = "//*[@id='timerAlertButton']")
    public WebElement appearAfter5SecondsButton;

    @FindBy (xpath = "//*[@id='enableAfter']")
    public WebElement willEnableButton;

    @FindBy (xpath = "//*[@id='visibleAfter']")
    public WebElement visibleAfterButton;


}
