package com.maw79.mods.handlers;

import com.maw79.mods.main.Reference;
import com.maw79.mods.util.Utils;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class ModSoundHandler {
	
	private static int size = 0;
	
	public static SoundEvent STEEL_FENCE_GATE_OPEN;
	public static SoundEvent STEEL_FENCE_GATE_CLOSE;
	public static SoundEvent STEEL_BUTTON_CLICK_ON;
	public static SoundEvent STEEL_BUTTON_CLICK_OFF;
	public static SoundEvent MAWSOUND_OPEN;
	public static SoundEvent MAWSOUND_COIN;
	public static SoundEvent MAWSOUND_SQUELCH;
	public static SoundEvent MAWSOUND_FLYBY;
	public static SoundEvent MAWSOUND_VOICE1;
	public static SoundEvent MAWSOUND_CHACHING;
	public static SoundEvent MAWSOUND_COINDROP;
	public static SoundEvent MAWSOUND_ERRORNOISE;
	public static SoundEvent MAWSOUND_ERRORSOUND;
	public static SoundEvent MAWSOUND_OUCH;
	public static SoundEvent MAWSOUND_SMRT;
	public static SoundEvent MAWSOUND_POPCORK;
	public static SoundEvent MAWSOUND_TADA;
	
	
	public static void init() {
		size = SoundEvent.REGISTRY.getKeys().size();
		
		STEEL_FENCE_GATE_OPEN = register("block.steel_fence_gate.open");
		STEEL_FENCE_GATE_CLOSE = register("block.steel_fence_gate.close");
		STEEL_BUTTON_CLICK_ON = register("block.steel_button.click_on");
		STEEL_BUTTON_CLICK_OFF = register("block.steel_button.click_off");
		MAWSOUND_OPEN = register("mawsound.open");
		MAWSOUND_COIN = register("mawsound.coin");
		MAWSOUND_SQUELCH = register("mawsound.squelch");
		MAWSOUND_FLYBY = register("mawsound.flyby");
		MAWSOUND_VOICE1 = register("mawsound.voice1");
		MAWSOUND_CHACHING = register("mawsound.chaching");
		MAWSOUND_COINDROP= register("mawsound.coindrop");
		MAWSOUND_ERRORNOISE= register("mawsound.errornoise");
		MAWSOUND_ERRORSOUND= register("mawsound.errorsound");
		MAWSOUND_OUCH= register("mawsound.ouch");
		MAWSOUND_SMRT = register("mawsound.smrt");
		MAWSOUND_POPCORK = register("mawsound.popcork");
		MAWSOUND_TADA = register("mawsound.tada");
		
		
	}
	
	public static SoundEvent register(String name) {
		ResourceLocation location = new ResourceLocation(Reference.MOD_ID, name);
		SoundEvent e = new SoundEvent(location);
		
		SoundEvent.REGISTRY.register(size, location, e);
		size++;
		Utils.getLogger().info("Registered sound: " + name);
		return e;
	}

}