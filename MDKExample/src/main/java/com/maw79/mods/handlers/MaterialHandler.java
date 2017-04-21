package com.maw79.mods.handlers;

import com.maw79.mods.main.Reference;

import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class MaterialHandler {

	public static ToolMaterial TUTORIAL = EnumHelper.addToolMaterial("tutorial", 3, 2500, 5F, 5F, 20);
	public static final ToolMaterial obsidianToolMaterial = EnumHelper.addToolMaterial(Reference.MOD_ID + ":obsidian", 2, 300, 5.0F, 2.0F, 12);
	public static ArmorMaterial obsidianMaterial = EnumHelper.addArmorMaterial("obsidian", "maw79:obsidian", 15, new int[]{2,6,5,2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 2.0f);		

	public static final ToolMaterial steelToolMaterial = EnumHelper.addToolMaterial(Reference.MOD_ID + ":steel", 3, 400, 5.0F, 2000.0F, 12);
	public static final ToolMaterial paintBrushToolMaterial = EnumHelper.addToolMaterial(Reference.MOD_ID + ":paint_brush", 0, 4, 0, 1, 1);
	public static final ToolMaterial rustyPaintBrushToolMaterial = EnumHelper.addToolMaterial(Reference.MOD_ID + ":rusty_paint_brush", 0, 1, 0, 1, 0);
	public static final ToolMaterial mediumPaintBrushToolMaterial = EnumHelper.addToolMaterial(Reference.MOD_ID + ":medium_paint_brush", 0, 2, 0, 1, 0);
	public static final ToolMaterial infinitePaintBrushToolMaterial = EnumHelper.addToolMaterial(Reference.MOD_ID + ":infinite_paint_brush", 0, 0, 0, 10, 2);

	public static final ToolMaterial glassToolMaterial = EnumHelper.addToolMaterial(Reference.MOD_ID + ":glass", 2, 1, 5.0F, 2.0F, 12);
	public static final ToolMaterial wandToolMaterial = EnumHelper.addToolMaterial(Reference.MOD_ID + ":wand", 2, 0, 3.0F, 1.0F, 12);
	
	public static final ToolMaterial halfStampMaterial = EnumHelper.addToolMaterial(Reference.MOD_ID + ":half_stamp", 2, 4, 3.0F, 1.0F, 12);


}
