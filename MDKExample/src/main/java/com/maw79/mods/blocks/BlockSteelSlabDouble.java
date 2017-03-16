package com.maw79.mods.blocks;


	public class BlockSteelSlabDouble extends BlockSteelSlab {

		public BlockSteelSlabDouble(String unlocalizedName) {
			super(unlocalizedName);
		}

		/**
		 * Says that this block is the double version of the tin slab
		 */
		@Override
		public boolean isDouble() {
			return true;
		}

	}

