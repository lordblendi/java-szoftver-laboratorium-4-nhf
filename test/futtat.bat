@echo off
setlocal ENABLEDELAYEDEXPANSION

set PATH=%PATH%;C:\Program Files\Java\jdk1.7.0_40\bin

call :Takaritas

::echo Forditas...
::javac ..\src\*.java -d ..\bin

echo.
echo Tesztek futtatasa...
set count=1
set sikeres=0
for /f "tokens=1,2 delims=#" %%a in ('"prompt #$H#$E# & echo on & for %%b in (1) do rem"') do (
  set "DEL=%%a"
)
set /p ".=%DEL%" <NUL > SIKERES
set /p ".=%DEL%" <NUL > HIBA
for %%f in (*.in.txt) do (
	set infile=%%~nf.txt
	set base=!infile:~0,-7!
	set outfile=!base!.out.txt
	set testfile=!base!.test.txt
	set difffile=!base!.diff.txt
	
	echo !count!. teszteset ^(!base!^)
	echo 	Bemenet: 	!infile!
	echo 	Kimenet: 	!outfile!
	echo 	Elvart kimenet:	!testfile!
	echo 	Diff fajl:	!difffile!
	echo 	Futtatas...
	java -cp ..\bin Main < !infile! > !outfile!
	echo 	Diff keszitese...
	diff -u !testfile! !outfile! > !difffile!
	
	if ERRORLEVEL 1 (
		set /p ".=%DEL% 	Eredmeny:	" <NUL
		call :Szines 0C HIBA
	) ELSE (
		set /p ".=%DEL% 	Eredmeny:	" <NUL
		call :Szines 0A SIKERES
		set /a sikeres=!sikeres! + 1
	)
	echo.
	
	echo.
	set /a count=!count! + 1
)
set /p ".=!sikeres!/!count! " <NUL
call :Szines 0A SIKERES
echo  teszteset
echo Nyomj meg egy billentyut miutan megvizsgaltad a kimeneteket...

pause >NUL

echo.
call :Takaritas
goto :End

:Takaritas
echo Takaritas...
::del ..\bin\*.class 2>NUL
del *.out.txt 2>NUL
del *.diff.txt 2>NUL
del SIKERES >NUL 2>&1
del HIBA >NUL 2>&1
echo.
goto :EOF

:Szines
findstr /v /a:%1 /R "^$" "%~2" NUL
goto :EOF

:End