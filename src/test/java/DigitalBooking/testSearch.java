package DigitalBooking;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reportes.ReportFactory;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class testSearch {
    private WebDriver driver;
    private WebDriverWait wait;

    static ExtentSparkReporter info = new ExtentSparkReporter("reportes/Busqueda-Test.html");
    static ExtentReports extent;

    @BeforeAll
    public static void run() {
        extent = ReportFactory.getInstance();
        extent.attachReporter(info);
        System.out.println("<<< COMIENZAN LOS TEST DE BÚSQUEDA Y AÑADIR AL CARRITO >>>");
    }

    @BeforeEach
    public void setUp() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        SearchPage searchPage = new SearchPage(driver, wait);
        searchPage.setup();
        searchPage.getUrl("https://opencart.abstracta.us/index.php?route=common/home");
    }

    @Test
    @Tag("BUSQUEDA")
    @Tag("EXITOSO")
    public void test_BusquedaExitosa() throws InterruptedException {
        ExtentTest test = extent.createTest("Búsqueda Exitosa");
        SearchPage searchPage = new SearchPage(driver, wait);
        searchPage.setup();
        searchPage.getUrl("https://opencart.abstracta.us/index.php?route=common/home");
        searchPage.completarBusqueda("Iphone");
        searchPage.clickBuscar();
        wait.until(ExpectedConditions.urlToBe("https://opencart.abstracta.us/index.php?route=product/search&search=Iphone"));
        searchPage.clickAddToCart();
        searchPage.productoAniadido();
        if (searchPage.productoAniadido().equals("iPhone")) {
            test.log(Status.PASS, "Producto añadido correctamente!");
        } else {
            test.log(Status.FAIL, "El producto no se añadió!");
        }
        searchPage.close();
    }

    @AfterEach
    public void cerrar() {
        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.close();
    }

    @AfterAll
    public static void saveReport() {
        extent.flush();
        System.out.println("<<< FINALIZAN LOS TEST DE BÚSQUEDA Y AÑADIR AL CARRITO >>>");
    }
}