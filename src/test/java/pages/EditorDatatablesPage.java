package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class EditorDatatablesPage {
    public EditorDatatablesPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy (xpath = "//*[@class='dt-button buttons-create']")
    public WebElement createUserButton;

    @FindBy (xpath = "//*[@id='DTE_Field_first_name']")
    public WebElement firstNameButtonInForm;

    @FindBy (xpath = "//*[@class='DTE_Form_Buttons']")
    public WebElement createButtonInForm;

    @FindBy (xpath = "//*[@type='search']")
    public WebElement searchUserBox;

    @FindBy (xpath = "//tbody/tr[1]/td[2]")
    public WebElement firstUserInTable;

    @FindBy (xpath = "//tbody/tr/td[2]")
    public List<WebElement> usersNameInTable;

}
