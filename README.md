# Uno Game Engine

A modular and extensible Uno Game Engine built in Java, designed to let developers easily create their own Uno game variations by plugging in new rules and behaviors.

## 🎯 Project Goal

The goal of this project is to provide a flexible engine for Uno-style card games, supporting custom rules while preserving a clean, maintainable architecture.

## ▶️ How It Works

Watch a walkthrough of the gameplay and features:  
[🎬 Uno Game Engine Demo](https://youtu.be/77C4c0nl8qk)

## 🔧 Key Features

- Fully object-oriented design (OOP principles: encapsulation, inheritance, polymorphism, abstraction)
- Built-in official Uno rules for immediate play
- Extendable rules system via strategy pattern
- Custom card set creation via factory pattern
- Game skeleton with Template Method pattern
- Developer-friendly code: Clean Code + SOLID principles
- Ready-to-use CLI-based game interface

## 🧱 Architecture Overview

- `Game` is the core abstract class to be extended (e.g., `BasicGame`)
- `CardFactory` enables custom card deck generation
- Strategy classes handle game logic (e.g., play direction, turn management)
- `Card` is an abstract class with `NumberedCard`, `ActionCard`, and `WildCard` as implementations


## 🧑‍💻 For Developers

To create a new variation:
1. Extend the `Game` class
2. Implement your own strategies
3. Define custom card distribution logic via your own `CardFactory` subclass

## 🚀 Technologies Used

- Java
- OOP Principles
- Design Patterns: Factory, Strategy, Template Method
- CLI (Java console)

## 📦 Getting Started

1. Clone the repo
2. Compile with:
   ```bash
   javac *.java
3. Run with:
   ```badh
   java Main

 ## 📄 License

This project is provided for educational and demonstration purposes only.  
Reuse or redistribution of the code is not permitted without the author's consent.

