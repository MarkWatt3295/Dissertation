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



import com.maw79.mods.main.Reference;


public class GuiHistoryBook extends GuiScreen
{
	private final int bookImageHeight = 192;
	private final int bookImageWidth = 192;
	private int currPage = 0;
	private static final int bookTotalPages = 9;
	private static ResourceLocation[] bookPageTextures = new ResourceLocation[bookTotalPages];
	private static String[] stringPageText = new String[bookTotalPages];
	private GuiButton buttonDone, button1, backbutton;
    private NextPageButton buttonNextPage;
    private NextPageButton buttonPreviousPage;
    
	public GuiHistoryBook()
	{
		
	    bookPageTextures[0] = new ResourceLocation(Reference.MOD_ID+":textures/gui/book1.png");
	    bookPageTextures[1] = new ResourceLocation(Reference.MOD_ID+":textures/gui/book1.png");
	    bookPageTextures[2] = new ResourceLocation(Reference.MOD_ID+":textures/gui/book1.png");
	    bookPageTextures[3] = new ResourceLocation(Reference.MOD_ID+":textures/gui/book1.png");
	    bookPageTextures[4] = new ResourceLocation(Reference.MOD_ID+":textures/gui/book1.png");
	    bookPageTextures[5] = new ResourceLocation(Reference.MOD_ID+":textures/gui/book1.png");
	    bookPageTextures[6] = new ResourceLocation(Reference.MOD_ID+":textures/gui/screenshot.png");
	    bookPageTextures[7] = new ResourceLocation(Reference.MOD_ID+":textures/gui/bookscreenshot.png");
	    bookPageTextures[8] = new ResourceLocation(Reference.MOD_ID+":textures/gui/book.png");
	    stringPageText[0] = "This is your History Book";
	    stringPageText[1] = "There are Three Different History Activitys available.\n \n- Historic Walks \n\n- Relic Hunter\n\n- Pier Building.";
	    stringPageText[2] = "Historic Walks \n \nHas you take a short walk and learn some Historic Facts.";
	    stringPageText[3] = "Relic Hunter \n \nIn Relic Hunter you are sent off to look for artifacts and relics.\n\nYou are given a pickaxe and must dig for these items.";
	    stringPageText[4] = "Pier Building \n \nIn Pier Building you must create a building from a set era. You are only allowed to use materials that where available during that time. Your partner will then judge and score your building.";
	    stringPageText[5] = "SS Page";
	    stringPageText[6] = "S2 Page";
	    stringPageText[7] = "S3 Page";
	    stringPageText[8] = "Final Page";
	}

    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
    @Override
	public void initGui() 
    {
        //buttonList.clear();
       // Keyboard.enableRepeatEvents(true);
        buttonDone = new GuiButton(0, width / 2 -40, bookImageHeight - 58, 80, 20, "Done");
		button1 = new GuiButton(1, width / 2 - 50 , bookImageHeight - 70, 90, 20, "View Screenshot");
		backbutton = new GuiButton(2, width / 2 -40, bookImageHeight - 58, 80, 20, "Back");
       
		//BUTTON LIST		
		buttonList.add(buttonDone);
        buttonList.add(button1);
        buttonList.add(backbutton);
        int offsetFromScreenLeft = (width - bookImageWidth) / 2;
        buttonList.add(buttonNextPage = new NextPageButton(1, offsetFromScreenLeft + 120, 156, true));
        buttonList.add(buttonPreviousPage = new NextPageButton(2, offsetFromScreenLeft + 38, 156, false));
        buttonDone.visible = false;
        button1.visible = false;
        buttonPreviousPage.visible = false;
        backbutton.visible = false;
    }

    /**
     * Called from the main game loop to update the screen.
     */
    @Override
	public void updateScreen() 
    {
    	if(currPage == 5){
    		backbutton.visible = true;
    	}
    	else if(currPage > 5){
    		backbutton.visible = false;
    	}
    	else if(currPage < 5){
    		backbutton.visible = false;
    	}
    	
    	
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
       
        else if(currPage == 2){
        	button1.visible = true;
        }
    	
        
    	
       
        else{
        	buttonDone.visible = false;
        	button1.visible = false;
        	//backbutton.visible = false;
        	
        	 
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
        else if (currPage == 2)
        {
        	mc.getTextureManager().bindTexture(bookPageTextures[2]);
        }
        else if (currPage == 3)
        {
        	mc.getTextureManager().bindTexture(bookPageTextures[3]);
        }
        else if (currPage == 4)
        {
        	mc.getTextureManager().bindTexture(bookPageTextures[4]);
        }
        else if (currPage == 5)
        {
        	mc.getTextureManager().bindTexture(bookPageTextures[5]);
        }
        else if (currPage == 6)
        {
        	mc.getTextureManager().bindTexture(bookPageTextures[6]);
        }
        else if (currPage == 7)
        {
        	mc.getTextureManager().bindTexture(bookPageTextures[7]);
        }
        else if (currPage == 8)
        {
        	mc.getTextureManager().bindTexture(bookPageTextures[8]);
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
        else if (parButton == button1)
    	{
    		button1.visible=false;
    		currPage = 5;
    		
    		 
    	}
        else if (parButton == backbutton)
    	{
    		currPage = 2;
    		buttonDone.visible = false;
    		backbutton.visible = false;
    	}
    }

   

    private void buttoncall() {
	System.out.println("Called b1 call");
	backbutton.visible = true;	
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