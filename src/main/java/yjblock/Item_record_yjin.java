package yjblock;

import net.minecraft.item.ItemRecord;

public class Item_record_yjin extends ItemRecord {

	public Item_record_yjin() {
	        super("yjin", Yjblock_core.yjinevent);
	        this.setRegistryName(Yjblock_core.MODID, "record_yjin");
	        this.setCreativeTab(Yjblock_core.yjtab);
	        this.setUnlocalizedName("record");
	    }
	}