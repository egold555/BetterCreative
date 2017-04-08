package org.golde.forge.bettercreative.helpers;

import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;

public class NBTJSON {

	public static NBTTagCompound toNBT(String json) throws NBTException {
		return JsonToNBT.getTagFromJson(json);
	}
	
	public static String toJson(NBTTagCompound tag) throws NBTException{
		if(tag == null) {
			throw new NBTException("Tag can not be null!");
		}
		return tag.toString();
	}
	
}
