package org.golde.forge.bettercreative.base;

import java.util.ArrayList;
import java.util.List;

import org.golde.forge.bettercreative.BetterCreative;
import org.golde.forge.bettercreative.helpers.NBTJSON;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class OverrideCMD extends Item{

	List<ItemStack> toAdd = new ArrayList<ItemStack>();
	
	public OverrideCMD(int texture, Block b, int data, String name) {
		this(texture, b, data, name, null);
	}
	
	public OverrideCMD(int texture, Block b, int data, String name, NBTTagCompound tag) {
		this(texture, new Block[]{b}, new int[]{data}, new String[] {name}, new NBTTagCompound[] {tag});
	}
	
	public OverrideCMD(int texture, Block[] blocks, int[] datas, String[] names) {
		this(texture, blocks, datas, names, new NBTTagCompound[] {null});
	}
	
	public OverrideCMD(int texture, Block[] blocks, int[] datas, String[] names, NBTTagCompound[] tags) {
		setCreativeTab(BetterCreative.CT_TAB);
		setRegistryName("BC_CMD_" + blocks[0].getRegistryName() + "_" + names[0]);
		setUnlocalizedName("BC_CMD_" + blocks[0].getRegistryName() + "_" + names[0]);
		canRepair = false;
		for(int i = 0; i < blocks.length; i++) {
			toAdd.add(cmdBlock(makeCommand(blocks[i], datas[i], tags[i]), names[i], texture));
		}
	}
	
	String makeCommand(Block b, int data, NBTTagCompound tag) {
		
		String stringTag = "";
		
		if(tag != null) {
			try {
				stringTag = NBTJSON.toJson(tag);
				return "setblock ~ ~ ~ " + b.getRegistryName() +" "+ data + " replace " + stringTag;
			} catch (NBTException e) {
				return "setblock ~ ~ ~ " + b.getRegistryName() +" "+ data;
			}
		}
		return "setblock ~ ~ ~ " + b.getRegistryName() +" "+ data;
	}
	
	ItemStack cmdBlock(String cmd, String name, int damage) {
		ItemStack i = new ItemStack(Blocks.COMMAND_BLOCK);
		NBTTagCompound main = new NBTTagCompound();
		main.setTag("BlockEntityTag", getCommand(cmd));
		main.setBoolean("Unbreakable", true);
		main.setInteger("HideFlags", 4);
		i.getItem().setMaxDamage(32);
		
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
    public void getSubItems(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> subItems)
    {
		subItems.addAll(toAdd);
    }
	
}
