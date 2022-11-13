package com.atlaspuplabs.configurator;

import java.util.ArrayList;

public class ConfigurationSection {

    public ArrayList<ConfigurationItem> items = new ArrayList<>();
    public String name;

    public ConfigurationSection(String name){
        this.name = name;
    }

    public boolean exists(ConfigurationItem item){
        for(ConfigurationItem i : items){
            if(i.name == item.name){
                return true;
            }
        }
        return false;
    }

    public ConfigurationItem get(String name){
        for(ConfigurationItem i : items){
            if(i.name == name){
                return i;
            }
        }
        return null;
    }
}
