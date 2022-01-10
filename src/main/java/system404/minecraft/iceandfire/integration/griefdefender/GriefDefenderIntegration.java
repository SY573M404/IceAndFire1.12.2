package system404.minecraft.iceandfire.integration.griefdefender;

import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;
import java.util.concurrent.atomic.AtomicReference;

public interface GriefDefenderIntegration {
    boolean hasClaimAt(World world, int x, int y, int z);

    class Loader {
        private static final Logger logger = LogManager.getLogger(Loader.class);

        private static boolean isLoaded = false;
        private static final AtomicReference<GriefDefenderIntegration> instance = new AtomicReference<>(null);

        public static @Nullable
        GriefDefenderIntegration getOrLoad() {
            synchronized(instance) {
                if (!isLoaded) {
                    instance.set(load());
                    isLoaded = true;
                }

                return instance.get();
            }
        }

        private static @Nullable
        GriefDefenderIntegration load() {
            try {
                Class.forName("com.griefdefender.api.GriefDefender");

                final Class<?> clazz =
                        Class.forName("system404.minecraft.iceandfire.integration.griefdefender.GriefDefenderIntegrationImpl");
                return (GriefDefenderIntegration) clazz.newInstance();
            } catch(Exception e) {
                logger.warn("Failed to create GriefDefender integration. I think you don't have it installed :)", e);
                return null;
            }
        }
    }
}
