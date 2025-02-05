package com.spectrasonic.flyboots.Listeners;

import com.spectrasonic.flyboots.Utils.ItemBuilder;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerListener implements Listener {

    @EventHandler
    public void onDoubleJump(PlayerToggleFlightEvent event) {
        Player player = event.getPlayer();
        ItemStack boots = player.getInventory().getBoots();

        if (boots != null && new ItemBuilder().isFlyBoots(boots)) {
            event.setCancelled(true);
            player.setAllowFlight(false);
            player.setFlying(false);
            player.setVelocity(player.getLocation().getDirection().multiply(1.5).setY(1));
        } else {
            player.setAllowFlight(false);
        }
    }
}