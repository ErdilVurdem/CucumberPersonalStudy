package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;

public class FacebookLoginStepDefinitions {

    FacebookPage facebookPage=new FacebookPage();

    @Given("kullanici {string} anasayfaya gider")
    public void kullanici_anasayfaya_gider(String verilenUrl) {
        Driver.getDriver().get(ConfigReader.getProperty(verilenUrl));
    }
    //@Then("facebook cookies kabul eder")
    //public void facebook_cookies_kabul_eder() {
    //    // Write code here that turns the phrase above into concrete actions
    //    throw new io.cucumber.java.PendingException();
    //}
    @Then("facebook'da yeni hesap olustur butonuna basar")
    public void facebook_da_yeni_hesap_olustur_butonuna_basar() {
        facebookPage.addNewAccountButton.click();
    }
    @When("Faker class'indan bilgilerle facebook kayit formunu doldurur")
    public void faker_class_indan_bilgilerle_facebook_kayit_formunu_doldurur() {
        Faker faker=new Faker();
        Actions actions=new Actions(Driver.getDriver());
        String fakeEmail=faker.internet().emailAddress();

         facebookPage.registerFormNameButton.sendKeys(faker.name().firstName());
         actions.sendKeys(Keys.TAB)
                 .sendKeys(faker.name().lastName())
                 .sendKeys(Keys.TAB)
                 .sendKeys(fakeEmail)
                 .sendKeys(Keys.TAB)
                 .sendKeys(fakeEmail)
                 .sendKeys(Keys.TAB)
                 .sendKeys(faker.internet().password())
                 .sendKeys(Keys.TAB)
                 .sendKeys(Keys.TAB)
                 .sendKeys("20")
                 .sendKeys(Keys.TAB)
                 .sendKeys("Mar")
                 .sendKeys(Keys.TAB)
                 .sendKeys("1988")
                 .sendKeys(Keys.TAB)
                 .sendKeys(Keys.TAB)
                 .sendKeys(Keys.RIGHT).perform();
         facebookPage.registerSubmitButton.click();
            }
    @Then("facebook kayit ol tusuna basar")
    public void facebook_kayit_ol_tusuna_basar() {
        facebookPage.registerSubmitButton.click();
    }
}
