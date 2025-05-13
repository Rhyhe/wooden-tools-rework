package rhyhe.woodentoolsrework;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.data.registry.recipe.RecipeGroup;
import net.minecraft.core.data.registry.recipe.entry.RecipeEntryCrafting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.RecipeEntrypoint;

public class WoodenToolsRework implements ModInitializer, RecipeEntrypoint, GameStartEntrypoint
{
    public static final String MOD_ID = "woodentoolsrework";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize()
    {
        LOGGER.info("Wooden Tools Rework(woodentoolsrework) initialized.");
    }

    @Override
    public void onRecipesReady()
    {
        Config.init();
        if (Config.config.getBoolean("unregister"))
        {
            RecipeGroup<RecipeEntryCrafting<?, ?>> workbench = Registries.RECIPES.WORKBENCH;
            workbench.unregister("stone_pickaxe");
            workbench.unregister("stone_axe");
            workbench.unregister("stone_sword");
            workbench.unregister("stone_hoe");
            workbench.unregister("stone_shovel");
        }
    }

    @Override
    public void initNamespaces()
    {

    }

    @Override
    public void beforeGameStart()
    {
    }

    @Override
    public void afterGameStart()
    {
    }

}
