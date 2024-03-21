@EditorTest @paralelRun2
Feature:  US1010 kullanici data ekleyebilmeli

  Scenario: TC001 Kullanıcı eklediği datayi tabloda görebilmeli

    When kullanici "editorUrl" anasayfaya gider
    Then new butonuna basar
    And tum bilgileri girer
    And Create tusuna basar
    When kullanici ilk isim ile arama yapar
    Then isim bolumunde isminin oldugunu dogrular
    Then sayfayi kapatir


