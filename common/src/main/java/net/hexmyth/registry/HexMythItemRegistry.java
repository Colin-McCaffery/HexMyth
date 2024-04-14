package net.hexmyth.registry;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.hexmyth.HexMyth;
import net.hexmyth.block.HexMythBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.world.item.ItemStack;

import static net.hexmyth.HexMyth.id;

public class HexMythItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(HexMyth.MOD_ID, Registry.ITEM_REGISTRY);

    public static void init() {
        ITEMS.register();
    }

    public static final CreativeModeTab HEXMYTH_GROUP = CreativeTabRegistry.create(id("hexmyth_group"), () -> new ItemStack(HexMythItemRegistry.CRYSTALLINE_GRASS_BLOCK.get()));

    public static final RegistrySupplier<Item> CRYSTALLINE_GRASS_BLOCK = ITEMS.register("crystalline_grass", () -> new BlockItem(HexMythBlocks.BLOCKS.get("crystalline_grass"), new Item.Properties().tab(HEXMYTH_GROUP)));
}