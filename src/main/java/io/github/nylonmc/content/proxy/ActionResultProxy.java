package io.github.nylonmc.content.proxy;

import net.minecraft.util.ActionResult;

public class ActionResultProxy {
    private ActionResultProxy(){}

    public static final ActionResult SUCCESS = ActionResult.SUCCESS;
    public static final ActionResult CONSUME = ActionResult.CONSUME;
    public static final ActionResult PASS = ActionResult.PASS;
    public static final ActionResult FAIL = ActionResult.FAIL;
}