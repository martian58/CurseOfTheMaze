# 🌀 CurseOfTheMaze — OOP Project

Welcome to **CurseOfTheMaze** — an object-oriented adventure game demonstrating core Java OOP concepts through a fun, interactive maze.  

---

## 📋 Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Object Oriented Design](#object-oriented-design)
- [Project Structure](#project-structure)
- [Build & Run Instructions](#build--run-instructions)
- [How to Play](#how-to-play)
- [Extending the Game](#extending-the-game)
- [Conclusion](#conclusion)

---

## 📝 Introduction

**CurseOfTheMaze** is a labyrinth-based adventure game built in Java.  
Players navigate through the maze, unlock doors, collect items, battle monsters, and discover secrets.  
The game was designed to reflect best practices in Object Oriented Programming (OOP), with a focus on encapsulation, inheritance, polymorphism, and composition.

---

## ✨ Features

- **Dynamic Maze World:** The game world is built from rooms, doors, chests, keys, monsters, and more—all interacting dynamically.
- **Locked Doors & Keys:** Some doors require keys to open, creating a puzzle element.
- **Chests & Rewards:** Hidden chests can be unlocked for health boosts or more keys.
- **Monsters:** Encounter and defeat monsters—be careful, some are tougher than others!
- **Crowbars & Secrets:** Sometimes force, not just keys, is the answer to progressing.
- **Expandable Design:** The codebase supports easy addition of new entities, obstacles, or mechanics.

---

## 🏗️ Object Oriented Design

This project was intentionally architected to demonstrate core OOP concepts:

- **Encapsulation:** Each class manages its own state and behavior.
- **Inheritance:** Common logic is shared (e.g., monsters inherit from a base entity).
- **Polymorphism:** Game interactions are handled through interfaces such as `GameObject`.
- **Composition:** The maze is composed of various objects, each with its own logic.
- **Extensibility:** New features (entities, actions) can be added with minimal changes to existing code.

---

## 🗂️ Project Structure

```
CurseOfTheMaze/
│
├── assets/                  
│   ├── chest.jpg
│   ├── door.jpg
│   ├── key.png
│   ├── player.jpg
│   ├── monster1.png
│   ├── monster2.png
│   
│
├── src/                            # Java source code (main logic & entities)
│   ├── CurseOfTheMaze.java         # Main game launcher
│   ├── MazePanel.java              # Handles game rendering
│   ├── MazeData.java               # Stores maze state and player info
│   ├── GameObject.java             # Interface for interactive objects
│   ├── Chest.java
│   ├── Door.java
│   ├── Key.java
│   ├── Monster1.java 
│   └── Monster2.java
│
├── docs/                           # Documentation and report
│   └── Report.pdf                  # Project report (university submission)
│
├── build.sh                        # Bash script to compile & run (Linux/macOS)
├── build.ps1                       # PowerShell script to compile & run (Windows PowerShell)
├── build.bat                       # Batch script to compile & run (Windows CMD)
├── release.sh                      # Script to create a distributable .jar
└── README.md                       # This report file
```

---

## 🛠️ Build & Run Instructions

### **Linux/macOS**
```bash
bash build.sh      # Compile and run the code
```

### **Windows (Command Prompt)**
```
build.bat
```

### **Windows (PowerShell)**
```powershell
.\build.ps1
```

### **Create a Release JAR**
```bash
bash release.sh
java -jar release/CurseOfTheMaze.jar
```

> **Requirements:**  
> - Java JDK 8 or newer must be installed and available in your system PATH.

---

## 🕹️ How to Play

- **Goal:** Reach the exit of the maze while collecting keys, unlocking doors, opening chests, and surviving monsters!
- **Movement:** Use the arrow keys to move.
- **Interact:** Move into a tile containing an object (key, door, chest, or monster) to interact.
- **Inventory:** Collected keys are shown on the info panel.
- **Health:** Avoid or defeat monsters; if your health reaches zero, game over!
- **Chests:** Some chests give health or more keys if you have a matching key.

---

## 🧩 Extending the Game

One objective of this project was extensibility.  
You can easily add new entities (e.g., new types of monsters, items, or puzzle objects) by creating a new class implementing `GameObject` and updating the maze and initialization logic.

---

## 🏁 Conclusion

**CurseOfTheMaze** demonstrates how object-oriented programming can be leveraged to create interactive, maintainable, and extensible software—in this case, a maze adventure game.  
This project reflects both technical skills and creative design, and is intended as a foundation for further exploration in Java and game development.

---

## 🙋‍♂️ Questions or Feedback?

Feel free to open an [issue](https://github.com/martian58/CurseOfTheMaze/issues) or submit a pull request if you'd like to contribute or have questions.

---
