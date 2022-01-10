package system404.minecraft.iceandfire.integration.griefdefender;

import com.griefdefender.api.GriefDefender;
import com.griefdefender.api.claim.Claim;
import com.griefdefender.api.claim.ClaimTypes;
import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bukkit.Bukkit;

public class GriefDefenderIntegrationImpl implements GriefDefenderIntegration {
    private static final Logger logger = LogManager.getLogger(GriefDefenderIntegrationImpl.class);

    public boolean hasClaimAt(World world, int x, int y, int z) {
        final Claim claim = GriefDefender.getCore().getClaimAt(
                Bukkit.getWorld(world.getWorldInfo().getWorldName()).getUID(),
                x,
                y,
                z
        );

        return claim != null && claim.getType() != ClaimTypes.WILDERNESS;
    }
}
