//package net.hexmyth.item;
//
//import net.minecraft.world.item.Item;
//import net.minecraft.world.item.CreativeModeTab;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class HexMythItems {
//
//  public static final Item CRYSTALLINE_GRASS_ITEM = new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC));
//  public static final Map<String, Item> ITEMS = new HashMap<>();
//
//  static {
//    ITEMS.put("crystalline_grass_item", CRYSTALLINE_GRASS_ITEM);
//  }
//
//  public static String getItemName(Item item) {
//    for (Map.Entry<String, Item> entry : ITEMS.entrySet()) {
//      if (entry.getValue().equals(item)) {
//        return entry.getKey();
//      }
//    }
//    return null;
//  }
//}