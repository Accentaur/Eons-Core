// package
package com.github.armouredheart.eons_core.common.item;

// Minecraft imports
import net.minecraft.item.Item;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.Rarity;
import net.minecraft.util.SoundEvent;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.EonsCore;
import com.github.armouredheart.eons_core.init.EonsItemGroups;

// misc imports

public class EonsMusicDiscItem extends MusicDiscItem {

    /** */
    public EonsMusicDiscItem(SoundEvent sound_event) {
        super(0, sound_event, new Item.Properties().group(EonsItemGroups.EONS_ITEM_GROUP));
    }
}