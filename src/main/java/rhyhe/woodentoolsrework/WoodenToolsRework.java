package rhyhe.woodentoolsrework;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.data.gamerule.TreecapitatorHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.RecipeEntrypoint;


public class WoodenToolsRework implements ModInitializer, RecipeEntrypoint, GameStartEntrypoint {
    public static final String MOD_ID = "woodentoolsrework";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    @Override
    public void onInitialize() {
        LOGGER.info("Wooden Tools Rework(woodentoolsrework) initialized.");
    }

	@Override
	public void onRecipesReady() {
	}

	@Override
	public void initNamespaces() {

	}

	@Override
	public void beforeGameStart() {

	}

	@Override
	public void afterGameStart() {

	}
}
