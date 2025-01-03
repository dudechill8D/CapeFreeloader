package org.dudechill8D.capefreeloader.mixin;

import com.mojang.authlib.SignatureState;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import com.mojang.authlib.minecraft.MinecraftProfileTextures;
import org.dudechill8D.capefreeloader.CapeFreeloader;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Debug(export = true)
@Mixin( targets = "net.minecraft.client.texture.PlayerSkinProvider$1" )
public abstract class PlayerMixin {
    @ModifyVariable( method = "method_54647", at = @At("STORE")) // found method by viewing bytecode of inner class and looking for strings
    private static MinecraftProfileTextures modify(MinecraftProfileTextures currentTextures) {
        MinecraftProfileTexture skin = currentTextures.skin();
        MinecraftProfileTexture cape = new MinecraftProfileTexture("http://textures.minecraft.net/texture/c3af7fb821254664558f28361158ca73303c9a85e96e5251102958d7ed60c4a3", null);
        MinecraftProfileTexture elytra = null; // new MinecraftProfileTexture("http://textures.minecraft.net/texture/f9a76537647989f9a0b6d001e320dac591c359e9e61a31f4ce11c88f207f0ad4", null);  // newest cape/elytra: 5c29410057e32abec02d870ecb52ec25fb45ea81e785a7854ae8429d7236ca26
        SignatureState sigState = currentTextures.signatureState();
        MinecraftProfileTextures newTextures = new MinecraftProfileTextures(skin, cape, elytra, sigState);
        CapeFreeloader.LOGGER.info("========================================================");
        return newTextures;
//        if (currentTextures.cape() != null)
//            CapeFreeloader.LOGGER.info("Cape:    " + currentTextures.cape().getUrl());
//        if (currentTextures.elytra() != null)
//            CapeFreeloader.LOGGER.info("Elytra:  " + currentTextures.elytra().getUrl());
//        return currentTextures;
    }
}