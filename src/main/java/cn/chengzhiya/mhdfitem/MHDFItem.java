package cn.chengzhiya.mhdfitem;

import cn.chengzhiya.mhdfitem.item.ItemHook;
import cn.chengzhiya.mhdfitem.item.impl.*;
import cn.chengzhiya.mhdfitem.manager.PluginManager;
import lombok.AccessLevel;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

@Getter
public final class MHDFItem {
    private final PluginManager pluginManager = new PluginManager();
    @Getter(AccessLevel.PRIVATE)
    private final ConcurrentHashMap<String, ItemHook> itemHookHashMap = new ConcurrentHashMap<>();

    public MHDFItem() {
        this.register("Vanilla", new VanillaImpl());

        if (this.getPluginManager().hasPlugin("CraftEngine")) {
            this.register("CraftEngine", new CraftEngineImpl());
        }
        if (this.getPluginManager().hasPlugin("MythicMobs")) {
            this.register("MythicMobs", new MythicMobsImpl());
        }
        if (this.getPluginManager().hasPlugin("ItemsAdder")) {
            this.register("ItemsAdder", new ItemsAdderImpl());
        }
        if (this.getPluginManager().hasPlugin("Oraxen")) {
            this.register("Oraxen", new OraxenImpl());
        }
        if (this.getPluginManager().hasPlugin("Nexo")) {
            this.register("Nexo", new NexoImpl());
        }
    }

    /**
     * 获取物品库实例列表
     */
    public List<ItemHook> getItemHookList() {
        return new ArrayList<>(this.getItemHookHashMap().values());
    }

    /**
     * 注册物品库
     *
     * @param id   物品库ID
     * @param hook 物品库实例
     */
    public void register(String id, ItemHook hook) {
        id = id.toLowerCase(Locale.ROOT);

        if (this.getItemHookHashMap().containsKey(id)) {
            throw new IllegalArgumentException(id + " 已经被 " + this.getItemHookHashMap().get(id).getClass() + " 注册了");
        }

        this.getItemHookHashMap().put(id, hook);
    }

    /**
     * 取消注册物品库
     *
     * @param id 物品库ID
     */
    public void unregister(String id) {
        id = id.toLowerCase(Locale.ROOT);

        if (!this.getItemHookHashMap().containsKey(id)) {
            throw new IllegalArgumentException(id + " 没有被注册");
        }

        this.getItemHookHashMap().remove(id);
    }

    /**
     * 获取物品库
     *
     * @param id 物品库ID
     * @return 物品库实例
     */
    public ItemHook getItemHook(String id) {
        id = id.toLowerCase(Locale.ROOT);
        return this.getItemHookHashMap().get(id);
    }

    /**
     * 获取指定物品库ID下指定物品ID的物品实例
     *
     * @param by 物品库ID
     * @param id 物品ID
     * @return 物品实例
     */
    public @NotNull ItemStack getItemStack(String by, String id) {
        ItemHook hook = this.getItemHook(by);
        if (hook == null) {
            return new ItemStack(Material.AIR);
        }

        ItemStack itemStack = hook.getItemById(id);
        if (itemStack == null) {
            itemStack = new ItemStack(Material.AIR);
        }

        return itemStack;
    }

    /**
     * 获取指定物品实例的物品ID
     *
     * @param itemStack 物品实例
     * @return 物品ID
     */
    public String getIdByItemStack(ItemStack itemStack) {
        String id = null;

        for (ItemHook itemHook : this.getItemHookList()) {
            if (itemHook.getIdByItem(itemStack) == null) {
                continue;
            }

            id = itemHook.getIdByItem(itemStack);
        }

        return id;
    }
}
