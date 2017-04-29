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

import com.maw79.mods.blocks.historyblocks.romanquests.TileEntityRomanQuest;
import com.maw79.mods.client.gui.GuiNotif;
import com.maw79.mods.main.Reference;
import com.maw79.mods.util.Utils;


public class GuiRomanArtifactsManual extends GuiScreen
{
	private final int bookImageHeight = 192;
	private final int bookImageWidth = 192;
	private int currPage = 0;
	private static final int bookTotalPages = 14;
	private static ResourceLocation[] bookPageTextures = new ResourceLocation[bookTotalPages];
	private static String[] stringPageText = new String[bookTotalPages];
	private GuiButton buttonDone, buttonTrack, buttonClear, item1, item2, item3, item4, item5, item6, item7, item8, item9,item10,menu;
    private NextPageButton buttonNextPage;
    private NextPageButton buttonPreviousPage;
    
	public GuiRomanArtifactsManual()
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
	    bookPageTextures[11] = new ResourceLocation(Reference.MOD_ID+":textures/gui/book1.png");
	    bookPageTextures[12] = new ResourceLocation(Reference.MOD_ID+":textures/gui/book1.png");
	    bookPageTextures[13] = new ResourceLocation(Reference.MOD_ID+":textures/gui/book1.png");
	    
	    stringPageText[0] = "§c"+"Roman Artifacts Manual"+"§0"+"\n\nThis Book contains information on the "+"§c"+ "Roman Artifacts Quest"+"§0"+ ".\n\nThere are "+"§c"+ "10 Artifacts"+"§0"+" hidden around the Roman section.\nFind them and bring them back to the Quest block for a reward.";
	    stringPageText[1] = "§c"+"How To Play"+"§0"+"\n\nSearch around for the "+"§c"+ "10"+"§0"+" Roman Artifacts. Collecting them will teach you some brief History and earn you points."; 
	    stringPageText[2] = "§c"+"Quick Links"; 
	    stringPageText[3] = "Item 1 - "+"§c"+"Hunt Cup"+"§0"+"\n\nHunting was a  very popular sport with the Romans.Cups where awarded to winners of Sports and Games. Cups where handmade and decorated with paintings representing the hunt or game."+ "\n\n"+TileEntityRomanQuest.itemnotfound1;
	    stringPageText[4] = "Item 2 - "+"§c"+"Tombstone"+"§0"+"\n\nThe Romans where some of the first to use detailed tombstones. Tombstones where created from Limestone and had hand crafted imagery and inscriptions giving an incite into the deceased's life."+ "\n"+TileEntityRomanQuest.itemnotfound2;
	    stringPageText[5] = "Item 3 - "+"§c"+"Actors Mask"+"§0"+"\n\nThe Romans created pottery masks for plays, partys and funerals. The masks would be handmade and only wealthy Romans would own them."+ "\n\n"+TileEntityRomanQuest.itemnotfound3;
	    stringPageText[6] = "Item 4 - "+"§c"+"Roman Coin"+"§0"+"\n\nRoman emperors had there sigils or faces imprinted on coins to show there elivated status and power."+ "\n\n"+TileEntityRomanQuest.itemnotfound4;
	    stringPageText[7] = "Item 5 - "+"§c"+"Drain Pipe"+"§0"+"\n\nThe Romans where fantastic architects. They designed and built buildings with working drain and sewage systems. Lead was often used to create pipes used by the Romans."+ "\n\n"+TileEntityRomanQuest.itemnotfound5;
	    stringPageText[8] = "Item 6 - "+"§c"+"Cooking Pot"+"§0"+"\n\nThe Romans would hang Copper Cooking Pots over fires in order to cook food. Roman cooks would be responsible for the cleaning and maintenance of these pots."+ "\n\n"+TileEntityRomanQuest.itemnotfound6;
	    stringPageText[9] = "Item 7 - "+"§c"+"Statues"+"§0"+"\n\nThe Romans sculpted statues from many different materials. Marble and Limestone where very popular choices. Statues where often sculpted in the shape of Roman Emporers and Roman Gods."+ "\n\n"+TileEntityRomanQuest.itemnotfound7;
	    stringPageText[10] = "Item 8 - "+"§c"+"Terracotta Tiles"+"§0"+"\n\nThe Romans designed and made Terrocotta Roof and Floor Tiles. The Tiles often had intricate patterns and designs to reflect wealth."+ "\n\n"+TileEntityRomanQuest.itemnotfound8;
	    stringPageText[11] = "Item 9 - "+"§c"+"Amethyst Intaglio"+"§0"+"\n\nAn Intaglio is a gem or precious stone that has been engraved. Usually the carving would be done on the flat back of the gem allowing the engraving to be viewed through the stone."+ "\n\n"+TileEntityRomanQuest.itemnotfound9;
	    stringPageText[12] = "Item 10 - "+"§c"+"Burrial Urn"+"§0"+"\n\nIn Roman Times the deceased where often cremated. The ashs where sealed in burial urns and placed in family resting halls. The urns had intricate designs and embosements."+ "\n\n"+TileEntityRomanQuest.itemnotfound10;
	    stringPageText[13] = "§c"+"Hints"+"§0"+"\n\nHave you checked out the Coloseum?\n\nHave you had a look around the Example Domus?.\n";
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
        buttonTrack = new GuiButton(1, width / 2 -10, bookImageHeight - 112, 60, 20, "Track");
        buttonClear = new GuiButton(2, width / 2 -10, bookImageHeight - 92, 60, 20, "Clear");
        item1 = new GuiButton(3, width / 2 -60, bookImageHeight - 142, 50, 20, "Item 1");
        item2 = new GuiButton(4, width / 2 , bookImageHeight - 142, 50, 20, "Item 2");
        item3 = new GuiButton(5, width / 2 -60, bookImageHeight - 122, 50, 20, "Item 3");
        item4 = new GuiButton(6, width / 2 , bookImageHeight - 122, 50, 20, "Item 4");
        item5 = new GuiButton(7, width / 2 -60, bookImageHeight - 102, 50, 20, "Item 5");
        item6 = new GuiButton(8, width / 2 , bookImageHeight - 102, 50, 20, "Item 6");
        item7 = new GuiButton(9, width / 2 -60, bookImageHeight - 82, 50, 20, "Item 7");
        item8 = new GuiButton(10, width / 2 , bookImageHeight - 82, 50, 20, "Item 8");
        item9 = new GuiButton(11, width / 2 -60, bookImageHeight - 62, 50, 20, "Item 9");
        item10 = new GuiButton(12, width / 2 , bookImageHeight - 62, 50, 20, "Item 10");
        menu = new GuiButton(13, width / 2 -60 , bookImageHeight - 182, 30, 20, "Menu");
        
      
		//BUTTON LIST		
        buttonList.add(item1);
        buttonList.add(item2);
        buttonList.add(item3);
        buttonList.add(item4);
        buttonList.add(item5);
        buttonList.add(item6);
        buttonList.add(item7);
        buttonList.add(item8);
        buttonList.add(item9);
        buttonList.add(item10);
        buttonList.add(menu);
		buttonList.add(buttonDone);
		buttonList.add(buttonTrack);
		buttonList.add(buttonClear);
        int offsetFromScreenLeft = (width - bookImageWidth) / 2;
        buttonList.add(buttonNextPage = new NextPageButton(1, offsetFromScreenLeft + 120, 156, true));
        buttonList.add(buttonPreviousPage = new NextPageButton(2, offsetFromScreenLeft + 38, 156, false));
        buttonDone.visible = false;
        buttonTrack.visible=false;
        buttonClear.visible=false;
        buttonPreviousPage.visible = false;
        item1.visible=false;
		item2.visible=false;
		item3.visible=false;
		item4.visible=false;
		item5.visible=false;
		item6.visible=false;
		item7.visible=false;
		item8.visible=false;
		item9.visible=false;
		item10.visible=false;
		menu.visible=false;
       
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
    	if(currPage > 2){
       	 menu.visible = true;
       }
   	 else {
       	 menu.visible = false;
       }
         
    	if(currPage == bookTotalPages -1){
    		buttonDone.visible = true;
    		buttonTrack.visible = false;
    		buttonClear.visible = false;
    	}
       
        else{
        	buttonDone.visible = false; 
        }
    	
    	if(currPage == 2 ){
    		item1.visible=true;
    		item2.visible=true;
    		item3.visible=true;
    		item4.visible=true;
    		item5.visible=true;
    		item6.visible=true;
    		item7.visible=true;
    		item8.visible=true;
    		item9.visible=true;
    		item10.visible=true;
    		
    	}
    
    	else {
    		item1.visible=false;
    		item2.visible=false;
    		item3.visible=false;
    		item4.visible=false;
    		item5.visible=false;
    		item6.visible=false;
    		item7.visible=false;
    		item8.visible=false;
    		item9.visible=false;
    		item10.visible=false;
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
       
        else if (parButton == buttonClear)
        {
      	  GuiNotif.xyztrack =" ";
        }
        else if (parButton == buttonPreviousPage)
        {
            if (currPage > 0)
            {
                --currPage;
            }
        }
        else if (parButton == item1)
        {
          Utils.getLogger().info("Item 1 Pressed");
          currPage = 3;
        }
        else if (parButton == item2)
        {
          Utils.getLogger().info("Item 2 Pressed");
          currPage = 4;
        }
        else if (parButton == item3)
        {
          Utils.getLogger().info("Item 3 Pressed");
          currPage = 5;
        }
        else if (parButton == item4)
        {
          Utils.getLogger().info("Item 4 Pressed");
          currPage = 6;
        }
        else if (parButton == item5)
        {
          Utils.getLogger().info("Item 5 Pressed");
          currPage = 7;
        }
        else if (parButton == item6)
        {
          Utils.getLogger().info("Item 6 Pressed");
          currPage = 8;
        }
        else if (parButton == item7)
        {
          Utils.getLogger().info("Item 7 Pressed");
          currPage = 9;
        }
        else if (parButton == item8)
        {
          Utils.getLogger().info("Item 8 Pressed");
          currPage = 10;
        }
        else if (parButton == item9)
        {
          Utils.getLogger().info("Item 9 Pressed");
          currPage = 11;
        }
        else if (parButton == item10)
        {
          Utils.getLogger().info("Item 10 Pressed");
          currPage = 12;
        }
        else if (parButton == menu)
        {
          Utils.getLogger().info("Menu Pressed");
          currPage = 2;
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