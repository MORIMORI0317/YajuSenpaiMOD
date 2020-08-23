package net.morimori.yjsnpimod.handler;

import com.google.common.collect.Streams;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.monster.piglin.PiglinEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.passive.PandaEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.PlaySoundAtEntityEvent;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.morimori.yjsnpimod.YJDamageSource;
import net.morimori.yjsnpimod.YJSNPIMOD;
import net.morimori.yjsnpimod.YJSoundEvents;
import net.morimori.yjsnpimod.block.YJBlocks;
import net.morimori.yjsnpimod.effect.YJEffects;
import net.morimori.yjsnpimod.entity.ToiletSitEntity;
import net.morimori.yjsnpimod.item.YJFoods;
import net.morimori.yjsnpimod.item.YJItems;
import net.morimori.yjsnpimod.tileentity.ToiletTileEntity;
import net.morimori.yjsnpimod.util.YJUtil;
import red.felnull.otyacraftengine.api.event.common.ResponseEvent;
import red.felnull.otyacraftengine.util.IKSGEntityUtil;

import java.util.Random;

public class ServerHandler {


    @SubscribeEvent
    public static void onMobSound(PlaySoundAtEntityEvent e) {


        if (e.getEntity() instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity) e.getEntity();

            if (e.getSound() == SoundEvents.ITEM_SHIELD_BLOCK) {
                if (Streams.stream(livingEntity.getHeldEquipment()).anyMatch(n -> n.getItem() == YJItems.JAKEN_YORUIKIMASYOU)) {
                    e.setSound(YJSoundEvents.YJ_DAMEGE);
                }
            }
        }
    }


    @SubscribeEvent
    public static void onDamege(LivingDamageEvent e) {
        if (YJUtil.isYJOn(e.getEntity())) {
            e.getEntity().world.playSound((PlayerEntity) null, e.getEntity().getPosX(), e.getEntity().getPosY(), e.getEntity().getPosZ(), YJSoundEvents.YJ_DAMEGE, SoundCategory.VOICE, 3, 1);
        }

        if (Streams.stream(e.getEntityLiving().getHeldEquipment()).anyMatch(n -> n.getItem() == YJItems.JAKEN_YORUIKIMASYOU)) {
            Random r = new Random();
            if (r.nextInt(114514) <= 810) {
                e.setCanceled(true);
                e.getEntityLiving().world.playSound((PlayerEntity) null, e.getEntity().func_233580_cy_(), YJSoundEvents.YJ_NU, SoundCategory.VOICE, 3.0F, 1);
                e.getEntityLiving().addPotionEffect(new EffectInstance(YJEffects.BEASTFICTION, 200, 0));
            }
        }
    }

    @SubscribeEvent
    public static void onDeath(LivingDeathEvent e) {
        if (e.getEntityLiving().getActivePotionEffects().stream().anyMatch(n -> n.getPotion() == YJEffects.COMA) && !e.getEntityLiving().getTags().contains("sleep")) {
            e.getEntityLiving().world.playSound((PlayerEntity) null, e.getEntityLiving().getPosX(), e.getEntityLiving().getPosY(), e.getEntityLiving().getPosZ(), YJSoundEvents.TON_SEKAINOTON, SoundCategory.VOICE, 3, 1);
        }
    }

    @SubscribeEvent
    public static void onMobTick(LivingEvent.LivingUpdateEvent e) {

        if (e.getEntityLiving().getActivePotionEffects().stream().anyMatch(n -> n.getPotion() == YJEffects.BEASTFICTION)) {
            e.getEntityLiving().removePotionEffect(YJEffects.COMA);
        }
        if (e.getEntityLiving().getActivePotionEffects().stream().anyMatch(n -> n.getPotion() == YJEffects.CUM)) {
            EffectInstance ci = e.getEntityLiving().getActivePotionEffect(YJEffects.CUM);
            if (ci.getDuration() <= 20) {
                e.getEntityLiving().removePotionEffect(YJEffects.CUM);
                e.getEntityLiving().attackEntityFrom(YJDamageSource.RAPE, e.getEntityLiving().getHealth());
                if (e.getEntityLiving() instanceof PlayerEntity && ((PlayerEntity) e.getEntityLiving()).isCreative()) {
                    e.getEntityLiving().setHealth(0);
                }
                if (!e.getEntityLiving().getTags().contains("sleep")) {
                    e.getEntityLiving().world.playSound((PlayerEntity) null, e.getEntityLiving().getPosX(), e.getEntityLiving().getPosY(), e.getEntityLiving().getPosZ(), YJSoundEvents.YJ_NNA, SoundCategory.VOICE, 3, 1);
                }
            }

        }
        if (e.getEntityLiving().getActivePotionEffects().stream().anyMatch(n -> n.getPotion() == YJEffects.COMA)) {
            if (!e.getEntityLiving().getTags().contains("sleep")) {
                Random r = new Random();
                int level = e.getEntityLiving().getActivePotionEffect(YJEffects.COMA).getAmplifier() + 1;
                float la = level / 256;
                if (r.nextInt((int) (100 - (99 * la))) == 0) {
                    e.getEntityLiving().world.playSound((PlayerEntity) null, e.getEntityLiving().getPosX(), e.getEntityLiving().getPosY(), e.getEntityLiving().getPosZ(), YJSoundEvents.TON_STAGGER, SoundCategory.VOICE, 3 * level, 1);
                    Vector3d mv = e.getEntityLiving().getMotion();
                    double x = (r.nextDouble() - 0.5d) * 1.5d;
                    double z = (r.nextDouble() - 0.5d) * 1.5d;
                    mv = mv.add(x, 0, z);
                    e.getEntityLiving().setMotion(mv);
                }
            }
        } else {
            e.getEntityLiving().removeTag("sleep");
        }
    }

    @SubscribeEvent
    public static void onBlockBrack(PlayerInteractEvent.LeftClickBlock e) {
        if (e.getEntityLiving().getActivePotionEffects().stream().anyMatch(n -> n.getPotion() == YJEffects.CUM)) {
            e.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onMobCrick(PlayerInteractEvent.EntityInteract e) {
        if (!e.getPlayer().world.isRemote) {
            ItemStack stack = e.getItemStack();
            if (e.getTarget() instanceof LivingEntity && !((LivingEntity) e.getTarget()).getActivePotionEffects().stream().anyMatch(n -> n.getPotion() == YJEffects.COMA) && stack.getItem() == YJItems.ICE_TEA) {

                LivingEntity entity = (LivingEntity) e.getTarget();
                YJFoods.ICE_TEA.getEffects().stream().forEach(n -> entity.addPotionEffect(n.getFirst()));
                e.getEntityLiving().world.playSound((PlayerEntity) null, e.getEntityLiving().getPosX(), e.getEntityLiving().getPosY(), e.getEntityLiving().getPosZ(), YJSoundEvents.YJ_OTTODAIJOUBUKA, SoundCategory.VOICE, 3, 1);
                if (!e.getPlayer().isCreative()) {
                    stack.shrink(1);
                }
            }
            if (e.getTarget() instanceof LivingEntity && e.getEntityLiving().getActivePotionEffects().stream().anyMatch(n -> n.getPotion() == YJEffects.BEASTFICTION) && !((LivingEntity) e.getTarget()).getActivePotionEffects().stream().anyMatch(n -> n.getPotion() == YJEffects.CUM) && e.getTarget().getTags().contains("sleep") && stack.getItem() == YJItems.SOFT_SMARTPHONE) {
                LivingEntity entity = (LivingEntity) e.getTarget();
                e.getEntityLiving().world.playSound((PlayerEntity) null, e.getEntityLiving().getPosX(), e.getEntityLiving().getPosY(), e.getEntityLiving().getPosZ(), YJSoundEvents.YJ_IKISUGI, SoundCategory.VOICE, 3, 1);
                entity.addPotionEffect(new EffectInstance(YJEffects.CUM, 220, 0));
                Random r = new Random();
                if (r.nextInt(19) == 0) {
                    e.getEntityLiving().addPotionEffect(new EffectInstance(YJEffects.CUM, 220, 0));
                }
                if (!e.getPlayer().isCreative()) {
                    stack.shrink(1);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onMobAttack(LivingAttackEvent e) {

        if (e.getEntity().world.isRemote || !e.getSource().getDamageType().equals("mob"))
            return;

        if (e.getSource().getTrueSource() instanceof LivingEntity && !(e.getSource().getTrueSource() instanceof PlayerEntity)) {
            LivingEntity entity = (LivingEntity) e.getSource().getTrueSource();
            ItemStack stack = entity.getHeldItemMainhand();
            if (stack.getItem() == YJItems.ICE_TEA) {
                if (!e.getEntityLiving().getActivePotionEffects().stream().anyMatch(n -> n.getPotion() == YJEffects.COMA)) {
                    YJFoods.ICE_TEA.getEffects().stream().forEach(n -> e.getEntityLiving().addPotionEffect(n.getFirst()));
                    e.getEntityLiving().world.playSound((PlayerEntity) null, e.getEntityLiving().getPosX(), e.getEntityLiving().getPosY(), e.getEntityLiving().getPosZ(), YJSoundEvents.YJ_OTTODAIJOUBUKA, SoundCategory.VOICE, 3, 1);
                    stack.shrink(1);
                }
            }
        }

    }

    @SubscribeEvent
    public static void onMobSpawn(LivingSpawnEvent.SpecialSpawn e) {
        LivingEntity mob = e.getEntityLiving();

        Random r = new Random();

        if (mob instanceof ZombieEntity || mob instanceof AbstractSkeletonEntity || mob instanceof PiglinEntity || mob instanceof FoxEntity || mob instanceof VillagerEntity || mob instanceof PandaEntity || mob instanceof AbstractIllagerEntity || mob instanceof VexEntity || mob instanceof WitchEntity) {
            if (r.nextFloat() <= 0.0810f) {
                mob.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(YJItems.ICE_TEA));
            }
        }


        if (mob instanceof ZombieEntity || mob instanceof AbstractSkeletonEntity || mob instanceof PiglinEntity) {
            if (r.nextFloat() <= 0.0810f) {
                mob.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(YJItems.CYCLOPS_SUNGLASSES));
            } else if (r.nextFloat() <= 0.01919f) {
                mob.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(YJItems.YJNIUM_HELMET));
                mob.setItemStackToSlot(EquipmentSlotType.CHEST, new ItemStack(YJItems.YJNIUM_CHESTPLATE));
                mob.setItemStackToSlot(EquipmentSlotType.LEGS, new ItemStack(YJItems.YJNIUM_LEGGINGS));
                mob.setItemStackToSlot(EquipmentSlotType.FEET, new ItemStack(YJItems.YJNIUM_BOOTS));
                mob.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(YJItems.YJNIUM_SWORD));
            } else if (r.nextFloat() <= 0.0114514f) {
                mob.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(YJItems.YJSNPI_HELMET));
                mob.setItemStackToSlot(EquipmentSlotType.CHEST, new ItemStack(YJItems.YJSNPI_CHESTPLATE));
                mob.setItemStackToSlot(EquipmentSlotType.LEGS, new ItemStack(YJItems.YJSNPI_LEGGINGS));
                mob.setItemStackToSlot(EquipmentSlotType.FEET, new ItemStack(YJItems.YJSNPI_BOOTS));
                mob.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(YJItems.YJSNPI_SWORD));
            }
        }

        if (mob instanceof FoxEntity) {
            if (r.nextFloat() <= 0.0364364f) {
                mob.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(YJItems.YJNIUM_INGOT));
            } else if (r.nextFloat() <= 0.01919f) {
                mob.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(YJItems.YJSNPI_INGOT));
            }
        }
    }

    @SubscribeEvent
    public static void onClientResponse(ResponseEvent.Client e) {
        ServerPlayerEntity pl = e.getPlayer();
        World worldIn = pl.getServerWorld();
        if (e.getLocation().equals(new ResourceLocation(YJSNPIMOD.MODID, "toiletsitting"))) {
            if (pl.getRidingEntity() instanceof ToiletSitEntity) {
                if (pl.getFoodStats().getFoodLevel() != 0 || pl.isCreative()) {
                    pl.getFoodStats().setFoodLevel(pl.getFoodStats().getFoodLevel() - 1);
                    worldIn.playSound((PlayerEntity) null, pl.getPosX(), pl.getPosY(), pl.getPosZ(), YJSoundEvents.YJ_BUTTIPA_MIZIKAME, SoundCategory.VOICE, 3, 1);
                    ToiletTileEntity tile = (ToiletTileEntity) worldIn.getTileEntity(pl.getRidingEntity().func_233580_cy_());
                    if (tile != null) {
                        tile.bukkake();
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void onMobDrop(LivingDropsEvent e) {
        if (!e.getEntityLiving().isNonBoss()) {
            IKSGEntityUtil.addMobDrop(e, new ItemStack(YJItems.YJ_STAR));
        }
        Random r = new Random();
        if (r.nextInt(100) == 0) {
            IKSGEntityUtil.addMobDrop(e, new ItemStack(YJBlocks.YJNIUM_ORE, r.nextInt(63) + 1));
        }
    }
}
