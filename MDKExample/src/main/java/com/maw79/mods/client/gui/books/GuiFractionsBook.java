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
import com.maw79.mods.init.ModFractionsBlocks;
import com.maw79.mods.init.ModTools;
import com.maw79.mods.items.mathsitems.ItemFractionStamp;
import com.maw79.mods.main.Reference;
import com.maw79.mods.util.Utils;


public class GuiFractionsBook extends GuiScreen
{
	private final int bookImageHeight = 192;
	private final int bookImageWidth = 192;
	private int currPage = 0;
	private static final int bookTotalPages = 8;
	private static ResourceLocation[] bookPageTextures = new ResourceLocation[bookTotalPages];
	private static String[] stringPageText = new String[bookTotalPages];
	private GuiButton buttonDone, halfsbutton, thirdsbutton, quartersbutton;
    private NextPageButton buttonNextPage;
    private NextPageButton buttonPreviousPage;
    
	public GuiFractionsBook()
	{
		
	    bookPageTextures[0] = new ResourceLocation(Reference.MOD_ID+":textures/gui/book1.png");
	    bookPageTextures[1] = new ResourceLocation(Reference.MOD_ID+":textures/gui/book1.png");
	    bookPageTextures[2] = new ResourceLocation(Reference.MOD_ID+":textures/gui/book1.png");
	    bookPageTextures[3] = new ResourceLocation(Reference.MOD_ID+":textures/gui/book1.png");
	    bookPageTextures[4] = new ResourceLocation(Reference.MOD_ID+":textures/gui/book1.png");
	    bookPageTextures[5] = new ResourceLocation(Reference.MOD_ID+":textures/gui/book1.png");
	    bookPageTextures[6] = new ResourceLocation(Reference.MOD_ID+":textures/gui/book1.png");
	    bookPageTextures[7] = new ResourceLocation(Reference.MOD_ID+":textures/gui/book1.png");
	    
	    String hc = "Half Fraction Blocks Left to Answer : "+ "§3"+TileEntityRecycler.halfscorrect;
	    String sline1 = "";
	  
	    String sline3 = "";
	    
	    
	    if(TileEntityMathsQuest.evencomplete == true){
	    	sline3 = "This Quest is Complete";
	    }
	    
	    if(TileEntityRecycler.halfscorrect == 0){
			   hc = "Quest Complete";
		   }
	    stringPageText[0] = "§3"+"Fractions Book"+"§0"+"\n\nThis Book contains information on all "+"§3"+ "3 "+"§0"+ "of the Fraction Quests. You can use the buttons below for quick page navigation";
	    stringPageText[1] = "§3"+"How To Play"+"§0"+"\nUsing the provided tools you need to match Fraction Stamps with the Equivalent Fraction Block. Correct answers will give the blocks green ticks and give the player points. Incorrect answers will play error sounds and decrease player points."; 
	    stringPageText[2] = "§3"+"Stamps"+"§0"+"\n\nYou are given "+"§3"+ "1 Half"+"§0"+ " Stamp, "+"§3"+ "1 Third"+"§0"+ " Stamp "+"§0"+"and "+"§3"+ "1 Quarter"+"§0"+ " Stamp. Each Stamp has a durability of " +"§3"+ "5"+"§0"+". On each use the durability will decrease by "+"§3"+ "1"+"§0"+". More Stamps can be purchased via the "+"§3"+ "Scarecrow"+"§0"+"." ;
	    stringPageText[3] = "§3"+"Question Wand"+"§0"+"\n\nThe Wand is used to reveal Fraction Block Questions. Simply right click a Fraction Block to see the question. To answer the question click the block with the stamp that correctly answers the question.";
	    stringPageText[4] = "§3"+"Halfs"+"§0"+"\n\n\nRead the Block Questions Revealed by the Wand. If you think the answer is equal to 1 Half then select the block using the 1 Half Stamp. If Correct you will recieve Points to spend in stores."; 
	    stringPageText[5] = "§3"+"Thirds"+"§0"+"\n\n\nRead the Block Questions Revealed by the Wand. If you think the answer is equal to 1 Third then select the block using the 1 Third Stamp. If Correct you will recieve Points to spend in stores."; 
	    stringPageText[6] = "§3"+"Quarters"+"§0"+"\n\n\nRead the Block Questions Revealed by the Wand. If you think the answer is equal to 1 Quarter then select the block using the 1 Quarter Stamp. If Correct you will recieve Points to spend in stores."; 
	    stringPageText[7] = "§3"+"Halfs Quest:\n"+"§0"+hc+"\n\n"+"Thirds Quest:\n"+"§0"+hc+"\n\n"+"Quarters Quest:\n"+"§0"+hc+"\n\n";
	    
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
        halfsbutton = new GuiButton(2, width / 2 -60, bookImageHeight - 80, 60, 20, "Halfs");
        thirdsbutton = new GuiButton(3, width / 2 -60, bookImageHeight - 60, 60, 20, "Thirds");
        quartersbutton = new GuiButton(4, width / 2 -60, bookImageHeight - 40, 60, 20, "Quarters");
       
		//BUTTON LIST		
		buttonList.add(buttonDone);
		buttonList.add(halfsbutton);
		buttonList.add(thirdsbutton);
		buttonList.add(quartersbutton);
        int offsetFromScreenLeft = (width - bookImageWidth) / 2;
        buttonList.add(buttonNextPage = new NextPageButton(1, offsetFromScreenLeft + 120, 156, true));
        buttonList.add(buttonPreviousPage = new NextPageButton(2, offsetFromScreenLeft + 38, 156, false));
        buttonDone.visible = false;
        buttonPreviousPage.visible = false;
        halfsbutton.visible = false;
        thirdsbutton.visible = false;
        quartersbutton.visible = false;
       
    }

    /**
     * Called from the main game loop to update the screen.
     */
    @Override
	public void updateScreen() 
    {
    	
    	if(currPage == 0){
    		halfsbutton.visible = true;
    		thirdsbutton.visible = true;
    		quartersbutton.visible = true;
    	}
    	else{
    		halfsbutton.visible = false;
    		thirdsbutton.visible = false;
    		quartersbutton.visible = false;
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
    	if (parButton == halfsbutton)
    	{
    		currPage =4;
    		// DEBUG
    		System.out.println("actionPerformed() HalfsButton");
    		
    	}
    	else if (parButton == thirdsbutton)
    	{
    		currPage =5;
    		// DEBUG
    		System.out.println("actionPerformed() ThirdsButton");
    		
    	}
    	else if (parButton == quartersbutton)
    	{
    		currPage =6;
    		// DEBUG
    		System.out.println("actionPerformed() QuartersButton");
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