package rhyhe.woodentoolsrework;

import turniplabs.halplibe.util.TomlConfigHandler;
import turniplabs.halplibe.util.toml.Toml;

import java.io.File;
import java.io.IOException;

public class Config
{
    //largely "inspired" by:
    //https://github.com/MartinSVK12/signalindustries/blob/55416a320c7092335433e49094eb3453aecea3e6/src/main/java/sunsetsatellite/signalindustries/SIConfig.java

    public static final TomlConfigHandler config = createConfiguration();

    public static void init()
    {
    }

    private static TomlConfigHandler createConfiguration()
    {
        Toml defaultToml = createDefaultTOML();
        TomlConfigHandler config = new TomlConfigHandler(WoodenToolsRework.MOD_ID, createDefaultTOML(), false);
        File configFile = config.getConfigFile();
        if (configFile.exists())
        {
            config.loadConfig();
            config.setDefaults(config.getRawParsed());
//            boolean changed = false;
//            if (changed)
//            {
//                config.setDefaults(config.getRawParsed());
//                config.writeConfig();
//                config.loadConfig();
//            }
        } else
        {
            config.setDefaults(defaultToml);
            try
            {
                //noinspection ResultOfMethodCallIgnored
                configFile.getParentFile().mkdirs();
                //noinspection ResultOfMethodCallIgnored
                configFile.createNewFile();
                config.writeConfig();
                config.loadConfig();
            } catch (IOException e)
            {
                throw new RuntimeException("Failed to generate config!", e);
            }
        }
        return config;
    }

    private static Toml createDefaultTOML()
    {
        Toml toml = new Toml("Wooden Tools Rework Configuration File");
        toml.addEntry("unregister", "Unregisters the stone tools recipes.", true);
        toml.addEntry("woodisstone", "Replaces the wood material to stone.", true);
        return toml;
    }
}
