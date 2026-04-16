
Feature: Logout

  Scenario: Basarili logout
    Given kullanici login olur
    When kullanici profil menusunu acar
    When kullanici logout butonuna tiklar
    Then login ekrani goruntulenmeli

