package system404.minecraft.iceandfire;

import com.gamerforea.eventhelper.config.Config;
import com.gamerforea.eventhelper.config.ConfigBoolean;
import com.gamerforea.eventhelper.config.ConfigUtils;

@Config(name = "IceAndFire")
public class EventConfig {
    private static final String CATEGORY_GRIEFING = "griefing";

    @ConfigBoolean(name = "griefRegions", category = CATEGORY_GRIEFING)
    public static boolean griefRegions = false;

    public static void init()
    {
        ConfigUtils.readConfig(EventConfig.class);
    }
}
