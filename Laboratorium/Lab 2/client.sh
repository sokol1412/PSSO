#!/bin/bash

#the client's codebase URL
myHTTPserverIP=192.168.0.15

#the client's codebase port
myHTTPserverPort=8080

RMIserverIP=192.168.0.10

# LOG=-Dsun.rmi.loader.logLevel=SILENT
LOG=-Dsun.rmi.loader.logLevel=BRIEF

rm client/*.class &>/dev/null
rm server/*.class &>/dev/null

javac client/ComputePi.java

# Make the bytecode available via the HTTP server
python -m SimpleHTTPServer $myHTTPserverPort &
echo "Press Enter when the HTTP server is on..."
read

java -Djava.rmi.server.codebase=http://$myHTTPserverIP:$myHTTPserverPort/ -Djava.rmi.server.useCodebaseOnly=false -Djava.security.policy=java.policy $LOG client.ComputePi $RMIserverIP 10

echo "Press CTRL+C to end..."
read