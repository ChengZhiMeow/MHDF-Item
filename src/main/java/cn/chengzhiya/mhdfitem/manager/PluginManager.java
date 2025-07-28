package cn.chengzhiya.mhdfitem.manager;

import org.bukkit.Bukkit;

public final class PluginManager {
    /**
     * 检测是否安装指定插件
     *
     * @param plugin 插件名称
     * @return 结果
     */
    public boolean hasPlugin(String plugin) {
        return Bukkit.getPluginManager().getPlugin(plugin) != null;
    }
}
