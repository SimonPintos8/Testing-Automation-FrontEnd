package DigitalBooking;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reportes.ReportFactory;

import java.time.Duration;

import static reportes.ReportFactory.captureScreenshot;

public class testRegister {
    private WebDriver driver;
    private WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("reportes/Register-Test.html");
    static ExtentReports extent;


    @BeforeAll
    public static void run() {
        extent = ReportFactory.getInstance();
        extent.attachReporter(info);
        System.out.println("<<< COMIENZAN LOS TEST DE REGISTRO >>>");
    }

    @BeforeEach
    public void setUp() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.setup();
        registerPage.getUrl("https://opencart.abstracta.us/index.php?route=common/home");
    }

    @Test
    @Tag("REGISTRO")
    @Tag("EXITOSO")
    public void RegistroExitoso() throws InterruptedException {
        ExtentTest test = extent.createTest("Registro Exitoso");
        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.clickCrearCuenta();
        registerPage.click(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a"));
        wait.until(ExpectedConditions.urlToBe("https://opencart.abstracta.us/index.php?route=account/register"));
        try {
            registerPage.escribirNombre("Pepe");
            registerPage.escribirApellido("Perez");
            registerPage.escribirCorreo("PepePerez3@gmail.com");
            registerPage.escribirTelephone("+598889923");
            registerPage.escribirContrasenia("1234");
            registerPage.repetirContrasenia("1234");
            registerPage.click(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[2]/input")); // Click en "No"
            registerPage.click(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")); // Aceptación de términos
            Thread.sleep(4000);
            registerPage.clickRegistrarse();
            wait.until(ExpectedConditions.urlToBe("https://opencart.abstracta.us/index.php?route=account/success"));
            if (registerPage.cuentaCreadaExito().equals("Congratulations! Your new account has been successfully created!")) {
                test.log(Status.PASS, "Registro alcanzado con éxito!");
            } else {
                test.log(Status.FAIL, "Registro incompleto");
            }

        } catch (Exception error) {
            test.log(Status.FAIL, "FALLO EL TEST DE REGISTRO" + error.getMessage());
            captureScreenshot(test, "FAIL_RegistroExitoso", driver);
        }

    }

    @AfterEach
    public void cerrar() {
        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.close();
    }

    @AfterAll
    public static void saveReport() {
        extent.flush();
        System.out.println("<<< FINALIZAN LOS TEST DE REGISTRO >>>");
    }
}
