package tech.kotlinhero.autohelper.core

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeDriverService
import org.openqa.selenium.chrome.ChromeOptions

@DslMarker
annotation class WebDriverDSL

interface WebDriverBuilder {
    @WebDriverDSL
    fun chrome(configure: ChromeDriverBuilder.() -> Unit): WebDriver
}

interface ChromeDriverBuilder {
    @WebDriverDSL
    fun driver(path: String)
    
    @WebDriverDSL
    fun binary(path: String)
    
    @WebDriverDSL
    fun silent()
    
    @WebDriverDSL
    fun useInternal(configure: InternalDriverOptionsBuilder.() -> Unit)
}

internal class DefaultWebDriverBuilder : WebDriverBuilder {
    @WebDriverDSL
    override fun chrome(configure: ChromeDriverBuilder.() -> Unit): WebDriver {
        return DefaultChromeDriverBuilder().apply { configure() }.build()
    }
}

internal class DefaultChromeDriverBuilder : ChromeDriverBuilder {

    private val serviceBuilder = ChromeDriverService.Builder()

    private val options = ChromeOptions().apply {
        addArguments("--remote-allow-origins=*")
    }

    @WebDriverDSL
    override fun driver(path: String) {
        System.setProperty("webdriver.chrome.driver", path)
    }

    @WebDriverDSL
    override fun binary(path: String) {
        options.setBinary(path)
    }

    @WebDriverDSL
    override fun silent() {
        serviceBuilder.withSilent(true)
    }

    @WebDriverDSL
    override fun useInternal(configure: InternalDriverOptionsBuilder.() -> Unit) {
        InternalDriverOptionsBuilder(this).configure()
    }

    fun build() = ChromeDriver(serviceBuilder.build(), options)

}

class InternalDriverOptionsBuilder(
    private val driverBuilder: ChromeDriverBuilder
) {
    @WebDriverDSL
    fun dev() = config(DevChromeConfig)

    @WebDriverDSL
    fun prod() = config(ProdChromeConfig)

    private fun config(config: WebDriverConfig) {
        driverBuilder.apply {
            binary(config.browserBinaryPath)
            driver(config.driverBinaryPath)
            silent()
        }
    }
}

@WebDriverDSL
fun webDriver(build: WebDriverBuilder.() -> WebDriver): WebDriver = DefaultWebDriverBuilder().build()

@WebDriverDSL
fun WebDriver.start(autoQuit: Boolean = true, block: WebDriver.() -> Unit) {
    block()
    if (autoQuit) {
        quit()
    }
}

interface FindElementScope {
    fun id(id: String): By
    fun xpath(xpath: String): By
}

internal class DefaultFindElementScope : FindElementScope {

    @WebDriverDSL
    override fun id(id: String): By {
        TODO("Not yet implemented")
    }

    @WebDriverDSL
    override fun xpath(xpath: String): By {
        TODO("Not yet implemented")
    }
}

@WebDriverDSL
fun WebDriver.findElement(buildBy: FindElementScope.() -> By): WebElement? {
    return runCatching {
        findElement(DefaultFindElementScope().buildBy())
    }.getOrNull()
}

fun internalChromeDriver() = webDriver {
    chrome {
        useInternal {
            dev()
        }
    }
}