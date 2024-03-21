Feature: Listede aranan eleman bulunmali

  @DemoGuruTesti
  Scenario: TC_001 kullanici_liste_alabilmeli asagidaki testi yapin
    Given user web sayfasinda
    Then Company listesini consola yazdirir
    And DCB Bank'in listede oldugunu test eder
    And sayfayi kapatir

  @DemoGuruTesti02
  Scenario: TC_17_kullanici_sirket_Prev_Close_alabilmeli olusturun ve asagidaki testi yapin
    Given user web sayfasinda
    And “Istenen Sirket” Prev.Close degerini yazdirir
    And 7 saniye bekler
    And sayfayi kapatir

    @DemoGuruIstenenSutunTesti
  Scenario: TC_18_kullanici_sutun_basligi_ile_liste_alabilmeli olusturun ve asagidaki testi yapin
    Given user web sayfasinda
    And 4 sutunundaki tum degerleri yazdirir
    And sayfayi kapatir

