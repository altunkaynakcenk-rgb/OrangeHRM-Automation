
Feature: Calisan Arama

  Scenario: Calisan arama
    Given kullanici login olur search icin
    When kullanici PIM sayfasina gider
    And kullanici employee name alanina "Ali" yazar
    And kullanici listeden calisani secer
    And kullanici search butonuna basar
    Then sonuc listesi filtrelenmeli
    And en az bir kolon dogrulanmali