package DigitalBooking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends BasePage{
    private By nombre = By.xpath("//*[@id=\"input-firstname\"]");
    private By apellido = By.xpath("//*[@id=\"input-lastname\"]");
    private By email = By.xpath("//*[@id=\"input-email\"]");
    private By telephone = By.xpath("//*[@id=\"input-telephone\"]");
    private By password = By.xpath("//*[@id=\"input-password\"]");
    private By repassword = By.xpath("//*[@id=\"input-confirm\"]");
    private By btnRegistrarse = By.xpath("//*[@id=\"content\"]/form/div/div/input[2]");//*[@id="root"]/main/div/form/button
    private By btnCrearCuenta = By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]");
    private By gracias = By.className("txt-gracias");
    private By exito = By.xpath("//*[@id=\"content\"]/p[1]");
    private By mailRegister = By.className("form-feedback");
    private By passwordDis = By.className("small-feedback");

    /**Constructor de la clase RegisterPage
     * @param driver la instancia de WebDriver utilizada para interactuar con la página web
     */
    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, null);
    }

    /** Hace click en el botón "Crear Cuenta".
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void clickCrearCuenta() throws InterruptedException {
        this.click(btnCrearCuenta);
    }

    /** Ingresa el nombre proporcionado en el campo de nombre.
     * @param name el nombre a ingresar en el campo
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void escribirNombre(String name) throws InterruptedException {
        this.sendText(name, nombre);
    }

    /** Ingresa el apellido proporcionado en el campo de apellido.
     * @param name el apellido a ingresar en el campo
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void escribirApellido(String name) throws InterruptedException {
        this.sendText(name, apellido);
    }

    /** Ingresa el correo electrónico proporcionado en el campo de correo electrónico.
     * @param mail el correo electrónico a ingresar en el campo
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void escribirCorreo(String mail) throws InterruptedException {
        this.sendText(mail, email);
    }

    /** Ingresa el teléfono proporcionado en el campo de telephone.
     * @param phone el teléfono a ingresar en el campo
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void escribirTelephone(String phone) throws InterruptedException {
        this.sendText(phone, telephone);
    }

    /** Ingresa la contraseña proporcionada en el campo de contraseña.
     * @param pass la contraseña a ingresar en el campo
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void escribirContrasenia(String pass) throws InterruptedException {
        this.sendText(pass, password);
    }

    /** Reingresa la contraseña proporcionada en el campo de confirmación de contraseña.
     * @param pass la contraseña a reingresar en el campo
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void repetirContrasenia(String pass) throws InterruptedException {
        this.sendText(pass, repassword);
    }

    /** Hace click en el botón "Registrarse".
     *
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void clickRegistrarse() throws InterruptedException {
        this.click(btnRegistrarse);
    }

    /** Obtiene el texto del mensaje de "Gracias" indicando la creación de la cuenta.
     * @return el texto del mensaje de "Gracias"
     * @throws InterruptedException si el hilo es interrumpido mientras espera

    public String cuentaCreadaGracias() throws InterruptedException {
        String res = this.getText(gracias);
        System.out.println("Resultado Card value: " + res);
        return res;
    }*/

    /** Obtiene el texto del mensaje de éxito indicando la creación de la cuenta.
     * @return el texto del mensaje de éxito
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public String cuentaCreadaExito() throws InterruptedException {
        String res = this.getText(exito);
        System.out.println("Resultado Card value: " + res);
        return res;
    }

    /** Obtiene el texto del mensaje indicando que el correo ya está registrado.
     * @return el texto del mensaje de correo registrado
     * @throws InterruptedException si el hilo es interrumpido mientras espera

    public String mailRegistrado() throws InterruptedException {
        String res = this.getText(mailRegister);
        System.out.println("Resultado Card value: " + res);
        return res;
    }
     */
    /** Obtiene el texto del mensaje indicando que las contraseñas no coinciden.
     * @return el texto del mensaje de contraseñas no coincidentes
     * @throws InterruptedException si el hilo es interrumpido mientras espera

    public String contraseñaNoCoinciden() throws InterruptedException {
        String res = this.getText(passwordDis);
        System.out.println("Resultado Card value: " + res);
        return res;
    }*/
}
