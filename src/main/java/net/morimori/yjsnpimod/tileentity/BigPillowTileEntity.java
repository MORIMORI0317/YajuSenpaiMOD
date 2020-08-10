package net.morimori.yjsnpimod.tileentity;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.morimori.yjsnpimod.effect.YJEffects;
import net.morimori.yjsnpimod.item.YJItems;
import red.felnull.otyacraftengine.tileentity.IkisugiTileEntity;

import java.util.List;

public class BigPillowTileEntity extends IkisugiTileEntity implements ITickableTileEntity {
    public BigPillowTileEntity() {
        super(YJTileEntityTypes.BIG_PILLOW);
    }

    @Override
    public void tick() {
        List<LivingEntity> entitys = world.getEntitiesWithinAABB(LivingEntity.class, new AxisAlignedBB(pos.getX(), pos.getY(), pos.getZ(), pos.getX() + 1, pos.getY() + 1, pos.getZ() + 1), n -> n.isAlive());

        if (!entitys.stream().anyMatch(n -> n.getTags().contains("sleep"))) {
            List<LivingEntity> entitysf = world.getEntitiesWithinAABB(LivingEntity.class, new AxisAlignedBB(pos.getX() - 5, pos.getY(), pos.getZ() - 5, pos.getX() + 5, pos.getY() + 5, pos.getZ() + 5), n -> n.isAlive());
            for (LivingEntity en : entitysf) {
                if (en.getActivePotionEffects().stream().anyMatch(n -> n.getPotion() == YJEffects.COMA)) {
                    en.addTag("sleep");
                    en.setPosition(this.pos.getX() + 0.5f, this.pos.getY(), this.pos.getZ() + 0.5f);
                    break;
                }
            }
        } else {
            entitys.stream().filter(n -> n.getTags().contains("sleep")).forEach(n -> {
                n.setPosition(this.pos.getX() + 0.5f, this.pos.getY(), this.pos.getZ() + 0.5f);
            });
        }

        List<LivingEntity> entitysf = world.getEntitiesWithinAABB(LivingEntity.class, new AxisAlignedBB(pos.getX() - 5, pos.getY(), pos.getZ() - 5, pos.getX() + 5, pos.getY() + 5, pos.getZ() + 5), n -> n.isAlive());
        entitysf.stream().filter(n -> n.getHeldItemMainhand().getItem() == YJItems.SOFT_SMARTPHONE).forEach(n -> n.addPotionEffect(new EffectInstance(YJEffects.BEASTFICTION, 10, 0)));

    }
}
