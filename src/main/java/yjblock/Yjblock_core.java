package yjblock;
//114514!
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
@Mod(modid = Yjblock_core.MODID, version = Yjblock_core.MODVER, name = Yjblock_core.MODNAME, useMetadata = true)
@EventBusSubscriber
public class Yjblock_core {
	public static final String MODID = "yjsnpimod";
	public static final String MODNAME = "The YJSNPI MOD";
	public static final String MODVER = "1.0";
    public static CreativeTabs yjtab = new Ctab_yjtab(CreativeTabs.getNextID());

    static ResourceLocation nna = new ResourceLocation(MODID, "nna");
    static SoundEvent nnaevent = new SoundEvent(nna);
    static ResourceLocation yarimasunexe = new ResourceLocation(MODID, "yarimasunexe");
    static SoundEvent yarimasunexeevent = new SoundEvent(yarimasunexe);
    static ResourceLocation onaon = new ResourceLocation(MODID, "onaon");
    static SoundEvent onaonevent = new SoundEvent(onaon);
    static ResourceLocation mazuutisaxa = new ResourceLocation(MODID, "mazuutisaxa");
    static SoundEvent mazuutisaxaevent = new SoundEvent(mazuutisaxa);
    static ResourceLocation kataku = new ResourceLocation(MODID, "kataku");
    static SoundEvent katakuevent = new SoundEvent(kataku);
    static ResourceLocation nuwatikareta = new ResourceLocation(MODID, "nuwatikareta");
    static SoundEvent nuwatikaretaevent = new SoundEvent(nuwatikareta);
    static ResourceLocation buttipa = new ResourceLocation(MODID, "buttipa");
    static SoundEvent buttipaevent = new SoundEvent(buttipa);
    static ResourceLocation ikisugi = new ResourceLocation(MODID, "ikisugi");
    static SoundEvent ikisugievent = new SoundEvent(ikisugi);
    static ResourceLocation osuonegai = new ResourceLocation(MODID, "osuonegai");
    static SoundEvent osuonegaievent = new SoundEvent(osuonegai);
    static ResourceLocation dedemasuyo = new ResourceLocation(MODID, "dedemasuyo");
    static SoundEvent dedemasuyoevent = new SoundEvent(dedemasuyo);
    static ResourceLocation fookimatii = new ResourceLocation(MODID, "fookimatii");
    static SoundEvent fookimatiievent = new SoundEvent(fookimatii);
    static ResourceLocation yjin = new ResourceLocation(MODID, "yjin");
    static SoundEvent yjinevent = new SoundEvent(yjin);
    static ResourceLocation yonsyou = new ResourceLocation(MODID, "yonsyou");
    static SoundEvent yonsyouevent = new SoundEvent(yonsyou);
    static ResourceLocation karatebu = new ResourceLocation(MODID, "karatebu");
    static SoundEvent karatebuevent = new SoundEvent(karatebu);
    @SubscribeEvent
    protected static void register(RegistryEvent.Register<Item> event){
    	Items_core.registerItem(event);
    	Blocks_core.registerItem(event);
    	System.out.println("Hello YJSNPI!!");

    }
    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Block> event) {
    	Blocks_core.registerBlocks(event);

    }
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
    public static void tourokuModels(ModelRegistryEvent event){
    	Items_core.tourokuModels();
    	Blocks_core.tourokuModels();

}

}