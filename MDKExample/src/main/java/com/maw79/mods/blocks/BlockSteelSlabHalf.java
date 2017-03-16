package com.maw79.mods.blocks;

public class BlockSteelSlabHalf extends BlockSteelSlab {

		public BlockSteelSlabHalf(String unlocalizedName) {
			super(unlocalizedName);
		}

		/**
		 * Says that it isn't the double version of the block
		 */
		@Override
		public boolean isDouble() {
			return false;
		}

	}

