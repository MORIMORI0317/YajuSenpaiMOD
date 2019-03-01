package yjblock;



import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
@ObjectHolder(Yjblock_core.MODID)
public class Blocks_core {
	 public static final Block Block_YJSMPI = new Block_YJSMPI();

    @SubscribeEvent
    public static void registerItem(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemBlock(Block_YJSMPI).setRegistryName(Yjblock_core.MODID, "yj_block"));

    }
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
    	event.getRegistry().register(Block_YJSMPI);

    }
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void tourokuModels(){

     	ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(Block_YJSMPI), 0, new ModelResourceLocation(new ResourceLocation(Yjblock_core.MODID, "yj_block"), "inventory"));

    }
}
