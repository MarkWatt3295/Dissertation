package com.maw79.mods.recipe;

import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.FMLLog;

public class DualFurnaceRecipe {

	private static final DualFurnaceRecipe SMELTING = new DualFurnaceRecipe();
	private final Table<ItemStack, ItemStack, ItemStack> dualSmeltingList = HashBasedTable.<ItemStack, ItemStack, ItemStack>create();
	private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();
	
	public static DualFurnaceRecipe instance(){
		return SMELTING;
	}
	
	private DualFurnaceRecipe(){
		this.addDualSmeltingRecipe(new ItemStack(Blocks.IRON_ORE), new ItemStack(Blocks.GOLD_ORE), new ItemStack(Blocks.DIAMOND_ORE), 10.0F);
	}
	
	public void addDualSmeltingRecipe(ItemStack input1, ItemStack input2, ItemStack result, float experience){
		if(getDualSmeltingResult(input1, input2) != ItemStack.EMPTY){
	FMLLog.info("Ignored dual smelting recipe with conflicting input: "+  input1 + " and "+ input2 + " = "+ result);
	return;
	}
		this.dualSmeltingList.put(input1, input2, result);
		this.experienceList.put(result, Float.valueOf(experience));
	}
	
		public ItemStack getDualSmeltingResult(ItemStack input1, ItemStack input2){
		for(Entry<ItemStack, Map<ItemStack, ItemStack>> entry : this.dualSmeltingList.columnMap().entrySet())
			if(this.compareItemStacks(input1, (ItemStack)entry.getKey()))
				for(Entry<ItemStack, ItemStack> ent : entry.getValue().entrySet())
					if(this.compareItemStacks(input2, (ItemStack)ent.getKey()))
							return (ItemStack)ent.getValue();
					return ItemStack.EMPTY;
	}
	
	private boolean compareItemStacks(ItemStack stack1, ItemStack stack2){
		return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
	}
	
	public Table<ItemStack, ItemStack, ItemStack> getDualSmeltingList(){
		return this.dualSmeltingList;
	}
	
	public float getDualSmeltingListExperience(ItemStack stack){
		for(Entry<ItemStack, Float> entry : this.experienceList.entrySet())
			if(this.compareItemStacks(stack, (ItemStack)entry.getKey()))
				return ((Float)entry.getValue()).floatValue();
		return 0.0F;
	}
}
