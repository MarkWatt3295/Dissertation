package com.maw79.mods.client.gui.books;




import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.maw79.mods.blocks.mathsblocks.questblock.TileEntityMathsQuest;
import com.maw79.mods.blocks.mathsblocks.recycler.TileEntityRecycler;
import com.maw79.mods.blocks.pointsblocks.TileEntityPointsBlock;
import com.maw79.mods.init.ModFractionsBlocks;
import com.maw79.mods.init.ModTools;
import com.maw79.mods.items.mathsitems.ItemFractionStamp;
import com.maw79.mods.main.Reference;
import com.maw79.mods.util.Utils;


public class GuiCoordinatesManual extends GuiScreen
{
	private final int bookImageHeight = 192;
	private final int bookImageWidth = 192;
	private int currPage = 0;
	private static final int bookTotalPages = 11;
	private static ResourceLocation[] bookPageTextures = new ResourceLocation[bookTotalPages];
	private static String[] stringPageText = new String[bookTotalPages];
	private GuiButton buttonDone;
    private NextPageButton buttonNextPage;
    private NextPageButton buttonPreviousPage;
    
	public GuiCoordinatesManual()
	{
		
	    bookPageTextures[0] = new ResourceLocation(Reference.MOD_ID+":textures/gui/book1.png");
	    bookPageTextures[1] = new ResourceLocation(Reference.MOD_ID+":textures/gui/book1.png");
	    bookPageTextures[2] = new ResourceLocation(Reference.MOD_ID+":textures/gui/book1.png");
	    bookPageTextures[3] = new ResourceLocation(Reference.MOD_ID+":textures/gui/book1.png");
	    bookPageTextures[4] = new ResourceLocation(Reference.MOD_ID+":textures/gui/book1.png");
	    bookPageTextures[5] = new ResourceLocation(Reference.MOD_ID+":textures/gui/book1.png");
	    bookPageTextures[6] = new ResourceLocation(Reference.MOD_ID+":textures/gui/book1.png");
	    bookPageTextures[7] = new ResourceLocation(Reference.MOD_ID+":textures/gui/book1.png");
	    bookPageTextures[8] = new ResourceLocation(Reference.MOD_ID+":textures/gui/book1.png");
	    bookPageTextures[9] = new ResourceLocation(Reference.MOD_ID+":textures/gui/book1.png");
	    bookPageTextures[10] = new ResourceLocation(Reference.MOD_ID+":textures/gui/book1.png");
	    
	    stringPageText[0] = "§3"+"Coordinates Manual"+"§0"+"\n\nThis Book contains information on the "+"§3"+ "Coordinates Quest"+"§0"+ ".\n\nFarmer Joe has lost his items. He needs your help to find them.\nFollow the coordinates in this book to retrieve his items.";
	    stringPageText[1] = "§3"+"How To Play"+"§0"+"\nYou must find Farmer Joe's lost items. Joe has given you the coordinates for all "+"§3"+ "8"+"§0"+" of his lost items. You need to go to each set of coordinates to find the items.\nYou have also been given tools to help you track your "+"§c"+"X"+"§0"+" ,"+"§a"+" Y"+"§0"+" and "+"§9"+" Z"+"§0"+" positions."; 
	    stringPageText[2] = "§3"+"XYZ Tools"+"§0"+"\n\n"+"§0"+"Each Tool Can be used to help guide you along an Axis.\n\n"+"§0"+"When holding an Axis tool, Right click to move "+"§a"+"Positively "+"§0"+"and shift right click to move "+"§c"+"Negatively"+"§0"+"."; 
	    stringPageText[3] = "§3"+"Coordinates #1"+"§0"+"\n\nThe first Item is located at :\n\n"+"§c"+"X: "+"§0"+"349.1\n\n"+"§a"+"Y: "+"§0"+"321\n\n"+"§9"+"Z: "+"§0"+"-845\n\n"+ "§0"+ "\nItem Found";
	    stringPageText[4] = "§3"+"Coordinates #2"+"§0"+"\n\nThe first Item is located at :\n\n"+"§c"+"X: "+"§0"+"349.1\n\n"+"§a"+"Y: "+"§0"+"321\n\n"+"§9"+"Z: "+"§0"+"-845\n\n"+ "§0"+ "\nItem Found";
	    stringPageText[5] = "§3"+"Coordinates #3"+"§0"+"\n\nThe first Item is located at :\n\n"+"§c"+"X: "+"§0"+"349.1\n\n"+"§a"+"Y: "+"§0"+"321\n\n"+"§9"+"Z: "+"§0"+"-845\n\n"+ "§0"+ "\nItem Found";
	    stringPageText[6] = "§3"+"Coordinates #4"+"§0"+"\n\nThe first Item is located at :\n\n"+"§c"+"X: "+"§0"+"349.1\n\n"+"§a"+"Y: "+"§0"+"321\n\n"+"§9"+"Z: "+"§0"+"-845\n\n"+ "§0"+ "\nItem Found";
	    stringPageText[7] = "§3"+"Coordinates #5"+"§0"+"\n\nThe first Item is located at :\n\n"+"§c"+"X: "+"§0"+"349.1\n\n"+"§a"+"Y: "+"§0"+"321\n\n"+"§9"+"Z: "+"§0"+"-845\n\n"+ "§0"+ "\nItem Found";
	    stringPageText[8] = "§3"+"Coordinates #6"+"§0"+"\n\nThe first Item is located at :\n\n"+"§c"+"X: "+"§0"+"349.1\n\n"+"§a"+"Y: "+"§0"+"321\n\n"+"§9"+"Z: "+"§0"+"-845\n\n"+ "§0"+ "\nItem Found";
	    stringPageText[9] = "§3"+"Coordinates #7"+"§0"+"\n\nThe first Item is located at :\n\n"+"§c"+"X: "+"§0"+"349.1\n\n"+"§a"+"Y: "+"§0"+"321\n\n"+"§9"+"Z: "+"§0"+"-845\n\n"+ "§0"+ "\nItem Found";
	    stringPageText[10] = "§3"+"Coordinates #8"+"§0"+"\n\nThe first Item is located at :\n\n"+"§c"+"X: "+"§0"+"349.1\n\n"+"§a"+"Y: "+"§0"+"321\n\n"+"§9"+"Z: "+"§0"+"-845\n\n"+ "§0"+ "\nItem Found";
	
	}

    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
    @Override
	public void initGui() 
    {
        //buttonList.clear();
       Keyboard.enableRepeatEvents(true);
        buttonDone = new GuiButton(0, width / 2 -30, bookImageHeight - 42, 60, 20, "Done");
      
		//BUTTON LIST		
		buttonList.add(buttonDone);
        int offsetFromScreenLeft = (width - bookImageWidth) / 2;
        buttonList.add(buttonNextPage = new NextPageButton(1, offsetFromScreenLeft + 120, 156, true));
        buttonList.add(buttonPreviousPage = new NextPageButton(2, offsetFromScreenLeft + 38, 156, false));
        buttonDone.visible = false;
        buttonPreviousPage.visible = false;
       
    }

    /**
     * Called from the main game loop to update the screen.
     */
    @Override
	public void updateScreen() 
    {
    	
    	if(currPage < bookTotalPages -1){
    		buttonNextPage.visible = true;
    	}
    	
    	else if(currPage == bookTotalPages -1){
    		buttonNextPage.visible = false;
    	}
    	
    	if(currPage == 0){
        	 buttonPreviousPage.visible = false;
        }
    	 else if(currPage > 0){
        	 buttonPreviousPage.visible = true;
        }
         
    	if(currPage == bookTotalPages -1){
    		buttonDone.visible = true;
    	}
       
        else{
        	buttonDone.visible = false;
        	
        	
        	 
        }
    }
	
    /**
     * Draws the screen and all the components in it.
     */
    @Override
	public void drawScreen(int parWidth, int parHeight, float p_73863_3_)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        if (currPage == 0)
    	{
        	mc.getTextureManager().bindTexture(bookPageTextures[0]);
    	}
        else if (currPage == 1)
        {
        	mc.getTextureManager().bindTexture(bookPageTextures[1]);
        }
       
        else
        {
        	mc.getTextureManager().bindTexture(bookPageTextures[0]);	
        }
        int offsetFromScreenLeft = (width - bookImageWidth ) / 2;
        drawTexturedModalRect(offsetFromScreenLeft, 2, 0, 0, bookImageWidth, bookImageHeight);
        int widthOfString;
        String stringPageIndicator = I18n.format("book.pageIndicator", new Object[] {Integer.valueOf(currPage + 1), bookTotalPages});

        widthOfString = fontRendererObj.getStringWidth(stringPageIndicator);
        fontRendererObj.drawString(stringPageIndicator, offsetFromScreenLeft - widthOfString + bookImageWidth - 44, 18, 0);
        fontRendererObj.drawSplitString(stringPageText[currPage], offsetFromScreenLeft + 36, 34, 116, 0);

        super.drawScreen(parWidth, parHeight, p_73863_3_);
    }


    @Override
	protected void actionPerformed(GuiButton parButton) 
    {
    	
     if (parButton == buttonDone)
    	{
    		// DEBUG
    		System.out.println("actionPerformed() buttonDone");
    		
    		mc.displayGuiScreen((GuiScreen)null);
    	}
        else if (parButton == buttonNextPage)
        {
            if (currPage < bookTotalPages - 1)
            {
                ++currPage;
            }
        }
        else if (parButton == buttonPreviousPage)
        {
            if (currPage > 0)
            {
                --currPage;
            }
        }
        
       
    }

   

    private void buttoncall() {
	System.out.println("Called b1 call");
		
	}

	/**
     * Returns true if this GUI should pause the game when it is displayed in single-player
     */
    @Override
	public boolean doesGuiPauseGame()
    {
        return true;
    }
    
    @SideOnly(Side.CLIENT)
    static class NextPageButton extends GuiButton
    {
        private final boolean isNextButton;

        public NextPageButton(int parButtonId, int parPosX, int parPosY, boolean parIsNextButton)
        {
            super(parButtonId, parPosX, parPosY, 23, 13, "");
            isNextButton = parIsNextButton;
        }

        /**
         * Draws this button to the screen.
         */
        @Override
		public void drawButton(Minecraft mc, int parX, int parY)
        {
            if (visible)
            {
                boolean isButtonPressed = parX >= xPosition && parY >= yPosition && parX < xPosition + width && parY < yPosition + height;
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                mc.getTextureManager().bindTexture(bookPageTextures[0]);
                int textureX = 0;
                int textureY = 192;

                if (isButtonPressed)
                {
                    textureX += 23;
                }

                if (!isNextButton)
                {
                    textureY += 13;
                }

                drawTexturedModalRect(xPosition, yPosition, textureX, textureY, 23, 13);
            }
        }
    }
}