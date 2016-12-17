@Echo off
chcp 1251

if not exist bin md bin
if not exist classes md classes
if exist %1.java del /q bin\%1.java
if exist *.java move *.java bin\
if exist classes\%1.class del /q classes\%1.class

javac -d classes bin\%1.java

java -classpath classes %1

if exist manifest.mf del /q manifest.mf

(Echo Manifest-Version: 1.0
Echo Created-By: 1.8.0_101 ^(Oracle Inc.^)
Echo Main-Class: %1)>>manifest.mf

if exist %2.jar del /q %2.jar
if not exist lib md lib
if exist lib\%2.jar del /q lib\%2.jar

jar cvmf manifest.mf lib/%2.jar -C ./classes %1.class

java -jar lib/%2.jar

if exist javadoc del /q javadoc\*.*
if not exist javadoc md javadoc

javadoc -d javadoc bin\%1.java

TIMEOUT /T -1
