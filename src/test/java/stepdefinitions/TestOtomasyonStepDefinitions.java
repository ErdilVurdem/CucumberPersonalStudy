package stepdefinitions;

import io.cucumber.java.en.*;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.TestOtomasyonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.attribute.FileAttribute;
import java.util.List;

public class TestOtomasyonStepDefinitions {
    TestOtomasyonPage testOtomasyonPage=new TestOtomasyonPage();

    String satirdakiUrunIsmi;
    int satirdakiUrunMik;

    int bulunanUrunMik;



    @Given("kullanici TestOtomasyon sayfasina gider")
    public void kullanici_test_otomasyon_sayfasina_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
    }
    @Given("phone icin arama yapar")
    public void phone_icin_arama_yapar() {
        testOtomasyonPage.aramaKutusu.sendKeys("phone"+ Keys.ENTER);
    }
    @Then("aradigi urunun bulundugunu test eder")
    public void aradigi_urunun_bulundugunu_test_eder() {
       String urunSayisi= testOtomasyonPage.bulunanUrunSayisiElementi.getText();
       urunSayisi=urunSayisi.substring(0,1);
       int intUrunSayisi=Integer.parseInt(urunSayisi);
       Assert.assertNotEquals(0,intUrunSayisi);
    }
    @Then("sayfayi kapatir")
    public void sayfayi_kapatir() {
        Driver.quitDriver();
    }

    @And("{int} saniye bekler")
    public void saniyeBekler(int beklemeSuresi) {
        ReusableMethods.bekle(beklemeSuresi);
    }

    @And("shoes icin arama yapar")
    public void shoesIcinAramaYapar() {
        testOtomasyonPage.aramaKutusu.sendKeys("shoes"+ Keys.ENTER);
    }

    @And("dress icin arama yapar")
    public void dressIcinAramaYapar() {
        testOtomasyonPage.aramaKutusu.sendKeys("dress"+ Keys.ENTER);
    }

    @And("{string} icin arama yapar")
    public void icinAramaYapar(String aranacakEleman) {
        testOtomasyonPage.aramaKutusu.sendKeys(aranacakEleman+Keys.ENTER);
    }

    @Then("{string} bulundugunu test eder")
    public void bulundugunuTestEder(String bulunacakEleman) {
       List<String> bulunanElementListStr=ReusableMethods.stringListeCevir(testOtomasyonPage.bulunanUrunElementleriList);
        boolean flag=false;
        for (int i = 0; i < bulunanElementListStr.size(); i++) {
           if ( testOtomasyonPage.bulunanUrunElementleriList.get(i).getText().toLowerCase().contains(bulunacakEleman)){
               flag=true;
           }
        }
        Assert.assertTrue(flag);

    }
    @Given("kullanici {string} sayfasina gider")
    public void kullanici_sayfasina_gider(String gidilecekUrl) {
        Driver.getDriver().get(ConfigReader.getProperty(gidilecekUrl));
    }
    @Then("ilk sayfa login linkine click yapar")
    public void ilk_sayfa_login_linkine_click_yapar() {
        testOtomasyonPage.accountLinki.click();
    }
    @Then("kullanici kutusuna {string} yazar")
    public void kullanici_kutusuna_yazar(String gecerliUserName) {
        testOtomasyonPage.emailKutusu.sendKeys(ConfigReader.getProperty(gecerliUserName));
    }
    @And("password kutusuna {string} yazar")
    public void passwordKutusunaYazar(String gecerliPassword) {
        testOtomasyonPage.passwordKutusu.sendKeys(ConfigReader.getProperty(gecerliPassword));
    }
    @Then("login butonuna basar")
    public void login_butonuna_basar() {
        testOtomasyonPage.loginButonu.click();
    }
    @Then("basarili giris yapildigini test eder")
    public void basarili_giris_yapildigini_test_eder() {
        Assert.assertTrue(testOtomasyonPage.girisYapildiMi.isDisplayed());
    }

    @And("giris yapilamadigini test eder")
    public void girisYapilamadiginiTestEder() {
        Assert.assertTrue(testOtomasyonPage.emailKutusu.isDisplayed());
    }


    @Then("urun excelindeki {string} daki urunun min. miktarini ve urun ismini kaydeder")
    public void urun_excelindeki_daki_urunun_min_miktarini_ve_urun_ismini_kaydeder(String istenenSatir) throws IOException {
        String dosyaYolu="src/test/resources/stok.xlsx";
        FileInputStream fileInputStream=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        Sheet sayfa2= workbook.getSheet("Sayfa2");

        satirdakiUrunIsmi=sayfa2.getRow(Integer.parseInt(istenenSatir)-1).getCell(0).toString();
        String satirdakiUrunMikStr=sayfa2.getRow(Integer.parseInt(istenenSatir)-1).getCell(1).toString();

        double satirdakiUrunMikDbl=Double.parseDouble(satirdakiUrunMikStr);
        satirdakiUrunMik=(int) satirdakiUrunMikDbl;


    }
    @Then("urun ismini testotomasyonu sayfasinda aratir ve sonuc sayisini kaydeder")
    public void urun_ismini_testotomasyonu_sayfasinda_aratir_ve_sonuc_sayisini_kaydeder() {

        testOtomasyonPage.aramaKutusu.sendKeys(satirdakiUrunIsmi+Keys.ENTER);

        String arananUrunYazisi=testOtomasyonPage.bulunanUrunSayisiElementi.getText();

        arananUrunYazisi=arananUrunYazisi.replaceAll("\\D","");
        bulunanUrunMik=Integer.parseInt(arananUrunYazisi);



    }
    @Then("bulunan urun sayisinin kaydedilen min. miktardan fazla oldugunu test eder")
    public void bulunan_urun_sayisinin_kaydedilen_min_miktardan_fazla_oldugunu_test_eder() {

        Assert.assertTrue(bulunanUrunMik>=satirdakiUrunMik);

    }

    @Then("urun excelindeki tum urunler icin arama yapip min miktarda urun oldugunu test eder")
    public void urunExcelindekiTumUrunlerIcinAramaYapipMinMiktardaUrunOldugunuTestEder() throws IOException {

        String dosyaYolu="src/test/resources/stok.xlsx";
        FileInputStream fileInputStream=new FileInputStream(dosyaYolu);
        Workbook workbook=WorkbookFactory.create(fileInputStream);
        Sheet sayfa2= workbook.getSheet("Sayfa2");

        int satirUzunlugu=sayfa2.getLastRowNum();

        boolean stoktaOlmayanVarMi=false;

        for (int i = 1; i <=satirUzunlugu ; i++) {
            satirdakiUrunIsmi=sayfa2.getRow(i).getCell(0).toString();
            String satirdakiUrunMikStr=sayfa2.getRow(i).getCell(1).toString();

            double satirdakiUrunMikDbl=Double.parseDouble(satirdakiUrunMikStr);
            satirdakiUrunMik=(int) satirdakiUrunMikDbl;

            Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

            testOtomasyonPage.aramaKutusu.sendKeys(satirdakiUrunIsmi+Keys.ENTER);

            String arananUrunYazisi=testOtomasyonPage.bulunanUrunSayisiElementi.getText();

            arananUrunYazisi=arananUrunYazisi.replaceAll("\\D","");
            bulunanUrunMik=Integer.parseInt(arananUrunYazisi);

            try {
                Assert.assertTrue(bulunanUrunMik>=satirdakiUrunMik);
            } catch (AssertionError e) {
                stoktaOlmayanVarMi=true;
                System.out.println("aranan "+satirdakiUrunIsmi+" min stok sayisi : "
                        + satirdakiUrunMik+ ", bulunan urun sayisi : " +
                        bulunanUrunMik);

            }

        }
        Assert.assertFalse(stoktaOlmayanVarMi);

        Driver.quitDriver();

    }
}
