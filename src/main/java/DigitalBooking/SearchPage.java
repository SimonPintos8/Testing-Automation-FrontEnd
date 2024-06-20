package DigitalBooking;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends BasePage {
    private By searchBox = By.xpath("//*[@id=\"search\"]/input");
    private By searchButtom = By.xpath("//*[@id=\"search\"]/span/button");
    private By addToCartButtom = By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[2]/button[1]");
    private By validateProductAdded = By.xpath("//*[@id=\"product-search\"]/div[1]/a[1]");

    public SearchPage(WebDriver driver, WebDriverWait wait) {
        super(driver, null);
    }

    /** Completa la búsqueda con la ciudad especificada.
     * @param ciudad La ciudad a buscar.
     * @throws InterruptedException Si ocurre un error durante la espera.
     */
    public void completarBusqueda(String ciudad) throws InterruptedException {
        this.sendText(ciudad, searchBox);
        this.sendKey(Keys.ENTER, searchBox);
    }

    /** Hace click en el botón de búsqueda.
     * @throws InterruptedException Si ocurre un error durante la espera.
     */
    public void clickBuscar() throws InterruptedException {
        this.click(searchButtom);
    }

    /** Hace click en el botón de añadir al carro
     * @throws InterruptedException Si ocurre un error durante la espera.
     */
    public void clickAddToCart() throws InterruptedException {
        this.click(addToCartButtom);
    }

    /** Obtiene el resultado de la búsqueda.
     * @return El texto del resultado de la búsqueda.
     * @throws InterruptedException Si ocurre un error durante la espera.
     */
    public String productoAniadido() throws InterruptedException {
        System.out.println("Producto añadido: " + this.getText(validateProductAdded));
        return this.getText(validateProductAdded);
    }
}