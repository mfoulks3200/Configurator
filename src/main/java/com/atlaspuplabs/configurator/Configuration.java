package com.atlaspuplabs.configurator;


import java.io.File;
import java.util.ArrayList;

public class Configuration {

    public String file;
    private String rawConfig;
    public ArrayList<ConfigurationSection> sections = new ArrayList<>();

    public Configuration(String file){
        this.file = file;
        ConfigurationSection defaultSection = new ConfigurationSection("Default");
        sections.add(defaultSection);

        refreshConfig();
    }

    public ConfigurationItem find(String name){
        for(ConfigurationSection section : sections){
            ConfigurationItem item = section.get(name);
            if(item != null){
                return item;
            }
        }
        return null;
    }

    public Object get(String name, String defaultValue){
        ConfigurationItem i = find(name);
        return i == null ? defaultValue : i.value;
    }

    public ConfigurationSection getSection(String name){
        for(ConfigurationSection section : sections){
            if(section.name == name){
                return section;
            }
        }
        return null;
    }

    public void refreshConfig(){
        rawConfig = Resources.getTextFile(file);
        ConfigurationSection current = sections.get(0);
        for(String line : rawConfig.split("\n")){
            if(line.length() == 0){
                continue;
            }
            if(line.substring(0,2).equals("#!")){
                String sectionName = line.substring(3);
                ConfigurationSection newSection = getSection(sectionName);
                if(newSection != null){
                    current = newSection;
                }else{
                    current = new ConfigurationSection(sectionName);
                    sections.add(current);
                }
                continue;
            }
            if(line.charAt(0) == '#'){
                continue;
            }
            String key = line.split("=")[0];
            String value = line.substring(line.indexOf('=')+1);
            ConfigurationItem item = current.get(key);
            if(item != null){
                item.value = value;
            }else{
                current.items.add(new ConfigurationItem(key, "", value));
            }
        }
    }

    public String toString(){
        String output = "\n|-----------------------------------------|\n";
        output += "| Configuration File: "+String.format("%19s",file)+" |\n";
        output += "|-----------------------------------------|\n";
        for(ConfigurationSection section : sections){
            output += "| "+String.format("%-39s",section.name)+" |\n";
            output += "|--------------------|--------------------|\n";
            for(ConfigurationItem i : section.items){
                output += "| "+String.format("%18s",i.name)+" | "+String.format("%18s",i.value.toString())+" |\n";
            }
            output += "|--------------------|--------------------|\n";
        }
        return output;
    }
}
