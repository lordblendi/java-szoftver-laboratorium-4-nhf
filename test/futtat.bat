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
		echo 	Eredmeny:	HIBA
	) ELSE (
		echo 	Eredmeny:	SIKERES
		set /A sikeres=!sikeres! + 1
	)
	
	echo.
	set /A count=!count! + 1
)
echo !sikeres!/!count! SIKERES teszteset
echo Nyomj meg egy billentyut miutan megvizsgaltad a kimeneteket! ...

pause >NUL

echo.
call :Takaritas
goto :End

:Takaritas
echo Takaritas...
::del ..\bin\*.class 2>NUL
del *.out.txt 2>NUL
del *.diff.txt 2>NUL
echo.
goto :EOF

:End
