import tech.kotlinhero.autohelper.core.internalChromeDriver
import tech.kotlinhero.autohelper.core.start
import kotlin.test.Test

class WebDriverTest {
    @Test
    fun `test webDriver extend dsl`() = internalChromeDriver().start {

    }
}