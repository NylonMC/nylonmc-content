package io.github.nylonmc.content.proxy;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegistryProxy {
    public void register(Registry registry, Identifier id, Object entry) {
        Registry.register(registry, id, entry);
    }

    public Registry getItemRegistry() {
        return Registry.ITEM;
    }
}