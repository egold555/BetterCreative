package org.golde.forge.bettercreative.blocks;

import java.util.List;

import org.golde.forge.bettercreative.BetterCreative;
import org.golde.forge.bettercreative.base.OverrideCMD;
import org.golde.forge.bettercreative.base.Texture;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityList;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BCSpawner{
	
	public BCSpawner() {
		for (EntityEntry e : ForgeRegistries.ENTITIES.getValues()) {
			GameRegistry.register(new OverrideCMD(Texture.SPAWNER, Blocks.MOB_SPAWNER, 0, TextFormatting.RESET + e.getName() + " Spawner", getBlockEntityTag(e.getRegistryName().toString())));
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
