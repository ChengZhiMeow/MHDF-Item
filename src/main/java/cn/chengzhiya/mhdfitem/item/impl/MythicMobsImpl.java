package cn.chengzhiya.mhdfitem.item.impl;

import cn.chengzhiya.mhdfitem.item.ItemHook;
import io.lumine.mythic.bukkit.MythicBukkit;
import lombok.Getter;
import org.bukkit.inventory.ItemStack;

@Getter
public final class MythicMobsImpl implements ItemHook {
    private final MythicBukkit api;

    public MythicMobsImpl() {
        this.api = MythicBukkit.inst();
    }

    @Override
    public String getIdByItem(ItemStack itemStack) {
        return this.getApi().getItemManager().getMythicTypeFromItem(itemStack);
    }

    @Override
    public ItemStack getItemById(String id) {
        return this.getApi().getItemManager().getItemStack(id);
    }
}
