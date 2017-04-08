package org.golde.forge.bettercreative.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.golde.forge.bettercreative.Constants;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class OverrideItem extends Item{

	private ArrayList<ItemStack> items = new ArrayList<ItemStack>();
	
	public OverrideItem(CreativeTabs tab, ItemStack[] is) {
		for(ItemStack i:is) {
			items.add(i);
		}
		setCreativeTab(tab);
		setRegistryName("BC_" + Item.getIdFromItem(is[0].getItem()));
		setUnlocalizedName("BC_" + Item.getIdFromItem(is[0].getItem()));
	}
	
	public OverrideItem(CreativeTabs tab, ItemStack is) {
		this(tab, new ItemStack[] {is});
	}
	
	public OverrideItem(CreativeTabs tab, Item i, int data) {
		this(tab, new ItemStack(i, 1, (byte)data));
	}
	
	public OverrideItem(CreativeTabs tab, Item i) {
		this(tab, i, 0);
	}
	
	public OverrideItem(CreativeTabs tab, Block b, int data) {
		this(tab, new ItemStack(Item.getItemFromBlock(b), 1, (byte)data));
	}
	
	public OverrideItem(CreativeTabs tab, Block b) {
		this(tab, Item.getItemFromBlock(b), 0);
	}
	
	@Override
	public boolean getHasSubtypes()
    {
        return this.hasSubtypes;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems)
    {
		for (ItemStack is:items) {
			subItems.add(is);
		}
    }
	
}
