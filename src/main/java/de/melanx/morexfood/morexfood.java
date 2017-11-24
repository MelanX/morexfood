package de.melanx.morexfood;

import de.melanx.morexfood.block.ModBlocks;
import de.melanx.morexfood.client.morexfoodTab;
import de.melanx.morexfood.item.ItemPeaSeed;
import de.melanx.morexfood.item.ModItems;
import de.melanx.morexfood.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = morexfood.MODID, version = morexfood.VERSION)

public class morexfood {
	
	public static final String MODID = "morexfood";
	public static final String VERSION = "0.1";
	public static final morexfoodTab creativeTab = new morexfoodTab();
	
	@SidedProxy(clientSide = "de.melanx.morexfood.proxy.ClientProxy", serverSide = "de.melanx.morexfood.proxy.CommonProxy")
	public static CommonProxy proxy;
	
	@Mod.EventBusSubscriber
	public static class RegistrationHandler {
		
		@SubscribeEvent
		public static void registerBlocks(RegistryEvent.Register<Block> event) {
			ModBlocks.register(event.getRegistry());
		}
		
		@SubscribeEvent
		public static void registerItems(RegistryEvent.Register<Item> event) {
			ModItems.register(event.getRegistry());
			ModBlocks.registerItemBlocks(event.getRegistry());
		}
		
		@SubscribeEvent
		public static void registerModels(ModelRegistryEvent event) {
			ModItems.registerModels();
			ModBlocks.registerModels();
		}
	}
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ModMetadata data = event.getModMetadata();
		data.autogenerated = false;
		data.modId = MODID;
		data.version = VERSION;
		data.authorList.add("MelanX");
		data.credits = "Credits to my girlfriend for patient with me while working at this mod.";
		data.description = "This is my first mod. It's for learning how to build a mod but it's a christmas present for my girlfriend, too. It adds her favourite food and a few ingredients for this.";
		data.name = "More XFood";
		System.out.println(MODID + " is loading");
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		
		MinecraftForge.addGrassSeed(new ItemStack(ItemPeaSeed), 10); //it's now shown as wrong.. :/
		
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		System.out.println(MODID + " is finished.");		
	}
	
}