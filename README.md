# 🚀 Automation Exercise - Functional Testing Framework

## 🧾 Project Overview

This project automates **Functional UI Testing**  for the [Automation Exercise](https://automationexercise.com) practice website. The framework covers:

* ✅ 26 **Functional UI Test Cases** (from registration, login to checkout, invoice, and scroll tests)
* 🧪 Combined test framework using Java, Selenium, TestNG, Maven, and reporting libraries

---

## 🧰 Tech Stack

| Layer             | Tools & Libraries                             |
| ----------------- | --------------------------------------------- |
| Language          | Java                                          |
| UI Automation     | Selenium WebDriver                            |
| Testing Framework | TestNG                                        |
| Build Tool        | Maven                                         |
| Reporting         | Allure Reports, Extent Reports                |
| File Support      | Apache POI, File Upload/Download, Screenshots |

---

## 🧪 Functional Test Cases (UI)

A total of **26 test cases** have been automated. Sample highlights:

* 🧍 Register, Login, Logout
* 🛒 Add to Cart, Product Quantity, Recommended Products
* 📩 Contact Form, Subscription Validation
* 🧾 Place Order, Invoice Download
* 📜 Scroll Tests (with and without arrow)
* 🔎 Product Search, Filter by Brand/Category

> 📂 Test Classes: `src/test/java/tests/testcase01.java` to `testcase26.java`
> 🧭 Page Classes: `src/test/java/pages/` for Page Object Model implementation

---

## 📁 Project Structure

```
automation-exercise/
│
├── src/test/java/
│   ├── pages/                       → POM classes (HomePage, CartPage, LoginPage, etc.)
│   │   ├── CartPage.java
│   │   ├── CheckoutPage.java
│   │   ├── ContactUsPage.java
│   │   ├── HomePage.java
│   │   ├── PaymentDetailsPage.java
│   │   ├── ProductDetailPage.java
│   │   ├── ProductsPage.java
│   │   └── SignupLoginPage.java
│   ├── tests/                       → Test classes: testcase01 to testcase26
│       ├── TestCase01.java
│       ├── TestCase02.java
│       ├── ...
│       └── TestCase26.java
│   └── utilities/
│       ├── BaseClass.java           → Setup, teardown, common utilities
│       ├── ExcelBase.java           → Excel-based data (if used)
│
├── src/test/resources/
│   ├── config.properties
│
├── testdata/
│   ├── sample.pdf, invoice.txt      → Supporting data for upload/download
│
├── reports/
│   └── ExtentReport.html
├── screenshots/                     → Failure snapshots
├── logs/                            → Test execution logs
├── allure-results/                 → Allure raw results
├── pom.xml                         → Maven dependencies and plugins
├── testng.xml                      → Test suite (parallel/groups/priority)
└── README.md
```

---

## ⚙️ Framework Features

* **Data-Driven Testing** via  Excel
* **Parallel Test Execution** using TestNG
* **Browser Support**: Chrome, Firefox (can extend)
* **Failure Screenshot Capture** integrated
* **Reusable Page Objects **

---

## 🧾 Reporting

### 🔷 Extent Reports

* View HTML report with test logs, screenshots, and status.

### 🔷 Allure Reports

```bash
allure serve allure-results
```

---

## 🚀 How to Run

### 🔧 Setup

1. Clone the repository
2. Install Java, Maven, Allure
3. Update `config.properties` (browser, URL)
4. Download browser drivers (chromedriver, geckodriver)

### ▶️ Run with Maven:

```bash
mvn clean test
```

### ▶️ Run specific groups/testcases:

Configure `testng.xml` accordingly.

---

## 📦 Key Dependencies in `pom.xml`

```
* `rest-assured`
* `testng`
* `json-path`, `xml-path`
* `json-schema-validator`
* `gson`, `jackson-databind`
* `javafaker`
* `scribejava-apis`
* `allure-testng`
* `extentreports`
* Maven Surefire and Compiler plugins
```

---

## 📌 Highlights

* ✅ Full coverage of realistic eCommerce scenarios
* 🔒 Secure login, data-driven inputs, and validations
* 📊 Allure + Extent Reports for result analysis
* 📁 TestData folder for test files (PDF, invoices)

---

## 👨‍💻 Author

**Bharath Reddy Mosarla**
QA Engineer | SDET Enthusiast
📧 [mosarlabharathreddy@gmail.com](mailto:mosarlabharathreddy@gmail.com)

---
