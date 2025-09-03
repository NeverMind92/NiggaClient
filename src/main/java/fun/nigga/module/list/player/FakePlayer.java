package fun.nigga.module.list.player;

import com.mojang.authlib.GameProfile;
import fun.nigga.module.Module;
import fun.nigga.module.ModuleCategory;
import fun.nigga.module.ModuleInformation;
import net.minecraft.client.network.OtherClientPlayerEntity;
import net.minecraft.entity.Entity;

import java.util.UUID;

@ModuleInformation(moduleName = "FakePlayer", moduleCategory = ModuleCategory.PLAYER)
public class FakePlayer extends Module {
    private OtherClientPlayerEntity fakePlayer;

    @Override
    public void onEnable() {
        if (mc.player == null || mc.world == null) return;

        GameProfile profile = new GameProfile(UUID.randomUUID(), mc.player.getName().getString());
        fakePlayer = new OtherClientPlayerEntity(mc.world, profile);
        fakePlayer.copyFrom(mc.player);

        fakePlayer.setPos(mc.player.getX(), mc.player.getY(), mc.player.getZ());
        mc.world.addEntity(fakePlayer);
    }

    @Override
    public void onDisable() {
        if (mc.world != null && fakePlayer != null) {
            mc.world.removeEntity(fakePlayer.getId(), Entity.RemovalReason.DISCARDED);
            fakePlayer = null;
        }
    }
}
