# Create output directory if it doesn't exist
if (-not (Test-Path "out")) {
    New-Item -ItemType Directory -Path "out" | Out-Null
}

# Compile all Java files to the out directory
javac -d out .\src\*.java

# Copy assets to the output directory
Copy-Item -Recurse -Force assets out\

# Run the main class
java -cp out CurseOfTheMaze