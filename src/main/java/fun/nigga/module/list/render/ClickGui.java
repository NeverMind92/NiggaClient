package fun.nigga.module.list.render;

import fun.nigga.module.Module;
import fun.nigga.module.ModuleCategory;
import fun.nigga.module.ModuleInformation;
import fun.nigga.ui.ClickGuiFrame;
import org.lwjgl.glfw.GLFW;

@ModuleInformation(moduleName = "ClickGui", moduleCategory = ModuleCategory.RENDER, moduleKeybind = GLFW.GLFW_KEY_RIGHT_SHIFT)
public class ClickGui extends Module {
    @Override
    public void onEnable() {
        mc.setScreen(new ClickGuiFrame());
        toggle();
    }
}
