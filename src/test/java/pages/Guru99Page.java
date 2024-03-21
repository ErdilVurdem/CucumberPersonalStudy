package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class Guru99Page {

    public Guru99Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



        @FindBy (xpath = "(//table/tbody)[2]/tr")
        public List<WebElement> wholeTableInPage;




}
