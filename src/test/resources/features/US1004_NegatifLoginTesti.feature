 @negatif
  Feature: Kullanıcı yanlis bilgilerle giris yapamamali
    @paralelRun1
    Scenario: TC001 Gecerli kullanici adi ve gecersiz sifre ile Negatif login testi
      Given kullanici "toUrl" sayfasina gider
      Then ilk sayfa login linkine click yapar
      And kullanici kutusuna "toGecerliEmail" yazar
      And password kutusuna "toGecersizPassword" yazar
      Then login butonuna basar
      And giris yapilamadigini test eder
      And 3 saniye bekler
      Then sayfayi kapatir

    Scenario: TC002 Gecersiz kullanici adi ve gecerli sifre ile Negatif login testi
      Given kullanici "toUrl" sayfasina gider
      Then ilk sayfa login linkine click yapar
      And kullanici kutusuna "toGecersizEmail" yazar
      And password kutusuna "toGecerliPassword" yazar
      Then login butonuna basar
      And giris yapilamadigini test eder
      And 3 saniye bekler
      Then sayfayi kapatir

    Scenario: TC002 Gecersiz kullanici adi ve gecersiz sifre ile Negatif login testi
      Given kullanici "toUrl" sayfasina gider
      Then ilk sayfa login linkine click yapar
      And kullanici kutusuna "toGecersizEmail" yazar
      And password kutusuna "toGecersizPassword" yazar
      Then login butonuna basar
      And giris yapilamadigini test eder
      And 3 saniye bekler
      Then sayfayi kapatir
