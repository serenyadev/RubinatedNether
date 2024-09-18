package net.artienia.rubinated_nether.screen.forge;

import net.minecraft.world.inventory.RecipeBookType;

public class ModRecipeBookTypesImpl {

    private static final RecipeBookType FREEZER = RecipeBookType.create("rubinated_nether:freezer");

    public static RecipeBookType getFreezer() {
        return FREEZER;
    }
}
