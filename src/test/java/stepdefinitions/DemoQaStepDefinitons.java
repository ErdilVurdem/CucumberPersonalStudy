package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DemoQaPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

import static org.junit.Assert.*;

public class DemoQaStepDefinitons {

    DemoQaPage demoQaPage=new DemoQaPage();

    @Then("Alerts’e tiklar")
    public void alerts_e_tiklar() {
        JavascriptExecutor javascriptExecutor =(JavascriptExecutor) Driver.getDriver();
        javascriptExecutor.executeScript("window.scrollBy(0,400)");
        ReusableMethods.bekle(1);
        demoQaPage.leftMenuAlertsButton.click();
    }
    @Then("On button click, alert will appear after {int} seconds karsisindaki click me butonuna basin")
    public void on_button_click_alert_will_appear_after_seconds_karsisindaki_click_me_butonuna_basin(Integer int1) {
        demoQaPage.appearAfter5SecondsButton.click();
    }
    @Then("Allert’in gorunur olmasini bekler")
    public void allert_in_gorunur_olmasini_bekler() {
        WebDriverWait webDriverWait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.alertIsPresent());
    }
    @Then("Allert uzerindeki yazinin “This alert appeared after {int} seconds” oldugunu test eder")
    public void allert_uzerindeki_yazinin_this_alert_appeared_after_seconds_oldugunu_test_eder(Integer int1) {
        System.out.println(Driver.getDriver().switchTo().alert().getText());
        assertEquals("This alert appeared after 5 seconds",Driver.getDriver().switchTo().alert().getText());
    }
    @Then("Ok diyerek alerti kapatir")
    public void ok_diyerek_alerti_kapatir() {
        Driver.getDriver().switchTo().alert().accept();
    }

    @And("“Will enable {int} seconds” butonunun enable olmasini bekleyin")
    public void willEnableSecondsButonununEnableOlmasiniBekleyin(int arg0) {
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(demoQaPage.willEnableButton));
    }

    @And("“Will enable {int} seconds” butonunun enable oldugunu test edin")
    public void willEnableSecondsButonununEnableOldugunuTestEdin(int arg0) {
        assertTrue(demoQaPage.willEnableButton.isEnabled());
    }

    @And("“Visible After {int} seconds” butonunun gorunur olmasini bekleyin")
    public void visibleAfterSecondsButonununGorunurOlmasiniBekleyin(int arg0) {
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(demoQaPage.visibleAfterButton));
    }

    @And("“Visible After {int} seconds” butonunun gorunur oldugunu test edin")
    public void visibleAfterSecondsButonununGorunurOldugunuTestEdin(int arg0) {
        assertTrue(demoQaPage.visibleAfterButton.isDisplayed());
    }
}
