package io.github.fabspu.biggertreesplugin;

import com.sun.source.tree.Tree;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.TreeType;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.type.Leaves;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.StructureGrowEvent;


public class TreeListener implements Listener {

    @EventHandler
    public void onPlacingSapling(StructureGrowEvent event){
        TreeType tree = event.getSpecies();
        Location location = event.getLocation();
        Material sapType = location.getBlock().getType();
        double x = location.getX();
        double y = location.getY();
        double z = location.getZ();
        //Bukkit.getPlayer("FashleHD").sendMessage("X: " + location.getX() + "; Y: " + location.getY() + "; Z:" + location.getZ());
        // Save all location for possible saplings
        Location[] locations1 = {new Location(location.getWorld(),x,y,z+1),new Location(location.getWorld(),x+1,y,z+1),new Location(location.getWorld(),x+1,y,z)};
        Location[] locations2 = {new Location(location.getWorld(),x,y,z+1),new Location(location.getWorld(),x-1,y,z+1),new Location(location.getWorld(),x-1,y,z)};
        Location[] locations3 = {new Location(location.getWorld(),x,y,z-1),new Location(location.getWorld(),x+1,y,z-1),new Location(location.getWorld(),x+1,y,z)};
        Location[] locations4 = {new Location(location.getWorld(),x,y,z-1),new Location(location.getWorld(),x-1,y,z-1),new Location(location.getWorld(),x-1,y,z)};
        Location[][] allLocations = {locations1,locations2,locations3,locations4};
        //Goes through all locations and checks for saps
        for(Location[] locs : allLocations){
            Location[] rightloc;
            Boolean flag = true;
            for(Location loc : locs){
               if(loc.getBlock().getType() != sapType){
                   flag = false;
                   //Bukkit.getPlayer("FashleHD").sendMessage("Did not work");
                   break;
               }
                rightloc = locs;
            }
            if(flag == true){
                Bukkit.getPlayer("FashleHD").sendMessage("Did Work");
                //event.setCancelled(true);
                event.getWorld().generateTree(location,TreeType.DARK_OAK);
                replaceWoodWithSaplingWood(location);
                break;
            }
        }

        //if(sap.getType() == Material.ACACIA_SAPLING)
         //   Bukkit.getPlayer("FashleHD").sendMessage("It worked!");

    }

    private void replaceWoodWithSaplingWood(Location location) {
        // Get the center block of the tree
        Block centerBlock = location.getBlock();

        // Iterate through the blocks in the tree structure
        for (int yOffset = 0; yOffset < 6; yOffset++) {
            for (int xOffset = -2; xOffset <= 2; xOffset++) {
                for (int zOffset = -2; zOffset <= 2; zOffset++) {
                    Block currentBlock = centerBlock.getRelative(xOffset, yOffset, zOffset);

                    // Check if the block is part of the tree and is wood
                    if (currentBlock.getType() == Material.DARK_OAK_LOG) {
                        // Replace the wood with the wood of the planted saplings
                        replaceBlockWithSaplingWood(currentBlock);
                    }
                }
            }
        }
    }

    private void replaceBlockWithSaplingWood(Block block) {
        // Replace the block with the wood of the planted saplings
        BlockState state = block.getState();
        state.setType(Material.ACACIA_LOG);
        state.update(true); // true to trigger a block update
    }

}


