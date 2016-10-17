
::The IP address of this host
SET myIP=192.168.56.1

::The server's codebase URL

SET myHTTPserverIP=%myIP%

::The server's codebase port

SET myHTTPserverPort=80

SET LOG=-Dsun.rmi.loader.logLevel=SILENT
::SET LOG=-Dsun.rmi.loader.logLevel=BRIEF

del /S server\*.class
del /S client\*.class
@echo RMIregistry cannot have a CLASSPATH to the bytecode of the remote object
cd server
REM set CLASSPATH=
start C:\"Program Files\Java\jdk1.8.0_60\bin\rmiregistry" -J-Djava.rmi.server.useCodebaseOnly=false -J-Djava.rmi.server.logCalls=true -J%LOG%
cd ..

javac server/ComputeEngine.java
REM rmic server.ComputeEngine
start /B hfs.exe server
@echo.
@echo Wait until HFS is ready before starting ComputeEngine!
@echo.
@pause

java -Djava.rmi.server.codebase=http://%myHTTPserverIP%:%myHTTPserverPort%/ -Djava.rmi.server.hostname=%myIP% -Djava.security.policy=java.policy -Djava.rmi.server.useCodebaseOnly=false %LOG% server.ComputeEngine