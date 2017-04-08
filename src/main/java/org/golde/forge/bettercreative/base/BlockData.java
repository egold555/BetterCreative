package org.golde.forge.bettercreative.base;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;

public class BlockData {

	public String cmd;
	public IBlockState blockState;
	public String registry;
	public Block block;
	int data;
	int icondamage;
	public BlockData(Block b, int d, int damage) {
		block = b;
		data = d;
		blockState = b.getStateFromMeta(data);
		cmd = "setblock ~ ~ ~ " + b.getRegistryName() + " " + data;
		registry = "BC_" + Block.getIdFromBlock(b) + "-" + data;
		icondamage = damage;
	}
	
	public BlockData(Block b, int d) {
		this(b, d, 0);
	}
	
}
