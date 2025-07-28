package cn.chengzhiya.mhdfitem.item.impl;

import cn.chengzhiya.mhdfitem.item.ItemHook;
import lombok.Getter;
import net.momirealms.craftengine.bukkit.api.CraftEngineItems;
import net.momirealms.craftengine.core.item.CustomItem;
import net.momirealms.craftengine.core.plugin.CraftEngine;
import net.momirealms.craftengine.core.util.Key;
import org.bukkit.inventory.ItemStack;

@Getter
public final class CraftEngineImpl implements ItemHook {
    private final CraftEngine api;

    public CraftEngineImpl() {
        this.api = CraftEngine.instance();
    }

    @Override
    public String getIdByItem(ItemStack itemStack) {
        Key key = this.getApi().itemManager().customItemId(itemStack);
        if (key == null) {
            return null;
        }

        return key.asString();
    }

    @Override
    public ItemStack getItemById(String id) {
        CustomItem<ItemStack> customItem = CraftEngineItems.byId(Key.of(id));
        if (customItem == null) {
            return null;
        }

        return customItem.buildItemStack();
    }
}
