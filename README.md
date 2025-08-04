# Vending Machine Management System (Java Console App)

A Java console application simulating a vending machine management system, supporting both customer and admin interactions.

### Features

* **Multiple Vending Machines:** Configurable compartments and products per machine
* **Product Management:** Add, move, list, and filter products by supplier
* **Customer Interface:** Purchase products via virtual bank accounts
* **Administrator Interface:** Manage vending machines and inventory
* **Bank Account Simulation:** Create accounts, process payments, and collect funds
* **Robust OOP Design:** Built with SOLID principles and design patterns like Singleton for CLI and bank account management

### SOLID Principles

* **Single Responsibility:** Clear, focused classes (e.g., Produs, Compartiment, Tonomat, ContBancar)
* **Open/Closed:** Easily extendable for new product types or payment methods without altering existing code
* **Liskov Substitution:** Flexible implementations via interfaces (IContBancar, ITonomat)
* **Interface Segregation:** Fine-grained interfaces ensure classes implement only necessary methods
* **Dependency Inversion:** High-level modules depend on abstractions, not concrete implementations
