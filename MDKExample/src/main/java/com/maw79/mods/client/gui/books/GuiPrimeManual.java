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


public class GuiPrimeManual extends GuiScreen
{
	private final int bookImageHeight = 192;
	private final int bookImageWidth = 192;
	private int currPage = 0;
	private static final int bookTotalPages = 3;
	private static ResourceLocation[] bookPageTextures = new ResourceLocation[bookTotalPages];
	private static String[] stringPageText = new String[bookTotalPages];
	private GuiButton buttonDone, numberFinder;
    private NextPageButton buttonNextPage;
    private NextPageButton buttonPreviousPage;
    
	public GuiPrimeManual()
	{
		
	    bookPageTextures[0] = new ResourceLocation(Reference.MOD_ID+":textures/gui/book1.png");
	    bookPageTextures[1] = new ResourceLocation(Reference.MOD_ID+":textures/gui/book1.png");
	    bookPageTextures[2] = new ResourceLocation(Reference.MOD_ID+":textures/gui/book1.png");
	    
	   
	    String s0 = TileEntityMathsQuest.primearray[0];
	    String s1 = TileEntityMathsQuest.primearray[1];
	    String s2 = TileEntityMathsQuest.primearray[2];
	    String s3 = TileEntityMathsQuest.primearray[3];
	    String s4 = TileEntityMathsQuest.primearray[4];
	    String s5 = TileEntityMathsQuest.primearray[5];
	    String s6 = TileEntityMathsQuest.primearray[6];
	    String s7 = TileEntityMathsQuest.primearray[7];
	   
	   
	    String sline1 = "Numbers Left to Find : "+"§9"+TileEntityMathsQuest.primenumstofind +"\n"+"§0";
	    String sline2 = "§c"+s0+s1+ s2+s3+"\n"+s4 +s5+s6+s7;
	    String sline3 = "";
	    
	    
	    if(TileEntityMathsQuest.primecomplete == true){
	    	sline3 = "This Quest is Complete";
	    }
	    stringPageText[0] = "§c"+"Prime Numbers Quest \n\n"+"§0"+ "Prime numbers are special numbers that can only be divided by themselves and 1. \n\n" +"§c"+"Prime Number Example \n\n"+"§0"+"19 is a prime number. It can only be divided by "+"§c"+ "1"+"§0"+ " and " +"§c"+ "19"+"§0";
	    stringPageText[1] = "§c"+"How To Play"+"§0"+"\n\nSearch underground for Prime Number blocks.  There are "+"§c"+"8 "+"§0"+"Prime Number blocks to find. Bring the blocks to the Maths Quest Block and submit them."; 
	    stringPageText[2] = "§c"+"Number Finder"+"§0"+"\n\n"+ sline1+ "\nYou have found:\n"+ sline2 + "\n\n"+ "§2"+ sline3 ;
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
        numberFinder = new GuiButton(1, width / 2 -60, bookImageHeight - 42, 60, 20, "Finder");
       
		//BUTTON LIST		
		buttonList.add(buttonDone);
		buttonList.add(numberFinder);
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
    	
    	if(currPage == 0){
    		numberFinder.visible = true;
    	}
    	else{
    		numberFinder.visible = false;
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
    	if (parButton == numberFinder)
    	{
    		currPage =2;
    		// DEBUG
    		System.out.println("actionPerformed() numberFinder");
    		
    	}
    else if (parButton == buttonDone)
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