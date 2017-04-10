package org.golde.forge.bettercreative;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.golde.forge.bettercreative.base.OverrideItem;
import org.golde.forge.bettercreative.blocks.BCSpawner;
import org.golde.forge.bettercreative.blocks.BCStructureBlock;
import org.golde.forge.bettercreative.blocks.SpecialBlocks;
import org.golde.forge.bettercreative.proxy.CommonProxy;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Constants.MODID, version = Constants.MOD_VERSION, name = Constants.MOD_NAME, acceptedMinecraftVersions = Constants.FORGE_VERSION)
public class BetterCreative {

	public static final CreativeTabs CT_TAB = new CreativeTabs("BCT_Tab"){
		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(Item.getItemFromBlock(Blocks.BARRIER));
		}
		
		//Sorts all items alphabetically by there display name
		public void displayAllRelevantItems(NonNullList<ItemStack> list) {
			super.displayAllRelevantItems(list);
			Collections.sort(list, new Comparator<ItemStack>() {
			      @Override
			      public int compare(final ItemStack object1, final ItemStack object2) {
			          return object1.getDisplayName().compareTo(object2.getDisplayName());
			      }
			  });
		};
		
	};
	
	
	@SidedProxy(clientSide = "org.golde.forge.bettercreative.proxy.ClientProxy", serverSide = "org.golde.forge.bettercreative.proxy.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		
		GameRegistry.register(new OverrideItem(CT_TAB, Blocks.DRAGON_EGG));
		GameRegistry.register(new OverrideItem(CT_TAB, Blocks.COMMAND_BLOCK));
		GameRegistry.register(new OverrideItem(CT_TAB, Blocks.CHAIN_COMMAND_BLOCK));
		GameRegistry.register(new OverrideItem(CT_TAB, Blocks.REPEATING_COMMAND_BLOCK));
		GameRegistry.register(new OverrideItem(CT_TAB, Blocks.BARRIER));
		GameRegistry.register(new OverrideItem(CT_TAB, Blocks.FARMLAND));
		GameRegistry.register(new OverrideItem(CT_TAB, Blocks.RED_MUSHROOM_BLOCK));
		GameRegistry.register(new OverrideItem(CT_TAB, Blocks.BROWN_MUSHROOM_BLOCK));
		GameRegistry.register(new OverrideItem(CT_TAB, Item.getItemById(217)));
		GameRegistry.register(new OverrideItem(CT_TAB, Items.COMMAND_BLOCK_MINECART));
		GameRegistry.register(new OverrideItem(CT_TAB, Blocks.GRASS_PATH));
		GameRegistry.register(new BCStructureBlock());
		SpecialBlocks.register();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e) {
		proxy.init();
		Item.getItemFromBlock(Blocks.COMMAND_BLOCK).setMaxDamage(32);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		new BCSpawner();
	}
	
}
