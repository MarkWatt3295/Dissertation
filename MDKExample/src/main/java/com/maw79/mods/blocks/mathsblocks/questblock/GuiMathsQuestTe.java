package com.maw79.mods.blocks.mathsblocks.questblock;


import java.io.IOException;

import com.maw79.mods.client.gui.GuiMathsQuestGive;
import com.maw79.mods.handlers.ModSoundHandler;
import com.maw79.mods.main.Reference;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.items.CapabilityItemHandler;

/**
 * The {@link BlockBreaker}'s gui
 * @author Mark Watt
 *
 */
public class GuiMathsQuestTe extends GuiContainer {

	/**
	 * The tile entity and player inventory
	 */
	private TileEntityMathsQuest te;
	private IInventory playerInv;
	GuiButton button1, button3, button4, button5, reward;
	final int BUTTON1= 1, BUTTON3 = 3, BUTTON4 = 4, BUTTON5 = 5, REWARD = 6;
	

	public boolean help = false;
	
	public String activequest = "";
	public static String questPrimeNumbers= "Prime Numbers";
	public static String questEvenNumbers= "Even Numbers";
	public static String questOddNumbers= "Odd Numbers";
	public static String questNumberSequence= "Number Sequence";
	
	public GuiMathsQuestTe(IInventory playerInv, TileEntityMathsQuest te) {
		super(new ContainerMathsQuest(playerInv, te));
		
		this.xSize = 176; //Texture xSize
		this.ySize = 166; //Texture ySize
		this.te = te;
		this.playerInv = playerInv;
		 
	}

	/**
	 * Draws the gui and the grey background behind it
	 */
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F); //Grey background
		if(help == true){
			mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/gui/container/mathsquesthelp.png"));
		}
		else{
		this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/gui/container/mathsquest.png"));
		}//Binds the texture for rendering
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize); //Draws our texture
	}
	
	/**
	 * Draws the text that is an overlay, i.e where it says Insulator in the gui on the top
	 */
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		if(GuiMathsQuestGive.questnumber == 1){
			activequest = "Prime Numbers";
		}
		else if(GuiMathsQuestGive.questnumber == 2){
			activequest = "Even Numbers";
		}
		else if(GuiMathsQuestGive.questnumber == 3){
			activequest = "Odd Numbers";
		}
		else if(GuiMathsQuestGive.questnumber == 4){
			activequest ="Number Sequence";
		}
		else{
			activequest = "No set Quest";
		}
    	
		//Default Strings
		String s = ("Maths Quest"); 
		String s2 = ("Current Quest : "+activequest);
		String s3 = "";
		String s4 = "";
		String s5 = "";
		String s6 = "";
		String findnums = "Visit Mr. Numbers For A Quest";
		
		if(GuiMathsQuestGive.questnumber == 1){ //Prime Nums
			 s = ("Maths Quest"); 
			 s2 = ("Current Quest : "+activequest);
			 s3 = "";
			 s4 = "";
			 s5 = "";
			 s6 = "";
			 findnums = "Numbers Left to find : "+TileEntityMathsQuest.primenumstofind;
			 if(TileEntityMathsQuest.primenumstofind == 0){
				 findnums = "QUEST COMPLETED";
				 button3.visible = false;
				 help = false;
				 button1.visible=false;
				 reward.visible = true;
				this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/gui/container/mathsquest.png"));
			 }
		}
		if(GuiMathsQuestGive.questnumber == 2){ //Even Nums
			 s = ("Maths Quest"); 
			 s2 = ("Current Quest : "+activequest);
			 s3 = "";
			 s4 = "";
			 s5 = "";
			 s6 = "";
			 findnums = "Numbers Left to find : "+TileEntityMathsQuest.evennumstofind;
			 if(TileEntityMathsQuest.evennumstofind == 0){
				 findnums = "QUEST COMPLETED";
				 button3.visible = false;
				 help = false;
				 button1.visible=false;
				 reward.visible = true;
				this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/gui/container/mathsquest.png"));
			 }
		}
		
		if(GuiMathsQuestGive.questnumber == 3){ //Odd Nums
			 s = ("Maths Quest"); 
			 s2 = ("Current Quest : "+activequest);
			 s3 = "";
			 s4 = "";
			 s5 = "";
			 s6 = "";
			 findnums = "Numbers Left to find : "+TileEntityMathsQuest.oddnumstofind;
			 if(TileEntityMathsQuest.oddnumstofind == 0){
				 findnums = "QUEST COMPLETED";
				 button3.visible = false;
				 help = false;
				 button1.visible=false;
				 reward.visible = true;
				this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/gui/container/mathsquest.png"));
			 }
		}
		if(GuiMathsQuestGive.questnumber == 4){ //Sequence Nums
			 s = ("Maths Quest"); 
			 s2 = ("Current Quest : "+activequest);
			 s3 = "";
			 s4 = "";
			 s5 = "";
			 s6 = "";
			 findnums = "Numbers Left to find : "+TileEntityMathsQuest.sequencenumstofind;
			 if(TileEntityMathsQuest.sequencenumstofind == 0){
				 findnums = "QUEST COMPLETED";
				 button3.visible = false;
				 help = false;
				 button1.visible=false;
				 reward.visible = true;
				this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/gui/container/mathsquest.png"));
			 }
		}
		
		
		if(help == true){
			 s = (activequest);
			 s2 = ("");
			 s3 = ("");
			 s4 = ("Visit Mr. Numbers");
			 s5 = ("To Start a Quest");
			 s6 = ("");
			 findnums = "";
		
			if(GuiMathsQuestGive.questnumber == 1){ //Prime Nums
			 s = (activequest + " Help");
			 s2 = ("Place Prime Numbers Here");
			 s3 = ("");
			 s4 = ("A Prime Number is a number");
			 s5 = ("that can only be divided");
			 s6 = ("by 1 and itself");
			 findnums = "";
		}
			if(GuiMathsQuestGive.questnumber == 2){//Even Nums
				 s = (activequest + " Help");
				 s2 = ("Place Even Numbers Here");
				 s3 = ("");
				 s4 = ("Even Numbers can be");
				 s5 = ("divided exactly by 2");
				 s6 = ("");
				 findnums = "";
			}
			if(GuiMathsQuestGive.questnumber == 3){//Odd Nums
				 s = (activequest + " Help");
				 s2 = ("Place Odd Numbers Here");
				 s3 = ("");
				 s4 = ("Odd Numbers cannot be");
				 s5 = ("divided exactly by 2");
				 s6 = ("");
				 findnums = "";
			}
			if(GuiMathsQuestGive.questnumber == 4){//Sequence Nums
				 s = (activequest + " Help");
				 s2 = ("Place Sequence Numbers here");
				 s3 = ("");
				 s4 = ("What are the next Numbers");
				 s5 = ("in the sequence ");
				 s6 = ("you are given?");
				 findnums = "";
			}
		}
			
	//DECIMAL COLOUR VALUES
		this.mc.fontRendererObj.drawString(s, this.xSize / 2 - this.mc.fontRendererObj.getStringWidth(s) / 2, 6, 30000); //Draws the block breaker name in the center on the top of the gui
		this.mc.fontRendererObj.drawString(s2, this.xSize / 2 - this.mc.fontRendererObj.getStringWidth(s2) / 2, 22, 4210752);
		this.mc.fontRendererObj.drawString(s3, this.xSize / 2 - this.mc.fontRendererObj.getStringWidth(s3) / 2, 58, 4210752);
		this.mc.fontRendererObj.drawString(s4, this.xSize / 2 - this.mc.fontRendererObj.getStringWidth(s4) / 2, 72, 4210752);
		this.mc.fontRendererObj.drawString(s5, this.xSize / 2 - this.mc.fontRendererObj.getStringWidth(s5) / 2, 82, 4210752);
		this.mc.fontRendererObj.drawString(s6, this.xSize / 2 - this.mc.fontRendererObj.getStringWidth(s6) / 2, 92, 4210752);
		this.mc.fontRendererObj.drawString(findnums, this.xSize / 2 - this.mc.fontRendererObj.getStringWidth(findnums) / 2, 62, 30000);
		
		 
		int actualMouseX = mouseX - ((this.width - this.xSize) / 2);
		int actualMouseY = mouseY - ((this.height - this.ySize) / 2);
		if(actualMouseX >= 134 && actualMouseX <= 149 && actualMouseY >= 17 && actualMouseY <= 32 && te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).getStackInSlot(9) == ItemStack.EMPTY) {
			
		}
	}
	@Override
    public void initGui() {
    	
        buttonList.clear();												//+120 -100
       // buttonList.add(button3 = new GuiButton(BUTTON3, (width / 2) + 80 / 2, (height/2) -5, 30, 20, "Help"));
       // buttonList.add(button2 = new GuiButton(BUTTON2, (width / 2) - 170 / 2, (height/2) -5, 40, 20, "Reset"));
        buttonList.add(button1 = new GuiButton(BUTTON1, (width / 2) + 80 / 2, (height/2) -50, 30, 20, "Back"));
        buttonList.add(button3 = new GuiButton(BUTTON3, (width / 2) - 20 , (height/2) -5, 40, 20, "Help"));
        buttonList.add(reward = new GuiButton(REWARD, (width / 2)-70 , (height/2) -5, 140, 20, "Now Return to Mr. Numbers"));
       // buttonList.add(button2 = new GuiButton(BUTTON2, (width / 2) -95 / 2, (height/2) -5, 40, 20, "Submit"));
      
      
        super.initGui();
        button1.visible = false;
        reward.visible = false;
        
    }
	  @Override
	    public boolean doesGuiPauseGame() {
	        return false;
	    }
	  
	 
	
	 @Override
	    public void actionPerformed(GuiButton button) throws IOException {
	    	
	    	
	        switch (button.id) {
	            case BUTTON1: //back
	            	help = false;
	            	button1.visible = false;
	            	drawGuiContainerBackgroundLayer(zLevel, BUTTON1, BUTTON1);
	            	button3.visible = true;
	            	
	            	break;
	            	
	          
	            	
	            case BUTTON3: //help
	            	
	            	mc.player.playSound(ModSoundHandler.STEEL_BUTTON_CLICK_OFF, 1.0f, 1.0f);
	            	
	            	help = true;
	            	button3.visible = false;
	            	drawGuiContainerBackgroundLayer(zLevel, BUTTON3, BUTTON3);
	            	button1.visible = true;
	            	
	            	break;
	            	
	            case REWARD: //help
	            	
	            	mc.player.playSound(ModSoundHandler.STEEL_BUTTON_CLICK_OFF, 1.0f, 1.0f);
	            	
	            	reward.visible = false;
	            	mc.player.closeScreen();
	            	
	            	break;
	            	
	        }
	      
	        super.actionPerformed(button);
	      
	    }
	
	 
	 private void onEvent() {
		
	}

	@Override
	    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
	      
	        super.mouseClicked(mouseX, mouseY, mouseButton);
	    }
	 
	
	 

}