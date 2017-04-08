package org.golde.forge.bettercreative.blocks;

import java.util.List;

import org.golde.forge.bettercreative.BetterCreative;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityList;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BCSpawner extends Item{

	@Override
	public boolean getHasSubtypes()
	{
		return this.hasSubtypes;
	}

	@Override
	public CreativeTabs getCreativeTab() {
		return BetterCreative.CT_MOD;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems)
	{
		for (String name : EntityList.NAME_TO_CLASS.keySet()) {
			subItems.add(getSpawnerFromEntityName(name));
		}
	}

	private ItemStack getSpawnerFromEntityName(String mob)
	{
		ItemStack spawner = new ItemStack(Blocks.MOB_SPAWNER);
		NBTTagCompound main = new NBTTagCompound();
		main.setTag("BlockEntityTag", getBlockEntityTag(mob));
		spawner.setTagCompound(main);
		spawner.setStackDisplayName(TextFormatting.RESET + mob + " Spawner");
		return spawner;
	}

	private NBTTagCompound getBlockEntityTag(String mob) {
		NBTTagCompound comp = new NBTTagCompound();
		comp.setTag("SpawnData", spawnData(mob));
		comp.setTag("SpawnPotentials", spawnPotentials(mob));
		return comp;
	}



	private NBTTagCompound spawnData(String mob) {
		NBTTagCompound main = new NBTTagCompound();
		main.setString("id", mob);
		return main;
	}

	private NBTTagCompound spawnPotentials(String mob) {
		NBTTagCompound main = new NBTTagCompound();
		NBTTagCompound id = new NBTTagCompound();
		id.setString("id", mob);
		main.setInteger("Weight", 1);
		main.setTag("Entity", id);
		return main;
	}

}
