package io.github.nylonmc.content.proxy;

import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Rarity;

public class ItemSettingsProxy {
    Item.Settings wrapped;

    public ItemSettingsProxy() {
        wrapped = new Item.Settings();
    }

    public Item.Settings get() {
        return wrapped;
    }

    public void food(FoodComponent foodComponent) {
        wrapped = wrapped.food(foodComponent);
    }

    public void maxCount(int maxCount) {
        wrapped = wrapped.maxCount(maxCount);
    }

    public void maxDamageIfAbsent(int maxDamage) {
        wrapped = wrapped.maxDamageIfAbsent(maxDamage);
    }

    public void maxDamage(int maxDamage) {
        wrapped = wrapped.maxDamage(maxDamage);
    }

    public void recipeRemainder(Item recipeRemainder) {
        wrapped = wrapped.recipeRemainder(recipeRemainder);
    }

    public void group(ItemGroup group) {
        wrapped = wrapped.group(group);
    }

    public void rarity(Rarity rarity) {
        wrapped = wrapped.rarity(rarity);
    }

    public void fireproof() {
        wrapped = wrapped.fireproof();
    }

}