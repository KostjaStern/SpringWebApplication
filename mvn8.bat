set "JAVA_HOME=C:\Program Files\Java\jdk1.8.0_101"
rem >mvn -DargLine="-Dhttps.protocols=TLSv1,TLSv1.1,TLSv1.2" package
call mvn -DargLine="-Dhttps.protocols=TLSv1,TLSv1.1,TLSv1.2" clean package -DskipTests
pause