package com.spectrasonic.flyboots.Listeners;

import com.spectrasonic.flyboots.Utils.ItemBuilder;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerListener implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        GameMode gameMode = player.getGameMode();
        
        if (gameMode != GameMode.SURVIVAL && gameMode != GameMode.ADVENTURE) {
            return;
        }

        ItemStack boots = player.getInventory().getBoots();
        
        if (boots != null && new ItemBuilder().isFlyBoots(boots)) {
            player.setAllowFlight(true);
        } else {
            player.setAllowFlight(false);
            player.setFlying(false);
        }
    }

    @EventHandler
    public void onDoubleJump(PlayerToggleFlightEvent event) {
        Player player = event.getPlayer();
        GameMode gameMode = player.getGameMode();
        
        if (gameMode != GameMode.SURVIVAL && gameMode != GameMode.ADVENTURE) {
            return;
        }

        ItemStack boots = player.getInventory().getBoots();

        if (boots != null && new ItemBuilder().isFlyBoots(boots)) {
            event.setCancelled(true);
            player.setFlying(!player.isFlying());
        }
    }
}