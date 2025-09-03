package fun.nigga.module;

import fun.nigga.module.list.combat.*;
import fun.nigga.module.list.movement.*;
import fun.nigga.module.list.player.*;
import fun.nigga.module.list.render.*;
import fun.nigga.module.list.render.hud.*;

import java.util.ArrayList;
import java.util.List;

public class ModuleStorage {
    private final List<Module> modules = new ArrayList<>();

    public void injectRegisterModules() {
        modules.addAll(List.of(
                new FullBright(),
                new ClickGui(),
                new Sprint(),
                new FakePlayer(),
                new Hud(),
                new TriggerBot(),
                new HighJump(),
                new NoRender(),
                new Flight(),
                new FightAura()
        ));
    }

    public List<Module> getModules() {
        return modules;
    }

    public List<Module> getCategory(ModuleCategory category) {
        return modules.stream()
                .filter(module -> module.getCategory().equals(category))
                .toList();
    }

    public <T extends Module> T get(final Class<T> clazz) {
        return modules.stream()
                .filter(module -> clazz.isAssignableFrom(module.getClass()))
                .map(clazz::cast)
                .findFirst()
                .orElse(null);
    }
}
