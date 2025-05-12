package rhyhe.woodentoolsrework.mixin;

import net.minecraft.core.item.material.ToolMaterial;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

// This is probably a hack way to change the properties of wood to stone - Rhyhe
@Debug(export = true)
@Mixin(value = ToolMaterial.class ,remap = false)
public class ToolMaterialMixin
{
@Final
@Shadow
public static ToolMaterial stone;

@Final
@Shadow
public static ToolMaterial wood = stone;

}
