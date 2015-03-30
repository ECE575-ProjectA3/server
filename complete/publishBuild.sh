#!/bin/bash
## Package a new maven build and send it to the server

# note: if this script fails, either copy the jarfile to the server
#       manually or delete duplicate jarfiles from the "target" directory

mvn package
scp target/*.jar ece575a3.ddns.net:/tmp/server.jar

# The server may now be executed by running "java -jar /tmp/server.jar" on the server
