package fun.nigga.module.list.movement;

import com.google.common.eventbus.Subscribe;
import fun.nigga.event.list.EventUpdate;
import fun.nigga.module.Module;
import fun.nigga.module.ModuleCategory;
import fun.nigga.module.ModuleInformation;

@ModuleInformation(moduleName = "Sprint", moduleCategory = ModuleCategory.MOVEMENT)
public class Sprint extends Module {
    @Subscribe
    public void onUpdate(EventUpdate event) {
        if (mc.player == null) return;

        if (mc.player.forwardSpeed > 0 && !mc.player.isSneaking()) {
            mc.player.setSprinting(true);
        }
    }
}
