package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pages.WebdriverUniversityPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class WebdriverUniversityStepDefinitions {

   WebdriverUniversityPage webdriverUniversityPage=new WebdriverUniversityPage();
    Faker faker=new Faker();
    String ilkWH;

    @Then("Login Portal'a kadar asagi inin")
    public void login_portal_a_kadar_asagi_inin() {
        ilkWH=Driver.getDriver().getWindowHandle();

        JavascriptExecutor javascriptExecutor =(JavascriptExecutor) Driver.getDriver();
        javascriptExecutor.executeScript("window.scrollBy(0,200)");

    }
    @Then("Login Portal'a tiklar")
    public void login_portal_a_tiklar() {
        webdriverUniversityPage.loginPortalButton.click();
    }
    @Then("Diger window'a gecer")
    public void diger_window_a_gecer() {
        ReusableMethods.titleIleWindowDegistir("WebDriver | Login Portal", Driver.getDriver());
    }
    @Then("username kutusuna deger yazdirir")
    public void usernameKutusunaDegerYazdirir() {
        webdriverUniversityPage.usernameButton.sendKeys(faker.name().username());
    }

    @And("password kutusuna deger yazdirir")
    public void passwordKutusunaDegerYazdirir() {
        webdriverUniversityPage.passwordButton.sendKeys(faker.internet().password());
    }
    @Then("WD login butonuna basar")
    public void wd_login_butonuna_basar() {
        webdriverUniversityPage.loginButton.click();
    }
    @Then("Popup'ta cikan yazinin validation failed oldugunu test eder")
    public void popup_ta_cikan_yazinin_validation_failed_oldugunu_test_eder() {
        Assert.assertEquals("validation failed",Driver.getDriver().switchTo().alert().getText().toLowerCase());
    }
    @Then("ok diyerek Popup'i kapatir")
    public void ok_diyerek_popup_i_kapatir() {
        Driver.getDriver().switchTo().alert().accept();
    }
    @Then("Ilk sayfaya geri doner")
    public void ılk_sayfaya_geri_doner() {
        Driver.getDriver().switchTo().window(ilkWH);
    }
    @Then("Ilk sayfaya donuldugunu test eder")
    public void ılk_sayfaya_donuldugunu_test_eder() {
        Assert.assertEquals("WebDriverUniversity.com",Driver.getDriver().getTitle());
    }


}
