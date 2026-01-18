# Selenium Java Test Automation Framework - v2

Test automation framework using Selenium WebDriver, Java, and TestNG with Page Object Model design pattern.

## 🛠️ Technologies

- **Java 25**
- **Selenium WebDriver 4.12.1**
- **TestNG 7.8.0**
- **Maven 3.9.12**
- **ChromeDriver**

## 📁 Project Structure

```
selenium-java/
├── src/
│   ├── main/java/
│   │   └── com/rafal/selenium/
│   │       └── HelloSelenium.java
│   └── test/java/
│       └── com/rafal/selenium/
│           ├── pages/
│           │   ├── LoginPage.java
│           │   └── SecurePage.java
│           ├── tests/
│           │   └── LoginTestPOM.java
│           └── BasicSeleniumTest.java
├── pom.xml
└── testng.xml
```

## 🚀 Running Tests

### Run all tests:
```bash
mvn test
```

### Run specific test class:
```bash
mvn test -Dtest=LoginTestPOM
```

### Compile and run:
```bash
mvn clean test
```

## 📋 Test Scenarios

### LoginTestPOM
- **testSuccessfulLogin** - Verify successful login with valid credentials
- **testLoginAndLogout** - Test complete login/logout cycle
- **testInvalidLogin** - Verify error handling with invalid credentials

### BasicSeleniumTest  - Initial approach without POM (for learning purposes)
- **testLogin** - Basic login test with assertions
- **testDifferentLocators** - Demonstration of various Selenium locators

## 🎯 Page Object Model

The framework implements Page Object Model (POM) design pattern:

- **LoginPage** - Encapsulates login page elements and actions
- **SecurePage** - Encapsulates secure area page elements and actions

## ⚙️ Configuration

### Chrome Options
- Disabled password manager
- Disabled save password bubble
- Disabled web security warnings
- Disabled notifications

### Test Site
Tests run against: `https://the-internet.herokuapp.com/`

## 📊 Test Results

All tests passing:
```
Tests run: 3, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

## 🎓 Learning Path

This project follows a structured learning plan covering:
- ✅ Java basics for QA
- ✅ Selenium WebDriver fundamentals
- ✅ Locators (ID, Name, CSS, XPath)
- ✅ TestNG annotations and assertions
- ✅ Page Object Model implementation
- ✅ WebDriverWait (planned)
- ⏳ CI/CD integration (planned)

## 📝 Notes

- ChromeDriver must be installed and available in PATH
- Java 25 required (or modify `maven.compiler.release` in pom.xml)

## 🤝 Contributing

This is a learning project. Feel free to fork and experiment!

## 📄 License

MIT License - feel free to use for learning purposes.
