package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.QualityDemyPage;
import utilities.ConfigReader;

public class QualityDemyStepDefinitions {

    QualityDemyPage qualityDemyPage=new QualityDemyPage();

    @Then("qd ilk sayfa login linkine click yapar")
    public void qd_ilk_sayfa_login_linkine_click_yapar() {
        qualityDemyPage.homePageLoginButton.click();
    }

    @Then("qd login butonuna basar")
    public void qd_login_butonuna_basar() {
       qualityDemyPage.submitBox.click();
    }
    @Then("qd giris yapilamadigini test eder")
    public void qd_giris_yapilamadigini_test_eder() {
        Assert.assertTrue(qualityDemyPage.submitBox.isDisplayed());
    }

    @And("qd kullanici kutusuna {string} yazar")
    public void qdKullaniciKutusunaYazar(String gecersizUserName) {
        qualityDemyPage.emailBox.sendKeys(gecersizUserName);
    }

    @And("qd password kutusuna {string} yazar")
    public void qdPasswordKutusunaYazar(String gecersizPassword) {
        qualityDemyPage.passwordBox.sendKeys(gecersizPassword);
    }

    @And("cookieleri kabul eder")
    public void cookieleriKabulEder() {
        qualityDemyPage.acceptCookiesButton.click();
    }
}
