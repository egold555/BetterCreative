package org.golde.forge.bettercreative.blocks;

import java.util.List;

import org.golde.forge.bettercreative.BetterCreative;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BCStructureBlock extends Item{
	
	public BCStructureBlock() {
		setRegistryName("BC_STRUCTURE_BLOCK");
		setUnlocalizedName("BC_STRUCTURE_BLOCK");
	}
	
	@Override
	public boolean getHasSubtypes()
    {
        return this.hasSubtypes;
    }
	
	@Override
	public CreativeTabs getCreativeTab() {
		return BetterCreative.CT_TAB;
	}

	@Override
	@SideOnly(Side.CLIENT)
    public void getSubItems(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> subItems)
    {
		subItems.add(getStructureBlock("DATA"));
		subItems.add(getStructureBlock("SAVE"));
		subItems.add(getStructureBlock("LOAD"));
		subItems.add(getStructureBlock("CORNER"));
    }

	private ItemStack getStructureBlock(String data)
	{
		ItemStack sb = new ItemStack(Blocks.STRUCTURE_BLOCK);
		NBTTagCompound main = new NBTTagCompound();
		main.setTag("BlockEntityTag", getNBT(data));
		sb.setTagCompound(main);
		sb.setStackDisplayName(TextFormatting.RESET + sb.getDisplayName() + " (" + data + ")");
		return sb;
	}

	private NBTTagCompound getNBT(String data)
	{	NBTTagCompound tag = new NBTTagCompound();
		tag.setString("mode", data);
		return tag;
	}
}
