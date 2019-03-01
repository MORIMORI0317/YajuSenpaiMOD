package yjblock;

import net.minecraft.item.ItemRecord;

public class Item_record_karatebu extends ItemRecord {

	public Item_record_karatebu() {
	        super("karatebu", Yjblock_core.karatebuevent);
	        this.setRegistryName(Yjblock_core.MODID, "record_karatebu");
	        this.setCreativeTab(Yjblock_core.yjtab);
	        this.setUnlocalizedName("record");
	    }
	}