Feature: US1003 Kullanici congiuration dosyasındaki verilerle giris yapabilmeli
@pozitif @paralelRun2
  Scenario: TC 001 Geçerli kullanıcı adı ve geçerli şifre ile login testi

    Given kullanici "toUrl" sayfasina gider
    Then ilk sayfa login linkine click yapar
    And kullanici kutusuna "toGecerliEmail" yazar
    And password kutusuna "toGecerliPassword" yazar
    Then login butonuna basar
    And basarili giris yapildigini test eder
    And 3 saniye bekler
    Then sayfayi kapatir