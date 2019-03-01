package yjblock;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
@ObjectHolder(Yjblock_core.MODID)
public class Items_core {
    public static final Item Item_yjin = new Item_record_yjin();
    public static final Item Item_yonsyou = new Item_record_yonsyou();
    public static final Item Item_karatebu = new Item_record_karatebu();
    @SubscribeEvent
    public static void registerItem(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(Item_yjin);
        event.getRegistry().register(Item_yonsyou);
        event.getRegistry().register(Item_karatebu);
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void tourokuModels(){
        ModelLoader.setCustomModelResourceLocation(Item_yjin, 0, new ModelResourceLocation(new ResourceLocation(Yjblock_core.MODID, "record_yjin"), "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item_yonsyou, 0, new ModelResourceLocation(new ResourceLocation(Yjblock_core.MODID, "record_yonsyou"), "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item_karatebu, 0, new ModelResourceLocation(new ResourceLocation(Yjblock_core.MODID, "record_karatebu"), "inventory"));

    }
}
