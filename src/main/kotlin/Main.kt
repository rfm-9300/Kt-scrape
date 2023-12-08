import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

fun main() {

    println("Hello World!")
    val driver: WebDriver = ChromeDriver()

    val chromeOptions = ChromeOptions()
    chromeOptions.addArguments("--headless")

    driver.get("https://www.particulares.santander.pt/pagina/indice/0,,840_1_2,00.html")


    val wait = WebDriverWait(driver, Duration.ofSeconds(10))
    var iframeElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ws")))

    // Switch to the iframe if it exists
    if (iframeElement != null) {
        driver.switchTo().frame(iframeElement as WebElement)
    }

    // Explicitly wait for the input element to be present
    val login = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text' and starts-with(@class, 'input')]")))
    val passwordElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='password']")))

    // Perform actions on the element (e.g., interact with the input)
    login.sendKeys("4293430612633450")
    passwordElement.sendKeys("029029")

    val submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit_button")))
    submitButton.click()

    driver.switchTo().defaultContent()



    ////

    iframeElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ws")))

    if (iframeElement != null) {
        driver.switchTo().frame(iframeElement as WebElement)
    }


    // Explicitly wait for the Saldo disponível label to be present

    val saldoLabel = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@class='data-label' and text()='Saldo disponível']")))

    val saldoValueElement = saldoLabel.findElement(By.xpath("//following-sibling::p[@class='balance-value text-green']"))

    val saldoValueText = saldoValueElement.text
    println("Saldo disponível: $saldoValueText")









}

