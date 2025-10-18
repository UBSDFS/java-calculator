# SDC230_OOP_LAB

# 🧮 Calculator Application

### Author: Ulysses Burden III  
**Course:** Software Control Design  
**Date:** October 2025  

---

## 📘 Overview
This project is a **console-based calculator application** built in Java.  
The purpose of this refactor was to transition from a simple procedural design into a **modular, object-oriented program** using classes and objects.  

The app demonstrates core software development principles including **encapsulation**, **abstraction**, and **separation of concerns**.  
It validates user input, handles runtime errors gracefully, and manages resources efficiently through the use of **try-with-resources**.

---

## ⚙️ Features
✅ Perform basic arithmetic operations:  
- Addition  
- Subtraction  
- Multiplication  
- Division  

✅ Input validation for menu selection and numeric entries  
✅ Graceful handling of divide-by-zero exceptions  
✅ Continuous program loop until user chooses to exit  
✅ Clean separation of logic, control, and interface  
✅ Safe resource management using `try-with-resources`  

---

## 🧩 Class Architecture

### **1. Calculator.java**
- Acts as the **entry point** of the program.  
- Creates the `Scanner` and `CalculatorEngine` objects.  
- Passes those objects into `MenuControl` for dependency injection.  
- Uses `try-with-resources` to ensure the `Scanner` closes automatically after program termination.  

**Key responsibilities:**
```java
try (Scanner in = new Scanner(System.in)) {
    CalculatorEngine engine = new CalculatorEngine();
    MenuControl menu = new MenuControl(in, engine);
    menu.run();
}
