package org.hackerthon;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class SidarGovernance {

    private static Javalin server;
    private final int DEFAULT_PORT = 8000;
    private static final String TEMPLATE_DIR = "/templates";

    public SidarGovernance(){
        configureServer();
    }
    public static void main(String[] args) {
        SidarGovernance sidar = new SidarGovernance();
        sidar.start();
    }

    public void  start(){
        SidarGovernance.server.start(DEFAULT_PORT);
    }

    public void configureServer(){
        SidarGovernance.server = Javalin.create(config->{
            config.addStaticFiles( TEMPLATE_DIR, Location.CLASSPATH);
        });
    }
}