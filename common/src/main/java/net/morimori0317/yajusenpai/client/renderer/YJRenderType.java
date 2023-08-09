package net.morimori0317.yajusenpai.client.renderer;

import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.morimori0317.yajusenpai.client.renderer.blockentity.YJPortalRenderer;

public class YJRenderType extends RenderType {
    private static final RenderType YJ_PORTAL = create("yj_portal", DefaultVertexFormat.POSITION, VertexFormat.Mode.QUADS, 256, false, false, CompositeState.builder().setShaderState(RENDERTYPE_END_PORTAL_SHADER).setTextureState(MultiTextureStateShard.builder().add(YJPortalRenderer.YJ_SKY_LOCATION, false, false).add(YJPortalRenderer.YJ_PORTAL_LOCATION, false, false).build()).createCompositeState(false));

    private YJRenderType(String string, VertexFormat vertexFormat, VertexFormat.Mode mode, int i, boolean bl, boolean bl2, Runnable runnable, Runnable runnable2) {
        super(string, vertexFormat, mode, i, bl, bl2, runnable, runnable2);
    }

    public static RenderType yjPortal() {
        return YJ_PORTAL;
    }
}
