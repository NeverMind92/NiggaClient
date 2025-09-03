package fun.nigga.mixin;

import fun.nigga.niggaWare;
import fun.nigga.event.list.EventWorldRender;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.RenderTickCounter;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class GameRendererMixin {
    @Inject(method = "render", at = @At(value = "HEAD"))
    private void render(RenderTickCounter tickCounter, boolean tick, CallbackInfo ci) {
        niggaWare.getInstance().getEventBus().post(new EventWorldRender(tickCounter, tick));
    }
}
