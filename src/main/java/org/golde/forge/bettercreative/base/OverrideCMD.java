package org.golde.forge.bettercreative.base;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class OverrideCMD extends Item{
	
	ItemStack toAdd;
	
	public static final int TEXTURE_MOB_SPAWNER = 1;
	
	public OverrideCMD(CreativeTabs tab, String cmd, String name, int damage) {
		toAdd = cmdBlock(cmd, name, damage);
		setCreativeTab(tab);
		setRegistryName("BC_CMD_" + name);
		setUnlocalizedName("BC_CMD_" + name);
		canRepair = false;
	}
	
	public OverrideCMD(CreativeTabs tab, BlockData d) {
		this(tab, d.cmd, d.block.getRegistryName().toString() +"_"+ d.data, d.icondamage);
	}

	ItemStack cmdBlock(String cmd, String name, int damage) {
		ItemStack i = new ItemStack(Blocks.COMMAND_BLOCK);
		NBTTagCompound main = new NBTTagCompound();
		main.setTag("BlockEntityTag", getCommand(cmd));
		//main.setBoolean("Unbreakable", true);
		main.setInteger("HideFlags", 4);
		i.getItem().setMaxDamage(16);
		
		i.setTagCompound(main);
		i.setItemDamage(damage);
		i.setStackDisplayName(TextFormatting.RESET + name);
		return i;
	}
	
	NBTTagCompound getCommand(String cmd) {
		NBTTagCompound comp = new NBTTagCompound();
		comp.setInteger("auto", 1);
		comp.setString("Command", cmd);
		return comp;
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
		subItems.add(toAdd);
    }
	
}
