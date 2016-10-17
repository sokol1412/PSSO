::the client's codebase URL
SET myHTTPserverIP=192.168.56.1
::the client's codebase port
SET myHTTPserverPort=80

SET RMIserverIP=192.168.56.1

REM SET LOG=-Dsun.rmi.loader.logLevel=SILENT
SET LOG=-Dsun.rmi.loader.logLevel=BRIEF

del /S client\*.class
del /S server\*.class
javac client/PrimeNum.java
javac client/ComputePrime.java

start /B hfs.exe client
@echo.
@echo Wait until HFS is ready before starting ComputePi!
@echo.
@pause

java -Djava.rmi.server.codebase=http://%myHTTPserverIP%:%myHTTPserverPort%/ -Djava.security.policy=java.policy -Djava.rmi.server.useCodebaseOnly=false %LOG% client.ComputePrime %RMIserverIP% %1
