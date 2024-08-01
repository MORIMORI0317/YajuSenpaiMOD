package net.morimori0317.yajusenpai.data;

import net.minecraft.advancements.critereon.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.ApplyExplosionDecay;
import net.minecraft.world.level.storage.loot.functions.FunctionUserBuilder;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.*;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.morimori0317.yajusenpai.block.YJBlocks;
import net.morimori0317.yajusenpai.data.cross.CrossDataGeneratorAccess;
import net.morimori0317.yajusenpai.data.cross.provider.BlockLootTableProviderWrapper;
import net.morimori0317.yajusenpai.item.YJItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class YJBlockLootTableProvider extends BlockLootTableProviderWrapper {
    protected static final LootItemCondition.Builder HAS_SHEARS = MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.SHEARS));
    protected static final float[] NORMAL_LEAVES_SAPLING_CHANCES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};
    private static final float[] NORMAL_LEAVES_STICK_CHANCES = new float[]{0.02F, 0.022222223F, 0.025F, 0.033333335F, 0.1F};

    public YJBlockLootTableProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookup, CrossDataGeneratorAccess crossDataGeneratorAccess) {
        super(packOutput, lookup, crossDataGeneratorAccess);
    }

    @Override
    public void generateBlockLootTables(BlockLootSubProvider blockLoot, BlockLootTableProviderAccess providerAccess) {
        providerAccess.dropSelf(YJBlocks.YAJUSENPAI_BLOCK.get());
        providerAccess.dropSelf(YJBlocks.GOMANETSU_SENPAI_BLOCK.get());
        providerAccess.dropSelf(YJBlocks.ENNUI_SENPAI_BLOCK.get());
        providerAccess.dropSelf(YJBlocks.MEDIKARA_SENPAI_BLOCK.get());
        providerAccess.dropSelf(YJBlocks.NEHAN_SENPAI_BLOCK.get());
        providerAccess.dropSelf(YJBlocks.SHITARIGAO_SENPAI_BLOCK.get());
        providerAccess.dropSelf(YJBlocks.YAJUSENPAI_IKISUGI_BLOCK.get());
        providerAccess.dropSelf(YJBlocks.IMDKUJ_SENPAI_BLOCK.get());
        providerAccess.dropSelf(YJBlocks.KUNEKUNE_SENPAI_BLOCK.get());
        providerAccess.dropSelf(YJBlocks.SZKFK_SENPAI_BLOCK.get());
        providerAccess.dropSelf(YJBlocks.CCCLKTJM_SENPAI_BLOCK.get());
        providerAccess.dropSelf(YJBlocks.CWCWTD_SENPAI_BLOCK.get());
        providerAccess.dropSelf(YJBlocks.INTLNGTM_SENPAI_BLOCK.get());

        providerAccess.dropSelf(YJBlocks.TON_BLOCK.get());
        providerAccess.dropSelf(YJBlocks.KMR_BLOCK.get());
        providerAccess.dropSelf(YJBlocks.MUR_BLOCK.get());
        providerAccess.dropSelf(YJBlocks.NKTIDKSG_BLOCK.get());
        providerAccess.dropSelf(YJBlocks.TAKEDA_INM_BLOCK.get());
        providerAccess.dropSelf(YJBlocks.KATYOU_BLOCK.get());
        providerAccess.dropSelf(YJBlocks.SECOND_INARI_OTOKO_BLOCK.get());
        providerAccess.dropSelf(YJBlocks.AKYS_BLOCK.get());
        providerAccess.dropSelf(YJBlocks.GO_BLOCK.get());
        providerAccess.dropSelf(YJBlocks.HIDE_BLOCK.get());

        providerAccess.dropSelf(YJBlocks.BB.get());
        providerAccess.dropSelf(YJBlocks.GB.get());
        providerAccess.dropSelf(YJBlocks.RB.get());

        providerAccess.dropSelf(YJBlocks.YJ_STONE.get());
        providerAccess.dropSelf(YJBlocks.YJ_DEEPSLATE.get());
        providerAccess.dropSelf(YJBlocks.YJ_DIRT.get());
        providerAccess.dropSelf(YJBlocks.YJ_SAND.get());
        providerAccess.dropSelf(YJBlocks.YJ_GRAVEL.get());

        providerAccess.add(YJBlocks.YJ_LEAVES.get(), createYJLeavesDrops(providerAccess, YJBlocks.YJ_LEAVES.get(), YJBlocks.YJ_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        providerAccess.dropSelf(YJBlocks.YJ_LOG.get());
        providerAccess.dropSelf(YJBlocks.YJ_PLANKS.get());
        providerAccess.add(YJBlocks.YJ_SLAB.get(), createSlabItemTable(providerAccess, YJBlocks.YJ_SLAB.get()));
        providerAccess.dropSelf(YJBlocks.YJ_STAIRS.get());

        providerAccess.add(YJBlocks.SHORT_YJ_GRASS.get(), createGrassDrops(providerAccess, YJBlocks.SHORT_YJ_GRASS.get()));
        providerAccess.add(YJBlocks.TALL_YJ_GRASS.get(), createDoublePlantWithSeedDrops(providerAccess, YJBlocks.TALL_YJ_GRASS.get(), YJBlocks.SHORT_YJ_GRASS.get()));

        providerAccess.dropSelf(YJBlocks.YJ_ROSE.get());
        dropPottedContents(providerAccess, YJBlocks.POTTED_YJ_ROSE.get());

        providerAccess.dropSelf(YJBlocks.YJ_SAPLING.get());
        dropPottedContents(providerAccess, YJBlocks.POTTED_YJ_SAPLING.get());

        providerAccess.add(YJBlocks.YJNIUM_ORE.get(), createOreDrop(providerAccess, YJBlocks.YJNIUM_ORE.get(), YJItems.RAW_YJNIUM.get()));
        providerAccess.add(YJBlocks.YAJUSENPAI_ORE.get(), createOreDrop(providerAccess, YJBlocks.YAJUSENPAI_ORE.get(), YJItems.RAW_YAJUSENPAI.get()));
        providerAccess.add(YJBlocks.DEEPSLATE_YJNIUM_ORE.get(), createOreDrop(providerAccess, YJBlocks.DEEPSLATE_YJNIUM_ORE.get(), YJItems.RAW_YJNIUM.get()));
        providerAccess.add(YJBlocks.DEEPSLATE_YAJUSENPAI_ORE.get(), createOreDrop(providerAccess, YJBlocks.DEEPSLATE_YAJUSENPAI_ORE.get(), YJItems.RAW_YAJUSENPAI.get()));

        providerAccess.dropSelf(YJBlocks.YJNIUM_BLOCK.get());
        providerAccess.dropSelf(YJBlocks.RAW_YJNIUM_BLOCK.get());
        providerAccess.dropSelf(YJBlocks.RAW_YAJUSENPAI_BLOCK.get());

        providerAccess.add(YJBlocks.POTATOES_SENPAI.get(), createPotatoSenpai(providerAccess));

        providerAccess.add(YJBlocks.YJ_HOUSE_DOOR.get(), createDoorTable(providerAccess, YJBlocks.YJ_HOUSE_DOOR.get()));

        providerAccess.dropSelf(YJBlocks.EXPLOSION_YAJUSENPAI_BLOCK.get());
        providerAccess.dropSelf(YJBlocks.PROLIFERATION_YAJUSENPAI_BLOCK.get());
        providerAccess.dropSelf(YJBlocks.BIG_PILLOW.get());
    }

    @Override
    public Iterable<Block> getKnownBlocks() {
        return extract(YJBlocks.BLOCKS);
    }

    private LootTable.Builder createPotatoSenpai(BlockLootTableProviderAccess providerAccess) {
/*        LootItemBlockStatePropertyCondition.Builder builder5 = LootItemBlockStatePropertyCondition.hasBlockStateProperties(YJBlocks.POTATOES_SENPAI.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PotatoBlock.AGE, 7));
        providerAccess.add(YJBlocks.POTATOES_SENPAI.get(), this.applyExplosionDecay(YJBlocks.POTATOES_SENPAI.get(), LootTable.lootTable()
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(YJItems.POTATO_SENPAI.get())))
                .withPool(LootPool.lootPool()
                        .when(builder5)
                        .add((LootItem.lootTableItem(YJItems.POTATO_SENPAI.get())
                                .apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.FORTUNE, 0.5714286f, 3))))).withPool(LootPool.lootPool().
                        when(builder5).add(LootItem.lootTableItem(YJItems.RAW_YJNIUM.get())
                                .when(LootItemRandomChanceCondition.randomChance(0.02f))))));*/

        HolderLookup.RegistryLookup<Enchantment> registryLookup = providerAccess.registries().lookupOrThrow(Registries.ENCHANTMENT);
        LootItemCondition.Builder builder5 = LootItemBlockStatePropertyCondition.hasBlockStateProperties(YJBlocks.POTATOES_SENPAI.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PotatoBlock.AGE, 7));
        return this.applyExplosionDecay(providerAccess, YJBlocks.POTATOES_SENPAI.get(), LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(YJItems.POTATO_SENPAI.get())))
                .withPool(LootPool.lootPool().when(builder5)
                        .add(LootItem.lootTableItem(YJItems.POTATO_SENPAI.get())
                                .apply(ApplyBonusCount.addBonusBinomialDistributionCount(registryLookup.getOrThrow(Enchantments.FORTUNE), 0.5714286F, 3))))
                .withPool(LootPool.lootPool().when(builder5).add(LootItem.lootTableItem(YJItems.POTATO_SENPAI.get()).when(LootItemRandomChanceCondition.randomChance(0.02F)))));
    }

    protected LootTable.Builder createDoorTable(BlockLootTableProviderAccess providerAccess, Block block) {
        return this.createSinglePropConditionTable(providerAccess, block, DoorBlock.HALF, DoubleBlockHalf.LOWER);
    }

    protected <T extends Comparable<T> & StringRepresentable> LootTable.Builder createSinglePropConditionTable(BlockLootTableProviderAccess providerAccess, Block block, Property<T> property, T comparable) {
        return LootTable.lootTable().withPool(this.applyExplosionCondition(providerAccess, block, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(block).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(property, comparable))))));
    }

    protected LootTable.Builder createOreDrop(BlockLootTableProviderAccess providerAccess, Block block, Item item) {
        HolderLookup.RegistryLookup<Enchantment> registryLookup = providerAccess.registries().lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(providerAccess, block, this.applyExplosionDecay(providerAccess, block, LootItem.lootTableItem(item).apply(ApplyBonusCount.addOreBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    protected LootTable.Builder createSilkTouchDispatchTable(BlockLootTableProviderAccess providerAccess, Block block, LootPoolEntryContainer.Builder<?> builder) {
        return createSelfDropDispatchTable(block, this.hasSilkTouch(providerAccess), builder);
    }

    protected void dropPottedContents(BlockLootTableProviderAccess providerAccess, Block block) {
        providerAccess.add(block, this.createPotFlowerItemTable(providerAccess, ((FlowerPotBlock) block).getPotted()));
    }

    private LootTable.Builder createPotFlowerItemTable(BlockLootTableProviderAccess providerAccess, ItemLike itemLike) {
        return LootTable.lootTable().withPool(this.applyExplosionCondition(providerAccess, Blocks.FLOWER_POT, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Blocks.FLOWER_POT)))).withPool((LootPool.Builder) this.applyExplosionCondition(providerAccess, itemLike, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(itemLike))));
    }

    protected LootTable.Builder createDoublePlantWithSeedDrops(BlockLootTableProviderAccess providerAccess, Block block, Block block2) {
        LootPoolEntryContainer.Builder<?> builder = LootItem.lootTableItem(block2).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))).when(HAS_SHEARS).otherwise(((LootPoolSingletonContainer.Builder) this.applyExplosionCondition(providerAccess, block, LootItem.lootTableItem(Items.WHEAT_SEEDS))).when(LootItemRandomChanceCondition.randomChance(0.125F)));
        return LootTable.lootTable().withPool(LootPool.lootPool().add(builder).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(net.minecraft.advancements.critereon.StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER))).when(LocationCheck.checkLocation(net.minecraft.advancements.critereon.LocationPredicate.Builder.location().setBlock(net.minecraft.advancements.critereon.BlockPredicate.Builder.block().of(new Block[]{block}).setProperties(net.minecraft.advancements.critereon.StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER))), new BlockPos(0, 1, 0)))).withPool(LootPool.lootPool().add(builder).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(net.minecraft.advancements.critereon.StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER))).when(LocationCheck.checkLocation(net.minecraft.advancements.critereon.LocationPredicate.Builder.location().setBlock(net.minecraft.advancements.critereon.BlockPredicate.Builder.block().of(new Block[]{block}).setProperties(net.minecraft.advancements.critereon.StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER))), new BlockPos(0, -1, 0))));
    }

    protected LootTable.Builder createSlabItemTable(BlockLootTableProviderAccess providerAccess, Block block) {
        return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                .add(this.applyExplosionDecay(providerAccess, block, LootItem.lootTableItem(block).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SlabBlock.TYPE, SlabType.DOUBLE)))))));
    }

    protected LootTable.Builder createYJLeavesDrops(BlockLootTableProviderAccess providerAccess, Block block, Block block2, float... fs) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = providerAccess.registries().lookupOrThrow(Registries.ENCHANTMENT);
        return this.createLeavesDrops(providerAccess, block, block2, fs)
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .when(this.doesNotHaveShearsOrSilkTouch(providerAccess))
                        .add(((LootPoolSingletonContainer.Builder) this.applyExplosionCondition(providerAccess, block, LootItem.lootTableItem(YJItems.APPLE_INM.get())))
                                .when(BonusLevelTableCondition.bonusLevelFlatChance(registrylookup.getOrThrow(Enchantments.FORTUNE), 0.005F, 0.0055555557F, 0.00625F, 0.008333334F, 0.025F))));
    }

    protected LootTable.Builder createGrassDrops(BlockLootTableProviderAccess providerAccess, Block block) {
        HolderLookup.RegistryLookup<Enchantment> registryLookup = providerAccess.registries().lookupOrThrow(Registries.ENCHANTMENT);
        return this.createShearsDispatchTable(block, (LootPoolEntryContainer.Builder) this.applyExplosionDecay(providerAccess, block, ((LootPoolSingletonContainer.Builder) LootItem.lootTableItem(Items.WHEAT_SEEDS).when(LootItemRandomChanceCondition.randomChance(0.125F))).apply(ApplyBonusCount.addUniformBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE), 2))));
    }

    protected static LootTable.Builder createShearsDispatchTable(Block block, LootPoolEntryContainer.Builder<?> builder) {
        return createSelfDropDispatchTable(block, HAS_SHEARS, builder);
    }

    public LootTable.Builder createLeavesDrops(BlockLootTableProviderAccess providerAccess, Block block, Block block2, float... fs) {
        HolderLookup.RegistryLookup<Enchantment> registryLookup = providerAccess.registries().lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchOrShearsDispatchTable(providerAccess, block,
                        ((LootPoolSingletonContainer.Builder) this.applyExplosionCondition(providerAccess, block, LootItem.lootTableItem(block2)))
                                .when(BonusLevelTableCondition.bonusLevelFlatChance(registryLookup.getOrThrow(Enchantments.FORTUNE), fs)))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(this.doesNotHaveShearsOrSilkTouch(providerAccess))
                        .add(((LootPoolSingletonContainer.Builder) this.applyExplosionDecay(providerAccess, block, LootItem.lootTableItem(Items.STICK)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))))
                                .when(BonusLevelTableCondition.bonusLevelFlatChance(registryLookup.getOrThrow(Enchantments.FORTUNE), NORMAL_LEAVES_STICK_CHANCES))));
    }

    protected <T extends FunctionUserBuilder<T>> T applyExplosionDecay(BlockLootTableProviderAccess providerAccess, ItemLike arg, FunctionUserBuilder<T> arg2) {
        return !providerAccess.explosionResistant().contains(arg.asItem()) ? arg2.apply(ApplyExplosionDecay.explosionDecay()) : arg2.unwrap();
    }

    private LootItemCondition.Builder doesNotHaveShearsOrSilkTouch(BlockLootTableProviderAccess providerAccess) {
        return this.hasShearsOrSilkTouch(providerAccess).invert();
    }

    protected <T extends ConditionUserBuilder<T>> T applyExplosionCondition(BlockLootTableProviderAccess providerAccess, ItemLike arg, ConditionUserBuilder<T> arg2) {
        return !providerAccess.explosionResistant().contains(arg.asItem()) ? arg2.when(ExplosionCondition.survivesExplosion()) : arg2.unwrap();
    }

    protected LootTable.Builder createSilkTouchOrShearsDispatchTable(BlockLootTableProviderAccess providerAccess, Block arg, LootPoolEntryContainer.Builder<?> arg2) {
        return createSelfDropDispatchTable(arg, this.hasShearsOrSilkTouch(providerAccess), arg2);
    }

    private LootItemCondition.Builder hasShearsOrSilkTouch(BlockLootTableProviderAccess providerAccess) {
        return HAS_SHEARS.or(this.hasSilkTouch(providerAccess));
    }

    protected LootItemCondition.Builder hasSilkTouch(BlockLootTableProviderAccess providerAccess) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = providerAccess.registries().lookupOrThrow(Registries.ENCHANTMENT);
        return MatchTool.toolMatches(ItemPredicate.Builder.item().withSubPredicate(ItemSubPredicates.ENCHANTMENTS, ItemEnchantmentsPredicate.enchantments(List.of(new EnchantmentPredicate(registrylookup.getOrThrow(Enchantments.SILK_TOUCH), MinMaxBounds.Ints.atLeast(1))))));
    }

    protected static LootTable.Builder createSelfDropDispatchTable(Block arg, LootItemCondition.Builder arg2, LootPoolEntryContainer.Builder<?> arg3) {
        return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(arg).when(arg2).otherwise(arg3)));
    }
}
