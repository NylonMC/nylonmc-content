package io.github.nylonmc.content.wrapper;

import io.github.nylonmc.content.ReturnValueContainer;
import io.github.nylonmc.content.interfaces.IItem;
import io.github.nylonmc.content.proxy.ItemSettingsProxy;
import io.github.nylonmc.core.Core;
import io.github.nylonmc.core.PythonThread;
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
    public UseData useData;

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
        synchronized (this) {
            ReturnValueContainer a = new ReturnValueContainer();
            useData = new UseData(world, user, hand, a);
            PythonThread.runPython("import nylonmc.content.minecraft as mc\n" +
                                   "_this = mc._id_to_item_wrapper[" + this.getNumericalId() + "]\n" +
                                   "mc._id_to_iitem[" + this.getNumericalId() + "].onUse(_this.useData.world, _this.useData.user, _this.useData.hand, _this.useData.returnValueContainer)\n");
            return a.getReturnValue() == null ? super.use(world, user, hand) : new TypedActionResult<>((ActionResult)a.getReturnValue(), user.getStackInHand(hand));
        }
    }

    public static final class UseData {
        public final World world;
        public final PlayerEntity user;
        public final Hand hand;
        public final ReturnValueContainer returnValueContainer;
        public UseData(World world, PlayerEntity user, Hand hand, ReturnValueContainer returnValueContainer) {
            this.world = world;
            this.user = user;
            this.hand = hand;
            this.returnValueContainer = returnValueContainer;
        }
    }

}