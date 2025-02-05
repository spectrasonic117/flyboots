package com.spectrasonic.flyboots;

import com.spectrasonic.flyboots.Commands.FlyBootsCommand;
import com.spectrasonic.flyboots.Listeners.PlayerListener;
import com.spectrasonic.flyboots.Utils.MessageUtils;
import co.aikar.commands.PaperCommandManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        registerCommands();
        registerEvents();
        MessageUtils.sendStartupMessage(this);
        MessageUtils.sendVeiMessage(this);

    }

    @Override
    public void onDisable() {
        MessageUtils.sendShutdownMessage(this);
    }

    public void registerCommands() {
        PaperCommandManager commandManager = new PaperCommandManager(this);
        commandManager.registerCommand(new FlyBootsCommand());
    }

    public void registerEvents() {
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);

    }
}
