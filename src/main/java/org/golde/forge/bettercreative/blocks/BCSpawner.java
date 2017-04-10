package org.golde.forge.bettercreative.blocks;

import java.util.List;

import org.golde.forge.bettercreative.BetterCreative;
import org.golde.forge.bettercreative.base.OverrideCMD;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityList;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BCSpawner{
	
	public BCSpawner() {
		for (String name : EntityList.NAME_TO_CLASS.keySet()) {
			GameRegistry.registerItem(new OverrideCMD(OverrideCMD.SPAWNER, Blocks.MOB_SPAWNER, 0, TextFormatting.RESET + name + " Spawner", getBlockEntityTag(name)));
		}
	}

	private NBTTagCompound getBlockEntityTag(String mob) {
		NBTTagCompound comp = new NBTTagCompound();
		comp.setTag("SpawnData", spawnData(mob));
		//comp.setTag("SpawnPotentials", spawnPotentials(mob));
		return comp;
	}

	private NBTTagCompound spawnData(String mob) {
		NBTTagCompound main = new NBTTagCompound();
		main.setString("id", mob);
		return main;
	}
	
}
