@qdNegative
Feature: US1009 Kullanıcı geçersiz kullanıcı adı ve geçersiz password ile giriş yapamamalı

  Scenario Outline: TC001 Kullanıcı geçersiz kullanıcı adi ve password ile login olmamalı
    Given kullanici "qdUrl" sayfasina gider
    And cookieleri kabul eder
    Then qd ilk sayfa login linkine click yapar
    And qd kullanici kutusuna "<kullanici adi>" yazar
    And qd password kutusuna "<password>" yazar
    Then qd login butonuna basar
    And qd giris yapilamadigini test eder
    And 3 saniye bekler
    Then sayfayi kapatir

    Examples:
    |kullanici adi  |  |password  |
    |Manager5       |  |Manager5! |
    |Manager6       |  |Manager6! |
    |Manager7       |  |Manager7! |
    |Manager8       |  |Manager8! |
    |Manager9       |  |Manager9! |