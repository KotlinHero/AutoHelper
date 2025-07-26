This is a Kotlin Multiplatform project targeting Desktop.

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that's common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple's CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

## WebDriver DSL

This project includes a custom DSL for WebDriver operations to simplify browser automation tasks.

### Usage

```kotlin
val driver = webDriver {
    browser("chrome")
    headless(true)
    implicitWait(10)
}

driver
    .navigateTo("https://www.example.com")
    .clickElement(byId("submit-button"))
    .inputText(byName("username"), "testuser")
    .inputText(byName("password"), "password123")

val text = driver.getText(byClassName("result"))
println("Result text: $text")

assert(driver.isElementPresent(byCssSelector(".success-message")))

driver.closeBrowser()
```

### Available Functions

- `webDriver {}` - Creates a new WebDriver instance with configuration
- `navigateTo(url)` - Opens a page and returns the driver for chaining
- `clickElement(selector)` - Clicks an element with automatic waiting
- `inputText(selector, text)` - Inputs text into an element with automatic waiting
- `getText(selector)` - Gets the text of an element with automatic waiting
- `isElementPresent(selector)` - Checks if an element is present on the page
- `closeBrowser()` - Closes the browser and cleans up resources

### Selector Helpers

- `byId(id)`
- `byName(name)`
- `byClassName(className)`
- `byXPath(xpath)`
- `byCssSelector(css)`

## Excel Reading

This project includes optimized utilities for reading Excel files (.xlsx format only), with special handling for large files.

### Usage

```kotlin
// Read Excel as 2D list (optimized for large files)
val data: List<List<String?>> = readExcel("data.xlsx")

// Read Excel as list of objects (maps) (optimized for large files)
val objects: List<Map<String, String?>> = readExcelAsObjects("data.xlsx")

// Read Excel as list of custom objects (using row index mapping)
val customObjects: List<CustomObject> = readExcelAsType("data.xlsx") { row ->
    CustomObject(
        name = row[0] ?: "",
        age = row[1]?.toIntOrNull() ?: 0,
        email = row[2] ?: ""
    )
}

// Read Excel as list of custom objects (using header mapping)
val customObjectsWithHeaders: List<CustomObject> = readExcelAsType("data.xlsx") { map ->
    CustomObject(
        name = map["Name"] ?: "",
        age = map["Age"]?.toIntOrNull() ?: 0,
        email = map["Email"] ?: ""
    )
}
```

### Functions

- `readExcel(filePath: String, sheetIndex: Int = 0)` - Reads Excel file and returns data as 2D list. Uses streaming parser for memory efficiency with large files.
- `readExcelAsObjects(filePath: String, sheetIndex: Int = 0, headerRowIndex: Int = 0)` - Reads Excel file and returns data as list of objects. Uses streaming parser for memory efficiency with large files.
- `<T> readExcelAsType(filePath: String, mapper: (List<String?>) -> T, sheetIndex: Int = 0, skipRows: Int = 0)` - Reads Excel file and maps each row to a custom type using index-based mapping.
- `<T> readExcelAsType(filePath: String, mapper: (Map<String, String?>) -> T, sheetIndex: Int = 0, headerRowIndex: Int = 0)` - Reads Excel file and maps each row to a custom type using header-based mapping.

## Log Component

This project includes a styled Log component for displaying application logs in the UI.

### Usage

```kotlin
var logs: List<String> by remember { mutableStateOf(listOf()) }

// In your UI:
Button(onClick = {
    logs = logs + "New log entry"
}) {
    Text("Add Log")
}

Log(
    logs = logs,
    modifier = Modifier
        .weight(1f)
        .fillMaxWidth()
)
```

The Log component features:
- Scrollable display with automatic limiting of displayed entries
- Clean, continuous styling without distinct separations between lines
- Monospace font for better readability
- Material 3 design principles
- Empty state handling

## UI Structure

The application features a responsive layout with:
- A left sidebar for navigation between different sections (Home, Settings, About)
- A main content area that changes based on the selected sidebar item
- Material 3 design principles throughout the interface

Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…