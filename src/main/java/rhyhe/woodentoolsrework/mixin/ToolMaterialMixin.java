package rhyhe.woodentoolsrework.mixin;

import net.minecraft.core.item.material.ToolMaterial;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import rhyhe.woodentoolsrework.Config;

@Debug(export = true)
@Mixin(value = ToolMaterial.class, remap = false)
public class ToolMaterialMixin
{
    // This is probably a hack way to change the properties of wood to stone
    // - Rhyhe
    @Final
    @Shadow
    @SuppressWarnings("unused")
    public final static ToolMaterial wood = Config.config.getBoolean("wood_is_stone") ?
            ToolMaterial.stone : ToolMaterial.wood;

}
