package io.github.nylonmc.content.interfaces;

import io.github.nylonmc.content.ReturnValueContainer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public interface IItem {
    public void onUse(World world, PlayerEntity user, Hand hand, ReturnValueContainer return_value);
    public void getSettings(ReturnValueContainer return_value);
}