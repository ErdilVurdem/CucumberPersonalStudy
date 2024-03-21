package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.EditorDatatablesPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class EditorDatatableStepDefinitions {

    EditorDatatablesPage editorDatatablesPage=new EditorDatatablesPage();
    String firstName;
    String lastName;

    @Then("new butonuna basar")
    public void new_butonuna_basar() {
        editorDatatablesPage.createUserButton.click();
    }
    @Then("tum bilgileri girer")
    public void tum_bilgileri_girer() {

        Actions actions=new Actions(Driver.getDriver());
        Faker faker=new Faker();

        firstName= faker.name().firstName();
        lastName=faker.name().lastName();

        editorDatatablesPage.firstNameButtonInForm.sendKeys(firstName);
        actions.sendKeys(Keys.TAB)
                .sendKeys(lastName)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.job().position())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress())
                .sendKeys(Keys.TAB)
                .sendKeys("-")
                .sendKeys(Keys.TAB)
                .sendKeys("2022-10-05")
                .sendKeys(Keys.TAB)
                .sendKeys("50000").perform();


    }
    @Then("Create tusuna basar")
    public void create_tusuna_basar() {
       editorDatatablesPage.createButtonInForm.click();
    }
    @When("kullanici ilk isim ile arama yapar")
    public void kullanici_ilk_isim_ile_arama_yapar() {
        editorDatatablesPage.searchUserBox.sendKeys(firstName+" "+lastName);
    }
    @Then("isim bolumunde isminin oldugunu dogrular")
    public void isim_bolumunde_isminin_oldugunu_dogrular() {
        boolean flag=false;

        List<String> users= ReusableMethods.stringListeCevir(editorDatatablesPage.usersNameInTable);
        System.out.println(users);
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).equals(firstName+" "+lastName)){
                flag=true;
            }
        }
        Assert.assertTrue(flag);
        
        //Assert.assertTrue(editorDatatablesPage.firstUserInTable.getText().contains(firstName+" "+lastName));
    }

    @And("{string} {string} {string} {string} {string}{string} ve {string} girer")
    public void veGirer(String firstName, String lastName, String position, String office, String extention, String startdate, String salary) {
        Actions actions=new Actions(Driver.getDriver());
        editorDatatablesPage.firstNameButtonInForm.sendKeys(firstName);
        ReusableMethods.bekle(1);
        actions.sendKeys(Keys.TAB)
                .sendKeys(lastName)
                .sendKeys(Keys.TAB)
                .sendKeys(position)
                .sendKeys(Keys.TAB)
                .sendKeys(office)
                .sendKeys(Keys.TAB)
                .sendKeys(extention)
                .sendKeys(Keys.TAB)
                .sendKeys(startdate)
                .sendKeys(Keys.TAB)
                .sendKeys(salary).perform();
    }

    @When("kullanici {string} ile arama yapar")
    public void kullaniciIleAramaYapar(String firstName) {
        editorDatatablesPage.searchUserBox.sendKeys(firstName);
    }

    @Then("listede ilk ismin {string} icerdigini test eder")
    public void listedeIlkIsminIcerdiginiTestEder(String firstName) {
        Assert.assertTrue(editorDatatablesPage.firstUserInTable.getText().contains(firstName));
    }
}
