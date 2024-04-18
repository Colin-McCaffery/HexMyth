//package net.hexmyth.registry;
//
//import dev.architectury.registry.registries.DeferredRegister;
//import dev.architectury.registry.registries.RegistrySupplier;
//import net.hexmyth.HexMyth;
//import net.hexmyth.world.feature.tree.CrystallineTree;
//import net.minecraft.world.level.levelgen.feature.Feature;
//import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
//import net.minecraft.core.Registry;
//
//public class HexMythFeatureRegistry {
//  public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(HexMyth.MOD_ID, Registry.FEATURE_REGISTRY);
//
//  public static final RegistrySupplier<Feature<?>> CRYSTALLINE_TREE = FEATURES.register("crystalline_tree", () -> new CrystallineTree(NoneFeatureConfiguration.CODEC));
//
//  public static void init() {
//    FEATURES.register();
//  }
//}