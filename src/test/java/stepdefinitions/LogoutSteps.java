package stepdefinitions;

import io.cucumber.java.en.*;
import io.cucumber.java.Before;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class LogoutSteps {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setUp() {
        driver = Hooks.driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // =========================
    // PROFIL MENU
    // =========================
    @When("kullanici profil menusunu acar")
    public void profil_menu() {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[@class='oxd-userdropdown-tab']")
        )).click();
    }

    // =========================
    // LOGOUT
    // =========================
    @And("kullanici logout butonuna tiklar")
    public void logout_click() {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[text()='Logout']")
        )).click();
    }

    // =========================
    // LOGIN KONTROL
    // =========================
    @Then("login ekrani goruntulenmeli")
    public void login_kontrol() {

        boolean loginVisible = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name("username"))
        ).isDisplayed();

        System.out.println("Login ekranı görünüyor: " + loginVisible);

        Assert.assertTrue(loginVisible);
    }
}