package stepdefinitions;

import io.cucumber.java.en.*;
import io.cucumber.java.zh_cn.而且;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.Guru99Page;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class GuruDemoStepDefinition {

    Guru99Page guru99Page=new Guru99Page();

    List<String> everyElementInPage=new ArrayList<>();


    @Given("user web sayfasinda")
    public void user_web_sayfasinda() {
        Driver.getDriver().get(ConfigReader.getProperty("demoGuruUrl"));
    }
    @Then("Company listesini consola yazdirir")
    public void company_listesini_consola_yazdirir() {
        for (int i = 0; i < guru99Page.wholeTableInPage.size(); i++) {
            everyElementInPage.add(guru99Page.wholeTableInPage.get(i).getText());
        }
        System.out.println(everyElementInPage);
    }
    @Then("DCB Bank'in listede oldugunu test eder")
    public void dcb_bank_in_listede_oldugunu_test_eder() {
        try {
            for (int i = 0; i < everyElementInPage.size(); i++) {
                Assert.assertTrue(everyElementInPage.get(i).contains("IDFC Bank"));
            }
        } catch (AssertionError e) {
            System.out.println("Aranan şirket listede bulunamadi");
        }
    }

    @And("“Istenen Sirket” Prev.Close degerini yazdirir")
    public void ıstenenSirketPrevCloseDegeriniYazdirir() {
        String dinamicXpath;
        List<String> prevCloseList=new ArrayList<>();
        WebElement iNciELemanPrevClose;

        for (int i = 1; i <=guru99Page.wholeTableInPage.size() ; i++) {
            dinamicXpath="(//table/tbody)[2]/tr["+i+"]/td[3]";
            iNciELemanPrevClose=Driver.getDriver().findElement(By.xpath(dinamicXpath));
            prevCloseList.add(iNciELemanPrevClose.getText());
        }
        System.out.println(prevCloseList);

    }


    @And("{int} sutunundaki tum degerleri yazdirir")
    public void sutunundakiTumDegerleriYazdirir(int yazdirilacakSatirNumarasi) {
        String dinamicXpath;
        List<String> prevCloseList=new ArrayList<>();
        WebElement iNciELemanPrevClose;

        for (int i = 1; i <=guru99Page.wholeTableInPage.size() ; i++) {
            dinamicXpath="(//table/tbody)[2]/tr["+i+"]/td["+yazdirilacakSatirNumarasi+"]";
            iNciELemanPrevClose=Driver.getDriver().findElement(By.xpath(dinamicXpath));
            prevCloseList.add(iNciELemanPrevClose.getText());
        }
        System.out.println(prevCloseList);

    }
}
