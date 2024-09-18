package net.artienia.rubinated_nether.block.entity;

import net.artienia.rubinated_nether.RubinatedNether;
import net.artienia.rubinated_nether.recipe.ModRecipeTypes;
import net.artienia.rubinated_nether.screen.FreezerMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.TagKey;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.tags.ITagManager;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;



public class FreezerBlockEntity extends AbstractFreezerBlockEntity implements MenuProvider {
    private static final Map<Item, Integer> freezingMap = new LinkedHashMap<>();

    public FreezerBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.FREEZER.get(), pos, state, ModRecipeTypes.FREEZING.get());
    }

    @Override
    public Component getDefaultName() {
        return Component.translatable("menu." + RubinatedNether.MOD_ID + ".freezer");
    }

    @Override
    public AbstractContainerMenu createMenu(int id, Inventory playerInventory) {
        return new FreezerMenu(id, playerInventory, this, this.dataAccess);
    }

    @Override
    public int getBurnDuration(ItemStack fuelStack) {
        if (fuelStack.isEmpty() || !getFreezingMap().containsKey(fuelStack.getItem())) {
            return 0;
        } else {
            return getFreezingMap().get(fuelStack.getItem());
        }
    }

    public static Map<Item, Integer> getFreezingMap() {
        return freezingMap;
    }

    public static void addItemFreezingTime(ItemLike itemProvider, int burnTime) {
        Item item = itemProvider.asItem();
        getFreezingMap().put(item, burnTime);
    }

    public static void addItemsFreezingTime(ItemLike[] itemProviders, int burnTime) {
        Stream.of(itemProviders).map(ItemLike::asItem).forEach((item) -> getFreezingMap().put(item, burnTime));
    }

    public static void addItemTagFreezingTime(TagKey<Item> itemTag, int burnTime) {
        ITagManager<Item> tags = ForgeRegistries.ITEMS.tags();
        if (tags != null) {
            tags.getTag(itemTag).stream().forEach((item) -> getFreezingMap().put(item, burnTime));
        }
    }

    public static void removeItemFreezingTime(ItemLike itemProvider) {
        Item item = itemProvider.asItem();
        getFreezingMap().remove(item);
    }

    public static void removeItemsFreezingTime(ItemLike[] itemProviders) {
        Stream.of(itemProviders).map(ItemLike::asItem).forEach((item) -> getFreezingMap().remove(item));
    }

    public static void removeItemTagFreezingTime(TagKey<Item> itemTag) {
        ITagManager<Item> tags = ForgeRegistries.ITEMS.tags();
        if (tags != null) {
            tags.getTag(itemTag).stream().forEach((item) -> getFreezingMap().remove(item));
        }
    }
}
