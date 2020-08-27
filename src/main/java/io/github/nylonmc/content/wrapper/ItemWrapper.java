package io.github.nylonmc.content.wrapper;

import io.github.nylonmc.content.ReturnValueContainer;
import io.github.nylonmc.content.interfaces.IItem;
import io.github.nylonmc.content.proxy.ItemSettingsProxy;
import io.github.nylonmc.content.wrapper.datatransfer.ItemWrapperData;
import io.github.nylonmc.core.Core;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ItemWrapper extends Item {
    protected IItem iitem;
    private long idCounter = 0;
    private final long numericalId;

    private static Item.Settings getSettingsFromIItem(IItem item) {
        ReturnValueContainer a = new ReturnValueContainer();
        item.getSettings(a);
        return ((ItemSettingsProxy)a.getReturnValue()).get();
    }
    
    public ItemWrapper(IItem item) {
        super(getSettingsFromIItem(item));
        this.iitem = item;
        numericalId = idCounter;
        idCounter++;
    }

    public void updateIItem(IItem item) {
        this.iitem = item;
    }

    public long getNumericalId() {
        return numericalId;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ReturnValueContainer a = new ReturnValueContainer();
        ItemWrapperData.itemWrapper = this;
        ItemWrapperData.thingToDo = () -> {
            System.out.println(iitem);
            iitem.onUse(world, user, hand, a);
        };
        Core.runPythonModule("nylonmc.content.hack.item");
        return a.getReturnValue() == null ? super.use(world, user, hand) : new TypedActionResult<>((ActionResult)a.getReturnValue(), user.getStackInHand(hand));
    }

}