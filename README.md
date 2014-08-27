servlet-osgi-module
===================

A sample Jahia module that registers a servlet using OSGi Blueprint

Requirements
------------
- Maven 3.0.x
- Jahia Digital Factory 7.0+

Compiling
---------

    mvn clean install
    
Deploying
---------

Copy the generated JAR from target/servlet-osgi-module-*.jar to Jahia Digital Factory's var/modules directory.

Testing
-------

Access the following URL : 

    http://localhost:8080/modules/org.jahia.modules.samples.servlet/test?test
    
You should get a result that looks like this : 

    Context path=/modules
    Servlet path=/org.jahia.modules.samples.servlet
    Path info=/test
    Query string=test
    
