package cn.chengzhiya.mhdfitem.item.impl;

import cn.chengzhiya.mhdfitem.item.ItemHook;
import io.th0rgal.oraxen.api.OraxenItems;
import io.th0rgal.oraxen.items.ItemBuilder;
import org.bukkit.inventory.ItemStack;

public final class OraxenImpl implements ItemHook {
    @Override
    public String getIdByItem(ItemStack itemStack) {
        return OraxenItems.getIdByItem(itemStack);
    }

    @Override
    public ItemStack getItemById(String id) {
        ItemBuilder itemBuilder = OraxenItems.getItemById(id);
        if (itemBuilder == null) {
            return null;
        }

        return itemBuilder.build();
    }
}
