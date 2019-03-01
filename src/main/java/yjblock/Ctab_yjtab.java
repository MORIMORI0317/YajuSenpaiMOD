package yjblock;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class Ctab_yjtab extends CreativeTabs {
public Ctab_yjtab(int id) {

	super("yjblocktab");
}
@Override
public ItemStack getTabIconItem() {
	return new ItemStack(Blocks_core.Block_YJSMPI);
}
}