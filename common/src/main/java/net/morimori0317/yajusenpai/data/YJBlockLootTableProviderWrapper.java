package net.morimori0317.yajusenpai.data;

import dev.felnull.otyacraftengine.data.CrossDataGeneratorAccess;
import dev.felnull.otyacraftengine.data.provider.BlockLootTableProviderWrapper;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.BlockPos;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.AlternativesEntry;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.*;
import net.minecraft.world.level.storage.loot.predicates.*;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.morimori0317.yajusenpai.block.YJBlocks;
import net.morimori0317.yajusenpai.item.YJItems;

public class YJBlockLootTableProviderWrapper extends BlockLootTableProviderWrapper {
    protected static final LootItemCondition.Builder HAS_SILK_TOUCH = MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))));
    protected static final LootItemCondition.Builder HAS_SHEARS = MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.SHEARS));
    private static final LootItemCondition.Builder HAS_SHEARS_OR_SILK_TOUCH = HAS_SHEARS.or(HAS_SILK_TOUCH);
    private static final LootItemCondition.Builder HAS_NO_SHEARS_OR_SILK_TOUCH = HAS_SHEARS_OR_SILK_TOUCH.invert();
    protected static final float[] NORMAL_LEAVES_SAPLING_CHANCES = new float[]{0.05f, 0.0625f, 0.083333336f, 0.1f};
    private static final float[] NORMAL_LEAVES_STICK_CHANCES = new float[]{0.02f, 0.022222223f, 0.025f, 0.033333335f, 0.1f};

    public YJBlockLootTableProviderWrapper(PackOutput packOutput, CrossDataGeneratorAccess crossDataGeneratorAccess) {
        super(packOutput, crossDataGeneratorAccess);
    }

    @Override
    public void generateBlockLootTables(BlockLootSubProvider blockLoot, BlockLootTableProviderAccess providerAccess) {

        providerAccess.dropSelf(YJBlocks.YJSNPI_INTERVIEW_BLOCK.get());
        providerAccess.dropSelf(YJBlocks.YJSNPI_GOMANETSU_BLOCK.get());
        providerAccess.dropSelf(YJBlocks.YJSNPI_ENNUI_BLOCK.get());
        providerAccess.dropSelf(YJBlocks.YJSNPI_MEZIKARA_BLOCK.get());
        providerAccess.dropSelf(YJBlocks.YJSNPI_NEHAN_BLOCK.get());
        providerAccess.dropSelf(YJBlocks.YJSNPI_SHITARIGAO_BLOCK.get());
        providerAccess.dropSelf(YJBlocks.YJSNPI_IKISUGI_BLOCK.get());
        providerAccess.dropSelf(YJBlocks.YJSNPI_IMDKUJ_BLOCK.get());
        providerAccess.dropSelf(YJBlocks.YJSNPI_KUNEKUNE_BLOCK.get());
        providerAccess.dropSelf(YJBlocks.YJSNPI_SZKFK_BLOCK.get());
        providerAccess.dropSelf(YJBlocks.YJSNPI_CCCLKTJM_BLOCK.get());
        providerAccess.dropSelf(YJBlocks.YJSNPI_CWCWTD_BLOCK.get());
        providerAccess.dropSelf(YJBlocks.YJSNPI_INTLNGTM_BLOCK.get());

        providerAccess.dropSelf(YJBlocks.TON_BLOCK.get());
        providerAccess.dropSelf(YJBlocks.KMR_BLOCK.get());
        providerAccess.dropSelf(YJBlocks.MUR_BLOCK.get());

        providerAccess.dropSelf(YJBlocks.BB.get());
        providerAccess.dropSelf(YJBlocks.GB.get());
        providerAccess.dropSelf(YJBlocks.RB.get());

        providerAccess.dropSelf(YJBlocks.YJ_STONE.get());
        providerAccess.dropSelf(YJBlocks.YJ_DEEPSLATE.get());
        providerAccess.dropSelf(YJBlocks.YJ_DIRT.get());
        providerAccess.dropSelf(YJBlocks.YJ_SAND.get());
        providerAccess.dropSelf(YJBlocks.YJ_GRAVEL.get());

        providerAccess.add(YJBlocks.YJ_LEAVES.get(), createYJLeavesDrops(YJBlocks.YJ_LEAVES.get(), YJBlocks.YJ_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        providerAccess.dropSelf(YJBlocks.YJ_LOG.get());
        providerAccess.dropSelf(YJBlocks.YJ_PLANKS.get());
        providerAccess.add(YJBlocks.YJ_SLAB.get(), createSlabItemTable(YJBlocks.YJ_SLAB.get()));
        providerAccess.dropSelf(YJBlocks.YJ_STAIRS.get());

        providerAccess.add(YJBlocks.YJ_GRASS.get(), createGrassDrops(YJBlocks.YJ_GRASS.get()));
        providerAccess.add(YJBlocks.TALL_YJ_GRASS.get(), createDoublePlantWithSeedDrops(YJBlocks.TALL_YJ_GRASS.get(), YJBlocks.YJ_GRASS.get()));

        providerAccess.dropSelf(YJBlocks.YJ_ROSE.get());
        dropPottedContents(providerAccess, YJBlocks.POTTED_YJ_ROSE.get());

        providerAccess.dropSelf(YJBlocks.YJ_SAPLING.get());
        dropPottedContents(providerAccess, YJBlocks.POTTED_YJ_SAPLING.get());

        providerAccess.add(YJBlocks.YJNIUM_ORE.get(), createOreDrop(YJBlocks.YJNIUM_ORE.get(), YJItems.RAW_YJNIUM.get()));
        providerAccess.add(YJBlocks.YJSNPI_ORE.get(), createOreDrop(YJBlocks.YJSNPI_ORE.get(), YJItems.RAW_YJSNPI.get()));
        providerAccess.add(YJBlocks.DEEPSLATE_YJNIUM_ORE.get(), createOreDrop(YJBlocks.DEEPSLATE_YJNIUM_ORE.get(), YJItems.RAW_YJNIUM.get()));
        providerAccess.add(YJBlocks.DEEPSLATE_YJSNPI_ORE.get(), createOreDrop(YJBlocks.DEEPSLATE_YJSNPI_ORE.get(), YJItems.RAW_YJSNPI.get()));

        providerAccess.dropSelf(YJBlocks.YJNIUM_BLOCK.get());
        providerAccess.dropSelf(YJBlocks.RAW_YJNIUM_BLOCK.get());
        providerAccess.dropSelf(YJBlocks.RAW_YJSNPI_BLOCK.get());

        LootItemBlockStatePropertyCondition.Builder builder5 = LootItemBlockStatePropertyCondition.hasBlockStateProperties(YJBlocks.POTATOES_SENPAI.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PotatoBlock.AGE, 7));
        providerAccess.add(YJBlocks.POTATOES_SENPAI.get(), this.applyExplosionDecay(YJBlocks.POTATOES_SENPAI.get(), LootTable.lootTable()
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(YJItems.POTATO_SENPAI.get())))
                .withPool(LootPool.lootPool()
                        .when(builder5)
                        .add((LootItem.lootTableItem(YJItems.POTATO_SENPAI.get())
                                .apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286f, 3))))).withPool(LootPool.lootPool().
                        when(builder5).add(LootItem.lootTableItem(YJItems.RAW_YJNIUM.get())
                                .when(LootItemRandomChanceCondition.randomChance(0.02f))))));

        providerAccess.add(YJBlocks.YJ_HOUSE_DOOR.get(), createDoorTable(YJBlocks.YJ_HOUSE_DOOR.get()));

        providerAccess.dropSelf(YJBlocks.YJSNPI_EXPLODING_BLOCK.get());
        providerAccess.dropSelf(YJBlocks.YJSNPI_PROLIFERATION_BLOCK.get());
        //providerAccess.add(YJBlocks.YJ_PORTAL.get(), BlockLootSubProvider.noDrop());
        providerAccess.dropSelf(YJBlocks.BIG_PILLOW.get());
    }

    @Override
    public Iterable<Block> getKnownBlocks() {
        return extract(YJBlocks.BLOCKS);
    }

    protected LootTable.Builder createDoorTable(Block block) {
        return this.createSinglePropConditionTable(block, DoorBlock.HALF, DoubleBlockHalf.LOWER);
    }

    protected <T extends Comparable<T> & StringRepresentable> LootTable.Builder createSinglePropConditionTable(Block block, Property<T> property, T comparable) {
        return LootTable.lootTable().withPool(this.applyExplosionCondition(block, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f)).add((LootPoolEntryContainer.Builder<?>) LootItem.lootTableItem(block).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(property, comparable))))));
    }

    protected LootTable.Builder createSlabItemTable(Block block) {
        return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f)).add((LootPoolEntryContainer.Builder) this.applyExplosionDecay(block, LootItem.lootTableItem(block).apply((LootItemFunction.Builder) ((Object) SetItemCountFunction.setCount(ConstantValue.exactly(2.0f)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SlabBlock.TYPE, SlabType.DOUBLE))))))));
    }

    protected LootTable.Builder createYJLeavesDrops(Block block, Block block2, float... fs) {
        return this.createLeavesDrops(block, block2, fs)
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0f))
                        .when(HAS_NO_SHEARS_OR_SILK_TOUCH)
                        .add((LootPoolEntryContainer.Builder<?>) ((LootPoolSingletonContainer.Builder) this.applyExplosionCondition(block, LootItem.lootTableItem(YJItems.APPLE.get())))
                                .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.005f, 0.0055555557f, 0.00625f, 0.008333334f, 0.025f))));
    }

    protected LootTable.Builder createOreDrop(Block block, Item item) {
        return createSilkTouchDispatchTable(block, (LootPoolEntryContainer.Builder) this.applyExplosionDecay(block, LootItem.lootTableItem(item).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    protected static LootTable.Builder createSilkTouchDispatchTable(Block block, LootPoolEntryContainer.Builder<?> builder) {
        return createSelfDropDispatchTable(block, HAS_SILK_TOUCH, builder);
    }

    protected void dropPottedContents(BlockLootTableProviderAccess providerAccess, Block block2) {
        providerAccess.add(block2, this.createPotFlowerItemTable(((FlowerPotBlock) block2).getContent()));
    }

    private LootTable.Builder createPotFlowerItemTable(ItemLike itemLike) {
        return LootTable.lootTable().withPool(this.applyExplosionCondition(Blocks.FLOWER_POT, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f)).add(LootItem.lootTableItem(Blocks.FLOWER_POT)))).withPool(this.applyExplosionCondition(itemLike, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f)).add(LootItem.lootTableItem(itemLike))));
    }

    protected LootTable.Builder createDoublePlantWithSeedDrops(Block block, Block block2) {
        AlternativesEntry.Builder builder = ((LootPoolSingletonContainer.Builder) ((LootPoolEntryContainer.Builder) ((Object) LootItem.lootTableItem(block2).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0f))))).when(HAS_SHEARS)).otherwise((LootPoolEntryContainer.Builder<?>) ((LootPoolSingletonContainer.Builder) this.applyExplosionCondition(block, LootItem.lootTableItem(Items.WHEAT_SEEDS))).when(LootItemRandomChanceCondition.randomChance(0.125f)));
        return LootTable.lootTable().withPool(LootPool.lootPool().add(builder).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER))).when(LocationCheck.checkLocation(LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER).build()).build()), new BlockPos(0, 1, 0)))).withPool(LootPool.lootPool().add(builder).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER))).when(LocationCheck.checkLocation(LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER).build()).build()), new BlockPos(0, -1, 0))));
    }

    protected LootTable.Builder createGrassDrops(Block block) {
        return createShearsDispatchTable(block, (LootPoolEntryContainer.Builder) this.applyExplosionDecay(block, ((LootPoolSingletonContainer.Builder) LootItem.lootTableItem(Items.WHEAT_SEEDS).when(LootItemRandomChanceCondition.randomChance(0.125f))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE, 2))));
    }

    protected static LootTable.Builder createShearsDispatchTable(Block block, LootPoolEntryContainer.Builder<?> builder) {
        return createSelfDropDispatchTable(block, HAS_SHEARS, builder);
    }

    protected <T extends ConditionUserBuilder<T>> T applyExplosionCondition(ItemLike itemLike, ConditionUserBuilder<T> conditionUserBuilder) {
        return conditionUserBuilder.when(ExplosionCondition.survivesExplosion());
    }

    protected LootTable.Builder createLeavesDrops(Block block, Block block2, float... fs) {
        return createSilkTouchOrShearsDispatchTable(block, ((LootPoolSingletonContainer.Builder) this.applyExplosionCondition(block, LootItem.lootTableItem(block2))).when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, fs))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f)).when(HAS_NO_SHEARS_OR_SILK_TOUCH).add((LootPoolEntryContainer.Builder<?>) ((LootPoolSingletonContainer.Builder) this.applyExplosionDecay(block, LootItem.lootTableItem(Items.STICK).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f))))).when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, NORMAL_LEAVES_STICK_CHANCES))));
    }

    protected <T extends FunctionUserBuilder<T>> T applyExplosionDecay(ItemLike itemLike, FunctionUserBuilder<T> functionUserBuilder) {
        return functionUserBuilder.apply(ApplyExplosionDecay.explosionDecay());
    }

    protected static LootTable.Builder createSilkTouchOrShearsDispatchTable(Block block, LootPoolEntryContainer.Builder<?> builder) {
        return createSelfDropDispatchTable(block, HAS_SHEARS_OR_SILK_TOUCH, builder);
    }

    private static LootTable.Builder createSelfDropDispatchTable(Block block, LootItemCondition.Builder builder, LootPoolEntryContainer.Builder<?> builder2) {
        return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f)).add((LootItem.lootTableItem(block).when(builder)).otherwise(builder2)));
    }

}
