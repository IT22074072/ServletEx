package org.example;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class App
{
    public static void main( String[] args ) throws LifecycleException {
        System.out.println( "Hello World!" );

        // Initialize Tomcat and set the port
        Tomcat tomcat = new Tomcat();

        // Add context
        Context context = tomcat.addContext("", null);

        // Add servlet and mapping
        Tomcat.addServlet(context, "HelloServlet", new HelloServlet());
        context.addServletMappingDecoded("/hello", "HelloServlet");

        // Start the server
        tomcat.start();
        tomcat.getServer().await();

    }
}
