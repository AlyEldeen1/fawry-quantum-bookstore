# 📚 Fawry Quantum Bookstore 

This project is my solution to the **Fawry N² Dev Slope #10 Challenge**.  
It simulates a basic online bookstore system supporting multiple book types, inventory management, and purchase flow.

---

## ✅ Features

- **Book Types Supported**
  - 📦 `PaperBook`: Has stock, delivered to address via `ShippingService`
  - 📧 `EBook`: Has file type, delivered via `MailService`
  - ❌ `ShowcaseBook`: Not for sale (demo/display books)

- **Inventory Management**
  - Add books with ISBN, title, author, price, and year
  - Remove outdated books based on age (e.g., older than 5 years)
  - Print all available books in the inventory

- **Purchase Flow**
  - Buy any available PaperBook or EBook using ISBN
  - Checks availability, reduces stock, triggers delivery
  - Handles errors like:
    - Book not found
    - Out of stock
    - Book not available (Showcase)

---

## 🧠 Design Overview

| Component       | Description |
|-----------------|-------------|
| ` Books/Book.java` | Abstract base class with common fields (ISBN, title, year, etc.) |
| `Books/PaperBook.java` | Has stock, uses `ShippingService` |
| `Books/EBook.java` | Has file type, uses `MailService` |
| `Books/ShowcaseBook.java` | Always unavailable |
| `service/ShippingService.java` | Sends PaperBook to a shipping address |
| `service/MailService.java` | Sends EBook to an email address |
| `store/Inventory.java` | Core class to add, remove, and buy books |
| `test/QuantumBookstoreFullTest.java` | Simulates full flow (adding, removing, purchasing) |

---


---

## 🏗️ How to Run

1. Clone the repo
2. Open in any Java IDE (IntelliJ recommended)
3. Use Java 17+
4. Run `QuantumBookstoreFullTest.java` to test the full flow

---

## 👨‍💻 Author

**Aly Eldeen**  
GitHub: [@AlyEldeen1](https://github.com/AlyEldeen1)

---

## 📝 License

This code is provided for the Fawry Internship challenge. Feel free to reuse it for educational purposes.

