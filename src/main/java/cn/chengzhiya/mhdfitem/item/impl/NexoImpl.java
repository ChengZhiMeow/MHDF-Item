package cn.chengzhiya.mhdfitem.item.impl;

import cn.chengzhiya.mhdfitem.item.ItemHook;
import com.nexomc.nexo.api.NexoItems;
import com.nexomc.nexo.items.ItemBuilder;
import org.bukkit.inventory.ItemStack;

public final class NexoImpl implements ItemHook {
    @Override
    public String getIdByItem(ItemStack itemStack) {
        return NexoItems.idFromItem(itemStack);
    }

    @Override
    public ItemStack getItemById(String id) {
        ItemBuilder itemBuilder = NexoItems.itemFromId(id);
        if (itemBuilder == null) {
            return null;
        }

        return itemBuilder.build();
    }
}
