package net.morimori.yjsnpimod.registry;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.decoration.Motive;
import net.morimori.yjsnpimod.YJSNPIMOD;

import java.util.HashMap;
import java.util.Map;

public class YJMotives {
    private static final Map<ResourceLocation, Motive> MOD_MOTIVES = new HashMap<>();
    public static final Motive ART = register("art", 64, 64);
    public static final Motive BUTTIPA = register("buttipa", 32, 32);
    public static final Motive COWCOW = register("cowcow", 16, 16);
    public static final Motive DEMASUYO = register("demasuyo", 32, 16);
    public static final Motive GANKOU = register("gankou", 32, 16);
    public static final Motive ICETEA = register("icetea", 64, 32);
    public static final Motive IKISUGI = register("ikisugi", 16, 16);
    public static final Motive IMDKOJI = register("imdkoji", 32, 32);
    public static final Motive INTERVIEW = register("interview", 16, 16);
    public static final Motive INTERVIEW_2 = register("interview_2", 64, 64);
    public static final Motive KANGAERU = register("kangaeru", 32, 16);
    public static final Motive KMR = register("kmr", 16, 16);
    public static final Motive KUGYOU = register("kugyou", 32, 16);
    public static final Motive KUNEKUNE = register("kunekune", 16, 32);
    public static final Motive LOGO = register("logo", 64, 32);
    public static final Motive MIACAT = register("miacat", 16, 32);
    public static final Motive MUR = register("mur", 32, 32);
    public static final Motive SANSYOU = register("sansyou", 64, 48);
    public static final Motive TADOKORO = register("tadokoro", 16, 16);
    public static final Motive TON = register("ton", 16, 16);
    public static final Motive YONSYOU = register("yonsyou", 64, 48);

    private static Motive register(String name, int x, int y) {
        Motive motive = new Motive(x, y);
        MOD_MOTIVES.put(new ResourceLocation(YJSNPIMOD.MODID, name), motive);
        return motive;
    }

    public static void init() {
        MOD_MOTIVES.forEach((n, m) -> Registry.register(Registry.MOTIVE, n, m));
    }
}
