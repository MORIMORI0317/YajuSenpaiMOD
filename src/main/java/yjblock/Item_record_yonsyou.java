package yjblock;

import net.minecraft.item.ItemRecord;

public class Item_record_yonsyou extends ItemRecord {

	public Item_record_yonsyou() {
	        super("yonsyou", Yjblock_core.yonsyouevent);
	        this.setRegistryName(Yjblock_core.MODID, "record_yonsyou");
	        this.setCreativeTab(Yjblock_core.yjtab);
	        this.setUnlocalizedName("record");
	    }
	}