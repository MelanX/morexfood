package de.melanx.morexfood.datagen;

import de.melanx.morexfood.MoreXFood;
import de.melanx.morexfood.datagen.handler.*;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = MoreXFood.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataCreator {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        ExistingFileHelper helper = event.getExistingFileHelper();

        if (event.includeServer()) {
            gen.addProvider(new LootTables(gen));
            gen.addProvider(new Recipes(gen));
            gen.addProvider(new ModTags(gen));
        }
        if (event.includeClient()) {
            gen.addProvider(new ItemModels(gen, helper));
            gen.addProvider(new BlockStates(gen, helper));
        }
    }

}
