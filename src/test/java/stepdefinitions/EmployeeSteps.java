package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.Keys;
import java.util.List;

import java.time.Duration;


public class EmployeeSteps {

    WebDriver driver;
    WebDriverWait wait;

    // =========================
    // LOGIN
    // =========================
    @Given("kullanici login olur")
    public void kullanici_login_olur() {

        driver = Hooks.driver;
        driver.get("https://opensource-demo.orangehrmlive.com/");

        wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")))
                .sendKeys("Admin");

        driver.findElement(By.name("password")).sendKeys("admin123");

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        wait.until(ExpectedConditions.urlContains("dashboard"));
    }

    // =========================
    // PIM MENU
    // =========================
    @When("kullanici PIM menusune gider")
    public void pim_menu() {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[normalize-space()='PIM']")
        )).click();
    }

    // =========================
    // ADD EMPLOYEE
    // =========================
    @And("kullanici Add Employee sayfasini acar")
    public void add_employee() {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[normalize-space()='Add Employee']")
        )).click();
    }

    // =========================
    // BİLGİ GİRME
    // =========================

    @And("kullanici {string} ve {string} bilgilerini girer")
    public void employee_info(String name, String surname) {

        WebElement first = wait.until(
                ExpectedConditions.elementToBeClickable(By.name("firstName"))
        );

        WebElement last = wait.until(
                ExpectedConditions.elementToBeClickable(By.name("lastName"))
        );

        // 🔥 sadece burayı değiştiriyoruz
        first.sendKeys(name);
        last.sendKeys(surname);

        // 👇 KRİTİK (event tetikler)
        last.sendKeys(Keys.TAB);
    }
    ///save
    @And("kullanici save butonuna basar")
    public void save_click() throws InterruptedException{

        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button[type='submit']")
        )).click();
        Thread.sleep(2200);
    }
    //profil ekranı açılmalı
    @Then("Employee Profile ekrani acilmali")
    public void profile_acildi() {

        WebElement header = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//h6[text()='Personal Details']")
                )
        );

        Assert.assertTrue(header.isDisplayed());
    }

    @And("profile bilgileri doldurulmalı")
    public void profile_doldur() {

        // 🔥 PROFILE SAYFASI GELDİ Mİ
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h6[text()='Personal Details']")
        ));

        // =========================
        // GENDER
        // =========================
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[text()='Male']")
        )).click();

        System.out.println("Gender seçildi");

        // =========================
        // NATIONALITY
        // =========================
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[text()='Nationality']/following::div[1]")
        )).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text()='Turkish']")
        )).click();

        System.out.println("Nationality seçildi");
    }
}