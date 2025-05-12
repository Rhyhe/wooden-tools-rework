package rhyhe.woodentoolsrework;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.options.components.BooleanOptionComponent;
import net.minecraft.client.gui.options.components.OptionsCategory;
import net.minecraft.client.gui.options.data.OptionsPage;
import net.minecraft.client.gui.options.data.OptionsPages;
import net.minecraft.client.option.GameSettings;
import net.minecraft.client.option.OptionBoolean;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;

public abstract class ModSettings
{
    public static OptionBoolean unregister;
    public static OptionBoolean woodIsStone;

    public static void init()
    {
        OptionsPages.register(
                new OptionsPage("gui.options.page.rhyhesmods.title", new ItemStack(Items.TOOL_PICKAXE_WOOD))
                        .withComponent(
                                new OptionsCategory("gui.options.page.rhyhesmods.category." + WoodenToolsRework.MOD_ID)
                                        .withComponent(new BooleanOptionComponent(unregister))
                                        .withComponent(new BooleanOptionComponent(woodIsStone)))

        );
    }

    static
    {
        GameSettings gameSettings = Minecraft.getMinecraft().gameSettings;
        unregister = new OptionBoolean(gameSettings, "unregister", true);
        woodIsStone = new OptionBoolean(gameSettings, "woodisstone", true);
    }
}
