package fun.nigga;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import fun.nigga.event.list.EventKeyInput;
import fun.nigga.module.Module;
import fun.nigga.module.ModuleStorage;
import net.fabricmc.api.ModInitializer;

import net.minecraft.client.MinecraftClient;

public class niggaWare implements ModInitializer {

	private static niggaWare instance;

	private final EventBus eventBus;

	private final ModuleStorage moduleStorage;

	public niggaWare() {
		instance = this;

		eventBus = new EventBus();
		eventBus.register(this);

		moduleStorage = new ModuleStorage();
	}

	public static niggaWare getInstance() {
		return instance == null ? new niggaWare() : instance;
	}

	public EventBus getEventBus() {
		return eventBus;
	}

	public ModuleStorage getModuleStorage() {
		return moduleStorage;
	}

	@Override
	public void onInitialize() {
		getModuleStorage().injectRegisterModules();
	}

	@Subscribe
	private void onModuleKeyPressed(EventKeyInput event) {
		for (Module module : getModuleStorage().getModules()) {
			if (event.getAction() == 1 && MinecraftClient.getInstance().currentScreen == null) {
				if (module.getKeybind() == event.getKey()) {
					module.toggle();
				}
			}
		}
	}
}