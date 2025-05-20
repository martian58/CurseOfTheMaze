# CurseOfTheMaze

**CurseOfTheMaze** is a labyrinth-based adventure game built with Java, following best practices in Object Oriented Programming (OOP). Navigate through interconnected rooms, interact with living beings and objects, unlock doors and chests, and discover secrets in a dynamic world.

## Features

- **World**: The game world encapsulates all entities, including rooms, doors, objects, and living beings.
- **Rooms & Doors**: The labyrinth is constructed from rooms connected by doors. Some doors may be locked and require keys or crowbars to open.
- **Living Beings**: Entities with health and strength that can move between rooms, interact with the environment, and pick up objects.
- **Objects**: Chests (can be locked and may contain objects), keys (to unlock locks), and crowbars (to force open locked items).
- **Activatable & Executable Entities**: Entities such as doors and chests can be activated (opened), and living beings have actions executed each turn.
- **Dynamic Interactions**: All entities interact dynamically, making the game world expandable and adaptable.

## Project Structure

```
CurseOfTheMaze/
│
├── assets/                # Place your .png files for game assets here
│   ├── chest.png
│   ├── door.png
│   ├── key.png
│   ├── crowbar.png
│   ├── player.png
│   ├── monster.png
│   └── ... (add your images)
│
├── src/                   # Java source code
│   ├── Activatable.java
│   ├── Chest.java
│   ├── Crowbar.java
│   ├── Door.java
│   ├── Entity.java
│   ├── Executable.java
│   ├── Item.java
│   ├── Key.java
│   ├── LivingBeing.java
│   ├── Lock.java
│   ├── Main.java
│   ├── Player.java
│   ├── Room.java
│   ├── World.java
│   └── CurseOfTheMaze.java
│
├── build.sh               # Compile and run script
└── README.md              # This file
```

## How to Run

1. Place all your asset images in the `assets/` folder.
2. Compile and run using the provided script:
   ```bash
   bash build.sh
   ```

## OOP Principles Used

- **Encapsulation**: Each class encapsulates its data and behaviors.
- **Inheritance**: Common behaviors are inherited (e.g., LivingBeing extends Entity).
- **Polymorphism**: Interfaces for `Activatable` and `Executable` allow for dynamic interactions.
- **Composition**: Entities are composed of other objects (e.g., Room has Doors, Chests contain Items).

## Expandability

The design allows easy extension:
- Add new items by extending the `Item` class.
- Add new behaviors by implementing `Executable` or `Activatable`.

## (Optional) UML Class Diagram

You may use a tool like draw.io to visualize the class diagram based on the structure.

---

Enjoy your adventure in the **CurseOfTheMaze**!