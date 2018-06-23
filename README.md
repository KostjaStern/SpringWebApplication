# SpringWebApplication

   I am going to use this project as a sandbox for illustration different approaches which can be used in spring web application.
   
## Tools versions which was used
   * Java version: 1.8.0_101, vendor: Oracle Corporation
   * Apache Maven 3.2.3
   * Weblogic 10.3.6.0
   
## How to build the project

   * Correct for yourself and run mvn8.bat

## The project structure:

SpringWebApplication.ear
 |-- lib
 |     |-- app-lib1-0.1.jar
 |           |-- spring
 |           |    |-- beanRefContext.xml
 |           |    |-- services-context.xml
 |           |-- com
 |                |-- ...
 |     |-- spring-core-4.3.0.RELEASE.jar
 |     |-- ...
 |
 |-- META-INF
 |     |-- application.xml
 | 
 |
 |-- AppWeb1.war
 |     |-- WEB-INF
 |           |-- web.xml
 |           |-- lib
 |           |     |-- ...
 |           |-- classes
 |           |     |-- ...
 |           |-- spring
 |                 |-- applicationContext.xml
 |
 |-- AppWeb2.war
             |-- web.xml
             |-- lib
             |    |-- ...
             |-- classes
             |    |-- ...
             |-- spring
                  |-- applicationContext.xml

P.S. The sceleton was takn from [this](https://spring.io/blog/2007/06/11/using-a-shared-parent-application-context-in-a-multi-war-spring-application/) article and then reworked to the maven project.