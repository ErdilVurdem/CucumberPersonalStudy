Feature: US1016 Kullanici yeni kayit olusturur

  @AutomationExTest01
  Scenario: TC24 kullanici kayit olusturabilmeli

    Given kullanici "automationUrl" anasayfaya gider
    And user sign up linkine tiklar
    And user Create an account bolumune email adresi girer
    And signUp butonuna basar
    And Enter account informations and click create account button
    Then hesap olustugunu test eder
    And sayfayi kapatir