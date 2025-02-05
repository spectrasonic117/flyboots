package com.spectrasonic.flyboots.Commands;

import com.spectrasonic.flyboots.Utils.ItemBuilder;
import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandCompletion;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Subcommand;
import org.bukkit.entity.Player;

@CommandAlias("flyboots")
@CommandPermission("flyboots.flyboots")
public class FlyBootsCommand extends BaseCommand {

    @Subcommand("give")
    @CommandCompletion("@players")
    @CommandPermission("flyboots.give")
    public void onGive(Player sender, Player target) {
        target.getInventory().addItem(new ItemBuilder().buildFlyBoots());
        sender.sendMessage("§aFlyBoots given to " + target.getName());
    }
}