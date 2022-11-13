package com.atlaspuplabs.configurator;

public class ExampleClass {

    public static String lastVersion = Main.conf.get("lastVersion", "0.0.0").toString();
}
