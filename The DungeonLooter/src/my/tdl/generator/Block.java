package my.tdl.generator;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import my.project.gop.main.Vector2F;
import my.tdl.main.Assets;

public class Block extends Rectangle{

	Vector2F pos = new Vector2F();
	private int BlockSize = 48;
	private BlockType blocktype;
	private BufferedImage block;
	
	public Block(Vector2F pos,BlockType blocktype) {
		this.pos = pos;
		this.blocktype = blocktype;
		init();
	}
	public void init(){
		switch(blocktype){
		case STONE_1:
			block = Assets.getStone_1();
			break;
		}
	}
	public void tick(double deltaTime){
		
	}
	
	public void render(Graphics2D g){
		//g.drawRect((int)pos.getWorldLocation().xpos, (int)pos.getWorldLocation().ypos, BlockSize, BlockSize);
		g.drawImage(block,(int)pos.getWorldLocation().xpos, (int)pos.getWorldLocation().ypos, BlockSize, BlockSize, null);
	}

	public enum BlockType{
		STONE_1
	}
}
