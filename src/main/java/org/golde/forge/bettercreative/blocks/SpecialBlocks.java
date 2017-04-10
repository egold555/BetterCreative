package org.golde.forge.bettercreative.blocks;

import java.util.ArrayList;
import java.util.List;

import org.golde.forge.bettercreative.base.OverrideCMD;
import org.golde.forge.bettercreative.base.Texture;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SpecialBlocks {

	static List<Item> items = new ArrayList<Item>();

	public static void register() {
		
		items.add(new OverrideCMD(Texture.STONE_SLAB, Blocks.DOUBLE_STONE_SLAB, 8, "Stone Slab"));
		items.add(new OverrideCMD(Texture.SANDSTONE_SLAB, Blocks.DOUBLE_STONE_SLAB, 9, "Sandstone Slab"));
		items.add(new OverrideCMD(Texture.RED_SANDSTONE_SLAB, Blocks.DOUBLE_STONE_SLAB2, 8, "Red Sandstone Slab"));
		items.add(new OverrideCMD(Texture.LIT_FURNACE, Blocks.LIT_FURNACE, 0 , "Lit Furnace"));
		items.add(new OverrideCMD(Texture.PORTAL, Blocks.PORTAL, 0 , "Nether Portal"));
		items.add(new OverrideCMD(Texture.END_PORTAL, Blocks.END_PORTAL, 0 , "End Portal"));
		items.add(new OverrideCMD(Texture.END_GATEWAY, Blocks.END_GATEWAY, 0 , "End Gateway"));
		items.add(new OverrideCMD(Texture.DAYLIGHT_DETECTOR_INVERTED, Blocks.DAYLIGHT_DETECTOR_INVERTED, 0 , "Daylight Detector Inverted"));
		items.add(new OverrideCMD(Texture.MUSHROOM_PORE, Blocks.BROWN_MUSHROOM_BLOCK, 0, "Mushroom Pores"));
		items.add(new OverrideCMD(Texture.MUSHROOM_STEM, Blocks.BROWN_MUSHROOM_BLOCK, 15, "Mushroom Stem"));
		
		items.add(new OverrideCMD(Texture.LOG_OAK, Blocks.LOG, 12, "Oak Log"));
		items.add(new OverrideCMD(Texture.LOG_SPRUCE, Blocks.LOG, 13, "Spruce Log"));
		items.add(new OverrideCMD(Texture.LOG_BIRCH, Blocks.LOG, 14, "Birch Log"));
		items.add(new OverrideCMD(Texture.LOG_JUNGLE, Blocks.LOG, 15, "Jungle Log"));
		items.add(new OverrideCMD(Texture.LOG_ACACIA, Blocks.LOG2, 12, "Acacia Log"));
		items.add(new OverrideCMD(Texture.LOG_DARK_OAK, Blocks.LOG2, 13, "Dark Oak Log"));
		
		
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
