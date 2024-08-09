package net.morimori0317.yajusenpai.item;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.block.Block;
import net.morimori0317.yajusenpai.particles.YJParticleTypes;

public class TakedaInmBlockItem extends InmBlockItem {
    public TakedaInmBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public void onDestroyed(ItemEntity itemEntity) {
        super.onDestroyed(itemEntity);

        if (itemEntity.level() instanceof ServerLevel serverLevel) {
            serverLevel.sendParticles(YJParticleTypes.TAKEDA_END.get(),
                    itemEntity.position().x,
                    itemEntity.position().y + itemEntity.getEyeHeight(),
                    itemEntity.position().z,
                    0, 0, 0, 0, 0);
        }

    }
}
