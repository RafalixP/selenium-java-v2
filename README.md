# Selenium Java Test Automation Framework

A scalable test automation framework built with Selenium WebDriver, Java, and TestNG, following the Page Object Model (POM) design pattern.

This project was created as part of a structured QA Automation learning path and is continuously extended with new features and best practices.

## 🛠 Tech Stack

- Java 25
- Selenium WebDriver 4.12.1
- TestNG 7.8.0
- Maven 3.9.12
- ChromeDriver
- Page Object Model (POM)

## 🏗 Architecture

The framework follows clean separation of concerns:

- **Tests layer** – contains test logic and assertions
- **Page Objects layer** – encapsulates UI elements and actions
- **Base classes** – reusable WebDriver setup and utility methods
- **Explicit waits** – stable handling of dynamic elements

## 📁 Project Structure
```
selenium-java/
├── src/
│   ├── main/java/
│   │   └── com/rafal/selenium/
│   └── test/java/
│       └── com/rafal/selenium/
│           ├── base/
│           ├── pages/
│           ├── tests/
│           └── utils/
├── pom.xml
└── testng.xml
```

## 🚀 Running Tests

Run all tests:
```bash
mvn clean test
```

Run specific test class:
```bash
mvn test -Dtest=LoginTestPOM
```

## 📋 Implemented Test Scenarios

### 🔐 Authentication – Login Flow
**Covered by:** LoginTest

**Scenarios:**
- Successful login with valid credentials
- Invalid login handling (wrong password, wrong username, empty fields)
- Proper error message assertion

**Technical aspects:**
- Form interactions
- Assertions on flash messages
- URL verification
- Page transition handling

### ⚙️ Dynamic Elements Handling
**Covered by:** DynamicLoadingTest

**Scenarios:**
- Handling element that is hidden in DOM and becomes visible
- Handling element rendered dynamically after clicking "Start"

**Technical aspects:**
- Explicit waits (WebDriverWait)
- Waiting for element visibility
- Waiting for loader disappearance
- Verifying initial and final element state

> 👉 **To jest bardzo ważne** — pokazuje, że rozumiesz synchronizację, a to jest 80% realnych problemów w Selenium.

### ☑️ Form Controls – Checkboxes
**Covered by:** CheckboxesTest

**Scenarios:**
- Selecting checkbox
- Unselecting checkbox
- Verifying selected state

**Technical aspects:**
- Working with isSelected()
- Handling state-based assertions

### 🔽 Dropdown Handling
**Covered by:** DropdownTest

**Scenarios:**
- Selecting option by visible text
- Selecting option by value
- Verifying selected option

**Technical aspects:**
- Using Select class
- Working with `<select>` elements
- Assertion of selected values

### 👤 Hover Interactions
**Covered by:** HoversTest

**Scenarios:**
- Revealing hidden elements on hover
- Verifying dynamic content visibility

**Technical aspects:**
- Actions class
- Mouse interactions
- Dynamic UI behaviour

## 🧠 Key Concepts Implemented

- Page Object Model (POM)
- Explicit waits (WebDriverWait)
- Reusable base test setup
- Separation of test logic from page logic
- Clean and maintainable test design
- Proper assertions for preconditions and postconditions

## 🌐 Test Environment

Tests run against: **https://the-internet.herokuapp.com/**

## 📊 Sample Test Execution
```
Tests run: 22, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

## 📈 Roadmap

- [ ] WebDriverManager integration
- [ ] Headless execution mode
- [ ] CI integration (GitHub Actions)
- [ ] Test reporting (Allure or ExtentReports)
- [ ] Parallel execution
- [ ] Cross-browser support

## 🎯 Purpose of This Project

This repository demonstrates:
- Practical Selenium knowledge
- Understanding of automation architecture
- Ability to build maintainable test frameworks
- Clean code practices in QA automation

## 📄 License

MIT License – free for learning and experimentation.