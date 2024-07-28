package net.morimori0317.yajusenpai.neoforge.handler;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.morimori0317.yajusenpai.alchemy.YJPotions;
import net.morimori0317.yajusenpai.handler.CommonHandler;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.event.entity.living.LivingDropsEvent;
import net.neoforged.neoforge.event.tick.EntityTickEvent;

public class CommonHandlerForge {
    @SubscribeEvent
    public static void onLivingTick(EntityTickEvent.Pre e) {
        if (e.getEntity() instanceof LivingEntity livingEntity) {
            CommonHandler.onLivingTick(livingEntity);
        }
    }

    @SubscribeEvent
    public static void onLivingDrop(LivingDropsEvent e) {
        CommonHandler.onLivingDrop(e.getEntity(), e.getSource(), stack -> {
            LivingEntity livingEntity = e.getEntity();
            ItemEntity entity = new ItemEntity(livingEntity.level(), livingEntity.position().x, livingEntity.position().y, livingEntity.position().z, stack);
            entity.setDefaultPickUpDelay();
            e.getDrops().add(entity);
        });
    }


    @SubscribeEvent
    public static void onRegisterBrewingRecipes(RegisterBrewingRecipesEvent e) {
        PotionBrewing.Builder builder = e.getBuilder();
        YJPotions.setupBrewing(builder::addMix);
    }
}
