package org.golde.forge.bettercreative.blocks;

import java.util.ArrayList;
import java.util.List;

import org.golde.forge.bettercreative.BetterCreative;
import org.golde.forge.bettercreative.base.BlockData;
import org.golde.forge.bettercreative.base.OverrideBlock;
import org.golde.forge.bettercreative.base.OverrideCMD;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SpecialBlocks {

	static List<BlockData> data = new ArrayList<BlockData>();
	static List<Item> items = new ArrayList<Item>();
	
	//Cake?
	//TODO: Block Textures / models	
	public static void register() {
		data.add(new BlockData(Blocks.DOUBLE_STONE_SLAB, 8, 0));
		data.add(new BlockData(Blocks.DOUBLE_STONE_SLAB, 9, 0));
		data.add(new BlockData(Blocks.DOUBLE_STONE_SLAB2, 8));
		data.add(new BlockData(Blocks.BROWN_MUSHROOM_BLOCK, 0));
		data.add(new BlockData(Blocks.LIT_FURNACE, 0));
		data.add(new BlockData(Blocks.PORTAL, 0));
		data.add(new BlockData(Blocks.END_PORTAL, 0));
		data.add(new BlockData(Blocks.END_GATEWAY, 0));
		data.add(new BlockData(Blocks.DAYLIGHT_DETECTOR_INVERTED, 0));
		data.add(new BlockData(Blocks.WHEAT, 7));
		data.add(new BlockData(Blocks.PUMPKIN_STEM, 7));
		data.add(new BlockData(Blocks.MELON_STEM, 7));
		for(int i = 1; i <=10; i++) { //http://minecraft.gamepedia.com/Mushroom_(block)
			data.add(new BlockData(Blocks.BROWN_MUSHROOM_BLOCK, i));
			data.add(new BlockData(Blocks.RED_MUSHROOM_BLOCK, i));
		}
		
		for(BlockData d:data) {
			items.add(new OverrideBlock(BetterCreative.CT_MOD, d));
			items.add(new OverrideCMD(BetterCreative.CT_SERVER, d));
		}
		
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
