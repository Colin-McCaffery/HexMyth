package net.hexmyth.registry;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.hexmyth.HexMyth;
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
    public static final RegistrySupplier<Item> CRYSTALLINE_GRASS_BLOCK = ITEMS.register("crystalline_grass", () -> new BlockItem(HexMythBlockRegistry.CRYSTALLINE_GRASS_BLOCK.get(), new Item.Properties().tab(HEXMYTH_GROUP)));
    public static final RegistrySupplier<Item> CRYSTALLINE_WOOD_LOG = ITEMS.register("crystalline_wood_log", () -> new BlockItem(HexMythBlockRegistry.CRYSTALLINE_WOOD_LOG.get(), new Item.Properties().tab(HEXMYTH_GROUP)));
    public static final RegistrySupplier<Item> CRYSTALLINE_WOOD = ITEMS.register("crystalline_wood", () -> new BlockItem(HexMythBlockRegistry.CRYSTALLINE_WOOD.get(), new Item.Properties().tab(HEXMYTH_GROUP)));
    public static final RegistrySupplier<Item> CRYSTALLINE_WOOD_PLANKS = ITEMS.register("crystalline_wood_planks", () -> new BlockItem(HexMythBlockRegistry.CRYSTALLINE_WOOD_PLANKS.get(), new Item.Properties().tab(HEXMYTH_GROUP)));
    public static final RegistrySupplier<Item> STRIPPED_CRYSTALLINE_WOOD_LOG = ITEMS.register("stripped_crystalline_wood_log", () -> new BlockItem(HexMythBlockRegistry.STRIPPED_CRYSTALLINE_WOOD_LOG.get(), new Item.Properties().tab(HEXMYTH_GROUP)));
    public static final RegistrySupplier<Item> STRIPPED_CRYSTALLINE_WOOD = ITEMS.register("stripped_crystalline_wood", () -> new BlockItem(HexMythBlockRegistry.STRIPPED_CRYSTALLINE_WOOD.get(), new Item.Properties().tab(HEXMYTH_GROUP)));
    public static final RegistrySupplier<Item> CRYSTALLINE_LEAVES = ITEMS.register("crystalline_leaves", () -> new BlockItem(HexMythBlockRegistry.CRYSTALLINE_LEAVES.get(), new Item.Properties().tab(HEXMYTH_GROUP)));
    public static final RegistrySupplier<Item> CRYSTALLINE_SAPLING = ITEMS.register("crystalline_sapling", () -> new BlockItem(HexMythBlockRegistry.CRYSTALLINE_SAPLING.get(), new Item.Properties().tab(HEXMYTH_GROUP)));
}