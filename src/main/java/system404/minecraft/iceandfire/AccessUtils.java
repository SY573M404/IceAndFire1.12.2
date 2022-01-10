package system404.minecraft.iceandfire;

import com.gamerforea.eventhelper.util.EventUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import system404.minecraft.iceandfire.integration.griefdefender.GriefDefenderIntegration;

public class AccessUtils {
    public static boolean hasPlayerAccess(EntityPlayer player, World world, int x, int y, int z) {
        GriefDefenderIntegration integration = GriefDefenderIntegration.Loader.getOrLoad();

        return (player == null && (integration == null || EventConfig.griefRegions)) ||
                (player != null && !EventUtils.cantBreak(player, new BlockPos(x, y, z))) ||
                (integration != null && !integration.hasClaimAt(world, x, y, z));
    }

    public static boolean hasPlayerAccess(EntityPlayer player, World world, BlockPos block) {
        return hasPlayerAccess(player, world, block.getX(), block.getY(), block.getZ());
    }

    public static boolean hasEntityAccess(World world, int x, int y, int z) {
        GriefDefenderIntegration integration = GriefDefenderIntegration.Loader.getOrLoad();

        return EventConfig.griefRegions || integration == null || !integration.hasClaimAt(world, x, y, z);
    }

    public static boolean hasEntityAccess(World world, BlockPos block) {
        return hasEntityAccess(world, block.getX(), block.getY(), block.getZ());
    }
}
