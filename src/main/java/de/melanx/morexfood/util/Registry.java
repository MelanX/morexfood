package de.melanx.morexfood.util;

import de.melanx.morexfood.MoreXFood;
import de.melanx.morexfood.block.*;
import de.melanx.morexfood.items.ItemKnife;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static de.melanx.morexfood.MoreXFood.MODID;

public class Registry {

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, MODID);
    public static final DeferredRegister<Item> BLOCK_ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, MODID);
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, MODID);

    // blocks
    public static final RegistryObject<Block> salt_ore = BLOCKS.register("salt_ore", OreSalt::new);
    private static final Block.Properties blockProps = Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.CROP);
    public static final RegistryObject<Block> agaricus_block = BLOCKS.register("crop_agaricus", () -> new BlockCropAgaricus(blockProps));
    public static final RegistryObject<Block> asparagus_block = BLOCKS.register("crop_asparagus", () -> new BlockCropAsparagus(blockProps));
    public static final RegistryObject<Block> peas_block = BLOCKS.register("crop_peas", () -> new BlockCropPea(blockProps));
    public static final RegistryObject<Block> rice_block = BLOCKS.register("crop_rice", () -> new BlockCropRice(blockProps));
    private static final Item.Properties itemProps = new Item.Properties().group(MoreXFood.creativeTab);
    public static final RegistryObject<Item> salt_ore_item = BLOCK_ITEMS.register("salt_ore", () -> new BlockItem(salt_ore.get(), itemProps));
    public static final RegistryObject<Item> agaricus_item = BLOCK_ITEMS.register("crop_agaricus", () -> new BlockItem(agaricus_block.get(), itemProps));
    public static final RegistryObject<Item> asparagus_item = BLOCK_ITEMS.register("crop_asparagus", () -> new BlockItem(asparagus_block.get(), itemProps));
    public static final RegistryObject<Item> peas_item = BLOCK_ITEMS.register("crop_peas", () -> new BlockItem(peas_block.get(), itemProps));
    public static final RegistryObject<Item> rice_item = BLOCK_ITEMS.register("crop_rice", () -> new BlockItem(rice_block.get(), itemProps));

    // items
    public static final RegistryObject<Item> knife = ITEMS.register("knife", () -> new ItemKnife(itemProps.containerItem(new ItemKnife(itemProps))));
    public static final RegistryObject<Item> ice_cubes = ITEMS.register("ice_cubes", () -> new Item(itemProps));
    public static final RegistryObject<Item> dust_salt = ITEMS.register("salt", () -> new Item(itemProps));

    // seeds
    public static final RegistryObject<Item> agaricus_seed = ITEMS.register("agaricus_seed", () -> new BlockNamedItem(agaricus_block.get(), itemProps));
    public static final RegistryObject<Item> asparagus_seed = ITEMS.register("asparagus_seed", () -> new BlockNamedItem(asparagus_block.get(), itemProps));
    public static final RegistryObject<Item> peas_seed = ITEMS.register("peas_seed", () -> new BlockNamedItem(peas_block.get(), itemProps));
    public static final RegistryObject<Item> rice_seed = ITEMS.register("rice_seed", () -> new BlockNamedItem(rice_block.get(), itemProps));

    // food
    public static final RegistryObject<Item> agaricus = ITEMS.register("agaricus", () -> new Item(itemProps.food(buildFoodValues(1, 0.6F))));
    public static final RegistryObject<Item> asparagus = ITEMS.register("asparagus", () -> new Item(itemProps.food(buildFoodValues(1, 0.5F))));
    public static final RegistryObject<Item> asparagus_pieces = ITEMS.register("asparagus_pieces", () -> new Item(itemProps.food(buildFoodValues(1, 0.4F))));
    public static final RegistryObject<Item> carrot_pieces = ITEMS.register("carrot_pieces", () -> new Item(itemProps.food(buildFoodValues(1, 0.6F, new EffectInstance(Effects.POISON, 150, 1), 30))));
    public static final RegistryObject<Item> chicken_fricassee = ITEMS.register("chicken_fricassee", () -> new Item(itemProps.food(buildFoodValues(11, 0.55F))));
    public static final RegistryObject<Item> chicken_fricassee_raw = ITEMS.register("chicken_fricassee_raw", () -> new Item(itemProps.food(buildFoodValues(4, 0.05F, new EffectInstance(Effects.POISON, 150, 1), 95))));
    public static final RegistryObject<Item> chicken_fricassee_special = ITEMS.register("chicken_fricassee_special", () -> new Item(itemProps.food(buildFoodValues(12, 0.55F))));
    public static final RegistryObject<Item> chicken_fricassee_special_raw = ITEMS.register("chicken_fricassee_special_raw", () -> new Item(itemProps.food(buildFoodValues(4, 0.05F, new EffectInstance(Effects.POISON, 120, 1), 95))));
    public static final RegistryObject<Item> chicken_fricassee_rice = ITEMS.register("chicken_fricassee_rice", () -> new Item(itemProps.food(buildFoodValues(13, 0.55F))));
    public static final RegistryObject<Item> chicken_fricassee_rice_raw = ITEMS.register("chicken_fricassee_rice_raw", () -> new Item(itemProps.food(buildFoodValues(5, 0.05F, new EffectInstance(Effects.POISON, 100, 1), 90))));
    public static final RegistryObject<Item> chicken_pieces = ITEMS.register("chicken_pieces", () -> new Item(itemProps.food(buildFoodValues(1, 0.2F))));
    public static final RegistryObject<Item> dog_goulash = ITEMS.register("dog_goulash", () -> new Item(itemProps.food(buildFoodValues(8, 0.45F, new EffectInstance(Effects.STRENGTH, 150, 1), 30))));
    public static final RegistryObject<Item> dog_goulash_raw = ITEMS.register("dog_meat_raw", () -> new Item(itemProps.food(buildFoodValues(4, 0.2F, new EffectInstance(Effects.POISON, 150, 1), 30))));
    public static final RegistryObject<Item> horse_meat = ITEMS.register("horse_meat", () -> new Item(itemProps.food(buildFoodValues(4, 0.2F, new EffectInstance(Effects.POISON, 150, 1), 10))));
    public static final RegistryObject<Item> ice_cream = ITEMS.register("ice_cream", () -> new Item(itemProps.food(buildFoodValues(5, 0.1F, new EffectInstance(Effects.FIRE_RESISTANCE, 100, 1), 30))));
    public static final RegistryObject<Item> ice_cream_baked = ITEMS.register("ice_cream_baked", () -> new Item(itemProps.food(buildFoodValues(2, 0.1F, new EffectInstance(Effects.FIRE_RESISTANCE, 150, 1), 40))));
    public static final RegistryObject<Item> lasagne = ITEMS.register("lasagne", () -> new Item(itemProps.food(buildFoodValues(12, 0.5F))));
    public static final RegistryObject<Item> mixed_vegetables = ITEMS.register("mixed_vegetables", () -> new Item(itemProps.food(buildFoodValues(3, 0.8F))));
    public static final RegistryObject<Item> peas = ITEMS.register("peas", () -> new Item(itemProps.food(buildFoodValues(1, 0.5F))));
    public static final RegistryObject<Item> rice = ITEMS.register("rice", () -> new Item(itemProps.food(buildFoodValues(1, 0.5F))));

    private static Food buildFoodValues(int hunger, float saturation) {
        return new Food.Builder().hunger(hunger).saturation(saturation).build();
    }

    private static Food buildFoodValues(int hunger, float saturation, EffectInstance effect, int chance) {
        return new Food.Builder().hunger(hunger).saturation(saturation).effect(effect, chance).build();
    }
}