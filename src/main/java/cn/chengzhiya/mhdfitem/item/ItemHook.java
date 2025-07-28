package cn.chengzhiya.mhdfitem.item;

import org.bukkit.inventory.ItemStack;

public interface ItemHook {
    /**
     * 获取指定物品实例的物品ID
     *
     * @param itemStack 物品实例
     * @return 物品ID
     */
    String getIdByItem(ItemStack itemStack);

    /**
     * 获取指定ID的物品实例
     *
     * @param id 物品ID
     * @return 物品实例
     */
    ItemStack getItemById(String id);
}
