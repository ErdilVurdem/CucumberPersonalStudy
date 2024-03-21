@wip
Feature: US1001 belirlenen urunler icin arama yapabilmeli


  Scenario: TC001 kullanici phone icin arama yapabilmeli
    Given kullanici TestOtomasyon sayfasina gider
    And phone icin arama yapar
    And 1 saniye bekler
    Then aradigi urunun bulundugunu test eder
    And  sayfayi kapatir

  Scenario: TC002 kullanici shoes icin arama yapabilmeli
    Given kullanici TestOtomasyon sayfasina gider
    And shoes icin arama yapar
    And 1 saniye bekler
    Then aradigi urunun bulundugunu test eder
    And  sayfayi kapatir

  Scenario: TC003 kullanici dress icin arama yapabilmeli
    Given kullanici TestOtomasyon sayfasina gider
    And dress icin arama yapar
    And 1 saniye bekler
    Then aradigi urunun bulundugunu test eder
    And  sayfayi kapatir

