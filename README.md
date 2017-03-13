DeployerFix
================

For TechNode 3.3

This mod adds functionality to the Blue Power deployer, allowing it deploy TFC seeds (ItemCustomSeeds) as well as any other mods seeds (IPlantable) including Immersive Engineering hemp seeds.

The deployer needs to deploy the seeds into an air block directly over TFC farmland and the normal TFC farmland requirements (sunlight, temperature, etc.) must still be satisfied. 

Note: the BP deployer normally performs the following actions:

-attempt to rightclick on an entity in front of the deployer

-attempt to use the item by itself

-attempt to rightclick the block in front of the deployer

-attempt to use the item on the block

-attempt to equip the item

**in that order**. The seeds deployment takes place _after_ these, so if a deployer contains a block and seed, the block will always get placed before the seed even if the seed comes first in the inventory. To avoid this, simply don't mix seeds and non-seeds in deployers.
