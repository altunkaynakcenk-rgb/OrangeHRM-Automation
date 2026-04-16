
Feature: Login Testi

  Scenario: Basarili Login
    Given kullanici login sayfasinda
    When kullanici "Admin" kullanici adini girer
    And kullanici "admin123" sifresini girer
    And kullanici login butonuna tiklar
    Then dashboard sayfasi goruntulenmeli

  Scenario Outline: Gecersiz Login
    Given kullanici login sayfasinda
    When kullanici "<username>" kullanici adini girer
    And kullanici "<password>" sifresini girer
    And kullanici login butonuna tiklar
    Then hata mesaji goruntulenmeli
    Examples:
      | username | password |
      | Artyu    | admin123 |
      | Admin    | 987   |
      | Artyu    | 987  |

  Scenario Outline: Bos Alan Validasyonu
    Given kullanici login sayfasinda
    When kullanici "<username>" kullanici adini girer
    And kullanici "<password>" sifresini girer
    And kullanici login butonuna tiklar
    Then gerekli alan uyarilari goruntulenmeli
    Examples:
      | username | password |
      | Admin    |          |
      |          | admin123 |
      |          |          |