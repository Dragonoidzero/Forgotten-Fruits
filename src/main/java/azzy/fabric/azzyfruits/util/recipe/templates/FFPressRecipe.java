package azzy.fabric.azzyfruits.util.recipe.templates;

import alexiil.mc.lib.attributes.fluid.volume.FluidVolume;
import azzy.fabric.azzyfruits.util.recipe.FFRecipe;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class FFPressRecipe extends FFRecipe {
    public ItemStack input;
    public Item byproduct;
    public FluidVolume output;

    public FFPressRecipe(String type, String id, ItemStack input, Item byproduct, FluidVolume output){
        super(type, id);
        this.input = input;
        this.byproduct = byproduct;
        this.output = output;
    }
}