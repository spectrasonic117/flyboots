package com.spectrasonic.flyboots.Utils;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemBuilder {

    public ItemStack buildFlyBoots() {
        ItemStack boots = new ItemStack(Material.IRON_BOOTS);
        ItemMeta meta = boots.getItemMeta();
        meta.setCustomModelData(117);
        meta.displayName(MiniMessage.miniMessage().deserialize("<gradient:#FF5733:#33FFC1>Fly Boots</gradient>"));
        meta.lore(java.util.Collections.singletonList(
                MiniMessage.miniMessage().deserialize("<gray>Double jump to fly!")
        ));
        boots.setItemMeta(meta);
        return boots;
    }

    public boolean isFlyBoots(ItemStack item) {
        if (item == null || item.getType() != Material.IRON_BOOTS) return false;
        return item.getItemMeta().hasCustomModelData() && item.getItemMeta().getCustomModelData() == 117;
    }
}