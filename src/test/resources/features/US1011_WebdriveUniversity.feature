@WebUni
Feature: US1011 sayfaya login olunabilmeli

  Scenario: US1011 sayfaya login olunabilmeli ve login olunduğu doğrulabilmeli
  When kullanici "webUniUrl" anasayfaya gider
  Then Login Portal'a kadar asagi inin
  And Login Portal'a tiklar
  And Diger window'a gecer
  Then username kutusuna deger yazdirir
  And password kutusuna deger yazdirir
  And WD login butonuna basar
  Then Popup'ta cikan yazinin validation failed oldugunu test eder
  And ok diyerek Popup'i kapatir
  Then Ilk sayfaya geri doner
  And 3 saniye bekler
  And Ilk sayfaya donuldugunu test eder
  And sayfayi kapatir