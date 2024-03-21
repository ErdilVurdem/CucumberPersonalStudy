@Soutline @paralelRun1
Feature: US1008 belirlenen urunler icin arama yapabilmeli

  Scenario Outline: TC001 kullanici verilen kelime icin arama yapabilmeli
    Given kullanici TestOtomasyon sayfasina gider
    And "<aranacak kelime>" icin arama yapar
    And 1 saniye bekler
    Then "<aranacak kelime>" bulundugunu test eder
    And  sayfayi kapatir

    Examples:
    |aranacak kelime|
    |phone|
    |shoes|
    |ıphone|