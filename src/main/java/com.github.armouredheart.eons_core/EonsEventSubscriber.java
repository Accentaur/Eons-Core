// package
package com.github.armouredheart.eons_core;

// Minecraft imports
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

// Forge imports
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.registries.IForgeRegistry;

// Eons imports
import com.github.armouredheart.eons_core.config.EonsConfig;
import com.github.armouredheart.eons_core.init.EonsItemGroups;
import com.github.armouredheart.eons_core.init.EonsBlocks;
import com.github.armouredheart.eons_core.EonsCore;
import com.github.armouredheart.eons_core.init.EonsBiomes;
import com.github.armouredheart.eons_core.common.world.gen.surfacebuilders.EonsSurfaceBuilders;

// misc imports
import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/** */
@EventBusSubscriber(modid = EonsCore.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public final class EonsEventSubscriber {

    //
    private static final Logger LOGGER = LogManager.getLogger(EonsCore.MOD_ID + " EonsEventSubcriber");

	/** */
    @SubscribeEvent
	public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> registry = event.getRegistry();
		// Automatically register BlockItems for all our Blocks
		EonsBlocks.BLOCKS.getEntries().stream()
				.map(RegistryObject::get)
				// You can do extra filtering here if you don't want some blocks to have an BlockItem automatically registered for them
				// .filter(block -> needsItemBlock(block))
				// Register the BlockItem for the block
				.forEach(block -> {
					// Make the properties, and make it so that the item will be on our ItemGroup (CreativeTab)
					final Item.Properties properties = new Item.Properties().group(EonsItemGroups.EONS_ITEM_GROUP);
					// Create the new BlockItem with the block and it's properties
					final BlockItem blockItem = new BlockItem(block, properties);
					// Set the new BlockItem's registry name to the block's registry name
					blockItem.setRegistryName(block.getRegistryName());
					// Register the BlockItem
					registry.register(blockItem);
				});
		LOGGER.debug("Registered BlockItems");
    }

    /** */
    @SubscribeEvent
	public static void onModConfigEvent(final ModConfig.ModConfigEvent event) {
		
    }

	/** */
	@SubscribeEvent
	public static void onRegisterBiomes(final RegistryEvent.Register<Biome> event) {
		EonsBiomes.registerBiomesToBiomeDictionary();
	}

	@SubscribeEvent
	public static void onRegisterSurfaceBuilders(RegistryEvent.Register<SurfaceBuilder<?>> event) {
		EonsSurfaceBuilders.registerEonsSurfaceBuilders(event);
	}

	@SubscribeEvent
	public static void onLoad(final ModConfig.Loading event) {
		// call method defined in config
		EonsConfig.onLoad(event);
	}
	
	@SubscribeEvent
	public static void onFileChange(final ModConfig.ConfigReloading event) {
		// call method defined in config
		EonsConfig.onFileChange(event);
	}

	/** */
	//@SubscribeEvent
	//public static void onFMLPreinit
	//OBJLoader.addDomain(EonsCore.MOD_ID)
}