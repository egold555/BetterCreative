package org.golde.forge.bettercreative.blocks;

import java.util.ArrayList;
import java.util.List;

import org.golde.forge.bettercreative.base.OverrideCMD;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SpecialBlocks {

	static List<Item> items = new ArrayList<Item>();

	public static void register() {
		
		items.add(new OverrideCMD(OverrideCMD.STONE_SLAB, Blocks.DOUBLE_STONE_SLAB, 8, "Stone Slab"));
		items.add(new OverrideCMD(OverrideCMD.SANDSTONE_SLAB, Blocks.DOUBLE_STONE_SLAB, 9, "Sandstone Slab"));
		items.add(new OverrideCMD(OverrideCMD.RED_SANDSTONE_SLAB, Blocks.DOUBLE_STONE_SLAB2, 8, "Red Sandstone Slab"));
		items.add(new OverrideCMD(OverrideCMD.LIT_FURNACE, Blocks.LIT_FURNACE, 0 , "Lit Furnace"));
		items.add(new OverrideCMD(OverrideCMD.PORTAL, Blocks.PORTAL, 0 , "Nether Portal"));
		items.add(new OverrideCMD(OverrideCMD.END_PORTAL, Blocks.END_PORTAL, 0 , "End Portal"));
		items.add(new OverrideCMD(OverrideCMD.END_GATEWAY, Blocks.END_GATEWAY, 0 , "End Gateway"));
		items.add(new OverrideCMD(OverrideCMD.DAYLIGHT_DETECTOR_INVERTED, Blocks.DAYLIGHT_DETECTOR_INVERTED, 0 , "Daylight Detector Inverted"));
		items.add(new OverrideCMD(OverrideCMD.UNKNOWN, Blocks.BROWN_MUSHROOM_BLOCK, 0, "Mushroom Pores"));
		items.add(new OverrideCMD(OverrideCMD.UNKNOWN, Blocks.BROWN_MUSHROOM_BLOCK, 15, "Mushroom Stem"));
		for(Item i :items) {
			GameRegistry.registerItem(i);
		}
	}
	
	public static void registerRenders() {
		for(Item i:items) {
			registerRender(i);
		}
	}
	
	private static void registerRender(Item item){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}

}
