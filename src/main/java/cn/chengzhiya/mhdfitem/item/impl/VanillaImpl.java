package cn.chengzhiya.mhdfitem.item.impl;

import cn.chengzhiya.mhdfitem.item.ItemHook;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class VanillaImpl implements ItemHook {
    @Override
    public String getIdByItem(ItemStack itemStack) {
        return itemStack.getType().name();
    }

    @Override
    public ItemStack getItemById(String id) {
        Material material = Material.matchMaterial(id);
        if (material == null) {
            return null;
        }

        return new ItemStack(material);
    }
}
