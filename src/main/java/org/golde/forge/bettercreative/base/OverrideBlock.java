package org.golde.forge.bettercreative.base;

import java.util.List;

import org.golde.forge.bettercreative.Constants;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class OverrideBlock extends Item{

	IBlockState blockToPlace;


	public OverrideBlock(CreativeTabs tab, Block blockToPlace, int data) {
		setCreativeTab(tab);
		this.blockToPlace = blockToPlace.getStateFromMeta(data);
		this.setUnlocalizedName("BC_" + Block.getIdFromBlock(blockToPlace) + "-" + data);
		this.setRegistryName("BC_" + Block.getIdFromBlock(blockToPlace) + "-" + data);
	}
	
	public OverrideBlock(CreativeTabs tab, BlockData data) {
		setCreativeTab(tab);
		this.blockToPlace = data.blockState;
		this.setUnlocalizedName(data.registry);
		this.setRegistryName(data.registry);
	}

	public OverrideBlock(CreativeTabs tab, Block blockToPlace) {
		this(tab, blockToPlace, 0);
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add("(Singleplayer Only)");
		super.addInformation(stack, playerIn, tooltip, advanced);
	}

	@Override //TODO: Won't place on east/south sides?
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if(!worldIn.isRemote) {
			worldIn.setBlockState(new BlockPos(pos.getX() + facing.getFrontOffsetX(), pos.getY() + facing.getFrontOffsetY(), pos.getZ() + facing.getFrontOffsetZ()), blockToPlace);
		}
		return EnumActionResult.SUCCESS;
	}

}
