@echo off

REM Create output directory if it doesn't exist
if not exist out (
    mkdir out
)

REM Compile all Java files to the out directory
javac -d out .\src\*.java

REM Copy assets to the output directory
xcopy /E /I /Y assets out\assets

REM Run the main class
java -cp out CurseOfTheMaze