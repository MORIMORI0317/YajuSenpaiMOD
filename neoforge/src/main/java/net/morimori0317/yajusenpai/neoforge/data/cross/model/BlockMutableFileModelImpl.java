package net.morimori0317.yajusenpai.neoforge.data.cross.model;

import net.morimori0317.yajusenpai.data.cross.model.FileModel;
import net.morimori0317.yajusenpai.data.cross.model.MutableFileModel;
import net.morimori0317.yajusenpai.data.cross.model.OverridePredicate;
import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BlockMutableFileModelImpl extends MutableFileModelImpl {
    private final BlockModelBuilder blockModelBuilder;

    public BlockMutableFileModelImpl(BlockModelBuilder blockModelBuilder) {
        super(blockModelBuilder);
        this.blockModelBuilder = blockModelBuilder;
    }

    @Override
    public MutableFileModel override(@NotNull FileModel model, @NotNull List<OverridePredicate> predicates) {
        throw new RuntimeException("Block model is not use override.");
    }
}
