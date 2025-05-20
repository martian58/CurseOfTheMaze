#!/bin/bash

# Create output directory if it doesn't exist
mkdir -p out

# Compile all Java files to the out directory
javac -d out ./src/*.java

# Copy assets to the output directory
cp -r assets out/

# Run the main class
java -cp out CurseOfTheMaze