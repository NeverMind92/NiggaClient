package fun.nigga.module.list.movement;

import com.google.common.eventbus.Subscribe;
import fun.nigga.event.list.EventUpdate;
import fun.nigga.module.Module;
import fun.nigga.module.ModuleCategory;
import fun.nigga.module.ModuleInformation;
import fun.nigga.module.settings.BooleanSetting;
import fun.nigga.module.settings.ModeSetting;
import fun.nigga.module.settings.NumberSetting;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;

@ModuleInformation(moduleName = "Flight", moduleCategory = ModuleCategory.MOVEMENT)
public class Flight extends Module {

    public ModeSetting mode = new ModeSetting("Server", this, "DexLand", "DexLand", "Vanilla");

    public Flight() {
        addSetting(mode);
    }

    @Subscribe
    public void onUpdate(EventUpdate event) {
        if (mc.player == null || mc.getNetworkHandler() == null) return;

        if (mode.getValue().equalsIgnoreCase("DexLand")) {
            if (mc.player.age % 2 == 0 && mc.player.forwardSpeed > 0 && !mc.player.isOnGround()) {
                mc.player.setVelocity(mc.player.getVelocity().x * 1.12, 0.02f, mc.player.getVelocity().z * 1.12);
                mc.getNetworkHandler().sendPacket(new ClientCommandC2SPacket(mc.player, ClientCommandC2SPacket.Mode.START_FALL_FLYING));
            }
        }
    }
}
