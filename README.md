blueprint-servlet-osgi-module
=============================

A sample Jahia module that registers a servlet using OSGi Blueprint

Important note
--------------

Using OSGi Blueprint inside a Jahia module implies that you will not be able to use Spring technologies
integrated such as Spring Webflow. If you need to use such features, you should use the 
[spring-servlet-osgi-module](https://github.com/Jahia/spring-servlet-osgi-module) example instead.

Requirements
------------
- Maven 3.0.x
- Jahia Digital Factory 7.0+

Compiling
---------

    mvn clean install
    
Deploying
---------

Copy the generated JAR from target/blueprint-servlet-osgi-module-*.jar to Jahia Digital Factory's var/modules directory.

Testing
-------

Access the following URL : 

    http://localhost:8080/modules/org.jahia.modules.samples.servlet.blueprint/test?test
    
You should get a result that looks like this : 

    Context path=/modules
    Servlet path=/org.jahia.modules.samples.servlet.blueprint
    Path info=/test
    Query string=test
    
Notes
-----

There is a bug in the OSGi Blueprint (reference) implementation. It doesn't export the org.osgi.service.blueprint 
 package when, according to the specification, it should. We use an exclude statement in the Import-Package instruction
 to get around this bug : 
 
            <plugin>
                <groupId>org.apache.felix</groupId>
                <artifactId>maven-bundle-plugin</artifactId>
                <extensions>true</extensions>
                <configuration>
                    <instructions>
                        <!-- We need to prevent the generation of the dependency to the blueprint package because Gemini Blueprint doesn't import it (https://bugs.eclipse.org/bugs/show_bug.cgi?id=351755) -->
                        <Import-Package>!org.osgi.service.blueprint,${jahia.plugin.projectPackageImport},*</Import-Package>
                    </instructions>
                </configuration>
            </plugin>

 For more details on the bug, see https://bugs.eclipse.org/bugs/show_bug.cgi?id=351755 
    
