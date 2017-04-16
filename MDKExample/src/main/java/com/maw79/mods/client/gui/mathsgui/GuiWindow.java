package com.maw79.mods.client.gui.mathsgui;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.maw79.mods.main.Reference;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class GuiWindow extends GuiContainer {

	int i = 0;
	int j = 0;
	int k = 0;
	EntityPlayer entity = null;

	GuiTextField textbox;

	public GuiWindow(World world, int i, int j, int k, EntityPlayer entity) {
		super(new GuiContainerMod(world, i, j, k, entity));
		this.i = i;
		this.j = j;
		this.k = k;
		this.entity = entity;
		this.xSize = 176;
		this.ySize = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/division.png");

	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		int posX = (this.width) / 2;
		int posY = (this.height) / 2;
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

		this.mc.renderEngine.bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);

		zLevel = 100.0F;

	}

	protected void mouseClicked(int par1, int par2, int par3) throws java.io.IOException {
		super.mouseClicked(par1, par2, par3);

		this.textbox.mouseClicked(par1, par2, par3);
	}

	public void updateScreen() {
	
		int posX = (this.width) / 2;
		int posY = (this.height) / 2;

		this.textbox.updateCursorCounter();
		super.updateScreen();
	}

	@Override
	protected void keyTyped(char par1, int par2) throws java.io.IOException {

		super.keyTyped(par1, par2);

		this.textbox.textboxKeyTyped(par1, par2);

	}

	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		int posX = (this.width) / 2;
		int posY = (this.height) / 2;
		this.fontRendererObj.drawString("Answer 1", (66), (36), 0xffffff);
		this.fontRendererObj.drawString("Answer 2", (66), (69), 0xffffff);
		this.fontRendererObj.drawString("Answer 3", (66), (100), 0xffffff);

		this.textbox.drawTextBox();
		this.fontRendererObj.drawString("TITLE", (74), (7), 0xffffff);

	}

	public void onGuiClosed() {
		super.onGuiClosed();
		Keyboard.enableRepeatEvents(false);
	}

	public void initGui() {
		super.initGui();
		this.guiLeft = (this.width - 176) / 2;
		this.guiTop = (this.height - 166) / 2;
		Keyboard.enableRepeatEvents(true);
		this.buttonList.clear();
		int posX = (this.width) / 2;
		int posY = (this.height) / 2;

		this.textbox = new GuiTextField(0, this.fontRendererObj, (34), (128), 120, 20);
		this.textbox.setMaxStringLength(32767);
		this.textbox.setFocused(true);

		this.textbox.setText("Submit Answer");

	}

	protected void actionPerformed(GuiButton button) {
		MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
		World world = server.worlds[0];

	}

	public boolean doesGuiPauseGame() {
		return false;
	}

}
