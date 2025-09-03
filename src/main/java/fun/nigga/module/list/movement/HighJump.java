package fun.nigga.module.list.movement;

import com.google.common.eventbus.Subscribe;
import fun.nigga.event.list.EventUpdate;
import fun.nigga.module.Module;
import fun.nigga.module.ModuleCategory;
import fun.nigga.module.ModuleInformation;

@ModuleInformation(moduleName = "HighJump", moduleCategory = ModuleCategory.MOVEMENT)
public class HighJump extends Module {
    @Subscribe
    public void onUpdate(EventUpdate event) {
        if (mc.player == null) return;

        if (mc.player.age % 4 == 0) {
            mc.player.jump();
            mc.player.setVelocity(0, 3, 0);
            toggle();
        }
    }
}
