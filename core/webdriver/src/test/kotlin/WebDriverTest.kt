import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import tech.kotlinhero.autohelper.core.webdriver.webDriver

class WebDriverTest {
    @Test
    fun `test webdriver run`() {
        val webDriver = webDriver {
            chrome {
                driver(path = "C:\\Users\\slowp\\dev\\repository\\AutoHelper\\composeApp\\bin\\common\\driver\\chromedriver.exe")
                binary(path = "C:\\Users\\slowp\\dev\\repository\\AutoHelper\\composeApp\\bin\\common\\chrome\\chrome.exe")
                silent()
                headless()
            }
        }
        webDriver.runCatching {
            get("https://www.baidu.com")
            findElement(By.id("s-top-loginbtn")).text
        }.fold(
            onSuccess = {
                println(it)
            },
            onFailure = {
                println(it)
            }
        )
    }
}