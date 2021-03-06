package azzy.fabric.forgottenfruits.block.entity;

import azzy.fabric.forgottenfruits.registry.BlockEntityRegistry;
import azzy.fabric.forgottenfruits.staticentities.blockentity.WoodPipeEntity;
import net.minecraft.block.Material;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class WoodPipe extends BasePipe {

    public WoodPipe(Settings settings, Material material, BlockSoundGroup sound, int glow, VoxelShape bounds, ParticleEffect... effects) {
        super(settings, material, sound, glow, bounds, effects);
    }

    @Override
    public WoodPipeEntity createBlockEntity(BlockView view) {
        return BlockEntityRegistry.WOOD_PIPE.instantiate();
    }
}
