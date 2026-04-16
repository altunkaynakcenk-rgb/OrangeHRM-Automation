
Feature: Calisan Ekleme

  Scenario: Yeni calisan ekleme
    Given kullanici login olur
    When kullanici PIM menusune gider
    And kullanici Add Employee sayfasini acar
    And kullanici "Ali" ve "Abaci" bilgilerini girer
    And kullanici save butonuna basar
    Then Employee Profile ekrani acilmali
    And profile bilgileri doldurulmalı