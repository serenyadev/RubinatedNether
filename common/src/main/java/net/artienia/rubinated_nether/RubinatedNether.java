package net.artienia.rubinated_nether;

import dev.architectury.platform.Platform;
import net.artienia.rubinated_nether.block.ModBlocks;
import net.artienia.rubinated_nether.block.entity.FreezerBlockEntity;
import net.artienia.rubinated_nether.block.entity.ModBlockEntityTypes;
import net.artienia.rubinated_nether.item.ModItems;
import net.artienia.rubinated_nether.item.ModTabs;
import net.artienia.rubinated_nether.recipe.ModRecipeSerializers;
import net.artienia.rubinated_nether.recipe.ModRecipeTypes;
import net.artienia.rubinated_nether.screen.ModMenuTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class RubinatedNether {

    public static final String MOD_ID = "rubinated_nether";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static void init() {
        LOGGER.info("Rubinating your nether");

        ModItems.register();
        ModBlocks.register();
        ModTabs.init();
        ModMenuTypes.register();
        ModBlockEntityTypes.register();
        ModRecipeTypes.register();
        ModRecipeSerializers.register();
        // Write common init code here.
    }

    public static void setup() {
        FreezerBlockEntity.addItemFreezingTime(Items.SNOWBALL, 50);
        FreezerBlockEntity.addItemFreezingTime(Blocks.SNOW_BLOCK, 200);
        FreezerBlockEntity.addItemFreezingTime(Blocks.FROSTED_ICE, 400);
        FreezerBlockEntity.addItemFreezingTime(Blocks.ICE, 800);
        FreezerBlockEntity.addItemFreezingTime(Blocks.BLUE_ICE, 1600);
        FreezerBlockEntity.addItemFreezingTime(Blocks.PACKED_ICE, 3200);

        if(Platform.isModLoaded("aether")){
            // TODO
            //FreezerBlockEntity.addItemFreezingTime(AetherBlocks.ICESTONE.get(), 600);
        }
    }

    public static ResourceLocation id(String id) {
        return new ResourceLocation(MOD_ID, id);
    }
}
