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
        TomlConfigHandler config = new TomlConfigHandler(WoodenToolsRework.MOD_ID, defaultToml, false);
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
        return new Toml("Wooden Tool Rework Configuration File")
                .addEntry("unregister", "Unregisters the stone tools recipes. This makes them uncraftable.", true)
                .addEntry("wood_is_stone",
                        "Replaces the wood material to stone, making wooden tools have the same properties as stone tools",
                        true)
                .addEntry("build_better_pickaxe_iron",
                        "Replaces the logo of the achievement BUILD_BETTER_PICKAXE with an iron pickaxe instead of a stone pickaxe.",
                        true);
    }
}
