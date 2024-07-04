# E-Commerce Project

Welcome to the E-Commerce project, developed as part of the Programming Workshop IV course at Cracow University of Economics. This project aims to provide hands-on experience in the following areas:

- **Test-Driven Development (TDD)**
- **Object-Oriented Programming (OOP) principles**
- **Programming best practices**
- **Java and Spring Boot environment**
- **Integration with PayU API**

## Overview

In this workshop, we are building an E-Commerce application from the ground up. The project covers a range of functionalities typical of an E-Commerce platform, including product browsing, cart management, order processing, and more. **Please note that the project is not yet finished and is actively maintained and evolving.**

## Features

- **Payment Processing:** Integration with PayU API for secure transaction handling.
- **Shopping Cart Management:** Allows users to add, remove, and modify items in their shopping carts.
- **Offer Calculation:** Calculates prices and generates quotations based on selected items and configurations.
- **Facade Design Pattern:**
    - **Unified Interface:** `SalesFacade` offers a unified interface for handling operations related to shopping carts, offers, payments, and reservations. It abstracts away the complexities of components like `Cart`, `OfferCalculator`, `PaymentGateway`, and `ReservationRepository`.
    - **Simplified Usage:** Clients interact with `SalesFacade` methods (`getCurrentOffer`, `acceptOffer`, `addToCart`) instead of directly manipulating lower-level components, which promotes code clarity and reduces potential errors.
- **Testing:**
    - **Unit Tests**
    - **Integration Tests**
    - **End-to-End (E2E) Tests**

## Technologies Used

- **Java 17**
- **Spring Boot 3.2.4**
- **JUnit 5.10.2**
- **AssertJ 3.25.1**
- **PayU API**
- **H2 Database**

I hope this project provides valuable insights and practical experience in modern software development practices. The project is a work in progress, and contributions and feedback are welcome.


