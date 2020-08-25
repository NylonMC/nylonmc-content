package io.github.nylonmc.content.wrapper;

import io.github.nylonmc.content.proxy.ItemSettingsProxy;
import net.minecraft.item.Item;

public class ItemWrapper extends Item {

    public ItemWrapper(Settings settings) {
        super(settings);
    }
    
    public ItemWrapper(ItemSettingsProxy settings) {
        super(settings.get());
    }

}