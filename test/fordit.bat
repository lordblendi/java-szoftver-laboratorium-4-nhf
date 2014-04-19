@echo off

set PATH=%PATH%;C:\Program Files\Java\jdk1.7.0_40\bin

echo Takaritas...
del ..\bin\*.class 2>NUL
echo.

echo Forditas...
javac ..\src\*.java -d ..\bin
echo.

set /p ".=Forditas kesz, nyomj meg egy billentyut a kilepeshez..." <NUL
pause >NUL