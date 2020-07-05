package azzy.fabric.forgottenfruits.block;

import azzy.fabric.forgottenfruits.registry.BlockRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.RavagerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class CindermoteBlock extends PlantBase {

    public CindermoteBlock(int stages, Material material, BlockSoundGroup sound, ItemConvertible seeds, int minLight, int maxLight, ParticleEffect effects, double flight, int count, float donotusethis, int dispersion) {
        super(stages, material, sound, seeds, minLight, maxLight, effects, flight, count, donotusethis, dispersion);
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!world.isClient)
            if ((entity instanceof RavagerEntity && world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) || entity.isSprinting()) {
                world.createExplosion(null, DamageSource.IN_FIRE, null, pos.getX(), pos.getY(), pos.getZ(), 6f, false, Explosion.DestructionType.NONE);
            } else if (!entity.isInSneakingPose() && entity.getType() != EntityType.ITEM) {
                entity.setOnFireFor(20);
                entity.damage(DamageSource.LAVA, 2f);
            }

    }

    protected boolean canPlantOnTop(BlockState floor, BlockView view, BlockPos pos) {
        return floor.getBlock() == BlockRegistry.NETHER_FARMLAND;
    }
}
