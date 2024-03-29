package de.melanx.morexfood.datagen;

import de.melanx.morexfood.MoreXFood;
import de.melanx.morexfood.datagen.handler.*;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = MoreXFood.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataCreator {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper helper = event.getExistingFileHelper();

        if (event.includeServer()) {
            generator.addProvider(new ModLootTables(generator));
            generator.addProvider(new Recipes(generator));
            ModTags.ModBlocks blockTagsProvider = new ModTags.ModBlocks(generator, helper);
            generator.addProvider(blockTagsProvider);
            generator.addProvider(new ModTags.ModItems(generator, blockTagsProvider, helper));
            generator.addProvider(new LootModifiers(generator));
        }
        if (event.includeClient()) {
            generator.addProvider(new ItemModels(generator, helper));
            generator.addProvider(new BlockStates(generator, helper));
        }
    }
}
