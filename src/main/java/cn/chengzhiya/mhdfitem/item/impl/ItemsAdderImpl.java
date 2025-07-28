package cn.chengzhiya.mhdfitem.item.impl;

import cn.chengzhiya.mhdfitem.item.ItemHook;
import dev.lone.itemsadder.api.CustomStack;
import org.bukkit.inventory.ItemStack;

public final class ItemsAdderImpl implements ItemHook {
    @Override
    public String getIdByItem(ItemStack itemStack) {
        CustomStack customStack = CustomStack.byItemStack(itemStack);
        if (customStack == null) {
            return null;
        }

        return customStack.getNamespacedID();
    }

    @Override
    public ItemStack getItemById(String id) {
        CustomStack customStack = CustomStack.getInstance(id);
        if (customStack == null) {
            return null;
        }

        return customStack.getItemStack();
    }
}
