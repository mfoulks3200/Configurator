# Configurator

A simple configuration system for Java. Define options that are reflectively managed to and from disk.

    //Define a new configuration file
    public static Configuration conf = new Configuration("example.cfg");

    //Define a new configuration option (in the first/default section)
    public static String headless = conf.get("headless", "true").toString();

    //Define a new section
    ConfigurationSection videoSection = new ConfigurationSection("Video");
    conf.sections.add(videoSection);
    conf.refreshConfig();