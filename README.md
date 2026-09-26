# Concurrent Restaurant Simulator

A restaurant management and simulation system developed in **Java**, focused on **concurrency, object-oriented programming, and design patterns**.

## Overview

The system simulates the operation of a restaurant, including customer orders, dish preparation, payment, and table management. The kitchen handles multiple orders concurrently while limiting the number of dishes being prepared at the same time.

The project also includes a login and account management system with persistent data storage.

## Main Features

- Concurrent management of orders, kitchen operations, and dish preparation.
- Maximum of **6 dishes being prepared simultaneously**.
- Persistence using Java object serialization.
- Input validation and exception handling.
- Interactive menu and restaurant operation.
- **Mediator** and **Strategy** design patterns.
- Use of `Thread`, `Runnable`, `Vector`, and `ArrayList`.

## Technologies

- **Java**
- **Object-Oriented Programming**
- **Concurrency and Multithreading**
- **Design Patterns**
- **Object Serialization**

## Design Patterns

### Mediator

Used to coordinate communication between components of the login and account management system.

### Strategy

Used to manage different types of dishes and their preparation behavior.

---

# Español

## Descripción

Sistema de gestión y simulación de un restaurante desarrollado en **Java**, enfocado en **programación orientada a objetos, concurrencia y patrones de diseño**.

El sistema simula diferentes procesos de la operación de un restaurante, incluyendo la llegada de clientes a las mesas, selección de platillos, toma y preparación de pedidos, consumo y pago. La cocina procesa múltiples pedidos de forma concurrente y cuenta con un límite de **6 platillos en preparación simultáneamente**.

El sistema también incluye un módulo de inicio de sesión y gestión de cuentas, con persistencia de información mediante serialización de objetos.

## Características principales

- Gestión concurrente de pedidos, cocina y preparación de platillos.
- Simulación de tiempos de preparación y consumo.
- Capacidad máxima de **6 platillos en preparación simultáneamente**.
- Persistencia de información mediante serialización de objetos.
- Validación de entradas y manejo de excepciones.
- Menú interactivo y gestión de mesas.
- Uso de los patrones de diseño **Mediator** y **Strategy**.
- Uso de `Thread`, `Runnable`, `Vector` y `ArrayList`.

## Patrones de diseño

### Mediator

Utilizado para coordinar la comunicación entre los componentes relacionados con el inicio de sesión y la gestión de cuentas, reduciendo el acoplamiento directo entre ellos.

### Strategy

Utilizado para representar los diferentes tipos de platillos y gestionar sus comportamientos de preparación de manera intercambiable.
