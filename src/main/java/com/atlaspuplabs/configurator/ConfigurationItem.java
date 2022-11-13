package com.atlaspuplabs.configurator;

import java.util.ArrayList;

public class ConfigurationItem<T> {

    public String name;
    public String comment;
    public T value;

    public ConfigurationSection section;
    public Configuration parent;

    public ConfigurationItem(String name, String comment, T defaultValue){
        this.name = name;
        this.comment = comment;
        this.value = defaultValue;
    }

}
