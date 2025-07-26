package tech.kotlinhero.autohelper.core

interface WebDriverConfig {
    val browserBinaryPath: String
    val driverBinaryPath: String
}

object DevChromeConfig : WebDriverConfig {
    override val browserBinaryPath: String
        get() = "C:\\Users\\slowp\\dev\\repository\\AutoHelper\\composeApp\\bin\\common\\chrome\\chrome.exe"
    override val driverBinaryPath: String
        get() = "C:\\Users\\slowp\\dev\\repository\\AutoHelper\\composeApp\\bin\\common\\driver\\chromedriver.exe"
}

object ProdChromeConfig : WebDriverConfig {
    override val browserBinaryPath: String
        get() = TODO("Not yet implemented")
    override val driverBinaryPath: String
        get() = TODO("Not yet implemented")
}