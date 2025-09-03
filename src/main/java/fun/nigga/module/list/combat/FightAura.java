package fun.nigga.module.list.combat;

import com.google.common.eventbus.Subscribe;
import fun.nigga.event.list.EventUpdate;
import fun.nigga.module.Module;
import fun.nigga.module.ModuleCategory;
import fun.nigga.module.ModuleInformation;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;

@ModuleInformation(moduleName = "FightAura", moduleCategory = ModuleCategory.COMBAT)
public class FightAura extends Module {
    @Subscribe
    public void onUpdate(EventUpdate event) {
        if (mc.player == null || mc.world == null || mc.interactionManager == null) return;

        for (PlayerEntity player : mc.world.getPlayers()) {

            if (player == mc.player) continue;

            if (mc.player.distanceTo(player) <= 3.0F) {
                if (mc.player.getAttackCooldownProgress(0.0F) >= 0.93F) {
                    mc.interactionManager.attackEntity(mc.player, player);
                    mc.player.swingHand(Hand.MAIN_HAND);
                }
            }
        }
    }
}
