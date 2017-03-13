/*
 *  Copyright (C) 2016 Peffern

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.peffern.deployer;


import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;


@Mod(modid = DeployerFix.MODID, name = DeployerFix.MODNAME, version = DeployerFix.VERSION, dependencies = "required-after:" + "terrafirmacraft" + ";" + "required-after:" + "bluepower" + ";" + "required-after:" + "ImmersiveEngineering")
public class DeployerFix
{	
    public static final String MODID = "DeployerFix";
    public static final String MODNAME = "DeployerFix";
    public static final String VERSION = "1.0";
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	//since i'm overriding the deployer i need my own tile entity
    	GameRegistry.registerTileEntity(TileCustomDeployer.class, "deployers.deployer");
    }
}
