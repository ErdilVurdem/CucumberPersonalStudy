package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SouceDemoPage {

    public SouceDemoPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//*[@placeholder='Username']")
    public WebElement userNameButton;

    @FindBy (xpath = "//*[@placeholder='Password']")
    public WebElement passwordButton;

    @FindBy (xpath = "//*[@type='submit']")
    public WebElement loginButton;

    @FindBy (xpath= "(//*[@class='inventory_item_name '])[1]")
    public WebElement firstProductInList;

    @FindBy (xpath = "//*[@name='add-to-cart-sauce-labs-backpack']")
    public WebElement addToCartButton;

    @FindBy (xpath = "//*[@class='shopping_cart_link']")
    public WebElement shoppingCartButton;

    @FindBy (xpath = "(//*[@id='item_4_title_link'])[1]")
    public WebElement firstProductInCart;



}
