package de.melanx.morexfood.items;

import de.melanx.morexfood.morexfood;
import net.minecraft.item.ItemFood;
import net.minecraftforge.oredict.OreDictionary;

public class ItemAgaricus extends ItemFood {
	
	public ItemAgaricus() {
		super(1, 0.6f, false);
		setUnlocalizedName("agaricus");
		setRegistryName("agaricus");
		setCreativeTab(morexfood.creativeTab);
	}
	
	public void registerItemModel() {
		morexfood.proxy.registerItemRenderer(this, 0, "agaricus");
	}
	
	public void initOreDict() {
		OreDictionary.registerOre("cropAgaricus", this);
		OreDictionary.registerOre("listAllmushroom", this);
	}

}