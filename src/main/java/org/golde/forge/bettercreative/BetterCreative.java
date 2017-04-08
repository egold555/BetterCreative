package org.golde.forge.bettercreative;

import java.text.Collator;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.golde.forge.bettercreative.base.OverrideBlock;
import org.golde.forge.bettercreative.base.OverrideCMD;
import org.golde.forge.bettercreative.base.OverrideItem;
import org.golde.forge.bettercreative.blocks.BCSpawner;
import org.golde.forge.bettercreative.blocks.BCSpawnerList;
import org.golde.forge.bettercreative.blocks.BCStructureBlock;
import org.golde.forge.bettercreative.blocks.SpecialBlocks;
import org.golde.forge.bettercreative.proxy.CommonProxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Constants.MODID, version = Constants.MOD_VERSION, name = Constants.MOD_NAME, acceptedMinecraftVersions = Constants.FORGE_VERSION)
public class BetterCreative {

	public static final CreativeTabs CT_MOD = new CreativeTabs("BCT_Mod"){
		@Override
		public Item getTabIconItem() {
			return Item.getItemFromBlock(Blocks.BARRIER);
		}
		
		//Sorts all items alphabetically by there display name
		public void displayAllRelevantItems(List<ItemStack> list) {
			super.displayAllRelevantItems(list);
			Collections.sort(list, new Comparator<ItemStack>() {
			      @Override
			      public int compare(final ItemStack object1, final ItemStack object2) {
			          return object1.getDisplayName().compareTo(object2.getDisplayName());
			      }
			  });
		};
		
	};
	
	public static final CreativeTabs CT_BOTH = new CreativeTabs("BCT_Both"){
		@Override
		public Item getTabIconItem() {
			return Item.getItemById(217);
		}
		
		public void displayAllRelevantItems(List<ItemStack> list) {
			super.displayAllRelevantItems(list);
			Collections.sort(list, new Comparator<ItemStack>() {
			      @Override
			      public int compare(final ItemStack object1, final ItemStack object2) {
			          return object1.getDisplayName().compareTo(object2.getDisplayName());
			      }
			  });
		};
		
	};
	
	public static final CreativeTabs CT_SERVER = new CreativeTabs("BCT_Server"){
		
		@Override
		public Item getTabIconItem() {
			return Item.getItemFromBlock(Blocks.COMMAND_BLOCK);
		}

	};
	
	@SidedProxy(clientSide = "org.golde.forge.bettercreative.proxy.ClientProxy", serverSide = "org.golde.forge.bettercreative.proxy.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		
		GameRegistry.registerItem(new OverrideItem(CT_BOTH, Blocks.DRAGON_EGG));
		GameRegistry.registerItem(new OverrideItem(CT_BOTH, Blocks.COMMAND_BLOCK));
		GameRegistry.registerItem(new OverrideItem(CT_BOTH, Blocks.CHAIN_COMMAND_BLOCK));
		GameRegistry.registerItem(new OverrideItem(CT_BOTH, Blocks.REPEATING_COMMAND_BLOCK));
		GameRegistry.registerItem(new OverrideItem(CT_BOTH, Blocks.BARRIER));
		GameRegistry.registerItem(new OverrideItem(CT_BOTH, Blocks.FARMLAND));
		GameRegistry.registerItem(new OverrideItem(CT_BOTH, Blocks.RED_MUSHROOM_BLOCK));
		GameRegistry.registerItem(new OverrideItem(CT_BOTH, Blocks.BROWN_MUSHROOM_BLOCK));
		GameRegistry.registerItem(new OverrideItem(CT_BOTH, Item.getItemById(217)));
		GameRegistry.registerItem(new OverrideItem(CT_BOTH, Items.COMMAND_BLOCK_MINECART));
		GameRegistry.registerItem(new OverrideItem(CT_BOTH, Blocks.GRASS_PATH));
		GameRegistry.registerItem(new BCStructureBlock(), "BC_STRUCTURE_BLOCK");
		//GameRegistry.registerItem(new OverrideCMD(CT_CMD, "setblock ~ ~ ~ double_stone_slab 8", "double_stone_slab"));
		SpecialBlocks.register();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e) {
		proxy.init();
		Item.getItemFromBlock(Blocks.COMMAND_BLOCK).setMaxDamage(16);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		GameRegistry.registerItem(new BCSpawner(), "BC_MOB_SPAWNER");
		new BCSpawnerList();
	}
	
}
