package org.hackerthon;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class Main {

    public static void main(String[] args) {
        Javalin server = Javalin.create(config->{
                config.addStaticFiles("/templates", Location.CLASSPATH);
                })
                .start(8000);
    }
}