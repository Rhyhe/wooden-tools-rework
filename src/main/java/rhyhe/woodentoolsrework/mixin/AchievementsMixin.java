package rhyhe.woodentoolsrework.mixin;

import net.minecraft.core.achievement.Achievement;
import net.minecraft.core.achievement.Achievements;
import net.minecraft.core.item.IItemConvertible;
import net.minecraft.core.item.Items;
import net.minecraft.core.util.collection.NamespaceID;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Debug(export = true)
@Mixin(value = Achievements.class, remap = false)
public class AchievementsMixin
{

    @Redirect(method = "<clinit>", at = @At(value = "NEW", target = "(Lnet/minecraft/core/util/collection/NamespaceID;Ljava/lang/String;Lnet/minecraft/core/item/IItemConvertible;Lnet/minecraft/core/achievement/Achievement;)Lnet/minecraft/core/achievement/Achievement;"
            , ordinal = 12))
    @NotNull
    private static Achievement mixin(NamespaceID id, String name, IItemConvertible icon, Achievement parent)
    {
        return new Achievement(
                id,
                name,
                Items.TOOL_PICKAXE_IRON,
                parent
        );
    }

}
