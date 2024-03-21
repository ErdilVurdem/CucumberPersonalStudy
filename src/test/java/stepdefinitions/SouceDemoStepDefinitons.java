package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.SouceDemoPage;
import utilities.ConfigReader;
import utilities.Driver;

public class SouceDemoStepDefinitons {

    SouceDemoPage souceDemoPage=new SouceDemoPage();
    String firstProductText;

    @Then("saucedemo username kutusuna {string} yazar")
    public void saucedemo_username_kutusuna_yazar(String gecerliUsername) {
        souceDemoPage.userNameButton.sendKeys(gecerliUsername);
    }
    @Then("saucedemo password kutusuna {string} yazar")
    public void saucedemo_password_kutusuna_yazar(String gecerliPassword) {
        souceDemoPage.passwordButton.sendKeys(gecerliPassword);
    }
    @Then("saucedemo login tusuna basar")
    public void saucedemo_login_tusuna_basar() {
        souceDemoPage.loginButton.click();
    }
    @Then("ilk urunun ismini kaydeder ve bu urunun sayfasina gider")
    public void ilk_urunun_ismini_kaydeder_ve_bu_urunun_sayfasina_gider() {
        firstProductText=souceDemoPage.firstProductInList.getText();
        souceDemoPage.firstProductInList.click();
    }
    @When("saucedemo add to Cart butonuna basar")
    public void saucedemo_add_to_cart_butonuna_basar() {
       souceDemoPage.addToCartButton.click();
    }
    @Then("saucedemo alisveris sepetine tiklar")
    public void saucedemo_alisveris_sepetine_tiklar() {
        souceDemoPage.shoppingCartButton.click();
    }
    @Then("sectigi urunun basarili olarak sepete eklendigini test eder")
    public void sectigi_urunun_basarili_olarak_sepete_eklendigini_test_eder() {
        Assert.assertEquals(firstProductText,souceDemoPage.firstProductInCart.getText());
    }
}
