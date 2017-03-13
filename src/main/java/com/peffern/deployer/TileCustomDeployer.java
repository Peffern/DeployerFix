package com.peffern.deployer;

import com.bioxx.tfc.Items.ItemCustomSeeds;
import com.bioxx.tfc.api.TFCBlocks;
import com.bluepowermod.tile.tier1.TileDeployer;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.util.ForgeDirection;

public class TileCustomDeployer extends TileDeployer
{
	@Override
	protected boolean rightClick(FakePlayer player, int useItems)
	{
		boolean ret = super.rightClick(player, useItems);
		if(ret)
			return ret;
		else
		{
			/* ==================================
			 * Actual Deployer Behavior goes here
			 * ================================== */
			ForgeDirection dir = getFacingDirection();
			
			int useX = xCoord + dir.offsetX;
			int useY = yCoord + dir.offsetY;
			int useZ = zCoord + dir.offsetZ;
			
			int belowX = useX;
			int belowY = useY - 1;
			int belowZ = useZ;
			
			for (int i = 0; i < useItems; i++) {
                player.inventory.currentItem = i;
                ItemStack stack = player.getCurrentEquippedItem();
                if(stack != null)
                {
	                if(worldObj.isAirBlock(useX, useY, useZ) && (worldObj.getBlock(belowX, belowY, belowZ) == TFCBlocks.tilledSoil || worldObj.getBlock(belowX, belowY, belowZ) == TFCBlocks.tilledSoil2))
	                {
	                	Item item = stack.getItem();
	                	if(item instanceof ItemCustomSeeds || item instanceof IPlantable)
	                    {
	                    	if(item.onItemUse(stack,player,worldObj,belowX,belowY,belowZ,ForgeDirection.UP.ordinal(),dir.offsetX,dir.offsetY,dir.offsetZ))
	                    		return true;
	                    }
	                }
                }
                
            }
			
			return false;
			
			/* ==================================
			 * End Actual Deployer Behavior
			 * ================================== */
		}
	}
}
