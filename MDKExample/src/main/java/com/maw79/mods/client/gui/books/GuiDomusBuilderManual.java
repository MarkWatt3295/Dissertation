package com.maw79.mods.client.gui.books;




import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.maw79.mods.blocks.mathsblocks.questblock.TileEntityMathsQuest;
import com.maw79.mods.main.Reference;
import com.maw79.mods.util.Utils;


public class GuiDomusBuilderManual extends GuiScreen
{
	private final int bookImageHeight = 192;
	private final int bookImageWidth = 192;
	private int currPage = 0;
	private static final int bookTotalPages = 4;
	private static ResourceLocation[] bookPageTextures = new ResourceLocation[bookTotalPages];
	private static String[] stringPageText = new String[bookTotalPages];
	private GuiButton buttonDone;
    private NextPageButton buttonNextPage;
    private NextPageButton buttonPreviousPage;
    
	public GuiDomusBuilderManual()
	{
		
	    bookPageTextures[0] = new ResourceLocation(Reference.MOD_ID+":textures/gui/book1.png");
	    bookPageTextures[1] = new ResourceLocation(Reference.MOD_ID+":textures/gui/book1.png");
	    bookPageTextures[2] = new ResourceLocation(Reference.MOD_ID+":textures/gui/book1.png");
	    bookPageTextures[3] = new ResourceLocation(Reference.MOD_ID+":textures/gui/book1.png");
	    
	    stringPageText[0] = "§d"+"Domus Builder Quest"+"§0"+"\n\nIn Ancient Rome the wealthy Romans lived in houses known as "+"§d"+ "Domus's"+"§0"+ ".\n\n"+"§d"+"Example Domus\n"+"§0"+ "To your left there is a premade Domus. Why not take a look around for some inspiration.";
	    stringPageText[1] = "§d"+"How To Play"+"§0"+"\nYou are given a Builder Coin. Equip this item and right click to activate build mode. In this mode you will have 5 minutes to build your own Roman Domus using materials supplied in the Chests. When your 5 minutes is up your partner will judge your domus using the Domus Scorer."; 
	    stringPageText[2] = "§d"+"Domus Scorer"+"§0"+"\n\nThe Domus Scorer is the block used to score the player made buildings. Points can be rewarded for having matching Domus Features.\n\nThe Domus Scorer only becomes active after a Build modes time expires.";
	    stringPageText[3] = "§d"+"Hints"+"§0"+"\n\nEquip all of the materials you want to use before activating the Build Coin.\n\nIf you have enough points you can purchase addition Build Coins for more building time.";
	}

    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
    @Override
	public void initGui() 
    {
       Keyboard.enableRepeatEvents(true);
        buttonDone = new GuiButton(0, width / 2 -30, bookImageHeight - 42, 60, 20, "Done");
       
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