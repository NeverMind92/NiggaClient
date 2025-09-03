package fun.nigga.util.chat;

import fun.nigga.util.MinecraftUtil;
import net.minecraft.text.Text;

public class ChatUtil {
    public static void send(String message) {
        if (MinecraftUtil.mc.player == null) return;

        MinecraftUtil.mc.player.sendMessage(Text.of("nigga§bWare §f» " + message), false);
    }
}
