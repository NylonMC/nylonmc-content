package io.github.nylonmc.content.proxy;

import io.github.nylonmc.content.interfaces.IItem;
import io.github.nylonmc.content.wrapper.ItemWrapper;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegistryProxy {
    
    public void register(Registry registry, Identifier id, ItemWrapper entry) {
        realRegister(registry, id, entry);
    }

    public void register(Registry registry, Identifier id, Object entry) {
        realRegister(registry, id, entry);
    }

    public void realRegister(Registry registry, Identifier id, Object entry) {
        Object entry1 = entry;
        if (entry instanceof IItem) {
            entry1 = new ItemWrapper((IItem)entry);
        }
        Registry.register(registry, id, entry1);
    }

    public Registry getItemRegistry() {
        return Registry.ITEM;
    }

}