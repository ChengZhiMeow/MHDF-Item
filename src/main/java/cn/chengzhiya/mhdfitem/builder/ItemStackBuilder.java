package cn.chengzhiya.mhdfitem.builder;

import cn.chengzhiya.mhdfitem.MHDFItem;
import lombok.Getter;
import lombok.Setter;
import net.kyori.adventure.text.Component;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

@Getter
@Setter
public final class ItemStackBuilder {
    private final MHDFItem instance;
    private String by = "Vanilla";
    private String type;
    private Component name;
    private List<Component> lore;
    private Integer customModelData;
    private boolean unbreakable = false;
    private int amount = 1;

    private ItemStackBuilder(MHDFItem instance) {
        this.instance = instance;
    }

    public static ItemStackBuilder builder(MHDFItem instance) {
        return new ItemStackBuilder(instance);
    }

    public ItemStackBuilder by(String by) {
        this.setBy(by);
        return this;
    }

    public ItemStackBuilder type(String type) {
        this.setType(type);
        return this;
    }

    public ItemStackBuilder name(Component name) {
        this.setName(name);
        return this;
    }

    public ItemStackBuilder lore(List<Component> lore) {
        this.setLore(lore);
        return this;
    }

    public ItemStackBuilder customModelData(Integer customModelData) {
        this.setCustomModelData(customModelData);
        return this;
    }

    public ItemStackBuilder amount(int amount) {
        this.setAmount(amount);
        return this;
    }

    public ItemStackBuilder unbreakable(boolean unbreakable) {
        this.setUnbreakable(unbreakable);
        return this;
    }

    public ItemStack build() {
        ItemStack stack = this.getInstance().getItemStack(this.getBy(), this.getType());
        ItemMeta meta = stack.getItemMeta();

        if (meta != null) {
            if (this.getName() != null) meta.displayName(this.getName());
            if (this.getLore() != null) meta.lore(this.getLore());
            if (this.getCustomModelData() != null) meta.setCustomModelData(this.getCustomModelData());
            meta.setUnbreakable(this.isUnbreakable());
            stack.setItemMeta(meta);
        }

        stack.setAmount(this.getAmount());

        return stack;
    }
}
