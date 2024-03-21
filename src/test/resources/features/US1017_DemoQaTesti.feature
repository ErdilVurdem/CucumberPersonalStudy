Feature: Explicit Wait

  @DemoQaAlerTesti
Scenario: Alert kapatılabilmeli
 Given kullanici "demoQa" anasayfaya gider
 Then Alerts’e tiklar
 And On button click, alert will appear after 5 seconds karsisindaki click me butonuna basin
 And Allert’in gorunur olmasini bekler
 And Allert uzerindeki yazinin “This alert appeared after 5 seconds” oldugunu test eder
 And Ok diyerek alerti kapatir
  And sayfayi kapatir

   @DemoQaEnableTesti
  Scenario: Buton enable olabilmeli
   Given kullanici "demoQaDynamic" anasayfaya gider
   And “Will enable 5 seconds” butonunun enable olmasini bekleyin
   And “Will enable 5 seconds” butonunun enable oldugunu test edin
   And sayfayi kapatir

    @DemoQaVisibleTesti
    Scenario: Buton visible olabilmeli
     Given kullanici "demoQaDynamic" anasayfaya gider
     And “Visible After 5 seconds” butonunun gorunur olmasini bekleyin
     And “Visible After 5 seconds” butonunun gorunur oldugunu test edin
     And sayfayi kapatir