package com.atlaspuplabs.configurator;

import com.atlaspuplabs.lumberjack.Event;
import com.atlaspuplabs.lumberjack.EventLog;

public class Main {

    public static Configuration conf;

    public static void main(String[] args) {
        new EventLog();
        conf = new Configuration("example.cfg");
        new Event(Main.conf.get("lastVersion", "0.0.0").toString());
    }
}