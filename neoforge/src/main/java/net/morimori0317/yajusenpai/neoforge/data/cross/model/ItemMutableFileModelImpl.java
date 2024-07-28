package net.morimori0317.yajusenpai.neoforge.data.cross.model;

import net.morimori0317.yajusenpai.data.cross.model.FileModel;
import net.morimori0317.yajusenpai.data.cross.model.MutableFileModel;
import net.morimori0317.yajusenpai.data.cross.model.OverridePredicate;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ItemMutableFileModelImpl extends MutableFileModelImpl {
    private final ItemModelBuilder itemModelBuilder;

    public ItemMutableFileModelImpl(ItemModelBuilder itemModelBuilder) {
        super(itemModelBuilder);
        this.itemModelBuilder = itemModelBuilder;
    }

    @Override
    public MutableFileModel override(@NotNull FileModel model, @NotNull List<OverridePredicate> predicates) {
        var mf = getModelFile(model);
        var ovs = itemModelBuilder.override().model(mf);

        for (OverridePredicate predicate : predicates) {
            ovs.predicate(predicate.key(), predicate.value());
        }

        ovs.end();
        return this;
    }
}
