package stepdefinitions;

import io.cucumber.java.en.*;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
public class LoginSteps {


    WebDriver driver;
    WebDriverWait wait;

    // =========================
    // LOGIN SAYFASI
    // =========================
    @Given("kullanici login sayfasinda")
    public void kullanici_login_sayfasinda() {
        System.out.println("STEP CALISTI ✅");
        driver = Hooks.driver;
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");

        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
    }

    // =========================
    // USERNAME
    // =========================

    @When("kullanici {string} kullanici adini girer")
    public void kullanici_username_girer(String username) {

        WebElement user = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name("username"))
        );

        user.clear();
        user.sendKeys(username);

        }


    // =========================
    // PASSWORD
    // =========================
    @When("kullanici {string} sifresini girer")

    public void kullanici_password_girer(String password) {

        WebElement pass = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name("password"))
        );

        pass.clear();
        pass.sendKeys(password);
    }



    // =========================
    // LOGIN CLICK
    // =========================
    @And("kullanici login butonuna tiklar")
    public void kullanici_login_tiklar() {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button[type='submit']")
        )).click();
    }
        @Then("dashboard sayfasi goruntulenmeli")
        public void dashboard_kontrol () throws InterruptedException {

            wait.until(ExpectedConditions.urlContains("dashboard"));

            Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
            Thread.sleep(2000);
        }

        // =========================
        // INVALID LOGIN
        // =========================
        @Then("hata mesaji goruntulenmeli")
        public void hata_mesaji_kontrol () {

            WebElement error = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.cssSelector(".oxd-alert-content-text")
                    )
            );
            System.out.println("Hata mesajı: " + error.getText());
            Assert.assertTrue(error.isDisplayed());


        }

        // =========================
        // EMPTY VALIDATION
        // =========================
        @Then("gerekli alan uyarilari goruntulenmeli")
        public void required_kontrol() throws InterruptedException {

            List<WebElement> errors = wait.until(
                    ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            By.cssSelector(".oxd-input-field-error-message")
                    )
            );
            System.out.println("Hata sayısı: " + errors.size());

            Assert.assertTrue(errors.size() > 0);




        }
    }



