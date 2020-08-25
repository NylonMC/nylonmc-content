package io.github.nylonmc.content;

import java.util.ArrayList;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;

import io.github.cottonmc.clientcommands.ClientCommandPlugin;
import io.github.cottonmc.clientcommands.CottonClientCommandSource;
import io.github.nylonmc.core.Core;
import io.github.nylonmc.core.PythonAdapter;
import io.github.nylonmc.core.proxies.BaseProxy;
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;

//todo broken
public class NylonClientCommands implements PreLaunchEntrypoint {

    private static ArrayList<LiteralArgumentBuilder> toRegister = new ArrayList<>();

    public static void register(LiteralArgumentBuilder builder) {
        toRegister.add(builder);
    }

    @Override
    public void onPreLaunch() {
        PythonAdapter.putProxy(ClientCommandPlugin.class, ClientCommandsPluginProxy::new);
    }

    public static class ClientCommandsPluginProxy extends BaseProxy implements ClientCommandPlugin {
        ClientCommandsPluginProxy(String module) {
            super(module);
        }

        @Override
        public void registerCommands(CommandDispatcher<CottonClientCommandSource> dispatcher) {
            Core.runPythonModule(module);
            for (LiteralArgumentBuilder lab : toRegister) {
                dispatcher.register(lab);
            }
            toRegister.clear();
        }
    }
    
}