package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

public class EmployeeSearchSteps {

        WebDriver driver = Hooks.driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // =========================
        // LOGIN
        // =========================
        @Given("kullanici login olur search icin")
        public void kullanici_login_olur_search_icin() {

            driver.get("https://opensource-demo.orangehrmlive.com/");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")))
                    .sendKeys("Admin");

            driver.findElement(By.name("password")).sendKeys("admin123");

            driver.findElement(By.cssSelector("button[type='submit']")).click();

            wait.until(ExpectedConditions.urlContains("dashboard"));
        }

        // =========================
        // PIM
        // =========================
        @When("kullanici PIM sayfasina gider")
        public void pim_sayfasi() {

            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//span[normalize-space()='PIM']")
            )).click();
        }

        // =========================
        // NAME INPUT
        // =========================
        @And("kullanici employee name alanina {string} yazar")
        public void employee_name_yaz(String name) {

            WebElement input = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//input[@placeholder='Type for hints...']")
                    )
            );

            input.sendKeys(name);
        }

        // =========================
        // AUTOCOMPLETE SEÇİM
        // =========================
        @And("kullanici listeden calisani secer")
        public void listeden_sec() {

            WebElement option = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//div[@role='listbox']//span")
                    )
            );

            option.click();
        }

        // =========================
        // SEARCH
        // =========================
        @And("kullanici search butonuna basar")
        public void search_click() {

            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[@type='submit']")
            )).click();
        }

        // =========================
        // RESULT CONTROL
        // =========================
        @Then("sonuc listesi filtrelenmeli")
        public void sonuc_kontrol() {

            WebElement table = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//div[@class='oxd-table-body']")
                    )
            );

            Assert.assertTrue(table.isDisplayed());
        }

        // =========================
        // COLUMN VALIDATION
        // =========================
        @And("en az bir kolon dogrulanmali")
        public void kolon_dogrula() {

            List<WebElement> cells = driver.findElements(
                    By.xpath("//div[@class='oxd-table-body']//div[@role='row']//div[3]")
            );

            boolean bulundu = false;

            for (WebElement cell : cells) {

                String name = cell.getText().trim();

                System.out.println("Bulunan isim: " + name);

                // 🔥 sadece Ali kabul
                if (name.equalsIgnoreCase("Ali") || name.startsWith("Ali ")) {
                    bulundu = true;
                    break;
                }
            }

            Assert.assertTrue("Ali bulunamadi ❌", bulundu);
        }
    }



