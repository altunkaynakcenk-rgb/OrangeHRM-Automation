
                               
                               🚀 OrangeHRM Test Otomasyon Projesi

                               

📌 Proje Hakkında
Bu proje, Selenium, Maven, JUnit ve Cucumber (BDD) kullanılarak geliştirilmiş bir test otomasyon framework’üdür.

OrangeHRM uygulaması üzerinde temel fonksiyonların (login, çalışan arama, çalışan ekleme ve logout) otomatik test edilmesini sağlar.

---

🛠️ Kullanılan Teknolojiler

Java
Selenium WebDriver
Apache Maven
JUnit
Cucumber (BDD)

---

⚙️ Kurulum

1. Projeyi Klonla
git clone https://github.com/altunkaynakcenk-rgb/OrangeHRM-Automation.git
2. Proje Klasörüne Gir
cd OrangeHRM-Automation
3. Bağımlılıkları Yükle
   Maven bağımlılıklarını yükle
   
 ▶️ Bağımlılıkları Yükle
 
     bash
     mvn clean install
   
   Proje için gerekli dosyalar  https://mvnrepository.com/ adresinden de  alınabilir 


▶️ Testleri Çalıştırma

    bash
    mvn test

    
---


📁 Proje Yapısı

 src
 ├── test
 │   ├── java        -> Step Definitions & Runner sınıfları
 │   └── resources   -> Feature dosyaları  



---

## 🌐 Test Ortamı

Testler aşağıdaki demo site üzerinde gerçekleştirilmiştir:

https://opensource-demo.orangehrmlive.com/

---

## 🧪 Test Senaryoları

* ✅ Login Test
* ✅ Add Employee
* ✅ Employee Search
* ✅ Logout Test
* ❌ Negatif Test (fail senaryosu)

---

## 📊 Test Raporu

Test çalıştıktan sonra raporlar aşağıdaki klasörde oluşur:

target/


---

## 📸 Screenshot

Test fail olduğunda otomatik screenshot alınır.

---

## 👤 Hazırlayan

**Cenk Altunkaynak**

---
