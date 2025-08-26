package tech.kotlinhero.autohelper.core.webdriver

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

@DslMarker
annotation class WebDriverDSL

@WebDriverDSL
fun webDriver(block: WebDriverBuilder.() -> Unit): WebDriver = DefaultWebDriverBuilder().apply { block() }.build()

@WebDriverDSL
fun WebDriver.findElementById(id: String): WebElement? {
    return findElementBy(By.id(id))
}

@WebDriverDSL
fun WebDriver.findElementByXpath(xpath: String): WebElement? {
    return findElementBy(By.xpath(xpath))
}

@WebDriverDSL
fun WebDriver.findElementBy(by: By): WebElement? {
    return runCatching {
        findElement(by)
    }.getOrNull()
}